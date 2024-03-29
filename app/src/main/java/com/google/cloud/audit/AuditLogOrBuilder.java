// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/audit/audit_log.proto

package com.google.cloud.audit;

public interface AuditLogOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.audit.AuditLog)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   * The name of the API service performing the operation. For example,
   * `"datastore.googleapis.com"`.
   * </pre>
   *
   * <code>optional string service_name = 7;</code>
   */
  java.lang.String getServiceName();
  /**
   * <pre>
   * The name of the API service performing the operation. For example,
   * `"datastore.googleapis.com"`.
   * </pre>
   *
   * <code>optional string service_name = 7;</code>
   */
  com.google.protobuf.ByteString
      getServiceNameBytes();

  /**
   * <pre>
   * The name of the service method or operation.
   * For API calls, this should be the name of the API method.
   * For example,
   *     "google.datastore.v1.Datastore.RunQuery"
   *     "google.logging.v1.LoggingService.DeleteLog"
   * </pre>
   *
   * <code>optional string method_name = 8;</code>
   */
  java.lang.String getMethodName();
  /**
   * <pre>
   * The name of the service method or operation.
   * For API calls, this should be the name of the API method.
   * For example,
   *     "google.datastore.v1.Datastore.RunQuery"
   *     "google.logging.v1.LoggingService.DeleteLog"
   * </pre>
   *
   * <code>optional string method_name = 8;</code>
   */
  com.google.protobuf.ByteString
      getMethodNameBytes();

  /**
   * <pre>
   * The resource or collection that is the target of the operation.
   * The name is a scheme-less URI, not including the API service name.
   * For example:
   *     "shelves/SHELF_ID/books"
   *     "shelves/SHELF_ID/books/BOOK_ID"
   * </pre>
   *
   * <code>optional string resource_name = 11;</code>
   */
  java.lang.String getResourceName();
  /**
   * <pre>
   * The resource or collection that is the target of the operation.
   * The name is a scheme-less URI, not including the API service name.
   * For example:
   *     "shelves/SHELF_ID/books"
   *     "shelves/SHELF_ID/books/BOOK_ID"
   * </pre>
   *
   * <code>optional string resource_name = 11;</code>
   */
  com.google.protobuf.ByteString
      getResourceNameBytes();

  /**
   * <pre>
   * The number of items returned from a List or Query API method,
   * if applicable.
   * </pre>
   *
   * <code>optional int64 num_response_items = 12;</code>
   */
  long getNumResponseItems();

  /**
   * <pre>
   * The status of the overall operation.
   * </pre>
   *
   * <code>optional .google.rpc.Status status = 2;</code>
   */
  boolean hasStatus();
  /**
   * <pre>
   * The status of the overall operation.
   * </pre>
   *
   * <code>optional .google.rpc.Status status = 2;</code>
   */
  com.google.rpc.Status getStatus();

  /**
   * <pre>
   * Authentication information.
   * </pre>
   *
   * <code>optional .google.cloud.audit.AuthenticationInfo authentication_info = 3;</code>
   */
  boolean hasAuthenticationInfo();
  /**
   * <pre>
   * Authentication information.
   * </pre>
   *
   * <code>optional .google.cloud.audit.AuthenticationInfo authentication_info = 3;</code>
   */
  com.google.cloud.audit.AuthenticationInfo getAuthenticationInfo();

  /**
   * <pre>
   * Authorization information. If there are multiple
   * resources or permissions involved, then there is
   * one AuthorizationInfo element for each {resource, permission} tuple.
   * </pre>
   *
   * <code>repeated .google.cloud.audit.AuthorizationInfo authorization_info = 9;</code>
   */
  java.util.List<com.google.cloud.audit.AuthorizationInfo> 
      getAuthorizationInfoList();
  /**
   * <pre>
   * Authorization information. If there are multiple
   * resources or permissions involved, then there is
   * one AuthorizationInfo element for each {resource, permission} tuple.
   * </pre>
   *
   * <code>repeated .google.cloud.audit.AuthorizationInfo authorization_info = 9;</code>
   */
  com.google.cloud.audit.AuthorizationInfo getAuthorizationInfo(int index);
  /**
   * <pre>
   * Authorization information. If there are multiple
   * resources or permissions involved, then there is
   * one AuthorizationInfo element for each {resource, permission} tuple.
   * </pre>
   *
   * <code>repeated .google.cloud.audit.AuthorizationInfo authorization_info = 9;</code>
   */
  int getAuthorizationInfoCount();

  /**
   * <pre>
   * Metadata about the operation.
   * </pre>
   *
   * <code>optional .google.cloud.audit.RequestMetadata request_metadata = 4;</code>
   */
  boolean hasRequestMetadata();
  /**
   * <pre>
   * Metadata about the operation.
   * </pre>
   *
   * <code>optional .google.cloud.audit.RequestMetadata request_metadata = 4;</code>
   */
  com.google.cloud.audit.RequestMetadata getRequestMetadata();

  /**
   * <pre>
   * The operation request. This may not include all request parameters,
   * such as those that are too large, privacy-sensitive, or duplicated
   * elsewhere in the log record.
   * It should never include user-generated data, such as file contents.
   * When the JSON object represented here has a proto equivalent, the proto
   * name will be indicated in the `&#64;type` property.
   * </pre>
   *
   * <code>optional .google.protobuf.Struct request = 16;</code>
   */
  boolean hasRequest();
  /**
   * <pre>
   * The operation request. This may not include all request parameters,
   * such as those that are too large, privacy-sensitive, or duplicated
   * elsewhere in the log record.
   * It should never include user-generated data, such as file contents.
   * When the JSON object represented here has a proto equivalent, the proto
   * name will be indicated in the `&#64;type` property.
   * </pre>
   *
   * <code>optional .google.protobuf.Struct request = 16;</code>
   */
  com.google.protobuf.Struct getRequest();

  /**
   * <pre>
   * The operation response. This may not include all response elements,
   * such as those that are too large, privacy-sensitive, or duplicated
   * elsewhere in the log record.
   * It should never include user-generated data, such as file contents.
   * When the JSON object represented here has a proto equivalent, the proto
   * name will be indicated in the `&#64;type` property.
   * </pre>
   *
   * <code>optional .google.protobuf.Struct response = 17;</code>
   */
  boolean hasResponse();
  /**
   * <pre>
   * The operation response. This may not include all response elements,
   * such as those that are too large, privacy-sensitive, or duplicated
   * elsewhere in the log record.
   * It should never include user-generated data, such as file contents.
   * When the JSON object represented here has a proto equivalent, the proto
   * name will be indicated in the `&#64;type` property.
   * </pre>
   *
   * <code>optional .google.protobuf.Struct response = 17;</code>
   */
  com.google.protobuf.Struct getResponse();

  /**
   * <pre>
   * Other service-specific data about the request, response, and other
   * activities.
   * </pre>
   *
   * <code>optional .google.protobuf.Any service_data = 15;</code>
   */
  boolean hasServiceData();
  /**
   * <pre>
   * Other service-specific data about the request, response, and other
   * activities.
   * </pre>
   *
   * <code>optional .google.protobuf.Any service_data = 15;</code>
   */
  com.google.protobuf.Any getServiceData();
}
