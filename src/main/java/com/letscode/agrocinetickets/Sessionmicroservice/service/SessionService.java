package com.letscode.agrocinetickets.Sessionmicroservice.service;

import com.letscode.agrocinetickets.Sessionmicroservice.model.Result;
import com.letscode.agrocinetickets.Sessionmicroservice.model.Session;
import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionRequest;
import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionResponse;
import com.letscode.agrocinetickets.Sessionmicroservice.repository.SessionRepository;
import com.letscode.agrocinetickets.Sessionmicroservice.util.mapper.SessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;
    private final SessionMapper sessionMapper;

    public Mono<Result> createSession(SessionRequest sessionRequest) {
        Session session = sessionMapper.requestToModel(sessionRequest);
        session.setType(sessionRepository.getEntityName());
        session.setId(UUID.randomUUID().toString());

        return Mono.fromFuture(sessionRepository.save(session))
                .thenReturn(Result.SUCESS)
                .onErrorReturn(Result.FAIL);
    }

    public Flux<SessionResponse> fetchSessions() {

        return Flux.from(sessionRepository.findAll().items())
                .map(sessionMapper::modelToResponse)
                .doOnError(RuntimeException::new);
    }

    public Mono<SessionResponse> findSession(String id) {

        return Mono.fromFuture(sessionRepository.findById(id))
                .doOnSuccess(Objects::requireNonNull)
                .doOnError(RuntimeException::new)
                .map(sessionMapper::modelToResponse);

    }

    public Flux<SessionResponse> findSessionsByRoom(String roomId) {
        return Flux.from(sessionRepository.findByRoom(roomId).items())
                .map(sessionMapper::modelToResponse)
                .doOnError(RuntimeException::new);
    }

    public Flux<SessionResponse> findSessionsByTime(@RequestParam("time") String timeId) {
        // TODO sessionsRepository.findByTime(roomId);
        return null;
    }

    public Flux<SessionResponse> findSessionsByMovie( String movieId) {
        return Flux.from(sessionRepository.findByMovie(movieId).items())
                .map(sessionMapper::modelToResponse)
                .doOnError(RuntimeException::new);
    }

    public Mono<SessionResponse> modifySession(String id) {
        //TODO SessionsRepository.modifySession(id)
        return null;
    }

    public Mono<SessionResponse> modifySessionEntirely(String id) {
        //TODO SessionsRepository.modifySessionEntirely(id)
        return null;
    }

    public Mono<Result> deleteSession(String id) {
        return Mono.fromFuture(sessionRepository.deleteById(id))
                .doOnSuccess(Objects::requireNonNull)
                .thenReturn(Result.SUCESS)
                .onErrorReturn(Result.FAIL);
    }

    public Mono<SessionResponse> occupySeat(String id, int line, int column) {
        //TODO SessionsRepository.occupySeat(id, line, column)
        return null;
    }

    public Mono<SessionResponse> verifySeat(String id, int line, int column) {
        //TODO SessionsRepository.verifySeat(id, line, column)
        return null;
    }

    public Mono<SessionResponse> vacateSeat(String id, int line, int column) {
        //TODO SessionsRepository.vacateSeat(id, line, column)
        return null;
    }

    public Mono<SessionResponse> fetchSessionSeats(String id) {
        //TODO SessionsRepository.fetchSessionSeats(id)
        return null;
    }
}
