// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/api/source_info.proto

package com.google.api;

/**
 * <pre>
 * Source information used to create a Service Config
 * </pre>
 *
 * Protobuf type {@code google.api.SourceInfo}
 */
public  final class SourceInfo extends
    com.google.protobuf.GeneratedMessageLite<
        SourceInfo, SourceInfo.Builder> implements
    // @@protoc_insertion_point(message_implements:google.api.SourceInfo)
    SourceInfoOrBuilder {
  private SourceInfo() {
    sourceFiles_ = emptyProtobufList();
  }
  public static final int SOURCE_FILES_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.ProtobufList<com.google.protobuf.Any> sourceFiles_;
  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  public java.util.List<com.google.protobuf.Any> getSourceFilesList() {
    return sourceFiles_;
  }
  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  public java.util.List<? extends com.google.protobuf.AnyOrBuilder> 
      getSourceFilesOrBuilderList() {
    return sourceFiles_;
  }
  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  public int getSourceFilesCount() {
    return sourceFiles_.size();
  }
  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  public com.google.protobuf.Any getSourceFiles(int index) {
    return sourceFiles_.get(index);
  }
  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  public com.google.protobuf.AnyOrBuilder getSourceFilesOrBuilder(
      int index) {
    return sourceFiles_.get(index);
  }
  private void ensureSourceFilesIsMutable() {
    if (!sourceFiles_.isModifiable()) {
      sourceFiles_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(sourceFiles_);
     }
  }

  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  private void setSourceFiles(
      int index, com.google.protobuf.Any value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureSourceFilesIsMutable();
    sourceFiles_.set(index, value);
  }
  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  private void setSourceFiles(
      int index, com.google.protobuf.Any.Builder builderForValue) {
    ensureSourceFilesIsMutable();
    sourceFiles_.set(index, builderForValue.build());
  }
  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  private void addSourceFiles(com.google.protobuf.Any value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureSourceFilesIsMutable();
    sourceFiles_.add(value);
  }
  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  private void addSourceFiles(
      int index, com.google.protobuf.Any value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureSourceFilesIsMutable();
    sourceFiles_.add(index, value);
  }
  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  private void addSourceFiles(
      com.google.protobuf.Any.Builder builderForValue) {
    ensureSourceFilesIsMutable();
    sourceFiles_.add(builderForValue.build());
  }
  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  private void addSourceFiles(
      int index, com.google.protobuf.Any.Builder builderForValue) {
    ensureSourceFilesIsMutable();
    sourceFiles_.add(index, builderForValue.build());
  }
  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  private void addAllSourceFiles(
      java.lang.Iterable<? extends com.google.protobuf.Any> values) {
    ensureSourceFilesIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, sourceFiles_);
  }
  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  private void clearSourceFiles() {
    sourceFiles_ = emptyProtobufList();
  }
  /**
   * <pre>
   * All files used during config generation.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any source_files = 1;</code>
   */
  private void removeSourceFiles(int index) {
    ensureSourceFilesIsMutable();
    sourceFiles_.remove(index);
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < sourceFiles_.size(); i++) {
      output.writeMessage(1, sourceFiles_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < sourceFiles_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, sourceFiles_.get(i));
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static com.google.api.SourceInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.google.api.SourceInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.google.api.SourceInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.google.api.SourceInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.google.api.SourceInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.google.api.SourceInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.google.api.SourceInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static com.google.api.SourceInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.google.api.SourceInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.google.api.SourceInfo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.api.SourceInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * <pre>
   * Source information used to create a Service Config
   * </pre>
   *
   * Protobuf type {@code google.api.SourceInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.google.api.SourceInfo, Builder> implements
      // @@protoc_insertion_point(builder_implements:google.api.SourceInfo)
      com.google.api.SourceInfoOrBuilder {
    // Construct using com.google.api.SourceInfo.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * All files used during config generation.
     * </pre>
     *
     * <code>repeated .google.protobuf.Any source_files = 1;</code>
     */
    public java.util.List<com.google.protobuf.Any> getSourceFilesList() {
      return java.util.Collections.unmodifiableList(
          instance.getSourceFilesList());
    }
    /**
     * <pre>
     * All files used during config generation.
     * </pre>
     *
     * <code>repeated .google.protobuf.Any source_files = 1;</code>
     */
    public int getSourceFilesCount() {
      return instance.getSourceFilesCount();
    }/**
     * <pre>
     * All files used during config generation.
     * </pre>
     *
     * <code>repeated .google.protobuf.Any source_files = 1;</code>
     */
    public com.google.protobuf.Any getSourceFiles(int index) {
      return instance.getSourceFiles(index);
    }
    /**
     * <pre>
     * All files used during config generation.
     * </pre>
     *
     * <code>repeated .google.protobuf.Any source_files = 1;</code>
     */
    public Builder setSourceFiles(
        int index, com.google.protobuf.Any value) {
      copyOnWrite();
      instance.setSourceFiles(index, value);
      return this;
    }
    /**
     * <pre>
     * All files used during config generation.
     * </pre>
     *
     * <code>repeated .google.protobuf.Any source_files = 1;</code>
     */
    public Builder setSourceFiles(
        int index, com.google.protobuf.Any.Builder builderForValue) {
      copyOnWrite();
      instance.setSourceFiles(index, builderForValue);
      return this;
    }
    /**
     * <pre>
     * All files used during config generation.
     * </pre>
     *
     * <code>repeated .google.protobuf.Any source_files = 1;</code>
     */
    public Builder addSourceFiles(com.google.protobuf.Any value) {
      copyOnWrite();
      instance.addSourceFiles(value);
      return this;
    }
    /**
     * <pre>
     * All files used during config generation.
     * </pre>
     *
     * <code>repeated .google.protobuf.Any source_files = 1;</code>
     */
    public Builder addSourceFiles(
        int index, com.google.protobuf.Any value) {
      copyOnWrite();
      instance.addSourceFiles(index, value);
      return this;
    }
    /**
     * <pre>
     * All files used during config generation.
     * </pre>
     *
     * <code>repeated .google.protobuf.Any source_files = 1;</code>
     */
    public Builder addSourceFiles(
        com.google.protobuf.Any.Builder builderForValue) {
      copyOnWrite();
      instance.addSourceFiles(builderForValue);
      return this;
    }
    /**
     * <pre>
     * All files used during config generation.
     * </pre>
     *
     * <code>repeated .google.protobuf.Any source_files = 1;</code>
     */
    public Builder addSourceFiles(
        int index, com.google.protobuf.Any.Builder builderForValue) {
      copyOnWrite();
      instance.addSourceFiles(index, builderForValue);
      return this;
    }
    /**
     * <pre>
     * All files used during config generation.
     * </pre>
     *
     * <code>repeated .google.protobuf.Any source_files = 1;</code>
     */
    public Builder addAllSourceFiles(
        java.lang.Iterable<? extends com.google.protobuf.Any> values) {
      copyOnWrite();
      instance.addAllSourceFiles(values);
      return this;
    }
    /**
     * <pre>
     * All files used during config generation.
     * </pre>
     *
     * <code>repeated .google.protobuf.Any source_files = 1;</code>
     */
    public Builder clearSourceFiles() {
      copyOnWrite();
      instance.clearSourceFiles();
      return this;
    }
    /**
     * <pre>
     * All files used during config generation.
     * </pre>
     *
     * <code>repeated .google.protobuf.Any source_files = 1;</code>
     */
    public Builder removeSourceFiles(int index) {
      copyOnWrite();
      instance.removeSourceFiles(index);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:google.api.SourceInfo)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.google.api.SourceInfo();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        sourceFiles_.makeImmutable();
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        com.google.api.SourceInfo other = (com.google.api.SourceInfo) arg1;
        sourceFiles_= visitor.visitList(sourceFiles_, other.sourceFiles_);
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
                if (!sourceFiles_.isModifiable()) {
                  sourceFiles_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(sourceFiles_);
                }
                sourceFiles_.add(
                    input.readMessage(com.google.protobuf.Any.parser(), extensionRegistry));
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
        if (PARSER == null) {    synchronized (com.google.api.SourceInfo.class) {
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


  // @@protoc_insertion_point(class_scope:google.api.SourceInfo)
  private static final com.google.api.SourceInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new SourceInfo();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static com.google.api.SourceInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<SourceInfo> PARSER;

  public static com.google.protobuf.Parser<SourceInfo> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

