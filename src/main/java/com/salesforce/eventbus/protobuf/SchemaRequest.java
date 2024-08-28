// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: pubsub_api.proto
// Protobuf Java Version: 4.27.3

package com.salesforce.eventbus.protobuf;

/**
 * <pre>
 *
 * Request for the GetSchema RPC method. The schema request is based on the event schema ID.
 * </pre>
 *
 * Protobuf type {@code eventbus.v1.SchemaRequest}
 */
public final class SchemaRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:eventbus.v1.SchemaRequest)
    SchemaRequestOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 3,
      /* suffix= */ "",
      SchemaRequest.class.getName());
  }
  // Use SchemaRequest.newBuilder() to construct.
  private SchemaRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private SchemaRequest() {
    schemaId_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_SchemaRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_SchemaRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.salesforce.eventbus.protobuf.SchemaRequest.class, com.salesforce.eventbus.protobuf.SchemaRequest.Builder.class);
  }

  public static final int SCHEMA_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object schemaId_ = "";
  /**
   * <pre>
   * Schema fingerprint for this event, which is a hash of the schema.
   * </pre>
   *
   * <code>string schema_id = 1;</code>
   * @return The schemaId.
   */
  @java.lang.Override
  public java.lang.String getSchemaId() {
    java.lang.Object ref = schemaId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      schemaId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Schema fingerprint for this event, which is a hash of the schema.
   * </pre>
   *
   * <code>string schema_id = 1;</code>
   * @return The bytes for schemaId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSchemaIdBytes() {
    java.lang.Object ref = schemaId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      schemaId_ = b;
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
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(schemaId_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, schemaId_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(schemaId_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, schemaId_);
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
    if (!(obj instanceof com.salesforce.eventbus.protobuf.SchemaRequest)) {
      return super.equals(obj);
    }
    com.salesforce.eventbus.protobuf.SchemaRequest other = (com.salesforce.eventbus.protobuf.SchemaRequest) obj;

    if (!getSchemaId()
        .equals(other.getSchemaId())) return false;
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
    hash = (37 * hash) + SCHEMA_ID_FIELD_NUMBER;
    hash = (53 * hash) + getSchemaId().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.salesforce.eventbus.protobuf.SchemaRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.salesforce.eventbus.protobuf.SchemaRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.SchemaRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.salesforce.eventbus.protobuf.SchemaRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.SchemaRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.salesforce.eventbus.protobuf.SchemaRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.SchemaRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.salesforce.eventbus.protobuf.SchemaRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.salesforce.eventbus.protobuf.SchemaRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.salesforce.eventbus.protobuf.SchemaRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.salesforce.eventbus.protobuf.SchemaRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.salesforce.eventbus.protobuf.SchemaRequest parseFrom(
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
  public static Builder newBuilder(com.salesforce.eventbus.protobuf.SchemaRequest prototype) {
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
   * Request for the GetSchema RPC method. The schema request is based on the event schema ID.
   * </pre>
   *
   * Protobuf type {@code eventbus.v1.SchemaRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:eventbus.v1.SchemaRequest)
      com.salesforce.eventbus.protobuf.SchemaRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_SchemaRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_SchemaRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.salesforce.eventbus.protobuf.SchemaRequest.class, com.salesforce.eventbus.protobuf.SchemaRequest.Builder.class);
    }

    // Construct using com.salesforce.eventbus.protobuf.SchemaRequest.newBuilder()
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
      schemaId_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.salesforce.eventbus.protobuf.PubSubProto.internal_static_eventbus_v1_SchemaRequest_descriptor;
    }

    @java.lang.Override
    public com.salesforce.eventbus.protobuf.SchemaRequest getDefaultInstanceForType() {
      return com.salesforce.eventbus.protobuf.SchemaRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.salesforce.eventbus.protobuf.SchemaRequest build() {
      com.salesforce.eventbus.protobuf.SchemaRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.salesforce.eventbus.protobuf.SchemaRequest buildPartial() {
      com.salesforce.eventbus.protobuf.SchemaRequest result = new com.salesforce.eventbus.protobuf.SchemaRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.salesforce.eventbus.protobuf.SchemaRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.schemaId_ = schemaId_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.salesforce.eventbus.protobuf.SchemaRequest) {
        return mergeFrom((com.salesforce.eventbus.protobuf.SchemaRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.salesforce.eventbus.protobuf.SchemaRequest other) {
      if (other == com.salesforce.eventbus.protobuf.SchemaRequest.getDefaultInstance()) return this;
      if (!other.getSchemaId().isEmpty()) {
        schemaId_ = other.schemaId_;
        bitField0_ |= 0x00000001;
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
            case 10: {
              schemaId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
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

    private java.lang.Object schemaId_ = "";
    /**
     * <pre>
     * Schema fingerprint for this event, which is a hash of the schema.
     * </pre>
     *
     * <code>string schema_id = 1;</code>
     * @return The schemaId.
     */
    public java.lang.String getSchemaId() {
      java.lang.Object ref = schemaId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        schemaId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Schema fingerprint for this event, which is a hash of the schema.
     * </pre>
     *
     * <code>string schema_id = 1;</code>
     * @return The bytes for schemaId.
     */
    public com.google.protobuf.ByteString
        getSchemaIdBytes() {
      java.lang.Object ref = schemaId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        schemaId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Schema fingerprint for this event, which is a hash of the schema.
     * </pre>
     *
     * <code>string schema_id = 1;</code>
     * @param value The schemaId to set.
     * @return This builder for chaining.
     */
    public Builder setSchemaId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      schemaId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Schema fingerprint for this event, which is a hash of the schema.
     * </pre>
     *
     * <code>string schema_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSchemaId() {
      schemaId_ = getDefaultInstance().getSchemaId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Schema fingerprint for this event, which is a hash of the schema.
     * </pre>
     *
     * <code>string schema_id = 1;</code>
     * @param value The bytes for schemaId to set.
     * @return This builder for chaining.
     */
    public Builder setSchemaIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      schemaId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:eventbus.v1.SchemaRequest)
  }

  // @@protoc_insertion_point(class_scope:eventbus.v1.SchemaRequest)
  private static final com.salesforce.eventbus.protobuf.SchemaRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.salesforce.eventbus.protobuf.SchemaRequest();
  }

  public static com.salesforce.eventbus.protobuf.SchemaRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SchemaRequest>
      PARSER = new com.google.protobuf.AbstractParser<SchemaRequest>() {
    @java.lang.Override
    public SchemaRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<SchemaRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SchemaRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.salesforce.eventbus.protobuf.SchemaRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

