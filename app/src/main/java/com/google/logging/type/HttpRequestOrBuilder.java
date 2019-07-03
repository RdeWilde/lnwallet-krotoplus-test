// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/logging/type/http_request.proto

package com.google.logging.type;

public interface HttpRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.logging.type.HttpRequest)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   * The request method. Examples: `"GET"`, `"HEAD"`, `"PUT"`, `"POST"`.
   * </pre>
   *
   * <code>optional string request_method = 1;</code>
   */
  java.lang.String getRequestMethod();
  /**
   * <pre>
   * The request method. Examples: `"GET"`, `"HEAD"`, `"PUT"`, `"POST"`.
   * </pre>
   *
   * <code>optional string request_method = 1;</code>
   */
  com.google.protobuf.ByteString
      getRequestMethodBytes();

  /**
   * <pre>
   * The scheme (http, https), the host name, the path and the query
   * portion of the URL that was requested.
   * Example: `"http://example.com/some/info?color=red"`.
   * </pre>
   *
   * <code>optional string request_url = 2;</code>
   */
  java.lang.String getRequestUrl();
  /**
   * <pre>
   * The scheme (http, https), the host name, the path and the query
   * portion of the URL that was requested.
   * Example: `"http://example.com/some/info?color=red"`.
   * </pre>
   *
   * <code>optional string request_url = 2;</code>
   */
  com.google.protobuf.ByteString
      getRequestUrlBytes();

  /**
   * <pre>
   * The size of the HTTP request message in bytes, including the request
   * headers and the request body.
   * </pre>
   *
   * <code>optional int64 request_size = 3;</code>
   */
  long getRequestSize();

  /**
   * <pre>
   * The response code indicating the status of response.
   * Examples: 200, 404.
   * </pre>
   *
   * <code>optional int32 status = 4;</code>
   */
  int getStatus();

  /**
   * <pre>
   * The size of the HTTP response message sent back to the client, in bytes,
   * including the response headers and the response body.
   * </pre>
   *
   * <code>optional int64 response_size = 5;</code>
   */
  long getResponseSize();

  /**
   * <pre>
   * The user agent sent by the client. Example:
   * `"Mozilla/4.0 (compatible; MSIE 6.0; Windows 98; Q312461; .NET CLR 1.0.3705)"`.
   * </pre>
   *
   * <code>optional string user_agent = 6;</code>
   */
  java.lang.String getUserAgent();
  /**
   * <pre>
   * The user agent sent by the client. Example:
   * `"Mozilla/4.0 (compatible; MSIE 6.0; Windows 98; Q312461; .NET CLR 1.0.3705)"`.
   * </pre>
   *
   * <code>optional string user_agent = 6;</code>
   */
  com.google.protobuf.ByteString
      getUserAgentBytes();

  /**
   * <pre>
   * The IP address (IPv4 or IPv6) of the client that issued the HTTP
   * request. Examples: `"192.168.1.1"`, `"FE80::0202:B3FF:FE1E:8329"`.
   * </pre>
   *
   * <code>optional string remote_ip = 7;</code>
   */
  java.lang.String getRemoteIp();
  /**
   * <pre>
   * The IP address (IPv4 or IPv6) of the client that issued the HTTP
   * request. Examples: `"192.168.1.1"`, `"FE80::0202:B3FF:FE1E:8329"`.
   * </pre>
   *
   * <code>optional string remote_ip = 7;</code>
   */
  com.google.protobuf.ByteString
      getRemoteIpBytes();

  /**
   * <pre>
   * The IP address (IPv4 or IPv6) of the origin server that the request was
   * sent to.
   * </pre>
   *
   * <code>optional string server_ip = 13;</code>
   */
  java.lang.String getServerIp();
  /**
   * <pre>
   * The IP address (IPv4 or IPv6) of the origin server that the request was
   * sent to.
   * </pre>
   *
   * <code>optional string server_ip = 13;</code>
   */
  com.google.protobuf.ByteString
      getServerIpBytes();

  /**
   * <pre>
   * The referer URL of the request, as defined in
   * [HTTP/1.1 Header Field Definitions](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html).
   * </pre>
   *
   * <code>optional string referer = 8;</code>
   */
  java.lang.String getReferer();
  /**
   * <pre>
   * The referer URL of the request, as defined in
   * [HTTP/1.1 Header Field Definitions](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html).
   * </pre>
   *
   * <code>optional string referer = 8;</code>
   */
  com.google.protobuf.ByteString
      getRefererBytes();

  /**
   * <pre>
   * The request processing latency on the server, from the time the request was
   * received until the response was sent.
   * </pre>
   *
   * <code>optional .google.protobuf.Duration latency = 14;</code>
   */
  boolean hasLatency();
  /**
   * <pre>
   * The request processing latency on the server, from the time the request was
   * received until the response was sent.
   * </pre>
   *
   * <code>optional .google.protobuf.Duration latency = 14;</code>
   */
  com.google.protobuf.Duration getLatency();

  /**
   * <pre>
   * Whether or not a cache lookup was attempted.
   * </pre>
   *
   * <code>optional bool cache_lookup = 11;</code>
   */
  boolean getCacheLookup();

  /**
   * <pre>
   * Whether or not an entity was served from cache
   * (with or without validation).
   * </pre>
   *
   * <code>optional bool cache_hit = 9;</code>
   */
  boolean getCacheHit();

  /**
   * <pre>
   * Whether or not the response was validated with the origin server before
   * being served from cache. This field is only meaningful if `cache_hit` is
   * True.
   * </pre>
   *
   * <code>optional bool cache_validated_with_origin_server = 10;</code>
   */
  boolean getCacheValidatedWithOriginServer();

  /**
   * <pre>
   * The number of HTTP response bytes inserted into cache. Set only when a
   * cache fill was attempted.
   * </pre>
   *
   * <code>optional int64 cache_fill_bytes = 12;</code>
   */
  long getCacheFillBytes();

  /**
   * <pre>
   * Protocol used for the request. Examples: "HTTP/1.1", "HTTP/2", "websocket"
   * </pre>
   *
   * <code>optional string protocol = 15;</code>
   */
  java.lang.String getProtocol();
  /**
   * <pre>
   * Protocol used for the request. Examples: "HTTP/1.1", "HTTP/2", "websocket"
   * </pre>
   *
   * <code>optional string protocol = 15;</code>
   */
  com.google.protobuf.ByteString
      getProtocolBytes();
}
