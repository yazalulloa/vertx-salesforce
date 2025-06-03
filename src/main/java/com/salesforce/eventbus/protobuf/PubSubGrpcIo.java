package com.salesforce.eventbus.protobuf;

import static com.salesforce.eventbus.protobuf.PubSubGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

import io.grpc.ClientCall;

import io.grpc.stub.StreamObserver;

import io.vertx.grpcio.client.GrpcIoClientChannel;
import io.vertx.grpcio.client.impl.GrpcIoClientImpl;

/**
 * gRPC/IO client/service in a Vert.x idiomatic way.
 */
public final class PubSubGrpcIo {

  private PubSubGrpcIo() {}

  /**
   * Build a new stub.
   */
  public static PubSubStub newStub(io.vertx.grpcio.client.GrpcIoClient client, io.vertx.core.net.SocketAddress socketAddress) {
    return newStub(((GrpcIoClientImpl)client).vertx(), new io.vertx.grpcio.client.GrpcIoClientChannel(client, socketAddress));
  }

  /**
   * Build a new stub.
   */
  public static PubSubStub newStub(io.vertx.core.Vertx vertx, io.grpc.Channel channel) {
    return new PubSubStub(vertx, channel);
  }

  /**
     * <pre>
     * 
     *  The Pub/Sub API provides a single interface for publishing and subscribing to platform events, including real-time
     *  event monitoring events, and change data capture events. The Pub/Sub API is a gRPC API that is based on HTTP/2.
     * 
     *  A session token is needed to authenticate. Any of the Salesforce supported
     *  OAuth flows can be used to obtain a session token:
     *  https://help.salesforce.com/articleView?id=sf.remoteaccess_oauth_flows.htm&amp;type=5
     * 
     *  For each RPC, a client needs to pass authentication information
     *  as metadata headers (https://www.grpc.io/docs/guides/concepts/#metadata) with their method call.
     * 
     *  For Salesforce session token authentication, use:
     *    accesstoken : access token
     *    instanceurl : Salesforce instance URL
     *    tenantid : tenant/org id of the client
     * 
     *  StatusException is thrown in case of response failure for any request.
     * </pre>
     */
  public static final class PubSubStub extends io.grpc.stub.AbstractStub<PubSubStub> implements PubSubClient {
    private final io.vertx.core.internal.ContextInternal context;
    private PubSubGrpc.PubSubStub delegateStub;

    private PubSubStub(io.vertx.core.Vertx vertx, io.grpc.Channel channel) {
      super(channel);
      this.delegateStub = PubSubGrpc.newStub(channel);
      this.context = (io.vertx.core.internal.ContextInternal)vertx.getOrCreateContext();
    }

    private PubSubStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
      this.delegateStub = PubSubGrpc.newStub(channel).build(channel, callOptions);
      this.context = (io.vertx.core.internal.ContextInternal) ((GrpcIoClientImpl)((GrpcIoClientChannel)getChannel()).client()).vertx().getOrCreateContext();
    }

