// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/audit/audit_log.proto

package com.google.cloud.audit;

/**
 * <pre>
 * Metadata about the request.
 * </pre>
 *
 * Protobuf type {@code google.cloud.audit.RequestMetadata}
 */
public  final class RequestMetadata extends
    com.google.protobuf.GeneratedMessageLite<
        RequestMetadata, RequestMetadata.Builder> implements
    // @@protoc_insertion_point(message_implements:google.cloud.audit.RequestMetadata)
    RequestMetadataOrBuilder {
  private RequestMetadata() {
    callerIp_ = "";
    callerSuppliedUserAgent_ = "";
  }
  public static final int CALLER_IP_FIELD_NUMBER = 1;
  private java.lang.String callerIp_;
  /**
   * <pre>
   * The IP address of the caller.
   * </pre>
   *
   * <code>optional string caller_ip = 1;</code>
   */
  public java.lang.String getCallerIp() {
    return callerIp_;
  }
  /**
   * <pre>
   * The IP address of the caller.
   * </pre>
   *
   * <code>optional string caller_ip = 1;</code>
   */
  public com.google.protobuf.ByteString
      getCallerIpBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(callerIp_);
  }
  /**
   * <pre>
   * The IP address of the caller.
   * </pre>
   *
   * <code>optional string caller_ip = 1;</code>
   */
  private void setCallerIp(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    callerIp_ = value;
  }
  /**
   * <pre>
   * The IP address of the caller.
   * </pre>
   *
   * <code>optional string caller_ip = 1;</code>
   */
  private void clearCallerIp() {
    
    callerIp_ = getDefaultInstance().getCallerIp();
  }
  /**
   * <pre>
   * The IP address of the caller.
   * </pre>
   *
   * <code>optional string caller_ip = 1;</code>
   */
  private void setCallerIpBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    callerIp_ = value.toStringUtf8();
  }

  public static final int CALLER_SUPPLIED_USER_AGENT_FIELD_NUMBER = 2;
  private java.lang.String callerSuppliedUserAgent_;
  /**
   * <pre>
   * The user agent of the caller.
   * This information is not authenticated and should be treated accordingly.
   * For example:
   * +   `google-api-python-client/1.4.0`:
   *     The request was made by the Google API client for Python.
   * +   `Cloud SDK Command Line Tool apitools-client/1.0 gcloud/0.9.62`:
   *     The request was made by the Google Cloud SDK CLI (gcloud).
   * +   `AppEngine-Google; (+http://code.google.com/appengine; appid: s~my-project`:
   *     The request was made from the `my-project` App Engine app.
   * </pre>
   *
   * <code>optional string caller_supplied_user_agent = 2;</code>
   */
  public java.lang.String getCallerSuppliedUserAgent() {
    return callerSuppliedUserAgent_;
  }
  /**
   * <pre>
   * The user agent of the caller.
   * This information is not authenticated and should be treated accordingly.
   * For example:
   * +   `google-api-python-client/1.4.0`:
   *     The request was made by the Google API client for Python.
   * +   `Cloud SDK Command Line Tool apitools-client/1.0 gcloud/0.9.62`:
   *     The request was made by the Google Cloud SDK CLI (gcloud).
   * +   `AppEngine-Google; (+http://code.google.com/appengine; appid: s~my-project`:
   *     The request was made from the `my-project` App Engine app.
   * </pre>
   *
   * <code>optional string caller_supplied_user_agent = 2;</code>
   */
  public com.google.protobuf.ByteString
      getCallerSuppliedUserAgentBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(callerSuppliedUserAgent_);
  }
  /**
   * <pre>
   * The user agent of the caller.
   * This information is not authenticated and should be treated accordingly.
   * For example:
   * +   `google-api-python-client/1.4.0`:
   *     The request was made by the Google API client for Python.
   * +   `Cloud SDK Command Line Tool apitools-client/1.0 gcloud/0.9.62`:
   *     The request was made by the Google Cloud SDK CLI (gcloud).
   * +   `AppEngine-Google; (+http://code.google.com/appengine; appid: s~my-project`:
   *     The request was made from the `my-project` App Engine app.
   * </pre>
   *
   * <code>optional string caller_supplied_user_agent = 2;</code>
   */
  private void setCallerSuppliedUserAgent(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    callerSuppliedUserAgent_ = value;
  }
  /**
   * <pre>
   * The user agent of the caller.
   * This information is not authenticated and should be treated accordingly.
   * For example:
   * +   `google-api-python-client/1.4.0`:
   *     The request was made by the Google API client for Python.
   * +   `Cloud SDK Command Line Tool apitools-client/1.0 gcloud/0.9.62`:
   *     The request was made by the Google Cloud SDK CLI (gcloud).
   * +   `AppEngine-Google; (+http://code.google.com/appengine; appid: s~my-project`:
   *     The request was made from the `my-project` App Engine app.
   * </pre>
   *
   * <code>optional string caller_supplied_user_agent = 2;</code>
   */
  private void clearCallerSuppliedUserAgent() {
    
    callerSuppliedUserAgent_ = getDefaultInstance().getCallerSuppliedUserAgent();
  }
  /**
   * <pre>
   * The user agent of the caller.
   * This information is not authenticated and should be treated accordingly.
   * For example:
   * +   `google-api-python-client/1.4.0`:
   *     The request was made by the Google API client for Python.
   * +   `Cloud SDK Command Line Tool apitools-client/1.0 gcloud/0.9.62`:
   *     The request was made by the Google Cloud SDK CLI (gcloud).
   * +   `AppEngine-Google; (+http://code.google.com/appengine; appid: s~my-project`:
   *     The request was made from the `my-project` App Engine app.
   * </pre>
   *
   * <code>optional string caller_supplied_user_agent = 2;</code>
   */
  private void setCallerSuppliedUserAgentBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    callerSuppliedUserAgent_ = value.toStringUtf8();
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!callerIp_.isEmpty()) {
      output.writeString(1, getCallerIp());
    }
    if (!callerSuppliedUserAgent_.isEmpty()) {
      output.writeString(2, getCallerSuppliedUserAgent());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (!callerIp_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(1, getCallerIp());
    }
    if (!callerSuppliedUserAgent_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(2, getCallerSuppliedUserAgent());
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static com.google.cloud.audit.RequestMetadata parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.google.cloud.audit.RequestMetadata parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.google.cloud.audit.RequestMetadata parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.google.cloud.audit.RequestMetadata parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.google.cloud.audit.RequestMetadata parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.google.cloud.audit.RequestMetadata parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.google.cloud.audit.RequestMetadata parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static com.google.cloud.audit.RequestMetadata parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.google.cloud.audit.RequestMetadata parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.google.cloud.audit.RequestMetadata parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.cloud.audit.RequestMetadata prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * <pre>
   * Metadata about the request.
   * </pre>
   *
   * Protobuf type {@code google.cloud.audit.RequestMetadata}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.google.cloud.audit.RequestMetadata, Builder> implements
      // @@protoc_insertion_point(builder_implements:google.cloud.audit.RequestMetadata)
      com.google.cloud.audit.RequestMetadataOrBuilder {
    // Construct using com.google.cloud.audit.RequestMetadata.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * The IP address of the caller.
     * </pre>
     *
     * <code>optional string caller_ip = 1;</code>
     */
    public java.lang.String getCallerIp() {
      return instance.getCallerIp();
    }
    /**
     * <pre>
     * The IP address of the caller.
     * </pre>
     *
     * <code>optional string caller_ip = 1;</code>
     */
    public com.google.protobuf.ByteString
        getCallerIpBytes() {
      return instance.getCallerIpBytes();
    }
    /**
     * <pre>
     * The IP address of the caller.
     * </pre>
     *
     * <code>optional string caller_ip = 1;</code>
     */
    public Builder setCallerIp(
        java.lang.String value) {
      copyOnWrite();
      instance.setCallerIp(value);
      return this;
    }
    /**
     * <pre>
     * The IP address of the caller.
     * </pre>
     *
     * <code>optional string caller_ip = 1;</code>
     */
    public Builder clearCallerIp() {
      copyOnWrite();
      instance.clearCallerIp();
      return this;
    }
    /**
     * <pre>
     * The IP address of the caller.
     * </pre>
     *
     * <code>optional string caller_ip = 1;</code>
     */
    public Builder setCallerIpBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setCallerIpBytes(value);
      return this;
    }

    /**
     * <pre>
     * The user agent of the caller.
     * This information is not authenticated and should be treated accordingly.
     * For example:
     * +   `google-api-python-client/1.4.0`:
     *     The request was made by the Google API client for Python.
     * +   `Cloud SDK Command Line Tool apitools-client/1.0 gcloud/0.9.62`:
     *     The request was made by the Google Cloud SDK CLI (gcloud).
     * +   `AppEngine-Google; (+http://code.google.com/appengine; appid: s~my-project`:
     *     The request was made from the `my-project` App Engine app.
     * </pre>
     *
     * <code>optional string caller_supplied_user_agent = 2;</code>
     */
    public java.lang.String getCallerSuppliedUserAgent() {
      return instance.getCallerSuppliedUserAgent();
    }
    /**
     * <pre>
     * The user agent of the caller.
     * This information is not authenticated and should be treated accordingly.
     * For example:
     * +   `google-api-python-client/1.4.0`:
     *     The request was made by the Google API client for Python.
     * +   `Cloud SDK Command Line Tool apitools-client/1.0 gcloud/0.9.62`:
     *     The request was made by the Google Cloud SDK CLI (gcloud).
     * +   `AppEngine-Google; (+http://code.google.com/appengine; appid: s~my-project`:
     *     The request was made from the `my-project` App Engine app.
     * </pre>
     *
     * <code>optional string caller_supplied_user_agent = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCallerSuppliedUserAgentBytes() {
      return instance.getCallerSuppliedUserAgentBytes();
    }
    /**
     * <pre>
     * The user agent of the caller.
     * This information is not authenticated and should be treated accordingly.
     * For example:
     * +   `google-api-python-client/1.4.0`:
     *     The request was made by the Google API client for Python.
     * +   `Cloud SDK Command Line Tool apitools-client/1.0 gcloud/0.9.62`:
     *     The request was made by the Google Cloud SDK CLI (gcloud).
     * +   `AppEngine-Google; (+http://code.google.com/appengine; appid: s~my-project`:
     *     The request was made from the `my-project` App Engine app.
     * </pre>
     *
     * <code>optional string caller_supplied_user_agent = 2;</code>
     */
    public Builder setCallerSuppliedUserAgent(
        java.lang.String value) {
      copyOnWrite();
      instance.setCallerSuppliedUserAgent(value);
      return this;
    }
    /**
     * <pre>
     * The user agent of the caller.
     * This information is not authenticated and should be treated accordingly.
     * For example:
     * +   `google-api-python-client/1.4.0`:
     *     The request was made by the Google API client for Python.
     * +   `Cloud SDK Command Line Tool apitools-client/1.0 gcloud/0.9.62`:
     *     The request was made by the Google Cloud SDK CLI (gcloud).
     * +   `AppEngine-Google; (+http://code.google.com/appengine; appid: s~my-project`:
     *     The request was made from the `my-project` App Engine app.
     * </pre>
     *
     * <code>optional string caller_supplied_user_agent = 2;</code>
     */
    public Builder clearCallerSuppliedUserAgent() {
      copyOnWrite();
      instance.clearCallerSuppliedUserAgent();
      return this;
    }
    /**
     * <pre>
     * The user agent of the caller.
     * This information is not authenticated and should be treated accordingly.
     * For example:
     * +   `google-api-python-client/1.4.0`:
     *     The request was made by the Google API client for Python.
     * +   `Cloud SDK Command Line Tool apitools-client/1.0 gcloud/0.9.62`:
     *     The request was made by the Google Cloud SDK CLI (gcloud).
     * +   `AppEngine-Google; (+http://code.google.com/appengine; appid: s~my-project`:
     *     The request was made from the `my-project` App Engine app.
     * </pre>
     *
     * <code>optional string caller_supplied_user_agent = 2;</code>
     */
    public Builder setCallerSuppliedUserAgentBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setCallerSuppliedUserAgentBytes(value);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:google.cloud.audit.RequestMetadata)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.google.cloud.audit.RequestMetadata();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        com.google.cloud.audit.RequestMetadata other = (com.google.cloud.audit.RequestMetadata) arg1;
        callerIp_ = visitor.visitString(!callerIp_.isEmpty(), callerIp_,
            !other.callerIp_.isEmpty(), other.callerIp_);
        callerSuppliedUserAgent_ = visitor.visitString(!callerSuppliedUserAgent_.isEmpty(), callerSuppliedUserAgent_,
            !other.callerSuppliedUserAgent_.isEmpty(), other.callerSuppliedUserAgent_);
        if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
            .INSTANCE) {
        }
        return this;
      }
      case MERGE_FROM_STREAM: {
        com.google.protobuf.CodedInputStream input =
            (com.google.protobuf.CodedInputStream) arg0;
        com.google.protobuf.ExtensionRegistryLite extensionRegistry =
            (com.google.protobuf.ExtensionRegistryLite) arg1;
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              default: {
                if (!input.skipField(tag)) {
                  done = true;
                }
                break;
              }
              case 10: {
                String s = input.readStringRequireUtf8();

                callerIp_ = s;
                break;
              }
              case 18: {
                String s = input.readStringRequireUtf8();

                callerSuppliedUserAgent_ = s;
                break;
              }
            }
          }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw new RuntimeException(e.setUnfinishedMessage(this));
        } catch (java.io.IOException e) {
          throw new RuntimeException(
              new com.google.protobuf.InvalidProtocolBufferException(
                  e.getMessage()).setUnfinishedMessage(this));
        } finally {
        }
      }
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        if (PARSER == null) {    synchronized (com.google.cloud.audit.RequestMetadata.class) {
            if (PARSER == null) {
              PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
            }
          }
        }
        return PARSER;
      }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:google.cloud.audit.RequestMetadata)
  private static final com.google.cloud.audit.RequestMetadata DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new RequestMetadata();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static com.google.cloud.audit.RequestMetadata getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<RequestMetadata> PARSER;

  public static com.google.protobuf.Parser<RequestMetadata> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

