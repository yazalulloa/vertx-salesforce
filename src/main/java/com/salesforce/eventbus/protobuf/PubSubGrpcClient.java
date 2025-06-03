package com.salesforce.eventbus.protobuf;

import io.vertx.core.Future;
import io.vertx.core.Completable;
import io.vertx.core.Handler;
import io.vertx.core.net.SocketAddress;
import io.vertx.grpc.client.GrpcClient;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;
import io.vertx.grpc.common.GrpcStatus;
import io.vertx.grpc.common.ServiceName;
import io.vertx.grpc.common.ServiceMethod;
import io.vertx.grpc.common.GrpcMessageDecoder;
import io.vertx.grpc.common.GrpcMessageEncoder;

/**
 * <p>A client for invoking the PubSub gRPC service.</p>
 */
@io.vertx.codegen.annotations.VertxGen
public interface PubSubGrpcClient extends PubSubClient {

  /**
   * Subscribe protobuf RPC client service method.
   */
  @io.vertx.codegen.annotations.GenIgnore(io.vertx.codegen.annotations.GenIgnore.PERMITTED_TYPE)
  ServiceMethod<com.salesforce.eventbus.protobuf.FetchResponse, com.salesforce.eventbus.protobuf.FetchRequest> Subscribe = ServiceMethod.client(
    ServiceName.create("eventbus.v1", "PubSub"),
    "Subscribe",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.salesforce.eventbus.protobuf.FetchResponse.newBuilder()));

  /**
   * GetSchema protobuf RPC client service method.
   */
  @io.vertx.codegen.annotations.GenIgnore(io.vertx.codegen.annotations.GenIgnore.PERMITTED_TYPE)
  ServiceMethod<com.salesforce.eventbus.protobuf.SchemaInfo, com.salesforce.eventbus.protobuf.SchemaRequest> GetSchema = ServiceMethod.client(
    ServiceName.create("eventbus.v1", "PubSub"),
    "GetSchema",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.salesforce.eventbus.protobuf.SchemaInfo.newBuilder()));

  /**
   * GetTopic protobuf RPC client service method.
   */
  @io.vertx.codegen.annotations.GenIgnore(io.vertx.codegen.annotations.GenIgnore.PERMITTED_TYPE)
  ServiceMethod<com.salesforce.eventbus.protobuf.TopicInfo, com.salesforce.eventbus.protobuf.TopicRequest> GetTopic = ServiceMethod.client(
    ServiceName.create("eventbus.v1", "PubSub"),
    "GetTopic",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.salesforce.eventbus.protobuf.TopicInfo.newBuilder()));

  /**
   * Publish protobuf RPC client service method.
   */
  @io.vertx.codegen.annotations.GenIgnore(io.vertx.codegen.annotations.GenIgnore.PERMITTED_TYPE)
  ServiceMethod<com.salesforce.eventbus.protobuf.PublishResponse, com.salesforce.eventbus.protobuf.PublishRequest> Publish = ServiceMethod.client(
    ServiceName.create("eventbus.v1", "PubSub"),
    "Publish",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.salesforce.eventbus.protobuf.PublishResponse.newBuilder()));

  /**
   * PublishStream protobuf RPC client service method.
   */
  @io.vertx.codegen.annotations.GenIgnore(io.vertx.codegen.annotations.GenIgnore.PERMITTED_TYPE)
  ServiceMethod<com.salesforce.eventbus.protobuf.PublishResponse, com.salesforce.eventbus.protobuf.PublishRequest> PublishStream = ServiceMethod.client(
    ServiceName.create("eventbus.v1", "PubSub"),
    "PublishStream",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.salesforce.eventbus.protobuf.PublishResponse.newBuilder()));

  /**
   * ManagedSubscribe protobuf RPC client service method.
   */
  @io.vertx.codegen.annotations.GenIgnore(io.vertx.codegen.annotations.GenIgnore.PERMITTED_TYPE)
  ServiceMethod<com.salesforce.eventbus.protobuf.ManagedFetchResponse, com.salesforce.eventbus.protobuf.ManagedFetchRequest> ManagedSubscribe = ServiceMethod.client(
    ServiceName.create("eventbus.v1", "PubSub"),
    "ManagedSubscribe",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.salesforce.eventbus.protobuf.ManagedFetchResponse.newBuilder()));

  /**
   * Create and return a PubSub gRPC service client. The assumed wire format is Protobuf.
   *
   * @param client the gRPC client
   * @param host   the host providing the service
   * @return the configured client
   */
  static PubSubGrpcClient create(GrpcClient client, SocketAddress host) {
    return new PubSubGrpcClientImpl(client, host);
  }

  /**
   * Create and return a PubSub gRPC service client.
   *
   * @param client     the gRPC client
   * @param host       the host providing the service
   * @param wireFormat the wire format
   * @return the configured client
   */
  static PubSubGrpcClient create(GrpcClient client, SocketAddress host, io.vertx.grpc.common.WireFormat wireFormat) {
    return new PubSubGrpcClientImpl(client, host, wireFormat);
  }
}

