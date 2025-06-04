package com.yaz.vertx_salesforce;

import io.vertx.core.AbstractVerticle;
import java.util.UUID;

public class TokenVerticle extends AbstractVerticle {

  public static final String ADDRESS = "com.yaz.vertx_salesforce.token";

  @Override
  public void start() throws Exception {
    vertx.eventBus().consumer(ADDRESS, msg -> {

      vertx.setTimer(500, id -> {
        // Simulate a delay to get the token
        msg.reply(UUID.randomUUID().toString());
      });

    });
  }
}
