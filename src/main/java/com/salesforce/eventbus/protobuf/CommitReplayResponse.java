// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: pubsub_api.proto
// Protobuf Java Version: 4.27.3

package com.salesforce.eventbus.protobuf;

/**
 * <pre>
 *
 * This feature is part of an open beta release and is subject to the applicable
 * Beta Services Terms provided at Agreements and Terms
 * (https://www.salesforce.com/company/legal/agreements/).
 *
 * There is no guaranteed 1:1 CommitReplayRequest to CommitReplayResponse.
 * N CommitReplayRequest(s) can get compressed in a batch resulting in a single
 * CommitReplayResponse which reflects the latest values of last
 * CommitReplayRequest in that batch.
 * </pre>
 *
 * Protobuf type {@code eventbus.v1.CommitReplayResponse}
 */
public final class CommitReplayResponse extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:eventbus.v1.CommitReplayResponse)
    CommitReplayResponseOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 3,
      /* suffix= */ "",
      CommitReplayResponse.class.getName());
  }
  // Use CommitReplayResponse.newBuilder() to construct.
  private CommitReplayResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private CommitReplayResponse() {
    commitRequestId_ = "";
    replayId_ = com.google.protobuf.ByteString.EMPTY;
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_CommitReplayResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_CommitReplayResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.salesforce.eventbus.protobuf.CommitReplayResponse.class, com.salesforce.eventbus.protobuf.CommitReplayResponse.Builder.class);
  }

  private int bitField0_;
  public static final int COMMIT_REQUEST_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object commitRequestId_ = "";
  /**
   * <pre>
   * commit_request_id to identify commit responses.
   * </pre>
   *
   * <code>string commit_request_id = 1;</code>
   * @return The commitRequestId.
   */
  @java.lang.Override
  public java.lang.String getCommitRequestId() {
    java.lang.Object ref = commitRequestId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      commitRequestId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * commit_request_id to identify commit responses.
   * </pre>
   *
   * <code>string commit_request_id = 1;</code>
   * @return The bytes for commitRequestId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCommitRequestIdBytes() {
    java.lang.Object ref = commitRequestId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      commitRequestId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int REPLAY_ID_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString replayId_ = com.google.protobuf.ByteString.EMPTY;
  /**
   * <pre>
   * replayId that may have been committed
   * </pre>
   *
   * <code>bytes replay_id = 2;</code>
   * @return The replayId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getReplayId() {
    return replayId_;
  }

  public static final int ERROR_FIELD_NUMBER = 3;
  private com.salesforce.eventbus.protobuf.Error error_;
  /**
   * <pre>
   * for failed commits
   * </pre>
   *
   * <code>.eventbus.v1.Error error = 3;</code>
   * @return Whether the error field is set.
   */
  @java.lang.Override
  public boolean hasError() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <pre>
   * for failed commits
   * </pre>
   *
   * <code>.eventbus.v1.Error error = 3;</code>
   * @return The error.
   */
  @java.lang.Override
  public com.salesforce.eventbus.protobuf.Error getError() {
    return error_ == null ? com.salesforce.eventbus.protobuf.Error.getDefaultInstance() : error_;
  }
  /**
   * <pre>
   * for failed commits
   * </pre>
   *
   * <code>.eventbus.v1.Error error = 3;</code>
   */
  @java.lang.Override
  public com.salesforce.eventbus.protobuf.ErrorOrBuilder getErrorOrBuilder() {
    return error_ == null ? com.salesforce.eventbus.protobuf.Error.getDefaultInstance() : error_;
  }

  public static final int PROCESS_TIME_FIELD_NUMBER = 4;
  private long processTime_ = 0L;
  /**
   * <pre>
   * time when server received request in epoch ms
   * </pre>
   *
   * <code>int64 process_time = 4;</code>
   * @return The processTime.
   */
  @java.lang.Override
  public long getProcessTime() {
    return processTime_;
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
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(commitRequestId_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, commitRequestId_);
    }
    if (!replayId_.isEmpty()) {
      output.writeBytes(2, replayId_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(3, getError());
    }
    if (processTime_ != 0L) {
      output.writeInt64(4, processTime_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(commitRequestId_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, commitRequestId_);
    }
    if (!replayId_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, replayId_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getError());
    }
    if (processTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, processTime_);
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
    if (!(obj instanceof com.salesforce.eventbus.protobuf.CommitReplayResponse)) {
      return super.equals(obj);
    }
    com.salesforce.eventbus.protobuf.CommitReplayResponse other = (com.salesforce.eventbus.protobuf.CommitReplayResponse) obj;

    if (!getCommitRequestId()
        .equals(other.getCommitRequestId())) return false;
    if (!getReplayId()
        .equals(other.getReplayId())) return false;
    if (hasError() != other.hasError()) return false;
    if (hasError()) {
      if (!getError()
          .equals(other.getError())) return false;
    }
    if (getProcessTime()
        != other.getProcessTime()) return false;
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
    hash = (37 * hash) + COMMIT_REQUEST_ID_FIELD_NUMBER;
    hash = (53 * hash) + getCommitRequestId().hashCode();
    hash = (37 * hash) + REPLAY_ID_FIELD_NUMBER;
    hash = (53 * hash) + getReplayId().hashCode();
    if (hasError()) {
      hash = (37 * hash) + ERROR_FIELD_NUMBER;
      hash = (53 * hash) + getError().hashCode();
    }
    hash = (37 * hash) + PROCESS_TIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getProcessTime());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.salesforce.eventbus.protobuf.CommitReplayResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.salesforce.eventbus.protobuf.CommitReplayResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.CommitReplayResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.salesforce.eventbus.protobuf.CommitReplayResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.CommitReplayResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.salesforce.eventbus.protobuf.CommitReplayResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.CommitReplayResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.salesforce.eventbus.protobuf.CommitReplayResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.salesforce.eventbus.protobuf.CommitReplayResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.salesforce.eventbus.protobuf.CommitReplayResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.CommitReplayResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.salesforce.eventbus.protobuf.CommitReplayResponse parseFrom(
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
  public static Builder newBuilder(com.salesforce.eventbus.protobuf.CommitReplayResponse prototype) {
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
   * This feature is part of an open beta release and is subject to the applicable
   * Beta Services Terms provided at Agreements and Terms
   * (https://www.salesforce.com/company/legal/agreements/).
   *
   * There is no guaranteed 1:1 CommitReplayRequest to CommitReplayResponse.
   * N CommitReplayRequest(s) can get compressed in a batch resulting in a single
   * CommitReplayResponse which reflects the latest values of last
   * CommitReplayRequest in that batch.
   * </pre>
   *
   * Protobuf type {@code eventbus.v1.CommitReplayResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:eventbus.v1.CommitReplayResponse)
      com.salesforce.eventbus.protobuf.CommitReplayResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_CommitReplayResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_CommitReplayResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.salesforce.eventbus.protobuf.CommitReplayResponse.class, com.salesforce.eventbus.protobuf.CommitReplayResponse.Builder.class);
    }

    // Construct using com.salesforce.eventbus.protobuf.CommitReplayResponse.newBuilder()
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
        getErrorFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      commitRequestId_ = "";
      replayId_ = com.google.protobuf.ByteString.EMPTY;
      error_ = null;
      if (errorBuilder_ != null) {
        errorBuilder_.dispose();
        errorBuilder_ = null;
      }
      processTime_ = 0L;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_CommitReplayResponse_descriptor;
    }

    @java.lang.Override
    public com.salesforce.eventbus.protobuf.CommitReplayResponse getDefaultInstanceForType() {
      return com.salesforce.eventbus.protobuf.CommitReplayResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.salesforce.eventbus.protobuf.CommitReplayResponse build() {
      com.salesforce.eventbus.protobuf.CommitReplayResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.salesforce.eventbus.protobuf.CommitReplayResponse buildPartial() {
      com.salesforce.eventbus.protobuf.CommitReplayResponse result = new com.salesforce.eventbus.protobuf.CommitReplayResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.salesforce.eventbus.protobuf.CommitReplayResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.commitRequestId_ = commitRequestId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.replayId_ = replayId_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.error_ = errorBuilder_ == null
            ? error_
            : errorBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.processTime_ = processTime_;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.salesforce.eventbus.protobuf.CommitReplayResponse) {
        return mergeFrom((com.salesforce.eventbus.protobuf.CommitReplayResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.salesforce.eventbus.protobuf.CommitReplayResponse other) {
      if (other == com.salesforce.eventbus.protobuf.CommitReplayResponse.getDefaultInstance()) return this;
      if (!other.getCommitRequestId().isEmpty()) {
        commitRequestId_ = other.commitRequestId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getReplayId() != com.google.protobuf.ByteString.EMPTY) {
        setReplayId(other.getReplayId());
      }
      if (other.hasError()) {
        mergeError(other.getError());
      }
      if (other.getProcessTime() != 0L) {
        setProcessTime(other.getProcessTime());
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
              commitRequestId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              replayId_ = input.readBytes();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              input.readMessage(
                  getErrorFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 32: {
              processTime_ = input.readInt64();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
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

    private java.lang.Object commitRequestId_ = "";
    /**
     * <pre>
     * commit_request_id to identify commit responses.
     * </pre>
     *
     * <code>string commit_request_id = 1;</code>
     * @return The commitRequestId.
     */
    public java.lang.String getCommitRequestId() {
      java.lang.Object ref = commitRequestId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        commitRequestId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * commit_request_id to identify commit responses.
     * </pre>
     *
     * <code>string commit_request_id = 1;</code>
     * @return The bytes for commitRequestId.
     */
    public com.google.protobuf.ByteString
        getCommitRequestIdBytes() {
      java.lang.Object ref = commitRequestId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        commitRequestId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * commit_request_id to identify commit responses.
     * </pre>
     *
     * <code>string commit_request_id = 1;</code>
     * @param value The commitRequestId to set.
     * @return This builder for chaining.
     */
    public Builder setCommitRequestId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      commitRequestId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * commit_request_id to identify commit responses.
     * </pre>
     *
     * <code>string commit_request_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCommitRequestId() {
      commitRequestId_ = getDefaultInstance().getCommitRequestId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * commit_request_id to identify commit responses.
     * </pre>
     *
     * <code>string commit_request_id = 1;</code>
     * @param value The bytes for commitRequestId to set.
     * @return This builder for chaining.
     */
    public Builder setCommitRequestIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      commitRequestId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString replayId_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     * replayId that may have been committed
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
     * replayId that may have been committed
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
     * replayId that may have been committed
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

    private com.salesforce.eventbus.protobuf.Error error_;
    private com.google.protobuf.SingleFieldBuilder<
        com.salesforce.eventbus.protobuf.Error, com.salesforce.eventbus.protobuf.Error.Builder, com.salesforce.eventbus.protobuf.ErrorOrBuilder> errorBuilder_;
    /**
     * <pre>
     * for failed commits
     * </pre>
     *
     * <code>.eventbus.v1.Error error = 3;</code>
     * @return Whether the error field is set.
     */
    public boolean hasError() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <pre>
     * for failed commits
     * </pre>
     *
     * <code>.eventbus.v1.Error error = 3;</code>
     * @return The error.
     */
    public com.salesforce.eventbus.protobuf.Error getError() {
      if (errorBuilder_ == null) {
        return error_ == null ? com.salesforce.eventbus.protobuf.Error.getDefaultInstance() : error_;
      } else {
        return errorBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * for failed commits
     * </pre>
     *
     * <code>.eventbus.v1.Error error = 3;</code>
     */
    public Builder setError(com.salesforce.eventbus.protobuf.Error value) {
      if (errorBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        error_ = value;
      } else {
        errorBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * for failed commits
     * </pre>
     *
     * <code>.eventbus.v1.Error error = 3;</code>
     */
    public Builder setError(
        com.salesforce.eventbus.protobuf.Error.Builder builderForValue) {
      if (errorBuilder_ == null) {
        error_ = builderForValue.build();
      } else {
        errorBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * for failed commits
     * </pre>
     *
     * <code>.eventbus.v1.Error error = 3;</code>
     */
    public Builder mergeError(com.salesforce.eventbus.protobuf.Error value) {
      if (errorBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
          error_ != null &&
          error_ != com.salesforce.eventbus.protobuf.Error.getDefaultInstance()) {
          getErrorBuilder().mergeFrom(value);
        } else {
          error_ = value;
        }
      } else {
        errorBuilder_.mergeFrom(value);
      }
      if (error_ != null) {
        bitField0_ |= 0x00000004;
        onChanged();
      }
      return this;
    }
    /**
     * <pre>
     * for failed commits
     * </pre>
     *
     * <code>.eventbus.v1.Error error = 3;</code>
     */
    public Builder clearError() {
      bitField0_ = (bitField0_ & ~0x00000004);
      error_ = null;
      if (errorBuilder_ != null) {
        errorBuilder_.dispose();
        errorBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * for failed commits
     * </pre>
     *
     * <code>.eventbus.v1.Error error = 3;</code>
     */
    public com.salesforce.eventbus.protobuf.Error.Builder getErrorBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getErrorFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * for failed commits
     * </pre>
     *
     * <code>.eventbus.v1.Error error = 3;</code>
     */
    public com.salesforce.eventbus.protobuf.ErrorOrBuilder getErrorOrBuilder() {
      if (errorBuilder_ != null) {
        return errorBuilder_.getMessageOrBuilder();
      } else {
        return error_ == null ?
            com.salesforce.eventbus.protobuf.Error.getDefaultInstance() : error_;
      }
    }
    /**
     * <pre>
     * for failed commits
     * </pre>
     *
     * <code>.eventbus.v1.Error error = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        com.salesforce.eventbus.protobuf.Error, com.salesforce.eventbus.protobuf.Error.Builder, com.salesforce.eventbus.protobuf.ErrorOrBuilder> 
        getErrorFieldBuilder() {
      if (errorBuilder_ == null) {
        errorBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            com.salesforce.eventbus.protobuf.Error, com.salesforce.eventbus.protobuf.Error.Builder, com.salesforce.eventbus.protobuf.ErrorOrBuilder>(
                getError(),
                getParentForChildren(),
                isClean());
        error_ = null;
      }
      return errorBuilder_;
    }

    private long processTime_ ;
    /**
     * <pre>
     * time when server received request in epoch ms
     * </pre>
     *
     * <code>int64 process_time = 4;</code>
     * @return The processTime.
     */
    @java.lang.Override
    public long getProcessTime() {
      return processTime_;
    }
    /**
     * <pre>
     * time when server received request in epoch ms
     * </pre>
     *
     * <code>int64 process_time = 4;</code>
     * @param value The processTime to set.
     * @return This builder for chaining.
     */
    public Builder setProcessTime(long value) {

      processTime_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * time when server received request in epoch ms
     * </pre>
     *
     * <code>int64 process_time = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearProcessTime() {
      bitField0_ = (bitField0_ & ~0x00000008);
      processTime_ = 0L;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:eventbus.v1.CommitReplayResponse)
  }

  // @@protoc_insertion_point(class_scope:eventbus.v1.CommitReplayResponse)
  private static final com.salesforce.eventbus.protobuf.CommitReplayResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.salesforce.eventbus.protobuf.CommitReplayResponse();
  }

  public static com.salesforce.eventbus.protobuf.CommitReplayResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CommitReplayResponse>
      PARSER = new com.google.protobuf.AbstractParser<CommitReplayResponse>() {
    @java.lang.Override
    public CommitReplayResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<CommitReplayResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CommitReplayResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.salesforce.eventbus.protobuf.CommitReplayResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
