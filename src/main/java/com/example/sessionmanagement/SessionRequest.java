package com.example.sessionmanagement;

import java.util.Map;

class SessionRequest {
    private String userId;
    private Map<String, String> parameters;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
