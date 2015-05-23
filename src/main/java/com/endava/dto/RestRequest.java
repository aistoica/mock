package com.endava.dto;

/**
 * Created by astoica on 5/23/2015.
 */
public class RestRequest {

    private String method;

    private String path;

    private Integer port;

    public RestRequest(String method, String path, Integer port) {
        this.method = method;
        this.path = path;
        this.port = port;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
