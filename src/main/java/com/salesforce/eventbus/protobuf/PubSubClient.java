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
public interface PubSubClient extends PubSub {

  /**
   * Calls the GetSchema RPC service method.
   *
   * @param request the com.salesforce.eventbus.protobuf.SchemaRequest request message
   * @return a future of the com.salesforce.eventbus.protobuf.SchemaInfo response message
   */
  @io.vertx.codegen.annotations.GenIgnore(io.vertx.codegen.annotations.GenIgnore.PERMITTED_TYPE)
  Future<com.salesforce.eventbus.protobuf.SchemaInfo> getSchema(com.salesforce.eventbus.protobuf.SchemaRequest request);

  /**
   * Calls the GetTopic RPC service method.
   *
   * @param request the com.salesforce.eventbus.protobuf.TopicRequest request message
   * @return a future of the com.salesforce.eventbus.protobuf.TopicInfo response message
   */
  @io.vertx.codegen.annotations.GenIgnore(io.vertx.codegen.annotations.GenIgnore.PERMITTED_TYPE)
  Future<com.salesforce.eventbus.protobuf.TopicInfo> getTopic(com.salesforce.eventbus.protobuf.TopicRequest request);

  /**
   * Calls the Publish RPC service method.
   *
   * @param request the com.salesforce.eventbus.protobuf.PublishRequest request message
   * @return a future of the com.salesforce.eventbus.protobuf.PublishResponse response message
   */
  @io.vertx.codegen.annotations.GenIgnore(io.vertx.codegen.annotations.GenIgnore.PERMITTED_TYPE)
  Future<com.salesforce.eventbus.protobuf.PublishResponse> publish(com.salesforce.eventbus.protobuf.PublishRequest request);

  /**
   * Calls the Subscribe RPC service method.
   *
   * @param compltable a completable that will be passed a stream to which the com.salesforce.eventbus.protobuf.FetchRequest request messages can be written to.
   * @return a future of the com.salesforce.eventbus.protobuf.FetchResponse response messages
   */
  @io.vertx.codegen.annotations.GenIgnore
  Future<ReadStream<com.salesforce.eventbus.protobuf.FetchResponse>> subscribe(Completable<WriteStream<com.salesforce.eventbus.protobuf.FetchRequest>> completable);

  /**
   * Calls the Subscribe RPC service method.
   *
    * @param streamOfMessages a stream of messages to be sent to the service
   * @return a future of the com.salesforce.eventbus.protobuf.FetchResponse response messages
   */
  @io.vertx.codegen.annotations.GenIgnore(io.vertx.codegen.annotations.GenIgnore.PERMITTED_TYPE)
  default Future<ReadStream<com.salesforce.eventbus.protobuf.FetchResponse>> subscribe(ReadStream<com.salesforce.eventbus.protobuf.FetchRequest> streamOfMessages) {
    io.vertx.core.streams.Pipe<com.salesforce.eventbus.protobuf.FetchRequest> pipe = streamOfMessages.pipe();
    return subscribe((result, error) -> {
        if (error == null) {
          pipe.to(result);
        } else {
          pipe.close();
        }
    });
  }

  /**
   * Calls the PublishStream RPC service method.
   *
   * @param compltable a completable that will be passed a stream to which the com.salesforce.eventbus.protobuf.PublishRequest request messages can be written to.
   * @return a future of the com.salesforce.eventbus.protobuf.PublishResponse response messages
   */
  @io.vertx.codegen.annotations.GenIgnore
  Future<ReadStream<com.salesforce.eventbus.protobuf.PublishResponse>> publishStream(Completable<WriteStream<com.salesforce.eventbus.protobuf.PublishRequest>> completable);

  /**
   * Calls the PublishStream RPC service method.
   *
    * @param streamOfMessages a stream of messages to be sent to the service
   * @return a future of the com.salesforce.eventbus.protobuf.PublishResponse response messages
   */
  @io.vertx.codegen.annotations.GenIgnore(io.vertx.codegen.annotations.GenIgnore.PERMITTED_TYPE)
  default Future<ReadStream<com.salesforce.eventbus.protobuf.PublishResponse>> publishStream(ReadStream<com.salesforce.eventbus.protobuf.PublishRequest> streamOfMessages) {
    io.vertx.core.streams.Pipe<com.salesforce.eventbus.protobuf.PublishRequest> pipe = streamOfMessages.pipe();
    return publishStream((result, error) -> {
        if (error == null) {
          pipe.to(result);
        } else {
          pipe.close();
        }
    });
  }

  /**
   * Calls the ManagedSubscribe RPC service method.
   *
   * @param compltable a completable that will be passed a stream to which the com.salesforce.eventbus.protobuf.ManagedFetchRequest request messages can be written to.
   * @return a future of the com.salesforce.eventbus.protobuf.ManagedFetchResponse response messages
   */
  @io.vertx.codegen.annotations.GenIgnore
  Future<ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchResponse>> managedSubscribe(Completable<WriteStream<com.salesforce.eventbus.protobuf.ManagedFetchRequest>> completable);

  /**
   * Calls the ManagedSubscribe RPC service method.
   *
    * @param streamOfMessages a stream of messages to be sent to the service
   * @return a future of the com.salesforce.eventbus.protobuf.ManagedFetchResponse response messages
   */
  @io.vertx.codegen.annotations.GenIgnore(io.vertx.codegen.annotations.GenIgnore.PERMITTED_TYPE)
  default Future<ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchResponse>> managedSubscribe(ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchRequest> streamOfMessages) {
    io.vertx.core.streams.Pipe<com.salesforce.eventbus.protobuf.ManagedFetchRequest> pipe = streamOfMessages.pipe();
    return managedSubscribe((result, error) -> {
        if (error == null) {
          pipe.to(result);
        } else {
          pipe.close();
        }
    });
  }
}
