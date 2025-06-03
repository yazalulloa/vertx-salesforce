package com.salesforce.eventbus.protobuf;

import io.vertx.core.Future;
import io.vertx.core.Promise;
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
 * <p>Contract definition PubSub service.</p>
 */
public interface PubSub {

  Future<com.salesforce.eventbus.protobuf.SchemaInfo> getSchema(com.salesforce.eventbus.protobuf.SchemaRequest request);

  Future<com.salesforce.eventbus.protobuf.TopicInfo> getTopic(com.salesforce.eventbus.protobuf.TopicRequest request);

  Future<com.salesforce.eventbus.protobuf.PublishResponse> publish(com.salesforce.eventbus.protobuf.PublishRequest request);

  Future<ReadStream<com.salesforce.eventbus.protobuf.FetchResponse>> subscribe(ReadStream<com.salesforce.eventbus.protobuf.FetchRequest> request);

  Future<ReadStream<com.salesforce.eventbus.protobuf.PublishResponse>> publishStream(ReadStream<com.salesforce.eventbus.protobuf.PublishRequest> request);

  Future<ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchResponse>> managedSubscribe(ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchRequest> request);

}