    @Override
    protected PubSubStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PubSubStub(channel, callOptions);
    }

    /**
         * <pre>
         *  Tenant/org GUID
         * </pre>
         */
    public io.vertx.core.Future<com.salesforce.eventbus.protobuf.SchemaInfo> getSchema(com.salesforce.eventbus.protobuf.SchemaRequest request) {
      return io.vertx.grpcio.common.impl.stub.ClientCalls.oneToOne(context, request, delegateStub::getSchema);
    }

    /**
         * <pre>
         *  Is publishing allowed?
         * </pre>
         */
    public io.vertx.core.Future<com.salesforce.eventbus.protobuf.TopicInfo> getTopic(com.salesforce.eventbus.protobuf.TopicRequest request) {
      return io.vertx.grpcio.common.impl.stub.ClientCalls.oneToOne(context, request, delegateStub::getTopic);
    }

    /**
         * <pre>
         *  Is subscription allowed?
         * </pre>
         */
    public io.vertx.core.Future<com.salesforce.eventbus.protobuf.PublishResponse> publish(com.salesforce.eventbus.protobuf.PublishRequest request) {
      return io.vertx.grpcio.common.impl.stub.ClientCalls.oneToOne(context, request, delegateStub::publish);
    }

    /**
         * <pre>
         *  Topic name
         * </pre>
         */
    public io.vertx.core.Future<io.vertx.core.streams.ReadStream<com.salesforce.eventbus.protobuf.FetchResponse>> subscribe(io.vertx.core.Completable<io.vertx.core.streams.WriteStream<com.salesforce.eventbus.protobuf.FetchRequest>> handler) {
      return io.vertx.grpcio.common.impl.stub.ClientCalls.manyToMany(context, handler, delegateStub::subscribe);
    }
    /**
         * <pre>
         *  ID of the current topic schema, which can be used for
         *  publishing of generically serialized events.
         * </pre>
         */
    public io.vertx.core.Future<io.vertx.core.streams.ReadStream<com.salesforce.eventbus.protobuf.PublishResponse>> publishStream(io.vertx.core.Completable<io.vertx.core.streams.WriteStream<com.salesforce.eventbus.protobuf.PublishRequest>> handler) {
      return io.vertx.grpcio.common.impl.stub.ClientCalls.manyToMany(context, handler, delegateStub::publishStream);
    }
    /**
         * <pre>
         *  RPC ID used to trace errors.
         * </pre>
         */
    public io.vertx.core.Future<io.vertx.core.streams.ReadStream<com.salesforce.eventbus.protobuf.ManagedFetchResponse>> managedSubscribe(io.vertx.core.Completable<io.vertx.core.streams.WriteStream<com.salesforce.eventbus.protobuf.ManagedFetchRequest>> handler) {
      return io.vertx.grpcio.common.impl.stub.ClientCalls.manyToMany(context, handler, delegateStub::managedSubscribe);
    }
  }

  /**
   * @return a service binding the given {@code service}.
   */
  public static io.grpc.BindableService bindableServiceOf(PubSubService service) {
    return new io.grpc.BindableService() {
      public io.grpc.ServerServiceDefinition bindService() {
        return serverServiceDefinition(service);
      }
    };
  }

  private static io.grpc.ServerServiceDefinition serverServiceDefinition(PubSubService service) {
    String compression = null;
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
      .addMethod(
        com.salesforce.eventbus.protobuf.PubSubGrpc.getSubscribeMethod(),
        asyncBidiStreamingCall(
                new MethodHandlers<
                        com.salesforce.eventbus.protobuf.FetchRequest,
                        com.salesforce.eventbus.protobuf.FetchResponse>(
                        service, METHODID_SUBSCRIBE, compression)))
      .addMethod(
        com.salesforce.eventbus.protobuf.PubSubGrpc.getGetSchemaMethod(),
        asyncUnaryCall(
                new MethodHandlers<
                        com.salesforce.eventbus.protobuf.SchemaRequest,
                        com.salesforce.eventbus.protobuf.SchemaInfo>(
                        service, METHODID_GET_SCHEMA, compression)))
      .addMethod(
        com.salesforce.eventbus.protobuf.PubSubGrpc.getGetTopicMethod(),
        asyncUnaryCall(
                new MethodHandlers<
                        com.salesforce.eventbus.protobuf.TopicRequest,
                        com.salesforce.eventbus.protobuf.TopicInfo>(
                        service, METHODID_GET_TOPIC, compression)))
      .addMethod(
        com.salesforce.eventbus.protobuf.PubSubGrpc.getPublishMethod(),
        asyncUnaryCall(
                new MethodHandlers<
                        com.salesforce.eventbus.protobuf.PublishRequest,
                        com.salesforce.eventbus.protobuf.PublishResponse>(
                        service, METHODID_PUBLISH, compression)))
      .addMethod(
        com.salesforce.eventbus.protobuf.PubSubGrpc.getPublishStreamMethod(),
        asyncBidiStreamingCall(
                new MethodHandlers<
                        com.salesforce.eventbus.protobuf.PublishRequest,
                        com.salesforce.eventbus.protobuf.PublishResponse>(
                        service, METHODID_PUBLISH_STREAM, compression)))
      .addMethod(
        com.salesforce.eventbus.protobuf.PubSubGrpc.getManagedSubscribeMethod(),
        asyncBidiStreamingCall(
                new MethodHandlers<
                        com.salesforce.eventbus.protobuf.ManagedFetchRequest,
                        com.salesforce.eventbus.protobuf.ManagedFetchResponse>(
                        service, METHODID_MANAGED_SUBSCRIBE, compression)))
      .build();
 }

  private static final int METHODID_SUBSCRIBE = 0;
  private static final int METHODID_GET_SCHEMA = 1;
  private static final int METHODID_GET_TOPIC = 2;
  private static final int METHODID_PUBLISH = 3;
  private static final int METHODID_PUBLISH_STREAM = 4;
  private static final int METHODID_MANAGED_SUBSCRIBE = 5;

  private static final class MethodHandlers<Req, Resp> implements
          io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

    private final PubSubService serviceImpl;
    private final int methodId;
    private final String compression;

    MethodHandlers(PubSubService serviceImpl, int methodId, String compression) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
      this.compression = compression;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SCHEMA:
          io.vertx.grpcio.common.impl.stub.ServerCalls.<com.salesforce.eventbus.protobuf.SchemaRequest, com.salesforce.eventbus.protobuf.SchemaInfo>oneToOne(
            (io.vertx.core.internal.ContextInternal) io.vertx.core.Vertx.currentContext(),
            (com.salesforce.eventbus.protobuf.SchemaRequest) request,
            (io.grpc.stub.StreamObserver<com.salesforce.eventbus.protobuf.SchemaInfo>) responseObserver,
            compression,
            serviceImpl::getSchema);
          break;
        case METHODID_GET_TOPIC:
          io.vertx.grpcio.common.impl.stub.ServerCalls.<com.salesforce.eventbus.protobuf.TopicRequest, com.salesforce.eventbus.protobuf.TopicInfo>oneToOne(
            (io.vertx.core.internal.ContextInternal) io.vertx.core.Vertx.currentContext(),
            (com.salesforce.eventbus.protobuf.TopicRequest) request,
            (io.grpc.stub.StreamObserver<com.salesforce.eventbus.protobuf.TopicInfo>) responseObserver,
            compression,
            serviceImpl::getTopic);
          break;
        case METHODID_PUBLISH:
          io.vertx.grpcio.common.impl.stub.ServerCalls.<com.salesforce.eventbus.protobuf.PublishRequest, com.salesforce.eventbus.protobuf.PublishResponse>oneToOne(
            (io.vertx.core.internal.ContextInternal) io.vertx.core.Vertx.currentContext(),
            (com.salesforce.eventbus.protobuf.PublishRequest) request,
            (io.grpc.stub.StreamObserver<com.salesforce.eventbus.protobuf.PublishResponse>) responseObserver,
            compression,
            serviceImpl::publish);
          break;
        default:
          throw new java.lang.AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
      StreamObserver<Req> reqStreamObserver;
      switch (methodId) {
        case METHODID_SUBSCRIBE:
          reqStreamObserver = (io.grpc.stub.StreamObserver<Req>) io.vertx.grpcio.common.impl.stub.ServerCalls.<com.salesforce.eventbus.protobuf.FetchRequest, com.salesforce.eventbus.protobuf.FetchResponse>manyToMany(
                  (io.vertx.core.internal.ContextInternal) io.vertx.core.Vertx.currentContext(),
                  (io.grpc.stub.StreamObserver<com.salesforce.eventbus.protobuf.FetchResponse>) responseObserver,
                  compression,
                  serviceImpl::subscribe);
          return reqStreamObserver;
        case METHODID_PUBLISH_STREAM:
          reqStreamObserver = (io.grpc.stub.StreamObserver<Req>) io.vertx.grpcio.common.impl.stub.ServerCalls.<com.salesforce.eventbus.protobuf.PublishRequest, com.salesforce.eventbus.protobuf.PublishResponse>manyToMany(
                  (io.vertx.core.internal.ContextInternal) io.vertx.core.Vertx.currentContext(),
                  (io.grpc.stub.StreamObserver<com.salesforce.eventbus.protobuf.PublishResponse>) responseObserver,
                  compression,
                  serviceImpl::publishStream);
          return reqStreamObserver;
        case METHODID_MANAGED_SUBSCRIBE:
          reqStreamObserver = (io.grpc.stub.StreamObserver<Req>) io.vertx.grpcio.common.impl.stub.ServerCalls.<com.salesforce.eventbus.protobuf.ManagedFetchRequest, com.salesforce.eventbus.protobuf.ManagedFetchResponse>manyToMany(
                  (io.vertx.core.internal.ContextInternal) io.vertx.core.Vertx.currentContext(),
                  (io.grpc.stub.StreamObserver<com.salesforce.eventbus.protobuf.ManagedFetchResponse>) responseObserver,
                  compression,
                  serviceImpl::managedSubscribe);
          return reqStreamObserver;
        default:
          throw new java.lang.AssertionError();
      }
    }
  }
}
