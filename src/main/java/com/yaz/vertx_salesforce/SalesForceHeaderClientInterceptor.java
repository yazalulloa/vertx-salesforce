package com.yaz.vertx_salesforce;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.Vertx;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SalesForceHeaderClientInterceptor implements ClientInterceptor {

  private final Vertx vertx;

  public SalesForceHeaderClientInterceptor(Vertx vertx) {
    this.vertx = vertx;
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor,
    CallOptions callOptions, Channel channel) {

    final var getTokenSingle = vertx.eventBus().rxRequest(TokenVerticle.ADDRESS, null)
      .doOnSubscribe(d -> {
        log.info("Getting Salesforce token for method: {}", methodDescriptor.getFullMethodName());
      });

    final var extraHeaders = Single.zip(getTokenSingle, getTokenSingle, getTokenSingle, getTokenSingle,
      (instanceUrl, accessToken, tenantId, xClientTraceId) -> {
        final var metadata = new Metadata();
        metadata.put(Constants.INSTANCE_URL_KEY, instanceUrl.body().toString());
        metadata.put(Constants.ACCESS_TOKEN_KEY, accessToken.body().toString());
        metadata.put(Constants.TENANT_ID_KEY, tenantId.body().toString());
        metadata.put(Constants.X_CLIENT_TRACE_ID_KEY, xClientTraceId.body().toString());
        return metadata;
      }).blockingGet();

    return new SimpleForwardingClientCall<>(channel.newCall(methodDescriptor, callOptions)) {
      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        headers.merge(extraHeaders);
        log.info("Adding Salesforce headers to request: {} {}", methodDescriptor.getFullMethodName(), headers);
        super.start(responseListener, headers);
      }
    };
  }
}
