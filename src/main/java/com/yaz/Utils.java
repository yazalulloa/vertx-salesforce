package com.yaz;

import io.grpc.stub.StreamObserver;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class Utils {

  private Utils() {
    //Empty construct for utils
  }


  public static String toString(CharSequence charSequence) {
    return charSequence == null ? null : String.valueOf(charSequence);
  }

  public static <T> Maybe<T> maybe(Consumer<StreamObserver<T>> consumer) {
    final var source = maybeOnSubscribe(consumer);
    return Maybe.create(source);
  }

  public static <T> MaybeOnSubscribe<T> maybeOnSubscribe(Consumer<StreamObserver<T>> consumer) {
    return emitter -> {
      final StreamObserver<T> actionListener = streamObserver(emitter);
      consumer.accept(actionListener);
    };
  }

  public static <T> StreamObserver<T> streamObserver(MaybeEmitter<T> emitter) {
    final var atomicBoolean = new AtomicBoolean(false);
    return new StreamObserver<T>() {
      @Override
      public void onNext(T value) {
        atomicBoolean.set(true);
        emitter.onSuccess(value);

      }

      @Override
      public void onError(Throwable t) {
        atomicBoolean.set(true);
        emitter.onError(t);
      }

      @Override
      public void onCompleted() {
        if (!atomicBoolean.get()) {
          emitter.onComplete();
        }
      }
    };
  }
}
