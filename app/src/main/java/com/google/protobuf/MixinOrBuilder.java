// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/protobuf/api.proto

package com.google.protobuf;

public interface MixinOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.protobuf.Mixin)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   * The fully qualified name of the interface which is included.
   * </pre>
   *
   * <code>optional string name = 1;</code>
   */
  java.lang.String getName();
  /**
   * <pre>
   * The fully qualified name of the interface which is included.
   * </pre>
   *
   * <code>optional string name = 1;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * If non-empty specifies a path under which inherited HTTP paths
   * are rooted.
   * </pre>
   *
   * <code>optional string root = 2;</code>
   */
  java.lang.String getRoot();
  /**
   * <pre>
   * If non-empty specifies a path under which inherited HTTP paths
   * are rooted.
   * </pre>
   *
   * <code>optional string root = 2;</code>
   */
  com.google.protobuf.ByteString
      getRootBytes();
}
