// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: pubsub_api.proto
// Protobuf Java Version: 4.27.3

package com.salesforce.eventbus.protobuf;

public interface ErrorOrBuilder extends
    // @@protoc_insertion_point(interface_extends:eventbus.v1.Error)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Error code
   * </pre>
   *
   * <code>.eventbus.v1.ErrorCode code = 1;</code>
   * @return The enum numeric value on the wire for code.
   */
  int getCodeValue();
  /**
   * <pre>
   * Error code
   * </pre>
   *
   * <code>.eventbus.v1.ErrorCode code = 1;</code>
   * @return The code.
   */
  com.salesforce.eventbus.protobuf.ErrorCode getCode();

  /**
   * <pre>
   * Error message
   * </pre>
   *
   * <code>string msg = 2;</code>
   * @return The msg.
   */
  java.lang.String getMsg();
  /**
   * <pre>
   * Error message
   * </pre>
   *
   * <code>string msg = 2;</code>
   * @return The bytes for msg.
   */
  com.google.protobuf.ByteString
      getMsgBytes();
}