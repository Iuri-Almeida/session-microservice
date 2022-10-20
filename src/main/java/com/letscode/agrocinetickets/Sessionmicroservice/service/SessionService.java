package com.letscode.agrocinetickets.Sessionmicroservice.service;

import com.letscode.agrocinetickets.Sessionmicroservice.model.Result;
import com.letscode.agrocinetickets.Sessionmicroservice.model.SeatOccupied;
import com.letscode.agrocinetickets.Sessionmicroservice.model.Session;
import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SeatsSessionResponse;
import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionRequest;
import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionResponse;
import com.letscode.agrocinetickets.Sessionmicroservice.repository.SessionRepository;
import com.letscode.agrocinetickets.Sessionmicroservice.util.mapper.SessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;
    private final SessionMapper sessionMapper;

    public Mono<Result> createSession(SessionRequest sessionRequest) {
        Session session = sessionMapper.requestToModel(sessionRequest);
        session.setId(UUID.randomUUID().toString());
        session.setSeats(new HashMap<>());
        IntStream.rangeClosed(1,sessionRequest.getSeatsNumber()).forEach(num -> session.getSeats().put(num, false));

        return Mono.fromFuture(sessionRepository.save(session))
                .thenReturn(Result.SUCCESS)
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

    public Flux<SessionResponse> findSessionsByTime(LocalDateTime time) {
        return Flux.from(sessionRepository.findByTime(time).items())
                .doOnError(RuntimeException::new)
                .map(sessionMapper::modelToResponse);
    }

    public Flux<SessionResponse> findSessionsByMovie(String movieId) {
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
                .thenReturn(Result.SUCCESS)
                .onErrorReturn(Result.FAIL);
    }

    public Mono<Result> occupySeat(String id, int seatNumber) {
        Session session = getModelById(id);

        if (session.getSeats().containsKey(seatNumber) && !session.getSeats().get(seatNumber)) {
            session.getSeats().put(seatNumber, SeatOccupied.TRUE.getOccupied());
        }

        return Mono.fromFuture(sessionRepository.save(session))
                .thenReturn(Result.SUCCESS)
                .onErrorReturn(Result.FAIL);
    }

    public Boolean verifySeat(String id, int seatNumber) {
        Session session = getModelById(id);
        if (session.getSeats().containsKey(seatNumber)) {
            return session.getSeats().get(seatNumber);
        }
        return false;
    }

    public Mono<Result> vacateSeat(String id, int seatNumber) {
        Session session = getModelById(id);

        if (session.getSeats().containsKey(seatNumber) && session.getSeats().get(seatNumber)) {
            session.getSeats().put(seatNumber, SeatOccupied.FALSE.getOccupied());
        }

        return Mono.fromFuture(sessionRepository.save(session))
                .thenReturn(Result.SUCCESS)
                .onErrorReturn(Result.FAIL);
    }

    public Mono<SeatsSessionResponse> fetchSessionSeats(String id) {

        return Mono.fromFuture(sessionRepository.findById(id))
                .doOnSuccess(Objects::requireNonNull)
                .doOnError(RuntimeException::new)
                .map(session -> {
                    SeatsSessionResponse seatsSessionResponse = new SeatsSessionResponse();
                    seatsSessionResponse.setSeats(session.getSeats());
                    int free = 0;
                    int occupied = 0;

                    for (int i = 1; i <= session.getSeats().size(); i++) {
                        if (session.getSeats().get(i)) {
                            occupied++;
                        } else {
                            free++;
                        }
                    }

                    seatsSessionResponse.setSeatsFree(free);
                    seatsSessionResponse.setSeatsOccupied(occupied);

                    return seatsSessionResponse;
                });

    }

    private Session getModelById(String id) {
        try {
            return sessionRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
