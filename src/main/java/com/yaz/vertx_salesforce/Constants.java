package com.yaz.vertx_salesforce;

import io.grpc.Metadata;

public class Constants {

  public static final String INSTANCE_URL_HEADER = "instanceUrl";
  public static final Metadata.Key<String> INSTANCE_URL_KEY = Metadata.Key.of(INSTANCE_URL_HEADER,
    Metadata.ASCII_STRING_MARSHALLER);
  public static final String ACCESS_TOKEN_HEADER = "accessToken";
  public static final Metadata.Key<String> ACCESS_TOKEN_KEY = Metadata.Key.of(ACCESS_TOKEN_HEADER,
    Metadata.ASCII_STRING_MARSHALLER);
  public static final String TENANT_ID_HEADER = "tenantId";
  public static final Metadata.Key<String> TENANT_ID_KEY = Metadata.Key.of(TENANT_ID_HEADER,
    Metadata.ASCII_STRING_MARSHALLER);
  public static final String X_CLIENT_TRACE_ID_HEADER = "x-client-trace-id";
  public static final Metadata.Key<String> X_CLIENT_TRACE_ID_KEY = Metadata.Key.of(X_CLIENT_TRACE_ID_HEADER,
    Metadata.ASCII_STRING_MARSHALLER);

}
