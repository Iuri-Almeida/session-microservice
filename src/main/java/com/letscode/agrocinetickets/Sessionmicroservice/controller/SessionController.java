package com.letscode.agrocinetickets.Sessionmicroservice.controller;

import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionRequest;
import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionResponse;
import com.letscode.agrocinetickets.Sessionmicroservice.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @PostMapping
    public ResponseEntity<Mono<SessionResponse>> createSession(@RequestBody SessionRequest sessionRequest) {
        return null;
    }

    @GetMapping
    public ResponseEntity<Flux<SessionResponse>> retrieveSessions() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<SessionResponse>> findSession(@PathVariable("id") String id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<Flux<SessionResponse>> findSessionsByRoom(@RequestParam("roomId") String roomId) {
        return null;
    }

    @GetMapping
    public ResponseEntity<Flux<SessionResponse>> findSessionsByTime(@RequestParam("time") String timeId) {
        return null;
    }

    @GetMapping
    public ResponseEntity<Flux<SessionResponse>> findSessionsByMovie(@RequestParam("movieId") String movieId) {
        return null;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Mono<SessionResponse>> modifySession(@PathVariable("id") String id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<SessionResponse>> modifySessionEntirely(@PathVariable("id") String id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSession(@PathVariable("id") String id) {
        return null;
    }

    @PatchMapping("/{id}/occupySeat")
    public ResponseEntity<Mono<SessionResponse>> occupySeat(@PathVariable("id") String id, @RequestParam("line") int line, @RequestParam("column") int column) {
        return null;
    }

    @GetMapping("/{id}/isSeatOccupied")
    public ResponseEntity<Mono<SessionResponse>> verifySeat(@PathVariable("id") String id, @RequestParam("line") int line, @RequestParam("column") int column) {
        return null;
    }

    @PatchMapping("/{id}/vacateSeat")
    public ResponseEntity<Mono<SessionResponse>> vacateSeat(@PathVariable("id") String id, @RequestParam("line") int line, @RequestParam("column") int column) {
        return null;
    }

    @GetMapping("/{id}/seats")
    public ResponseEntity<Mono<SessionResponse>> retrieveSessionSeats(@PathVariable("id") String id) {
        return null;
    }

}
