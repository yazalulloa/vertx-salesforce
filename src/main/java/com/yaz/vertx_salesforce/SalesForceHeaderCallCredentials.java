package com.yaz.vertx_salesforce;

import io.grpc.CallCredentials;
import io.grpc.Metadata;
import java.util.UUID;
import java.util.concurrent.Executor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SalesForceHeaderCallCredentials extends CallCredentials {

  @Override
  public void applyRequestMetadata(RequestInfo requestInfo, Executor executor, MetadataApplier metadataApplier) {

    log.info("Applying Salesforce headers for request: {}", requestInfo.getMethodDescriptor().getFullMethodName());

    executor.execute(() -> {

      // This values could come from an async call
      final var headers = new Metadata();
      headers.put(Constants.INSTANCE_URL_KEY, UUID.randomUUID().toString());
      headers.put(Constants.TENANT_ID_KEY, UUID.randomUUID().toString());
      headers.put(Constants.SESSION_TOKEN_KEY, UUID.randomUUID().toString());
      headers.put(Constants.X_CLIENT_TRACE_ID_KEY, UUID.randomUUID().toString());
      metadataApplier.apply(headers);
    });
  }
}
