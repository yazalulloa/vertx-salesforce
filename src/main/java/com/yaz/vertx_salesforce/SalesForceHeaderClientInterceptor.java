package com.yaz.vertx_salesforce;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SalesForceHeaderClientInterceptor implements ClientInterceptor {

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor,
    CallOptions callOptions, Channel channel) {

    // This values could come from an async call
    final var extraHeaders = new Metadata();
    extraHeaders.put(Constants.INSTANCE_URL_KEY, UUID.randomUUID().toString());
    extraHeaders.put(Constants.ACCESS_TOKEN_KEY, UUID.randomUUID().toString());
    extraHeaders.put(Constants.TENANT_ID_KEY, UUID.randomUUID().toString());
    extraHeaders.put(Constants.X_CLIENT_TRACE_ID_KEY, UUID.randomUUID().toString());

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
