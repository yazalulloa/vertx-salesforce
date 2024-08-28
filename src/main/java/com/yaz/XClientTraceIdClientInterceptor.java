package com.yaz;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XClientTraceIdClientInterceptor implements ClientInterceptor {

  private static final Metadata.Key<String> X_CLIENT_TRACE_ID = Metadata.Key.of("x-client-trace-id",
      Metadata.ASCII_STRING_MARSHALLER);

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
      CallOptions callOptions, Channel next) {
    return new ForwardingClientCall.SimpleForwardingClientCall<>(next.newCall(method, callOptions)) {

      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        String xClientTraceId = UUID.randomUUID().toString();
        headers.put(X_CLIENT_TRACE_ID, xClientTraceId);
        log.info("sending request for xClientTraceId {}", xClientTraceId);

        super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<>(responseListener) {
          @Override
          public void onClose(Status status, Metadata trailers) {
            trailers.get(X_CLIENT_TRACE_ID);
            log.info("request completed for xClientTraceId {} with status {}", xClientTraceId, status);
            super.onClose(status, trailers);
          }
        }, headers);
      }
    };
  }
}
