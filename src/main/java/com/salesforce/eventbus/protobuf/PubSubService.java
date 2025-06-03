package com.salesforce.eventbus.protobuf;

import io.vertx.core.Future;
import io.vertx.core.Completable;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;
import io.vertx.grpc.common.GrpcStatus;
import io.vertx.grpc.common.ServiceName;
import io.vertx.grpc.common.ServiceMethod;
import io.vertx.grpc.common.GrpcMessageDecoder;
import io.vertx.grpc.common.GrpcMessageEncoder;
import io.vertx.grpc.server.GrpcServerRequest;
import io.vertx.grpc.server.GrpcServer;
import io.vertx.grpc.server.Service;
import io.vertx.grpc.server.ServiceBuilder;

import com.google.protobuf.Descriptors;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Provides support for RPC methods implementations of the PubSub gRPC service.</p>
 *
 * <p>The following methods of this class should be overridden to provide an implementation of the service:</p>
 * <ul>
 *   <li>Subscribe</li>
 *   <li>GetSchema</li>
 *   <li>GetTopic</li>
 *   <li>Publish</li>
 *   <li>PublishStream</li>
 *   <li>ManagedSubscribe</li>
 * </ul>
 */
public class PubSubService implements PubSub {

  /**
   * Override this method to implement the GetSchema RPC.
   */
  public Future<com.salesforce.eventbus.protobuf.SchemaInfo> getSchema(com.salesforce.eventbus.protobuf.SchemaRequest request) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected void getSchema(com.salesforce.eventbus.protobuf.SchemaRequest request, Completable<com.salesforce.eventbus.protobuf.SchemaInfo> response) {
    getSchema(request).onComplete(response);
  }

  /**
   * Override this method to implement the GetTopic RPC.
   */
  public Future<com.salesforce.eventbus.protobuf.TopicInfo> getTopic(com.salesforce.eventbus.protobuf.TopicRequest request) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected void getTopic(com.salesforce.eventbus.protobuf.TopicRequest request, Completable<com.salesforce.eventbus.protobuf.TopicInfo> response) {
    getTopic(request).onComplete(response);
  }

  /**
   * Override this method to implement the Publish RPC.
   */
  public Future<com.salesforce.eventbus.protobuf.PublishResponse> publish(com.salesforce.eventbus.protobuf.PublishRequest request) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected void publish(com.salesforce.eventbus.protobuf.PublishRequest request, Completable<com.salesforce.eventbus.protobuf.PublishResponse> response) {
    publish(request).onComplete(response);
  }

  /**
   * Override this method to implement the Subscribe RPC.
   */
  public Future<ReadStream<com.salesforce.eventbus.protobuf.FetchResponse>> subscribe(ReadStream<com.salesforce.eventbus.protobuf.FetchRequest> request) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected void subscribe(ReadStream<com.salesforce.eventbus.protobuf.FetchRequest> request, WriteStream<com.salesforce.eventbus.protobuf.FetchResponse> response) {
    subscribe(request)
      .onComplete(ar -> {
        if (ar.succeeded()) {
          ReadStream<com.salesforce.eventbus.protobuf.FetchResponse> stream = ar.result();
          stream.pipeTo(response);
        } else {
          // Todo
        }
      });
  }

  /**
   * Override this method to implement the PublishStream RPC.
   */
  public Future<ReadStream<com.salesforce.eventbus.protobuf.PublishResponse>> publishStream(ReadStream<com.salesforce.eventbus.protobuf.PublishRequest> request) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected void publishStream(ReadStream<com.salesforce.eventbus.protobuf.PublishRequest> request, WriteStream<com.salesforce.eventbus.protobuf.PublishResponse> response) {
    publishStream(request)
      .onComplete(ar -> {
        if (ar.succeeded()) {
          ReadStream<com.salesforce.eventbus.protobuf.PublishResponse> stream = ar.result();
          stream.pipeTo(response);
        } else {
          // Todo
        }
      });
  }

  /**
   * Override this method to implement the ManagedSubscribe RPC.
   */
  public Future<ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchResponse>> managedSubscribe(ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchRequest> request) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected void managedSubscribe(ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchRequest> request, WriteStream<com.salesforce.eventbus.protobuf.ManagedFetchResponse> response) {
    managedSubscribe(request)
      .onComplete(ar -> {
        if (ar.succeeded()) {
          ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchResponse> stream = ar.result();
          stream.pipeTo(response);
        } else {
          // Todo
        }
      });
  }
}
