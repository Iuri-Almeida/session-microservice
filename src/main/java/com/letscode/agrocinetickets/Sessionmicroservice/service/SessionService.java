package com.letscode.agrocinetickets.Sessionmicroservice.service;

import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionRequest;
import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionResponse;
import com.letscode.agrocinetickets.Sessionmicroservice.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;

    public Mono<SessionResponse> createSession(SessionRequest sessionRequest) {
        // TODO sessionRepository.save(sessionRequest);
        return null;
    }

    public Flux<SessionResponse> findSessions() {
        // TODO sessionRepository.findAll();
        return null;
    }

    public Mono<SessionResponse> findSession(String id) {
        // TODO sessionRepository.findById(id);
        return null;
    }

    public Flux<SessionResponse> findSessionsByRoom(String roomId) {
        // TODO sessionsRepository.findByRoomId(roomId);
        return null;
    }

    public Flux<SessionResponse> findSessionsByTime(@RequestParam("time") String timeId) {
        // TODO sessionsRepository.findByTime(roomId);
        return null;
    }

    public Flux<SessionResponse> findSessionsByMovie(@RequestParam("movieId") String movieId) {
        // TODO sessionsRepository.findByRoomId(roomId);
        return null;
    }

    public Mono<SessionResponse> modifySession(String id) {
        //TODO SessionsRepository.modifySession(id)
        return null;
    }
}
