// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: pubsub_api.proto
// Protobuf Java Version: 4.27.3

package com.salesforce.eventbus.protobuf;

public interface ConsumerEventOrBuilder extends
    // @@protoc_insertion_point(interface_extends:eventbus.v1.ConsumerEvent)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The event with fields identical to ProducerEvent
   * </pre>
   *
   * <code>.eventbus.v1.ProducerEvent event = 1;</code>
   * @return Whether the event field is set.
   */
  boolean hasEvent();
  /**
   * <pre>
   * The event with fields identical to ProducerEvent
   * </pre>
   *
   * <code>.eventbus.v1.ProducerEvent event = 1;</code>
   * @return The event.
   */
  com.salesforce.eventbus.protobuf.ProducerEvent getEvent();
  /**
   * <pre>
   * The event with fields identical to ProducerEvent
   * </pre>
   *
   * <code>.eventbus.v1.ProducerEvent event = 1;</code>
   */
  com.salesforce.eventbus.protobuf.ProducerEventOrBuilder getEventOrBuilder();

  /**
   * <pre>
   * The replay ID of the event.
   * A subscriber app can store the replay ID. When the app restarts, it can resume subscription
   * starting from events in the event bus after the event with that replay ID.
   * </pre>
   *
   * <code>bytes replay_id = 2;</code>
   * @return The replayId.
   */
  com.google.protobuf.ByteString getReplayId();
}
