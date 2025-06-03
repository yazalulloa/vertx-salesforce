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
public class PubSubGrpcService extends PubSubService implements Service {

  /**
   * PubSub service name.
   */
  public static final ServiceName SERVICE_NAME = ServiceName.create("eventbus.v1", "PubSub");

  /**
   * PubSub service descriptor.
   */
  public static final Descriptors.ServiceDescriptor SERVICE_DESCRIPTOR = PubSubProto.getDescriptor().findServiceByName("PubSub");

  @Override
  public ServiceName name() {
    return SERVICE_NAME;
  }

  @Override
  public Descriptors.ServiceDescriptor descriptor() {
    return SERVICE_DESCRIPTOR;
  }

  @Override
  public void bind(GrpcServer server) {
    builder(this).bind(all()).build().bind(server);
  }

  /**
   * @return a service binding all methods of the given {@code service}
   */
  public static Service of(PubSubService service) {
    return builder(service).bind(all()).build();
  }

  /**
   * Subscribe protobuf RPC server service method.
   */
  public static final ServiceMethod<com.salesforce.eventbus.protobuf.FetchRequest, com.salesforce.eventbus.protobuf.FetchResponse> Subscribe = ServiceMethod.server(
    SERVICE_NAME,
    "Subscribe",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.salesforce.eventbus.protobuf.FetchRequest.newBuilder()));

  /**
   * GetSchema protobuf RPC server service method.
   */
  public static final ServiceMethod<com.salesforce.eventbus.protobuf.SchemaRequest, com.salesforce.eventbus.protobuf.SchemaInfo> GetSchema = ServiceMethod.server(
    SERVICE_NAME,
    "GetSchema",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.salesforce.eventbus.protobuf.SchemaRequest.newBuilder()));

  /**
   * GetTopic protobuf RPC server service method.
   */
  public static final ServiceMethod<com.salesforce.eventbus.protobuf.TopicRequest, com.salesforce.eventbus.protobuf.TopicInfo> GetTopic = ServiceMethod.server(
    SERVICE_NAME,
    "GetTopic",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.salesforce.eventbus.protobuf.TopicRequest.newBuilder()));

  /**
   * Publish protobuf RPC server service method.
   */
  public static final ServiceMethod<com.salesforce.eventbus.protobuf.PublishRequest, com.salesforce.eventbus.protobuf.PublishResponse> Publish = ServiceMethod.server(
    SERVICE_NAME,
    "Publish",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.salesforce.eventbus.protobuf.PublishRequest.newBuilder()));

  /**
   * PublishStream protobuf RPC server service method.
   */
  public static final ServiceMethod<com.salesforce.eventbus.protobuf.PublishRequest, com.salesforce.eventbus.protobuf.PublishResponse> PublishStream = ServiceMethod.server(
    SERVICE_NAME,
    "PublishStream",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.salesforce.eventbus.protobuf.PublishRequest.newBuilder()));

  /**
   * ManagedSubscribe protobuf RPC server service method.
   */
  public static final ServiceMethod<com.salesforce.eventbus.protobuf.ManagedFetchRequest, com.salesforce.eventbus.protobuf.ManagedFetchResponse> ManagedSubscribe = ServiceMethod.server(
    SERVICE_NAME,
    "ManagedSubscribe",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.salesforce.eventbus.protobuf.ManagedFetchRequest.newBuilder()));

  /**
   * @return a mutable list of the known protobuf RPC server service methods.
   */
  public static java.util.List<ServiceMethod<?, ?>> all() {
    java.util.List<ServiceMethod<?, ?>> all = new java.util.ArrayList<>();
    all.add(Subscribe);
    all.add(GetSchema);
    all.add(GetTopic);
    all.add(Publish);
    all.add(PublishStream);
    all.add(ManagedSubscribe);
    return all;
  }


  /**
   * @return a free form builder that gives the opportunity to bind only certain methods of a service
   */
  public static Builder builder(PubSubService service) {
    return new Builder(service);
  }

  /**
   * Service builder.
   */
  public static class Builder implements ServiceBuilder {

    private final List<ServiceMethod<?, ?>> serviceMethods = new ArrayList<>();
    private final PubSubService instance;

    private Builder(PubSubService instance) {
      this.instance = instance;
    }

//    private void validate() {
//      for (ServiceMethod<?, ?> serviceMethod : serviceMethods) {
//        if (resolveHandler(serviceMethod) == null) {
//          throw new IllegalArgumentException("Invalid service method:" + serviceMethod);
//        }
//      }
//    }

    /**
     * Throws {@code UnsupportedOperationException}.
     */
    public <Req, Resp> ServiceBuilder bind(ServiceMethod<Req, Resp> serviceMethod, Handler<GrpcServerRequest<Req, Resp>> handler) {
      throw new UnsupportedOperationException();
    }

    /**
     * @return this builder
     */
    public Builder bind(List<ServiceMethod<?, ?>> methods) {
      serviceMethods.addAll(methods);
      return this;
    }

    /**
     * @return this builder
     */
    public Builder bind(ServiceMethod<?, ?>... methods) {
      return bind(java.util.Arrays.asList(methods));
    }

    public Service build() {
      return new Invoker();
    }

    private class Invoker implements Service {

      // Defensive copy
      private final List<ServiceMethod<?, ?>> serviceMethods = new ArrayList<>(Builder.this.serviceMethods);

      public ServiceName name() {
        return SERVICE_NAME;
      }

      public Descriptors.ServiceDescriptor descriptor() {
        return SERVICE_DESCRIPTOR;
      }

      /**
       * Bind the contained service methods to the {@code server}.
       */
      public void bind(GrpcServer server) {
        for (ServiceMethod<?, ?> serviceMethod : serviceMethods) {
          bindHandler(serviceMethod, server);
        }
      }

      private <Req, Resp> void bindHandler(ServiceMethod<Req, Resp> serviceMethod, GrpcServer server) {
        Handler<io.vertx.grpc.server.GrpcServerRequest<Req, Resp>> handler = resolveHandler(serviceMethod);
        server.callHandler(serviceMethod, handler);
      }

      private <Req, Resp> Handler<io.vertx.grpc.server.GrpcServerRequest<Req, Resp>> resolveHandler(ServiceMethod<Req, Resp> serviceMethod) {
        if (Subscribe == serviceMethod) {
          Handler<io.vertx.grpc.server.GrpcServerRequest<com.salesforce.eventbus.protobuf.FetchRequest, com.salesforce.eventbus.protobuf.FetchResponse>> handler = this::handle_subscribe;
          Handler<?> handler2 = handler;
          return (Handler<io.vertx.grpc.server.GrpcServerRequest<Req, Resp>>) handler2;
        }
        if (GetSchema == serviceMethod) {
          Handler<io.vertx.grpc.server.GrpcServerRequest<com.salesforce.eventbus.protobuf.SchemaRequest, com.salesforce.eventbus.protobuf.SchemaInfo>> handler = this::handle_getSchema;
          Handler<?> handler2 = handler;
          return (Handler<io.vertx.grpc.server.GrpcServerRequest<Req, Resp>>) handler2;
        }
        if (GetTopic == serviceMethod) {
          Handler<io.vertx.grpc.server.GrpcServerRequest<com.salesforce.eventbus.protobuf.TopicRequest, com.salesforce.eventbus.protobuf.TopicInfo>> handler = this::handle_getTopic;
          Handler<?> handler2 = handler;
          return (Handler<io.vertx.grpc.server.GrpcServerRequest<Req, Resp>>) handler2;
        }
        if (Publish == serviceMethod) {
          Handler<io.vertx.grpc.server.GrpcServerRequest<com.salesforce.eventbus.protobuf.PublishRequest, com.salesforce.eventbus.protobuf.PublishResponse>> handler = this::handle_publish;
          Handler<?> handler2 = handler;
          return (Handler<io.vertx.grpc.server.GrpcServerRequest<Req, Resp>>) handler2;
        }
        if (PublishStream == serviceMethod) {
          Handler<io.vertx.grpc.server.GrpcServerRequest<com.salesforce.eventbus.protobuf.PublishRequest, com.salesforce.eventbus.protobuf.PublishResponse>> handler = this::handle_publishStream;
          Handler<?> handler2 = handler;
          return (Handler<io.vertx.grpc.server.GrpcServerRequest<Req, Resp>>) handler2;
        }
        if (ManagedSubscribe == serviceMethod) {
          Handler<io.vertx.grpc.server.GrpcServerRequest<com.salesforce.eventbus.protobuf.ManagedFetchRequest, com.salesforce.eventbus.protobuf.ManagedFetchResponse>> handler = this::handle_managedSubscribe;
          Handler<?> handler2 = handler;
          return (Handler<io.vertx.grpc.server.GrpcServerRequest<Req, Resp>>) handler2;
        }
        return null;
      }


  private void handle_getSchema(io.vertx.grpc.server.GrpcServerRequest<com.salesforce.eventbus.protobuf.SchemaRequest, com.salesforce.eventbus.protobuf.SchemaInfo> request) {
    request.handler(msg -> {
      try {
        instance.getSchema(msg, (res, err) -> {
          if (err == null) {
            request.response().end(res);
          } else {
            request.response().status(GrpcStatus.UNKNOWN).end();
          }
        });
      } catch (UnsupportedOperationException err) {
        request.response().status(GrpcStatus.UNIMPLEMENTED).end();
      } catch (RuntimeException err) {
        request.response().status(GrpcStatus.UNKNOWN).end();
      }
    });
  }

  private void handle_getTopic(io.vertx.grpc.server.GrpcServerRequest<com.salesforce.eventbus.protobuf.TopicRequest, com.salesforce.eventbus.protobuf.TopicInfo> request) {
    request.handler(msg -> {
      try {
        instance.getTopic(msg, (res, err) -> {
          if (err == null) {
            request.response().end(res);
          } else {
            request.response().status(GrpcStatus.UNKNOWN).end();
          }
        });
      } catch (UnsupportedOperationException err) {
        request.response().status(GrpcStatus.UNIMPLEMENTED).end();
      } catch (RuntimeException err) {
        request.response().status(GrpcStatus.UNKNOWN).end();
      }
    });
  }

  private void handle_publish(io.vertx.grpc.server.GrpcServerRequest<com.salesforce.eventbus.protobuf.PublishRequest, com.salesforce.eventbus.protobuf.PublishResponse> request) {
    request.handler(msg -> {
      try {
        instance.publish(msg, (res, err) -> {
          if (err == null) {
            request.response().end(res);
          } else {
            request.response().status(GrpcStatus.UNKNOWN).end();
          }
        });
      } catch (UnsupportedOperationException err) {
        request.response().status(GrpcStatus.UNIMPLEMENTED).end();
      } catch (RuntimeException err) {
        request.response().status(GrpcStatus.UNKNOWN).end();
      }
    });
  }

  private void handle_subscribe(io.vertx.grpc.server.GrpcServerRequest<com.salesforce.eventbus.protobuf.FetchRequest, com.salesforce.eventbus.protobuf.FetchResponse> request) {
    try {
      instance.subscribe(request, request.response());
     } catch (UnsupportedOperationException err) {
      request.response().status(GrpcStatus.UNIMPLEMENTED).end();
     } catch (RuntimeException err) {
      request.response().status(GrpcStatus.UNKNOWN).end();
    }
  }

  private void handle_publishStream(io.vertx.grpc.server.GrpcServerRequest<com.salesforce.eventbus.protobuf.PublishRequest, com.salesforce.eventbus.protobuf.PublishResponse> request) {
    try {
      instance.publishStream(request, request.response());
     } catch (UnsupportedOperationException err) {
      request.response().status(GrpcStatus.UNIMPLEMENTED).end();
     } catch (RuntimeException err) {
      request.response().status(GrpcStatus.UNKNOWN).end();
    }
  }

  private void handle_managedSubscribe(io.vertx.grpc.server.GrpcServerRequest<com.salesforce.eventbus.protobuf.ManagedFetchRequest, com.salesforce.eventbus.protobuf.ManagedFetchResponse> request) {
    try {
      instance.managedSubscribe(request, request.response());
     } catch (UnsupportedOperationException err) {
      request.response().status(GrpcStatus.UNIMPLEMENTED).end();
     } catch (RuntimeException err) {
      request.response().status(GrpcStatus.UNKNOWN).end();
    }
  }
    }
  }
}
