package com.salesforce.eventbus.protobuf;

import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.net.SocketAddress;
import io.vertx.grpc.client.GrpcClient;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;
import io.vertx.grpc.common.GrpcStatus;

public class VertxPubSubGrpcClient {
  private final GrpcClient client;
  private final SocketAddress socketAddress;

  public VertxPubSubGrpcClient(GrpcClient client, SocketAddress socketAddress) {
    this.client = client;
    this.socketAddress = socketAddress;
  }

  public Future<com.salesforce.eventbus.protobuf.SchemaInfo> getSchema(com.salesforce.eventbus.protobuf.SchemaRequest request) {
    return client.request(socketAddress, PubSubGrpc.getGetSchemaMethod()).compose(req -> {
      req.end(request);
      return req.response().compose(resp -> resp.last());
    });
  }

  public Future<com.salesforce.eventbus.protobuf.TopicInfo> getTopic(com.salesforce.eventbus.protobuf.TopicRequest request) {
    return client.request(socketAddress, PubSubGrpc.getGetTopicMethod()).compose(req -> {
      req.end(request);
      return req.response().compose(resp -> resp.last());
    });
  }

  public Future<com.salesforce.eventbus.protobuf.PublishResponse> publish(com.salesforce.eventbus.protobuf.PublishRequest request) {
    return client.request(socketAddress, PubSubGrpc.getPublishMethod()).compose(req -> {
      req.end(request);
      return req.response().compose(resp -> resp.last());
    });
  }

  public Future<ReadStream<com.salesforce.eventbus.protobuf.FetchResponse>> subscribe(Handler<WriteStream<com.salesforce.eventbus.protobuf.FetchRequest>> request) {
    return client.request(socketAddress, PubSubGrpc.getSubscribeMethod()).compose(req -> {
      request.handle(req);
      return req.response().flatMap(resp -> {
        if (resp.status() != null && resp.status() != GrpcStatus.OK) {
          return Future.failedFuture("Invalid gRPC status " + resp.status());
        } else {
          return Future.succeededFuture(resp);
        }
      });
    });
  }

  public Future<ReadStream<com.salesforce.eventbus.protobuf.PublishResponse>> publishStream(Handler<WriteStream<com.salesforce.eventbus.protobuf.PublishRequest>> request) {
    return client.request(socketAddress, PubSubGrpc.getPublishStreamMethod()).compose(req -> {
      request.handle(req);
      return req.response().flatMap(resp -> {
        if (resp.status() != null && resp.status() != GrpcStatus.OK) {
          return Future.failedFuture("Invalid gRPC status " + resp.status());
        } else {
          return Future.succeededFuture(resp);
        }
      });
    });
  }

  public Future<ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchResponse>> managedSubscribe(Handler<WriteStream<com.salesforce.eventbus.protobuf.ManagedFetchRequest>> request) {
    return client.request(socketAddress, PubSubGrpc.getManagedSubscribeMethod()).compose(req -> {
      request.handle(req);
      return req.response().flatMap(resp -> {
        if (resp.status() != null && resp.status() != GrpcStatus.OK) {
          return Future.failedFuture("Invalid gRPC status " + resp.status());
        } else {
          return Future.succeededFuture(resp);
        }
      });
    });
  }

}