/**
 * The proxy implementation.
 */
class PubSubGrpcClientImpl implements PubSubGrpcClient {

  private final GrpcClient client;
  private final SocketAddress socketAddress;
  private final io.vertx.grpc.common.WireFormat wireFormat;

  PubSubGrpcClientImpl(GrpcClient client, SocketAddress socketAddress) {
    this(client, socketAddress, io.vertx.grpc.common.WireFormat.PROTOBUF);
  }

  PubSubGrpcClientImpl(GrpcClient client, SocketAddress socketAddress, io.vertx.grpc.common.WireFormat wireFormat) {
    this.client = java.util.Objects.requireNonNull(client);
    this.socketAddress = java.util.Objects.requireNonNull(socketAddress);
    this.wireFormat = java.util.Objects.requireNonNull(wireFormat);
  }

  public Future<com.salesforce.eventbus.protobuf.SchemaInfo> getSchema(com.salesforce.eventbus.protobuf.SchemaRequest request) {
    return client.request(socketAddress, GetSchema).compose(req -> {
      req.format(wireFormat);
      return req.end(request).compose(v -> req.response().compose(resp -> resp.last()));
    });
  }

  public Future<com.salesforce.eventbus.protobuf.TopicInfo> getTopic(com.salesforce.eventbus.protobuf.TopicRequest request) {
    return client.request(socketAddress, GetTopic).compose(req -> {
      req.format(wireFormat);
      return req.end(request).compose(v -> req.response().compose(resp -> resp.last()));
    });
  }

  public Future<com.salesforce.eventbus.protobuf.PublishResponse> publish(com.salesforce.eventbus.protobuf.PublishRequest request) {
    return client.request(socketAddress, Publish).compose(req -> {
      req.format(wireFormat);
      return req.end(request).compose(v -> req.response().compose(resp -> resp.last()));
    });
  }

  public Future<ReadStream<com.salesforce.eventbus.protobuf.FetchResponse>> subscribe(Completable<WriteStream<com.salesforce.eventbus.protobuf.FetchRequest>> completable) {
    return client.request(socketAddress, Subscribe)
       .andThen((res, err) -> {
        if (err == null) {
          res.format(wireFormat);
        }
        completable.complete(res, err);
      })
     .compose(req -> {
        return req.response().flatMap(resp -> {
          if (resp.status() != null && resp.status() != GrpcStatus.OK) {
            return Future.failedFuture(new io.vertx.grpc.client.InvalidStatusException(GrpcStatus.OK, resp.status()));
          } else {
            return Future.succeededFuture(resp);
          }
        });
    });
  }

  public Future<ReadStream<com.salesforce.eventbus.protobuf.PublishResponse>> publishStream(Completable<WriteStream<com.salesforce.eventbus.protobuf.PublishRequest>> completable) {
    return client.request(socketAddress, PublishStream)
       .andThen((res, err) -> {
        if (err == null) {
          res.format(wireFormat);
        }
        completable.complete(res, err);
      })
     .compose(req -> {
        return req.response().flatMap(resp -> {
          if (resp.status() != null && resp.status() != GrpcStatus.OK) {
            return Future.failedFuture(new io.vertx.grpc.client.InvalidStatusException(GrpcStatus.OK, resp.status()));
          } else {
            return Future.succeededFuture(resp);
          }
        });
    });
  }

  public Future<ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchResponse>> managedSubscribe(Completable<WriteStream<com.salesforce.eventbus.protobuf.ManagedFetchRequest>> completable) {
    return client.request(socketAddress, ManagedSubscribe)
       .andThen((res, err) -> {
        if (err == null) {
          res.format(wireFormat);
        }
        completable.complete(res, err);
      })
     .compose(req -> {
        return req.response().flatMap(resp -> {
          if (resp.status() != null && resp.status() != GrpcStatus.OK) {
            return Future.failedFuture(new io.vertx.grpc.client.InvalidStatusException(GrpcStatus.OK, resp.status()));
          } else {
            return Future.succeededFuture(resp);
          }
        });
    });
  }
}
