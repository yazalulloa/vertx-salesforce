package com.yaz;

import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Slf4j
@ExtendWith(VertxExtension.class)
class SalesForceClientTest {

  private boolean expectedFailure(Throwable throwable) {
    if (throwable instanceof StatusRuntimeException t) {
      return t.getStatus().getCode().value() == Code.UNAUTHENTICATED.value();
    }

    return false;
  }

  @Test
  void test_async(VertxTestContext testContext) {
    final var client = new SalesForceClient();

    client.async()
        .toSingle()
        .subscribe(topicInfo -> {
          testContext.completeNow();

        }, throwable -> {

          if (expectedFailure(throwable)) {
            testContext.completeNow();
            return;
          }

          testContext.failNow(throwable);
        });
  }

  @Test
  void test_blocking() {
    final var client = new SalesForceClient();

    try {
      client.blocking();
    } catch (Throwable throwable) {
      assert expectedFailure(throwable);
    }
  }

  @Test
  void test_asyncWithVertxChannel(Vertx vertx, VertxTestContext testContext) {
    final var client = new SalesForceClient();

    client.asyncWithVertxChannel(vertx)
        .toSingle()
        .subscribe(topicInfo -> {
          testContext.completeNow();
        }, throwable -> {

          if (expectedFailure(throwable)) {
            testContext.completeNow();
            return;
          }

          testContext.failNow(throwable);
        });

  }

  @Test
  void test_vertx(Vertx vertx, VertxTestContext testContext) {
    final var client = new SalesForceClient();

    client.vertx(vertx)
        .subscribe(topicInfo -> {
          testContext.completeNow();
        }, throwable -> {

          if (expectedFailure(throwable)) {
            testContext.completeNow();
            return;
          }

          testContext.failNow(throwable);
        });

  }

}