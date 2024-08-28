package com.salesforce.eventbus.protobuf;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;
import io.vertx.grpc.common.GrpcStatus;
import io.vertx.grpc.server.GrpcServer;
import io.vertx.grpc.server.GrpcServerResponse;

import java.util.ArrayList;
import java.util.List;

public class VertxPubSubGrpcServer  {
  public interface PubSubApi {
    default Future<com.salesforce.eventbus.protobuf.SchemaInfo> getSchema(com.salesforce.eventbus.protobuf.SchemaRequest request) {
      throw new UnsupportedOperationException("Not implemented");
    }
    default void getSchema(com.salesforce.eventbus.protobuf.SchemaRequest request, Promise<com.salesforce.eventbus.protobuf.SchemaInfo> response) {
      getSchema(request)
        .onSuccess(msg -> response.complete(msg))
        .onFailure(error -> response.fail(error));
    }
    default Future<com.salesforce.eventbus.protobuf.TopicInfo> getTopic(com.salesforce.eventbus.protobuf.TopicRequest request) {
      throw new UnsupportedOperationException("Not implemented");
    }
    default void getTopic(com.salesforce.eventbus.protobuf.TopicRequest request, Promise<com.salesforce.eventbus.protobuf.TopicInfo> response) {
      getTopic(request)
        .onSuccess(msg -> response.complete(msg))
        .onFailure(error -> response.fail(error));
    }
    default Future<com.salesforce.eventbus.protobuf.PublishResponse> publish(com.salesforce.eventbus.protobuf.PublishRequest request) {
      throw new UnsupportedOperationException("Not implemented");
    }
    default void publish(com.salesforce.eventbus.protobuf.PublishRequest request, Promise<com.salesforce.eventbus.protobuf.PublishResponse> response) {
      publish(request)
        .onSuccess(msg -> response.complete(msg))
        .onFailure(error -> response.fail(error));
    }
    default ReadStream<com.salesforce.eventbus.protobuf.FetchResponse> subscribe(ReadStream<com.salesforce.eventbus.protobuf.FetchRequest> request) {
      throw new UnsupportedOperationException("Not implemented");
    }
    default void subscribe(ReadStream<com.salesforce.eventbus.protobuf.FetchRequest> request, WriteStream<com.salesforce.eventbus.protobuf.FetchResponse> response) {
      subscribe(request)
        .handler(msg -> response.write(msg))
        .endHandler(msg -> response.end())
        .resume();
    }
    default ReadStream<com.salesforce.eventbus.protobuf.PublishResponse> publishStream(ReadStream<com.salesforce.eventbus.protobuf.PublishRequest> request) {
      throw new UnsupportedOperationException("Not implemented");
    }
    default void publishStream(ReadStream<com.salesforce.eventbus.protobuf.PublishRequest> request, WriteStream<com.salesforce.eventbus.protobuf.PublishResponse> response) {
      publishStream(request)
        .handler(msg -> response.write(msg))
        .endHandler(msg -> response.end())
        .resume();
    }
    default ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchResponse> managedSubscribe(ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchRequest> request) {
      throw new UnsupportedOperationException("Not implemented");
    }
    default void managedSubscribe(ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchRequest> request, WriteStream<com.salesforce.eventbus.protobuf.ManagedFetchResponse> response) {
      managedSubscribe(request)
        .handler(msg -> response.write(msg))
        .endHandler(msg -> response.end())
        .resume();
    }

    default PubSubApi bind_getSchema(GrpcServer server) {
      server.callHandler(PubSubGrpc.getGetSchemaMethod(), request -> {
        Promise<com.salesforce.eventbus.protobuf.SchemaInfo> promise = Promise.promise();
        request.handler(req -> {
          try {
            getSchema(req, promise);
          } catch (RuntimeException err) {
            promise.tryFail(err);
          }
        });
        promise.future()
          .onFailure(err -> request.response().status(GrpcStatus.INTERNAL).end())
          .onSuccess(resp -> request.response().end(resp));
      });
      return this;
    }
    default PubSubApi bind_getTopic(GrpcServer server) {
      server.callHandler(PubSubGrpc.getGetTopicMethod(), request -> {
        Promise<com.salesforce.eventbus.protobuf.TopicInfo> promise = Promise.promise();
        request.handler(req -> {
          try {
            getTopic(req, promise);
          } catch (RuntimeException err) {
            promise.tryFail(err);
          }
        });
        promise.future()
          .onFailure(err -> request.response().status(GrpcStatus.INTERNAL).end())
          .onSuccess(resp -> request.response().end(resp));
      });
      return this;
    }
    default PubSubApi bind_publish(GrpcServer server) {
      server.callHandler(PubSubGrpc.getPublishMethod(), request -> {
        Promise<com.salesforce.eventbus.protobuf.PublishResponse> promise = Promise.promise();
        request.handler(req -> {
          try {
            publish(req, promise);
          } catch (RuntimeException err) {
            promise.tryFail(err);
          }
        });
        promise.future()
          .onFailure(err -> request.response().status(GrpcStatus.INTERNAL).end())
          .onSuccess(resp -> request.response().end(resp));
      });
      return this;
    }
    default PubSubApi bind_subscribe(GrpcServer server) {
      server.callHandler(PubSubGrpc.getSubscribeMethod(), request -> {
        try {
          subscribe(request, request.response());
        } catch (RuntimeException err) {
          request.response().status(GrpcStatus.INTERNAL).end();
        }
      });
      return this;
    }
    default PubSubApi bind_publishStream(GrpcServer server) {
      server.callHandler(PubSubGrpc.getPublishStreamMethod(), request -> {
        try {
          publishStream(request, request.response());
        } catch (RuntimeException err) {
          request.response().status(GrpcStatus.INTERNAL).end();
        }
      });
      return this;
    }
    default PubSubApi bind_managedSubscribe(GrpcServer server) {
      server.callHandler(PubSubGrpc.getManagedSubscribeMethod(), request -> {
        try {
          managedSubscribe(request, request.response());
        } catch (RuntimeException err) {
          request.response().status(GrpcStatus.INTERNAL).end();
        }
      });
      return this;
    }

    default PubSubApi bindAll(GrpcServer server) {
      bind_subscribe(server);
      bind_getSchema(server);
      bind_getTopic(server);
      bind_publish(server);
      bind_publishStream(server);
      bind_managedSubscribe(server);
      return this;
    }
  }
}
