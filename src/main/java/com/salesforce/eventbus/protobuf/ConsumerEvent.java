// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: pubsub_api.proto
// Protobuf Java Version: 4.27.3

package com.salesforce.eventbus.protobuf;

/**
 * <pre>
 *
 * Represents an event that is consumed in a subscriber client.
 * In addition to the fields in ProducerEvent, ConsumerEvent has the replay_id field.
 * </pre>
 *
 * Protobuf type {@code eventbus.v1.ConsumerEvent}
 */
public final class ConsumerEvent extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:eventbus.v1.ConsumerEvent)
    ConsumerEventOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 3,
      /* suffix= */ "",
      ConsumerEvent.class.getName());
  }
  // Use ConsumerEvent.newBuilder() to construct.
  private ConsumerEvent(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private ConsumerEvent() {
    replayId_ = com.google.protobuf.ByteString.EMPTY;
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_ConsumerEvent_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_ConsumerEvent_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.salesforce.eventbus.protobuf.ConsumerEvent.class, com.salesforce.eventbus.protobuf.ConsumerEvent.Builder.class);
  }

  private int bitField0_;
  public static final int EVENT_FIELD_NUMBER = 1;
  private com.salesforce.eventbus.protobuf.ProducerEvent event_;
  /**
   * <pre>
   * The event with fields identical to ProducerEvent
   * </pre>
   *
   * <code>.eventbus.v1.ProducerEvent event = 1;</code>
   * @return Whether the event field is set.
   */
  @java.lang.Override
  public boolean hasEvent() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <pre>
   * The event with fields identical to ProducerEvent
   * </pre>
   *
   * <code>.eventbus.v1.ProducerEvent event = 1;</code>
   * @return The event.
   */
  @java.lang.Override
  public com.salesforce.eventbus.protobuf.ProducerEvent getEvent() {
    return event_ == null ? com.salesforce.eventbus.protobuf.ProducerEvent.getDefaultInstance() : event_;
  }
  /**
   * <pre>
   * The event with fields identical to ProducerEvent
   * </pre>
   *
   * <code>.eventbus.v1.ProducerEvent event = 1;</code>
   */
  @java.lang.Override
  public com.salesforce.eventbus.protobuf.ProducerEventOrBuilder getEventOrBuilder() {
    return event_ == null ? com.salesforce.eventbus.protobuf.ProducerEvent.getDefaultInstance() : event_;
  }

  public static final int REPLAY_ID_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString replayId_ = com.google.protobuf.ByteString.EMPTY;
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
  @java.lang.Override
  public com.google.protobuf.ByteString getReplayId() {
    return replayId_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getEvent());
    }
    if (!replayId_.isEmpty()) {
      output.writeBytes(2, replayId_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getEvent());
    }
    if (!replayId_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, replayId_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.salesforce.eventbus.protobuf.ConsumerEvent)) {
      return super.equals(obj);
    }
    com.salesforce.eventbus.protobuf.ConsumerEvent other = (com.salesforce.eventbus.protobuf.ConsumerEvent) obj;

    if (hasEvent() != other.hasEvent()) return false;
    if (hasEvent()) {
      if (!getEvent()
          .equals(other.getEvent())) return false;
    }
    if (!getReplayId()
        .equals(other.getReplayId())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasEvent()) {
      hash = (37 * hash) + EVENT_FIELD_NUMBER;
      hash = (53 * hash) + getEvent().hashCode();
    }
    hash = (37 * hash) + REPLAY_ID_FIELD_NUMBER;
    hash = (53 * hash) + getReplayId().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.salesforce.eventbus.protobuf.ConsumerEvent parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.salesforce.eventbus.protobuf.ConsumerEvent parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.ConsumerEvent parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.salesforce.eventbus.protobuf.ConsumerEvent parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.ConsumerEvent parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.salesforce.eventbus.protobuf.ConsumerEvent parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.ConsumerEvent parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.salesforce.eventbus.protobuf.ConsumerEvent parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.salesforce.eventbus.protobuf.ConsumerEvent parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.salesforce.eventbus.protobuf.ConsumerEvent parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.ConsumerEvent parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.salesforce.eventbus.protobuf.ConsumerEvent parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.salesforce.eventbus.protobuf.ConsumerEvent prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *
   * Represents an event that is consumed in a subscriber client.
   * In addition to the fields in ProducerEvent, ConsumerEvent has the replay_id field.
   * </pre>
   *
   * Protobuf type {@code eventbus.v1.ConsumerEvent}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:eventbus.v1.ConsumerEvent)
      com.salesforce.eventbus.protobuf.ConsumerEventOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_ConsumerEvent_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_ConsumerEvent_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.salesforce.eventbus.protobuf.ConsumerEvent.class, com.salesforce.eventbus.protobuf.ConsumerEvent.Builder.class);
    }

    // Construct using com.salesforce.eventbus.protobuf.ConsumerEvent.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage
              .alwaysUseFieldBuilders) {
        getEventFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      event_ = null;
      if (eventBuilder_ != null) {
        eventBuilder_.dispose();
        eventBuilder_ = null;
      }
      replayId_ = com.google.protobuf.ByteString.EMPTY;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_ConsumerEvent_descriptor;
    }

    @java.lang.Override
    public com.salesforce.eventbus.protobuf.ConsumerEvent getDefaultInstanceForType() {
      return com.salesforce.eventbus.protobuf.ConsumerEvent.getDefaultInstance();
    }

    @java.lang.Override
    public com.salesforce.eventbus.protobuf.ConsumerEvent build() {
      com.salesforce.eventbus.protobuf.ConsumerEvent result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.salesforce.eventbus.protobuf.ConsumerEvent buildPartial() {
      com.salesforce.eventbus.protobuf.ConsumerEvent result = new com.salesforce.eventbus.protobuf.ConsumerEvent(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.salesforce.eventbus.protobuf.ConsumerEvent result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.event_ = eventBuilder_ == null
            ? event_
            : eventBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.replayId_ = replayId_;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.salesforce.eventbus.protobuf.ConsumerEvent) {
        return mergeFrom((com.salesforce.eventbus.protobuf.ConsumerEvent)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.salesforce.eventbus.protobuf.ConsumerEvent other) {
      if (other == com.salesforce.eventbus.protobuf.ConsumerEvent.getDefaultInstance()) return this;
      if (other.hasEvent()) {
        mergeEvent(other.getEvent());
      }
      if (other.getReplayId() != com.google.protobuf.ByteString.EMPTY) {
        setReplayId(other.getReplayId());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getEventFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              replayId_ = input.readBytes();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private com.salesforce.eventbus.protobuf.ProducerEvent event_;
    private com.google.protobuf.SingleFieldBuilder<
        com.salesforce.eventbus.protobuf.ProducerEvent, com.salesforce.eventbus.protobuf.ProducerEvent.Builder, com.salesforce.eventbus.protobuf.ProducerEventOrBuilder> eventBuilder_;
    /**
     * <pre>
     * The event with fields identical to ProducerEvent
     * </pre>
     *
     * <code>.eventbus.v1.ProducerEvent event = 1;</code>
     * @return Whether the event field is set.
     */
    public boolean hasEvent() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * The event with fields identical to ProducerEvent
     * </pre>
     *
     * <code>.eventbus.v1.ProducerEvent event = 1;</code>
     * @return The event.
     */
    public com.salesforce.eventbus.protobuf.ProducerEvent getEvent() {
      if (eventBuilder_ == null) {
        return event_ == null ? com.salesforce.eventbus.protobuf.ProducerEvent.getDefaultInstance() : event_;
      } else {
        return eventBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The event with fields identical to ProducerEvent
     * </pre>
     *
     * <code>.eventbus.v1.ProducerEvent event = 1;</code>
     */
    public Builder setEvent(com.salesforce.eventbus.protobuf.ProducerEvent value) {
      if (eventBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        event_ = value;
      } else {
        eventBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The event with fields identical to ProducerEvent
     * </pre>
     *
     * <code>.eventbus.v1.ProducerEvent event = 1;</code>
     */
    public Builder setEvent(
        com.salesforce.eventbus.protobuf.ProducerEvent.Builder builderForValue) {
      if (eventBuilder_ == null) {
        event_ = builderForValue.build();
      } else {
        eventBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The event with fields identical to ProducerEvent
     * </pre>
     *
     * <code>.eventbus.v1.ProducerEvent event = 1;</code>
     */
    public Builder mergeEvent(com.salesforce.eventbus.protobuf.ProducerEvent value) {
      if (eventBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          event_ != null &&
          event_ != com.salesforce.eventbus.protobuf.ProducerEvent.getDefaultInstance()) {
          getEventBuilder().mergeFrom(value);
        } else {
          event_ = value;
        }
      } else {
        eventBuilder_.mergeFrom(value);
      }
      if (event_ != null) {
        bitField0_ |= 0x00000001;
        onChanged();
      }
      return this;
    }
    /**
     * <pre>
     * The event with fields identical to ProducerEvent
     * </pre>
     *
     * <code>.eventbus.v1.ProducerEvent event = 1;</code>
     */
    public Builder clearEvent() {
      bitField0_ = (bitField0_ & ~0x00000001);
      event_ = null;
      if (eventBuilder_ != null) {
        eventBuilder_.dispose();
        eventBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The event with fields identical to ProducerEvent
     * </pre>
     *
     * <code>.eventbus.v1.ProducerEvent event = 1;</code>
     */
    public com.salesforce.eventbus.protobuf.ProducerEvent.Builder getEventBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getEventFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The event with fields identical to ProducerEvent
     * </pre>
     *
     * <code>.eventbus.v1.ProducerEvent event = 1;</code>
     */
    public com.salesforce.eventbus.protobuf.ProducerEventOrBuilder getEventOrBuilder() {
      if (eventBuilder_ != null) {
        return eventBuilder_.getMessageOrBuilder();
      } else {
        return event_ == null ?
            com.salesforce.eventbus.protobuf.ProducerEvent.getDefaultInstance() : event_;
      }
    }
    /**
     * <pre>
     * The event with fields identical to ProducerEvent
     * </pre>
     *
     * <code>.eventbus.v1.ProducerEvent event = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        com.salesforce.eventbus.protobuf.ProducerEvent, com.salesforce.eventbus.protobuf.ProducerEvent.Builder, com.salesforce.eventbus.protobuf.ProducerEventOrBuilder> 
        getEventFieldBuilder() {
      if (eventBuilder_ == null) {
        eventBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            com.salesforce.eventbus.protobuf.ProducerEvent, com.salesforce.eventbus.protobuf.ProducerEvent.Builder, com.salesforce.eventbus.protobuf.ProducerEventOrBuilder>(
                getEvent(),
                getParentForChildren(),
                isClean());
        event_ = null;
      }
      return eventBuilder_;
    }

    private com.google.protobuf.ByteString replayId_ = com.google.protobuf.ByteString.EMPTY;
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
    @java.lang.Override
    public com.google.protobuf.ByteString getReplayId() {
      return replayId_;
    }
    /**
     * <pre>
     * The replay ID of the event.
     * A subscriber app can store the replay ID. When the app restarts, it can resume subscription
     * starting from events in the event bus after the event with that replay ID.
     * </pre>
     *
     * <code>bytes replay_id = 2;</code>
     * @param value The replayId to set.
     * @return This builder for chaining.
     */
    public Builder setReplayId(com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      replayId_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The replay ID of the event.
     * A subscriber app can store the replay ID. When the app restarts, it can resume subscription
     * starting from events in the event bus after the event with that replay ID.
     * </pre>
     *
     * <code>bytes replay_id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearReplayId() {
      bitField0_ = (bitField0_ & ~0x00000002);
      replayId_ = getDefaultInstance().getReplayId();
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:eventbus.v1.ConsumerEvent)
  }

  // @@protoc_insertion_point(class_scope:eventbus.v1.ConsumerEvent)
  private static final com.salesforce.eventbus.protobuf.ConsumerEvent DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.salesforce.eventbus.protobuf.ConsumerEvent();
  }

  public static com.salesforce.eventbus.protobuf.ConsumerEvent getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ConsumerEvent>
      PARSER = new com.google.protobuf.AbstractParser<ConsumerEvent>() {
    @java.lang.Override
    public ConsumerEvent parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<ConsumerEvent> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ConsumerEvent> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.salesforce.eventbus.protobuf.ConsumerEvent getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
