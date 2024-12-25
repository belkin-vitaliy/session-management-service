package com.example.sessionmanagement;

import java.util.Map;

class Session {
    private String sessionId;
    private String userId;
    private Map<String, String> parameters;

    public Session(String sessionId, String userId, Map<String, String> parameters) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.parameters = parameters;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
