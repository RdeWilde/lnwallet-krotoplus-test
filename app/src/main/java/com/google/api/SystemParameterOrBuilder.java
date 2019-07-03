// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/api/system_parameter.proto

package com.google.api;

public interface SystemParameterOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.api.SystemParameter)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   * Define the name of the parameter, such as "api_key" . It is case sensitive.
   * </pre>
   *
   * <code>optional string name = 1;</code>
   */
  java.lang.String getName();
  /**
   * <pre>
   * Define the name of the parameter, such as "api_key" . It is case sensitive.
   * </pre>
   *
   * <code>optional string name = 1;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * Define the HTTP header name to use for the parameter. It is case
   * insensitive.
   * </pre>
   *
   * <code>optional string http_header = 2;</code>
   */
  java.lang.String getHttpHeader();
  /**
   * <pre>
   * Define the HTTP header name to use for the parameter. It is case
   * insensitive.
   * </pre>
   *
   * <code>optional string http_header = 2;</code>
   */
  com.google.protobuf.ByteString
      getHttpHeaderBytes();

  /**
   * <pre>
   * Define the URL query parameter name to use for the parameter. It is case
   * sensitive.
   * </pre>
   *
   * <code>optional string url_query_parameter = 3;</code>
   */
  java.lang.String getUrlQueryParameter();
  /**
   * <pre>
   * Define the URL query parameter name to use for the parameter. It is case
   * sensitive.
   * </pre>
   *
   * <code>optional string url_query_parameter = 3;</code>
   */
  com.google.protobuf.ByteString
      getUrlQueryParameterBytes();
}