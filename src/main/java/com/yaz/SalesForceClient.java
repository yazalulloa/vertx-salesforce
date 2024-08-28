package com.yaz;

import com.salesforce.eventbus.protobuf.PubSubGrpc;
import com.salesforce.eventbus.protobuf.TopicInfo;
import com.salesforce.eventbus.protobuf.TopicRequest;
import com.salesforce.eventbus.protobuf.VertxPubSubGrpcClient;
import io.grpc.ClientInterceptors;
import io.grpc.ManagedChannelBuilder;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.vertx.core.Vertx;
import io.vertx.core.net.SocketAddress;
import io.vertx.grpc.client.GrpcClient;
import io.vertx.grpc.client.GrpcClientChannel;
import io.vertx.rxjava3.impl.AsyncResultSingle;

public class SalesForceClient {

  public static final String HOST = "api.pubsub.salesforce.com";
  public static final int PORT = 443;
  public static final TopicRequest request = TopicRequest.newBuilder().setTopicName("test").build();


  public Maybe<TopicInfo> async() {
    final var channel = ManagedChannelBuilder.forAddress(HOST, PORT).build();

//    final var interceptedChannel = ClientInterceptors.intercept(channel, new XClientTraceIdClientInterceptor());

    final var pubSubStub = PubSubGrpc.newStub(channel);//.withCallCredentials(callCredentials);

    return Utils.maybe(
        streamObserver -> pubSubStub.getTopic(request, streamObserver));
  }

  public TopicInfo blocking() {
    final var channel = ManagedChannelBuilder.forAddress(HOST, PORT).build();

//    final var interceptedChannel = ClientInterceptors.intercept(channel, new XClientTraceIdClientInterceptor());

    final var pubSubStub = PubSubGrpc.newBlockingStub(channel);//.withCallCredentials(callCredentials);

    return pubSubStub.getTopic(request);
  }

  public Maybe<TopicInfo> asyncWithVertxChannel(Vertx vertx) {
    final var channel = new GrpcClientChannel(GrpcClient.client(vertx), SocketAddress.inetSocketAddress(PORT, HOST));

//    final var interceptedChannel = ClientInterceptors.intercept(channel, new XClientTraceIdClientInterceptor());

    final var pubSubStub = PubSubGrpc.newStub(channel);//.withCallCredentials(callCredentials);

    return Utils.maybe(
        streamObserver -> pubSubStub.getTopic(request, streamObserver));
  }

  public Single<TopicInfo> vertx(Vertx vertx) {

    final var client = new VertxPubSubGrpcClient(GrpcClient.client(vertx),
        SocketAddress.inetSocketAddress(PORT, HOST));

    return AsyncResultSingle.toSingle(client.getTopic(request), m -> m);
  }
}
