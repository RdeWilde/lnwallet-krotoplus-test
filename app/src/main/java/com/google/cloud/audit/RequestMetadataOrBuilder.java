// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/audit/audit_log.proto

package com.google.cloud.audit;

public interface RequestMetadataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.audit.RequestMetadata)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   * The IP address of the caller.
   * </pre>
   *
   * <code>optional string caller_ip = 1;</code>
   */
  java.lang.String getCallerIp();
  /**
   * <pre>
   * The IP address of the caller.
   * </pre>
   *
   * <code>optional string caller_ip = 1;</code>
   */
  com.google.protobuf.ByteString
      getCallerIpBytes();

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
  java.lang.String getCallerSuppliedUserAgent();
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
  com.google.protobuf.ByteString
      getCallerSuppliedUserAgentBytes();
}
