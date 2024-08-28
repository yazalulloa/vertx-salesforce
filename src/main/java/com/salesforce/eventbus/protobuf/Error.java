// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: pubsub_api.proto
// Protobuf Java Version: 4.27.3

package com.salesforce.eventbus.protobuf;

/**
 * <pre>
 * Contains error information for an error that an RPC method returns.
 * </pre>
 *
 * Protobuf type {@code eventbus.v1.Error}
 */
public final class Error extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:eventbus.v1.Error)
    ErrorOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 3,
      /* suffix= */ "",
      Error.class.getName());
  }
  // Use Error.newBuilder() to construct.
  private Error(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private Error() {
    code_ = 0;
    msg_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_Error_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_Error_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.salesforce.eventbus.protobuf.Error.class, com.salesforce.eventbus.protobuf.Error.Builder.class);
  }

  public static final int CODE_FIELD_NUMBER = 1;
  private int code_ = 0;
  /**
   * <pre>
   * Error code
   * </pre>
   *
   * <code>.eventbus.v1.ErrorCode code = 1;</code>
   * @return The enum numeric value on the wire for code.
   */
  @java.lang.Override public int getCodeValue() {
    return code_;
  }
  /**
   * <pre>
   * Error code
   * </pre>
   *
   * <code>.eventbus.v1.ErrorCode code = 1;</code>
   * @return The code.
   */
  @java.lang.Override public com.salesforce.eventbus.protobuf.ErrorCode getCode() {
    com.salesforce.eventbus.protobuf.ErrorCode result = com.salesforce.eventbus.protobuf.ErrorCode.forNumber(code_);
    return result == null ? com.salesforce.eventbus.protobuf.ErrorCode.UNRECOGNIZED : result;
  }

  public static final int MSG_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object msg_ = "";
  /**
   * <pre>
   * Error message
   * </pre>
   *
   * <code>string msg = 2;</code>
   * @return The msg.
   */
  @java.lang.Override
  public java.lang.String getMsg() {
    java.lang.Object ref = msg_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      msg_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Error message
   * </pre>
   *
   * <code>string msg = 2;</code>
   * @return The bytes for msg.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMsgBytes() {
    java.lang.Object ref = msg_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      msg_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (code_ != com.salesforce.eventbus.protobuf.ErrorCode.UNKNOWN.getNumber()) {
      output.writeEnum(1, code_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(msg_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, msg_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (code_ != com.salesforce.eventbus.protobuf.ErrorCode.UNKNOWN.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, code_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(msg_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, msg_);
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
    if (!(obj instanceof com.salesforce.eventbus.protobuf.Error)) {
      return super.equals(obj);
    }
    com.salesforce.eventbus.protobuf.Error other = (com.salesforce.eventbus.protobuf.Error) obj;

    if (code_ != other.code_) return false;
    if (!getMsg()
        .equals(other.getMsg())) return false;
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
    hash = (37 * hash) + CODE_FIELD_NUMBER;
    hash = (53 * hash) + code_;
    hash = (37 * hash) + MSG_FIELD_NUMBER;
    hash = (53 * hash) + getMsg().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.salesforce.eventbus.protobuf.Error parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.salesforce.eventbus.protobuf.Error parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.Error parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.salesforce.eventbus.protobuf.Error parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.Error parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.salesforce.eventbus.protobuf.Error parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.Error parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.salesforce.eventbus.protobuf.Error parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.salesforce.eventbus.protobuf.Error parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.salesforce.eventbus.protobuf.Error parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.Error parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.salesforce.eventbus.protobuf.Error parseFrom(
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
  public static Builder newBuilder(com.salesforce.eventbus.protobuf.Error prototype) {
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
   * Contains error information for an error that an RPC method returns.
   * </pre>
   *
   * Protobuf type {@code eventbus.v1.Error}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:eventbus.v1.Error)
      com.salesforce.eventbus.protobuf.ErrorOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_Error_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_Error_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.salesforce.eventbus.protobuf.Error.class, com.salesforce.eventbus.protobuf.Error.Builder.class);
    }

    // Construct using com.salesforce.eventbus.protobuf.Error.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      code_ = 0;
      msg_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_Error_descriptor;
    }

    @java.lang.Override
    public com.salesforce.eventbus.protobuf.Error getDefaultInstanceForType() {
      return com.salesforce.eventbus.protobuf.Error.getDefaultInstance();
    }

    @java.lang.Override
    public com.salesforce.eventbus.protobuf.Error build() {
      com.salesforce.eventbus.protobuf.Error result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.salesforce.eventbus.protobuf.Error buildPartial() {
      com.salesforce.eventbus.protobuf.Error result = new com.salesforce.eventbus.protobuf.Error(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.salesforce.eventbus.protobuf.Error result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.code_ = code_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.msg_ = msg_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.salesforce.eventbus.protobuf.Error) {
        return mergeFrom((com.salesforce.eventbus.protobuf.Error)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.salesforce.eventbus.protobuf.Error other) {
      if (other == com.salesforce.eventbus.protobuf.Error.getDefaultInstance()) return this;
      if (other.code_ != 0) {
        setCodeValue(other.getCodeValue());
      }
      if (!other.getMsg().isEmpty()) {
        msg_ = other.msg_;
        bitField0_ |= 0x00000002;
        onChanged();
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
            case 8: {
              code_ = input.readEnum();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              msg_ = input.readStringRequireUtf8();
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

    private int code_ = 0;
    /**
     * <pre>
     * Error code
     * </pre>
     *
     * <code>.eventbus.v1.ErrorCode code = 1;</code>
     * @return The enum numeric value on the wire for code.
     */
    @java.lang.Override public int getCodeValue() {
      return code_;
    }
    /**
     * <pre>
     * Error code
     * </pre>
     *
     * <code>.eventbus.v1.ErrorCode code = 1;</code>
     * @param value The enum numeric value on the wire for code to set.
     * @return This builder for chaining.
     */
    public Builder setCodeValue(int value) {
      code_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Error code
     * </pre>
     *
     * <code>.eventbus.v1.ErrorCode code = 1;</code>
     * @return The code.
     */
    @java.lang.Override
    public com.salesforce.eventbus.protobuf.ErrorCode getCode() {
      com.salesforce.eventbus.protobuf.ErrorCode result = com.salesforce.eventbus.protobuf.ErrorCode.forNumber(code_);
      return result == null ? com.salesforce.eventbus.protobuf.ErrorCode.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     * Error code
     * </pre>
     *
     * <code>.eventbus.v1.ErrorCode code = 1;</code>
     * @param value The code to set.
     * @return This builder for chaining.
     */
    public Builder setCode(com.salesforce.eventbus.protobuf.ErrorCode value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      code_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Error code
     * </pre>
     *
     * <code>.eventbus.v1.ErrorCode code = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCode() {
      bitField0_ = (bitField0_ & ~0x00000001);
      code_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object msg_ = "";
    /**
     * <pre>
     * Error message
     * </pre>
     *
     * <code>string msg = 2;</code>
     * @return The msg.
     */
    public java.lang.String getMsg() {
      java.lang.Object ref = msg_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        msg_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Error message
     * </pre>
     *
     * <code>string msg = 2;</code>
     * @return The bytes for msg.
     */
    public com.google.protobuf.ByteString
        getMsgBytes() {
      java.lang.Object ref = msg_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        msg_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Error message
     * </pre>
     *
     * <code>string msg = 2;</code>
     * @param value The msg to set.
     * @return This builder for chaining.
     */
    public Builder setMsg(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      msg_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Error message
     * </pre>
     *
     * <code>string msg = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMsg() {
      msg_ = getDefaultInstance().getMsg();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Error message
     * </pre>
     *
     * <code>string msg = 2;</code>
     * @param value The bytes for msg to set.
     * @return This builder for chaining.
     */
    public Builder setMsgBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      msg_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:eventbus.v1.Error)
  }

  // @@protoc_insertion_point(class_scope:eventbus.v1.Error)
  private static final com.salesforce.eventbus.protobuf.Error DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.salesforce.eventbus.protobuf.Error();
  }

  public static com.salesforce.eventbus.protobuf.Error getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Error>
      PARSER = new com.google.protobuf.AbstractParser<Error>() {
    @java.lang.Override
    public Error parsePartialFrom(
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

  public static com.google.protobuf.Parser<Error> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Error> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.salesforce.eventbus.protobuf.Error getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

