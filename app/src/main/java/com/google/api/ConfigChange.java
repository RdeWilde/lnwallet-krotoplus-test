// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/api/config_change.proto

package com.google.api;

/**
 * <pre>
 * Output generated from semantically comparing two versions of a service
 * configuration.
 * Includes detailed information about a field that have changed with
 * applicable advice about potential consequences for the change, such as
 * backwards-incompatibility.
 * </pre>
 *
 * Protobuf type {@code google.api.ConfigChange}
 */
public  final class ConfigChange extends
    com.google.protobuf.GeneratedMessageLite<
        ConfigChange, ConfigChange.Builder> implements
    // @@protoc_insertion_point(message_implements:google.api.ConfigChange)
    ConfigChangeOrBuilder {
  private ConfigChange() {
    element_ = "";
    oldValue_ = "";
    newValue_ = "";
    advices_ = emptyProtobufList();
  }
  private int bitField0_;
  public static final int ELEMENT_FIELD_NUMBER = 1;
  private java.lang.String element_;
  /**
   * <pre>
   * Object hierarchy path to the change, with levels separated by a '.'
   * character. For repeated fields, an applicable unique identifier field is
   * used for the index (usually selector, name, or id). For maps, the term
   * 'key' is used. If the field has no unique identifier, the numeric index
   * is used.
   * Examples:
   * - visibility.rules[selector=="google.LibraryService.CreateBook"].restriction
   * - quota.metric_rules[selector=="google"].metric_costs[key=="reads"].value
   * - logging.producer_destinations[0]
   * </pre>
   *
   * <code>optional string element = 1;</code>
   */
  public java.lang.String getElement() {
    return element_;
  }
  /**
   * <pre>
   * Object hierarchy path to the change, with levels separated by a '.'
   * character. For repeated fields, an applicable unique identifier field is
   * used for the index (usually selector, name, or id). For maps, the term
   * 'key' is used. If the field has no unique identifier, the numeric index
   * is used.
   * Examples:
   * - visibility.rules[selector=="google.LibraryService.CreateBook"].restriction
   * - quota.metric_rules[selector=="google"].metric_costs[key=="reads"].value
   * - logging.producer_destinations[0]
   * </pre>
   *
   * <code>optional string element = 1;</code>
   */
  public com.google.protobuf.ByteString
      getElementBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(element_);
  }
  /**
   * <pre>
   * Object hierarchy path to the change, with levels separated by a '.'
   * character. For repeated fields, an applicable unique identifier field is
   * used for the index (usually selector, name, or id). For maps, the term
   * 'key' is used. If the field has no unique identifier, the numeric index
   * is used.
   * Examples:
   * - visibility.rules[selector=="google.LibraryService.CreateBook"].restriction
   * - quota.metric_rules[selector=="google"].metric_costs[key=="reads"].value
   * - logging.producer_destinations[0]
   * </pre>
   *
   * <code>optional string element = 1;</code>
   */
  private void setElement(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    element_ = value;
  }
  /**
   * <pre>
   * Object hierarchy path to the change, with levels separated by a '.'
   * character. For repeated fields, an applicable unique identifier field is
   * used for the index (usually selector, name, or id). For maps, the term
   * 'key' is used. If the field has no unique identifier, the numeric index
   * is used.
   * Examples:
   * - visibility.rules[selector=="google.LibraryService.CreateBook"].restriction
   * - quota.metric_rules[selector=="google"].metric_costs[key=="reads"].value
   * - logging.producer_destinations[0]
   * </pre>
   *
   * <code>optional string element = 1;</code>
   */
  private void clearElement() {
    
    element_ = getDefaultInstance().getElement();
  }
  /**
   * <pre>
   * Object hierarchy path to the change, with levels separated by a '.'
   * character. For repeated fields, an applicable unique identifier field is
   * used for the index (usually selector, name, or id). For maps, the term
   * 'key' is used. If the field has no unique identifier, the numeric index
   * is used.
   * Examples:
   * - visibility.rules[selector=="google.LibraryService.CreateBook"].restriction
   * - quota.metric_rules[selector=="google"].metric_costs[key=="reads"].value
   * - logging.producer_destinations[0]
   * </pre>
   *
   * <code>optional string element = 1;</code>
   */
  private void setElementBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    element_ = value.toStringUtf8();
  }

  public static final int OLD_VALUE_FIELD_NUMBER = 2;
  private java.lang.String oldValue_;
  /**
   * <pre>
   * Value of the changed object in the old Service configuration,
   * in JSON format. This field will not be populated if ChangeType == ADDED.
   * </pre>
   *
   * <code>optional string old_value = 2;</code>
   */
  public java.lang.String getOldValue() {
    return oldValue_;
  }
  /**
   * <pre>
   * Value of the changed object in the old Service configuration,
   * in JSON format. This field will not be populated if ChangeType == ADDED.
   * </pre>
   *
   * <code>optional string old_value = 2;</code>
   */
  public com.google.protobuf.ByteString
      getOldValueBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(oldValue_);
  }
  /**
   * <pre>
   * Value of the changed object in the old Service configuration,
   * in JSON format. This field will not be populated if ChangeType == ADDED.
   * </pre>
   *
   * <code>optional string old_value = 2;</code>
   */
  private void setOldValue(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    oldValue_ = value;
  }
  /**
   * <pre>
   * Value of the changed object in the old Service configuration,
   * in JSON format. This field will not be populated if ChangeType == ADDED.
   * </pre>
   *
   * <code>optional string old_value = 2;</code>
   */
  private void clearOldValue() {
    
    oldValue_ = getDefaultInstance().getOldValue();
  }
  /**
   * <pre>
   * Value of the changed object in the old Service configuration,
   * in JSON format. This field will not be populated if ChangeType == ADDED.
   * </pre>
   *
   * <code>optional string old_value = 2;</code>
   */
  private void setOldValueBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    oldValue_ = value.toStringUtf8();
  }

  public static final int NEW_VALUE_FIELD_NUMBER = 3;
  private java.lang.String newValue_;
  /**
   * <pre>
   * Value of the changed object in the new Service configuration,
   * in JSON format. This field will not be populated if ChangeType == REMOVED.
   * </pre>
   *
   * <code>optional string new_value = 3;</code>
   */
  public java.lang.String getNewValue() {
    return newValue_;
  }
  /**
   * <pre>
   * Value of the changed object in the new Service configuration,
   * in JSON format. This field will not be populated if ChangeType == REMOVED.
   * </pre>
   *
   * <code>optional string new_value = 3;</code>
   */
  public com.google.protobuf.ByteString
      getNewValueBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(newValue_);
  }
  /**
   * <pre>
   * Value of the changed object in the new Service configuration,
   * in JSON format. This field will not be populated if ChangeType == REMOVED.
   * </pre>
   *
   * <code>optional string new_value = 3;</code>
   */
  private void setNewValue(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    newValue_ = value;
  }
  /**
   * <pre>
   * Value of the changed object in the new Service configuration,
   * in JSON format. This field will not be populated if ChangeType == REMOVED.
   * </pre>
   *
   * <code>optional string new_value = 3;</code>
   */
  private void clearNewValue() {
    
    newValue_ = getDefaultInstance().getNewValue();
  }
  /**
   * <pre>
   * Value of the changed object in the new Service configuration,
   * in JSON format. This field will not be populated if ChangeType == REMOVED.
   * </pre>
   *
   * <code>optional string new_value = 3;</code>
   */
  private void setNewValueBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    newValue_ = value.toStringUtf8();
  }

  public static final int CHANGE_TYPE_FIELD_NUMBER = 4;
  private int changeType_;
  /**
   * <pre>
   * The type for this change, either ADDED, REMOVED, or MODIFIED.
   * </pre>
   *
   * <code>optional .google.api.ChangeType change_type = 4;</code>
   */
  public int getChangeTypeValue() {
    return changeType_;
  }
  /**
   * <pre>
   * The type for this change, either ADDED, REMOVED, or MODIFIED.
   * </pre>
   *
   * <code>optional .google.api.ChangeType change_type = 4;</code>
   */
  public com.google.api.ChangeType getChangeType() {
    com.google.api.ChangeType result = com.google.api.ChangeType.forNumber(changeType_);
    return result == null ? com.google.api.ChangeType.UNRECOGNIZED : result;
  }
  /**
   * <pre>
   * The type for this change, either ADDED, REMOVED, or MODIFIED.
   * </pre>
   *
   * <code>optional .google.api.ChangeType change_type = 4;</code>
   */
  private void setChangeTypeValue(int value) {
      changeType_ = value;
  }
  /**
   * <pre>
   * The type for this change, either ADDED, REMOVED, or MODIFIED.
   * </pre>
   *
   * <code>optional .google.api.ChangeType change_type = 4;</code>
   */
  private void setChangeType(com.google.api.ChangeType value) {
    if (value == null) {
      throw new NullPointerException();
    }
    
    changeType_ = value.getNumber();
  }
  /**
   * <pre>
   * The type for this change, either ADDED, REMOVED, or MODIFIED.
   * </pre>
   *
   * <code>optional .google.api.ChangeType change_type = 4;</code>
   */
  private void clearChangeType() {
    
    changeType_ = 0;
  }

  public static final int ADVICES_FIELD_NUMBER = 5;
  private com.google.protobuf.Internal.ProtobufList<com.google.api.Advice> advices_;
  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  public java.util.List<com.google.api.Advice> getAdvicesList() {
    return advices_;
  }
  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  public java.util.List<? extends com.google.api.AdviceOrBuilder> 
      getAdvicesOrBuilderList() {
    return advices_;
  }
  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  public int getAdvicesCount() {
    return advices_.size();
  }
  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  public com.google.api.Advice getAdvices(int index) {
    return advices_.get(index);
  }
  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  public com.google.api.AdviceOrBuilder getAdvicesOrBuilder(
      int index) {
    return advices_.get(index);
  }
  private void ensureAdvicesIsMutable() {
    if (!advices_.isModifiable()) {
      advices_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(advices_);
     }
  }

  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  private void setAdvices(
      int index, com.google.api.Advice value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureAdvicesIsMutable();
    advices_.set(index, value);
  }
  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  private void setAdvices(
      int index, com.google.api.Advice.Builder builderForValue) {
    ensureAdvicesIsMutable();
    advices_.set(index, builderForValue.build());
  }
  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  private void addAdvices(com.google.api.Advice value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureAdvicesIsMutable();
    advices_.add(value);
  }
  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  private void addAdvices(
      int index, com.google.api.Advice value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureAdvicesIsMutable();
    advices_.add(index, value);
  }
  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  private void addAdvices(
      com.google.api.Advice.Builder builderForValue) {
    ensureAdvicesIsMutable();
    advices_.add(builderForValue.build());
  }
  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  private void addAdvices(
      int index, com.google.api.Advice.Builder builderForValue) {
    ensureAdvicesIsMutable();
    advices_.add(index, builderForValue.build());
  }
  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  private void addAllAdvices(
      java.lang.Iterable<? extends com.google.api.Advice> values) {
    ensureAdvicesIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, advices_);
  }
  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  private void clearAdvices() {
    advices_ = emptyProtobufList();
  }
  /**
   * <pre>
   * Collection of advice provided for this change, useful for determining the
   * possible impact of this change.
   * </pre>
   *
   * <code>repeated .google.api.Advice advices = 5;</code>
   */
  private void removeAdvices(int index) {
    ensureAdvicesIsMutable();
    advices_.remove(index);
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!element_.isEmpty()) {
      output.writeString(1, getElement());
    }
    if (!oldValue_.isEmpty()) {
      output.writeString(2, getOldValue());
    }
    if (!newValue_.isEmpty()) {
      output.writeString(3, getNewValue());
    }
    if (changeType_ != com.google.api.ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber()) {
      output.writeEnum(4, changeType_);
    }
    for (int i = 0; i < advices_.size(); i++) {
      output.writeMessage(5, advices_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (!element_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(1, getElement());
    }
    if (!oldValue_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(2, getOldValue());
    }
    if (!newValue_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(3, getNewValue());
    }
    if (changeType_ != com.google.api.ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(4, changeType_);
    }
    for (int i = 0; i < advices_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, advices_.get(i));
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static com.google.api.ConfigChange parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.google.api.ConfigChange parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.google.api.ConfigChange parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.google.api.ConfigChange parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.google.api.ConfigChange parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.google.api.ConfigChange parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.google.api.ConfigChange parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static com.google.api.ConfigChange parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.google.api.ConfigChange parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.google.api.ConfigChange parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.api.ConfigChange prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * <pre>
   * Output generated from semantically comparing two versions of a service
   * configuration.
   * Includes detailed information about a field that have changed with
   * applicable advice about potential consequences for the change, such as
   * backwards-incompatibility.
   * </pre>
   *
   * Protobuf type {@code google.api.ConfigChange}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.google.api.ConfigChange, Builder> implements
      // @@protoc_insertion_point(builder_implements:google.api.ConfigChange)
      com.google.api.ConfigChangeOrBuilder {
    // Construct using com.google.api.ConfigChange.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * Object hierarchy path to the change, with levels separated by a '.'
     * character. For repeated fields, an applicable unique identifier field is
     * used for the index (usually selector, name, or id). For maps, the term
     * 'key' is used. If the field has no unique identifier, the numeric index
     * is used.
     * Examples:
     * - visibility.rules[selector=="google.LibraryService.CreateBook"].restriction
     * - quota.metric_rules[selector=="google"].metric_costs[key=="reads"].value
     * - logging.producer_destinations[0]
     * </pre>
     *
     * <code>optional string element = 1;</code>
     */
    public java.lang.String getElement() {
      return instance.getElement();
    }
    /**
     * <pre>
     * Object hierarchy path to the change, with levels separated by a '.'
     * character. For repeated fields, an applicable unique identifier field is
     * used for the index (usually selector, name, or id). For maps, the term
     * 'key' is used. If the field has no unique identifier, the numeric index
     * is used.
     * Examples:
     * - visibility.rules[selector=="google.LibraryService.CreateBook"].restriction
     * - quota.metric_rules[selector=="google"].metric_costs[key=="reads"].value
     * - logging.producer_destinations[0]
     * </pre>
     *
     * <code>optional string element = 1;</code>
     */
    public com.google.protobuf.ByteString
        getElementBytes() {
      return instance.getElementBytes();
    }
    /**
     * <pre>
     * Object hierarchy path to the change, with levels separated by a '.'
     * character. For repeated fields, an applicable unique identifier field is
     * used for the index (usually selector, name, or id). For maps, the term
     * 'key' is used. If the field has no unique identifier, the numeric index
     * is used.
     * Examples:
     * - visibility.rules[selector=="google.LibraryService.CreateBook"].restriction
     * - quota.metric_rules[selector=="google"].metric_costs[key=="reads"].value
     * - logging.producer_destinations[0]
     * </pre>
     *
     * <code>optional string element = 1;</code>
     */
    public Builder setElement(
        java.lang.String value) {
      copyOnWrite();
      instance.setElement(value);
      return this;
    }
    /**
     * <pre>
     * Object hierarchy path to the change, with levels separated by a '.'
     * character. For repeated fields, an applicable unique identifier field is
     * used for the index (usually selector, name, or id). For maps, the term
     * 'key' is used. If the field has no unique identifier, the numeric index
     * is used.
     * Examples:
     * - visibility.rules[selector=="google.LibraryService.CreateBook"].restriction
     * - quota.metric_rules[selector=="google"].metric_costs[key=="reads"].value
     * - logging.producer_destinations[0]
     * </pre>
     *
     * <code>optional string element = 1;</code>
     */
    public Builder clearElement() {
      copyOnWrite();
      instance.clearElement();
      return this;
    }
    /**
     * <pre>
     * Object hierarchy path to the change, with levels separated by a '.'
     * character. For repeated fields, an applicable unique identifier field is
     * used for the index (usually selector, name, or id). For maps, the term
     * 'key' is used. If the field has no unique identifier, the numeric index
     * is used.
     * Examples:
     * - visibility.rules[selector=="google.LibraryService.CreateBook"].restriction
     * - quota.metric_rules[selector=="google"].metric_costs[key=="reads"].value
     * - logging.producer_destinations[0]
     * </pre>
     *
     * <code>optional string element = 1;</code>
     */
    public Builder setElementBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setElementBytes(value);
      return this;
    }

    /**
     * <pre>
     * Value of the changed object in the old Service configuration,
     * in JSON format. This field will not be populated if ChangeType == ADDED.
     * </pre>
     *
     * <code>optional string old_value = 2;</code>
     */
    public java.lang.String getOldValue() {
      return instance.getOldValue();
    }
    /**
     * <pre>
     * Value of the changed object in the old Service configuration,
     * in JSON format. This field will not be populated if ChangeType == ADDED.
     * </pre>
     *
     * <code>optional string old_value = 2;</code>
     */
    public com.google.protobuf.ByteString
        getOldValueBytes() {
      return instance.getOldValueBytes();
    }
    /**
     * <pre>
     * Value of the changed object in the old Service configuration,
     * in JSON format. This field will not be populated if ChangeType == ADDED.
     * </pre>
     *
     * <code>optional string old_value = 2;</code>
     */
    public Builder setOldValue(
        java.lang.String value) {
      copyOnWrite();
      instance.setOldValue(value);
      return this;
    }
    /**
     * <pre>
     * Value of the changed object in the old Service configuration,
     * in JSON format. This field will not be populated if ChangeType == ADDED.
     * </pre>
     *
     * <code>optional string old_value = 2;</code>
     */
    public Builder clearOldValue() {
      copyOnWrite();
      instance.clearOldValue();
      return this;
    }
    /**
     * <pre>
     * Value of the changed object in the old Service configuration,
     * in JSON format. This field will not be populated if ChangeType == ADDED.
     * </pre>
     *
     * <code>optional string old_value = 2;</code>
     */
    public Builder setOldValueBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setOldValueBytes(value);
      return this;
    }

    /**
     * <pre>
     * Value of the changed object in the new Service configuration,
     * in JSON format. This field will not be populated if ChangeType == REMOVED.
     * </pre>
     *
     * <code>optional string new_value = 3;</code>
     */
    public java.lang.String getNewValue() {
      return instance.getNewValue();
    }
    /**
     * <pre>
     * Value of the changed object in the new Service configuration,
     * in JSON format. This field will not be populated if ChangeType == REMOVED.
     * </pre>
     *
     * <code>optional string new_value = 3;</code>
     */
    public com.google.protobuf.ByteString
        getNewValueBytes() {
      return instance.getNewValueBytes();
    }
    /**
     * <pre>
     * Value of the changed object in the new Service configuration,
     * in JSON format. This field will not be populated if ChangeType == REMOVED.
     * </pre>
     *
     * <code>optional string new_value = 3;</code>
     */
    public Builder setNewValue(
        java.lang.String value) {
      copyOnWrite();
      instance.setNewValue(value);
      return this;
    }
    /**
     * <pre>
     * Value of the changed object in the new Service configuration,
     * in JSON format. This field will not be populated if ChangeType == REMOVED.
     * </pre>
     *
     * <code>optional string new_value = 3;</code>
     */
    public Builder clearNewValue() {
      copyOnWrite();
      instance.clearNewValue();
      return this;
    }
    /**
     * <pre>
     * Value of the changed object in the new Service configuration,
     * in JSON format. This field will not be populated if ChangeType == REMOVED.
     * </pre>
     *
     * <code>optional string new_value = 3;</code>
     */
    public Builder setNewValueBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setNewValueBytes(value);
      return this;
    }

    /**
     * <pre>
     * The type for this change, either ADDED, REMOVED, or MODIFIED.
     * </pre>
     *
     * <code>optional .google.api.ChangeType change_type = 4;</code>
     */
    public int getChangeTypeValue() {
      return instance.getChangeTypeValue();
    }
    /**
     * <pre>
     * The type for this change, either ADDED, REMOVED, or MODIFIED.
     * </pre>
     *
     * <code>optional .google.api.ChangeType change_type = 4;</code>
     */
    public Builder setChangeTypeValue(int value) {
      copyOnWrite();
      instance.setChangeTypeValue(value);
      return this;
    }
    /**
     * <pre>
     * The type for this change, either ADDED, REMOVED, or MODIFIED.
     * </pre>
     *
     * <code>optional .google.api.ChangeType change_type = 4;</code>
     */
    public com.google.api.ChangeType getChangeType() {
      return instance.getChangeType();
    }
    /**
     * <pre>
     * The type for this change, either ADDED, REMOVED, or MODIFIED.
     * </pre>
     *
     * <code>optional .google.api.ChangeType change_type = 4;</code>
     */
    public Builder setChangeType(com.google.api.ChangeType value) {
      copyOnWrite();
      instance.setChangeType(value);
      return this;
    }
    /**
     * <pre>
     * The type for this change, either ADDED, REMOVED, or MODIFIED.
     * </pre>
     *
     * <code>optional .google.api.ChangeType change_type = 4;</code>
     */
    public Builder clearChangeType() {
      copyOnWrite();
      instance.clearChangeType();
      return this;
    }

    /**
     * <pre>
     * Collection of advice provided for this change, useful for determining the
     * possible impact of this change.
     * </pre>
     *
     * <code>repeated .google.api.Advice advices = 5;</code>
     */
    public java.util.List<com.google.api.Advice> getAdvicesList() {
      return java.util.Collections.unmodifiableList(
          instance.getAdvicesList());
    }
    /**
     * <pre>
     * Collection of advice provided for this change, useful for determining the
     * possible impact of this change.
     * </pre>
     *
     * <code>repeated .google.api.Advice advices = 5;</code>
     */
    public int getAdvicesCount() {
      return instance.getAdvicesCount();
    }/**
     * <pre>
     * Collection of advice provided for this change, useful for determining the
     * possible impact of this change.
     * </pre>
     *
     * <code>repeated .google.api.Advice advices = 5;</code>
     */
    public com.google.api.Advice getAdvices(int index) {
      return instance.getAdvices(index);
    }
    /**
     * <pre>
     * Collection of advice provided for this change, useful for determining the
     * possible impact of this change.
     * </pre>
     *
     * <code>repeated .google.api.Advice advices = 5;</code>
     */
    public Builder setAdvices(
        int index, com.google.api.Advice value) {
      copyOnWrite();
      instance.setAdvices(index, value);
      return this;
    }
    /**
     * <pre>
     * Collection of advice provided for this change, useful for determining the
     * possible impact of this change.
     * </pre>
     *
     * <code>repeated .google.api.Advice advices = 5;</code>
     */
    public Builder setAdvices(
        int index, com.google.api.Advice.Builder builderForValue) {
      copyOnWrite();
      instance.setAdvices(index, builderForValue);
      return this;
    }
    /**
     * <pre>
     * Collection of advice provided for this change, useful for determining the
     * possible impact of this change.
     * </pre>
     *
     * <code>repeated .google.api.Advice advices = 5;</code>
     */
    public Builder addAdvices(com.google.api.Advice value) {
      copyOnWrite();
      instance.addAdvices(value);
      return this;
    }
    /**
     * <pre>
     * Collection of advice provided for this change, useful for determining the
     * possible impact of this change.
     * </pre>
     *
     * <code>repeated .google.api.Advice advices = 5;</code>
     */
    public Builder addAdvices(
        int index, com.google.api.Advice value) {
      copyOnWrite();
      instance.addAdvices(index, value);
      return this;
    }
    /**
     * <pre>
     * Collection of advice provided for this change, useful for determining the
     * possible impact of this change.
     * </pre>
     *
     * <code>repeated .google.api.Advice advices = 5;</code>
     */
    public Builder addAdvices(
        com.google.api.Advice.Builder builderForValue) {
      copyOnWrite();
      instance.addAdvices(builderForValue);
      return this;
    }
    /**
     * <pre>
     * Collection of advice provided for this change, useful for determining the
     * possible impact of this change.
     * </pre>
     *
     * <code>repeated .google.api.Advice advices = 5;</code>
     */
    public Builder addAdvices(
        int index, com.google.api.Advice.Builder builderForValue) {
      copyOnWrite();
      instance.addAdvices(index, builderForValue);
      return this;
    }
    /**
     * <pre>
     * Collection of advice provided for this change, useful for determining the
     * possible impact of this change.
     * </pre>
     *
     * <code>repeated .google.api.Advice advices = 5;</code>
     */
    public Builder addAllAdvices(
        java.lang.Iterable<? extends com.google.api.Advice> values) {
      copyOnWrite();
      instance.addAllAdvices(values);
      return this;
    }
    /**
     * <pre>
     * Collection of advice provided for this change, useful for determining the
     * possible impact of this change.
     * </pre>
     *
     * <code>repeated .google.api.Advice advices = 5;</code>
     */
    public Builder clearAdvices() {
      copyOnWrite();
      instance.clearAdvices();
      return this;
    }
    /**
     * <pre>
     * Collection of advice provided for this change, useful for determining the
     * possible impact of this change.
     * </pre>
     *
     * <code>repeated .google.api.Advice advices = 5;</code>
     */
    public Builder removeAdvices(int index) {
      copyOnWrite();
      instance.removeAdvices(index);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:google.api.ConfigChange)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.google.api.ConfigChange();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        advices_.makeImmutable();
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        com.google.api.ConfigChange other = (com.google.api.ConfigChange) arg1;
        element_ = visitor.visitString(!element_.isEmpty(), element_,
            !other.element_.isEmpty(), other.element_);
        oldValue_ = visitor.visitString(!oldValue_.isEmpty(), oldValue_,
            !other.oldValue_.isEmpty(), other.oldValue_);
        newValue_ = visitor.visitString(!newValue_.isEmpty(), newValue_,
            !other.newValue_.isEmpty(), other.newValue_);
        changeType_ = visitor.visitInt(changeType_ != 0, changeType_,    other.changeType_ != 0, other.changeType_);
        advices_= visitor.visitList(advices_, other.advices_);
        if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
            .INSTANCE) {
          bitField0_ |= other.bitField0_;
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

                element_ = s;
                break;
              }
              case 18: {
                String s = input.readStringRequireUtf8();

                oldValue_ = s;
                break;
              }
              case 26: {
                String s = input.readStringRequireUtf8();

                newValue_ = s;
                break;
              }
              case 32: {
                int rawValue = input.readEnum();

                changeType_ = rawValue;
                break;
              }
              case 42: {
                if (!advices_.isModifiable()) {
                  advices_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(advices_);
                }
                advices_.add(
                    input.readMessage(com.google.api.Advice.parser(), extensionRegistry));
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
        if (PARSER == null) {    synchronized (com.google.api.ConfigChange.class) {
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


  // @@protoc_insertion_point(class_scope:google.api.ConfigChange)
  private static final com.google.api.ConfigChange DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ConfigChange();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static com.google.api.ConfigChange getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<ConfigChange> PARSER;

  public static com.google.protobuf.Parser<ConfigChange> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

