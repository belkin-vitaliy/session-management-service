package com.example.sessionmanagement;


import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/sessions")
class SessionController {

    private final Map<String, Session> sessionStore = new ConcurrentHashMap<>();

    @PostMapping
    public Session createSession(@RequestBody SessionRequest request) {
        String sessionId = generateSessionId();
        Session session = new Session(sessionId, request.getUserId(), request.getParameters());
        sessionStore.put(sessionId, session);
        return session;
    }

    @GetMapping("/{sessionId}")
    public Session getSession(@PathVariable String sessionId) {
        return sessionStore.get(sessionId);
    }

    @PutMapping("/{sessionId}/parameters")
    public Session updateSession(@PathVariable String sessionId, @RequestBody Map<String, String> parameters) {
        Session session = sessionStore.get(sessionId);
        if (session != null) {
            session.setParameters(parameters);
        }
        return session;
    }

    @DeleteMapping("/{sessionId}")
    public void deleteSession(@PathVariable String sessionId) {
        sessionStore.remove(sessionId);
    }

    private String generateSessionId() {
        return "session-" + System.currentTimeMillis();
    }
}
