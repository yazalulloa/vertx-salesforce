package com.yaz.vertx_salesforce;

import com.salesforce.eventbus.protobuf.PubSubGrpc;
import com.salesforce.eventbus.protobuf.PubSubGrpcIo;
import com.salesforce.eventbus.protobuf.PubSubGrpcService;
import com.salesforce.eventbus.protobuf.PubSubService;
import com.salesforce.eventbus.protobuf.TopicInfo;
import com.salesforce.eventbus.protobuf.TopicRequest;
import io.grpc.stub.StreamObserver;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.net.SocketAddress;
import io.vertx.ext.web.Router;
import io.vertx.grpc.client.GrpcClient;
import io.vertx.grpc.server.GrpcServer;
import io.vertx.grpcio.client.GrpcIoClient;
import io.vertx.grpcio.client.GrpcIoClientChannel;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Slf4j
@ExtendWith(VertxExtension.class)
public class SalesforceTest {

  private static int port = 43624; // Port for the HTTP server

  @BeforeAll
  static void beforeAll(Vertx vertx, VertxTestContext testContext) {

    final var grpcServer = GrpcServer.server(vertx);
    final var service = PubSubGrpcService.of(new PubSubService() {
      @Override
      public Future<TopicInfo> getTopic(TopicRequest request) {
        log.info("Received getTopic request for topic: {}", request.getTopicName());

        return Future.succeededFuture(TopicInfo.newBuilder()
          .setTopicName(request.getTopicName())
          .setCanSubscribe(true)
          .setCanPublish(true)
          .setSchemaId(request.getTopicName())
          .setTenantGuid("tenantGuid")
          .setRpcId(UUID.randomUUID().toString())
          .build());
      }
    });

    service.bind(grpcServer);

    final var router = Router.router(vertx);

    router.route()
      .consumes("application/grpc")
      .handler(rc -> {

        Assertions.assertNotNull(UUID.fromString(rc.request().getHeader(Constants.ACCESS_TOKEN_HEADER)));
        Assertions.assertNotNull(UUID.fromString(rc.request().getHeader(Constants.TENANT_ID_HEADER)));
        Assertions.assertNotNull(rc.request().getHeader(Constants.INSTANCE_URL_HEADER));
        Assertions.assertNotNull(rc.request().getHeader(Constants.X_CLIENT_TRACE_ID_HEADER));

        rc.next();
      })
      .handler(rc -> grpcServer.handle(rc.request()))
      .failureHandler(rc -> {
        final var throwable = rc.failure();
        log.error("Server Error", throwable);
        rc.response().setStatusCode(500).end(throwable.getMessage());
      });

    vertx.createHttpServer()
      .requestHandler(router)
      .listen(port)
      .onSuccess(server -> {
        log.info("HTTP server started on port: {}", server.actualPort());
        testContext.completeNow();
      })
      .onFailure(testContext::failNow);
  }

  @Test
  void grpc(Vertx vertx, VertxTestContext testContext) {
    final var httpClientOptions = new HttpClientOptions()
      .setSsl(port == 443)
      .setUseAlpn(true);

    final var grpcClient = GrpcIoClient.client(vertx, httpClientOptions);
    final var socketAddress = SocketAddress.inetSocketAddress(port, "localhost");
    final var channel = new GrpcIoClientChannel(grpcClient, socketAddress);

    final var pubSubStub = PubSubGrpc.newStub(channel)
      .withInterceptors(new SalesForceHeaderClientInterceptor());

    pubSubStub.getTopic(TopicRequest.newBuilder().setTopicName("some-topic").build(), new StreamObserver<TopicInfo>() {
      @Override
      public void onNext(TopicInfo topicInfo) {
        log.info("Received topic info: {}", topicInfo);
        testContext.completeNow();
      }

      @Override
      public void onError(Throwable throwable) {
        log.error("Error occurred while fetching topic info", throwable);
        testContext.failNow(throwable);
      }

      @Override
      public void onCompleted() {
        log.info("Completed fetching topic info");
        // No action needed here, as we handle the response in onNext
      }
    });
  }

  @Test
  void grpcIo(Vertx vertx, VertxTestContext testContext) {
    final var httpClientOptions = new HttpClientOptions()
      .setSsl(port == 443)
      .setUseAlpn(true);

    final var grpcClient = GrpcIoClient.client(vertx, httpClientOptions);
    final var socketAddress = SocketAddress.inetSocketAddress(port, "localhost");
    final var channel = new GrpcIoClientChannel(grpcClient, socketAddress);

    // Fails with java.lang.ClassCastException: class io.grpc.ClientInterceptors$InterceptorChannel cannot be cast to class io.vertx.grpcio.client.GrpcIoClientChannel (io.grpc.ClientInterceptors$InterceptorChannel and io.vertx.grpcio.client.GrpcIoClientChannel are in unnamed module of loader 'app')
    final var pubSubStub = PubSubGrpcIo.newStub(vertx, channel)
      .withInterceptors(new SalesForceHeaderClientInterceptor());

    pubSubStub.getTopic(TopicRequest.newBuilder().setTopicName("some-topic").build())
      .onSuccess(topicInfo -> {
        log.info("Received topic info: {}", topicInfo);
        testContext.completeNow();
      })
      .onFailure(testContext::failNow);
  }
}
