package com.letscode.agrocinetickets.Sessionmicroservice.controller;

import com.letscode.agrocinetickets.Sessionmicroservice.model.Result;
import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionRequest;
import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionResponse;
import com.letscode.agrocinetickets.Sessionmicroservice.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @PostMapping
    public ResponseEntity<Mono<Result>> createSession(@RequestBody SessionRequest sessionRequest) {
        return ResponseEntity.ok(sessionService.createSession(sessionRequest));
    }

    @GetMapping
    public ResponseEntity<Flux<SessionResponse>> fetchSessions() {
        return ResponseEntity.ok(sessionService.fetchSessions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<SessionResponse>> findSession(@PathVariable("id") String id) {
        return ResponseEntity.ok(sessionService.findSession(id));
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<Flux<SessionResponse>> findSessionsByRoom(@PathVariable String roomId) {
        return ResponseEntity.ok(sessionService.findSessionsByRoom(roomId));
    }

    @GetMapping("/time")
    public ResponseEntity<Flux<SessionResponse>> findSessionsByTime(@RequestParam("time") String time) {
        return ResponseEntity.ok(sessionService.findSessionsByTime(LocalDateTime.parse(time)));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<Flux<SessionResponse>> findSessionsByMovie(@PathVariable String movieId) {
        return ResponseEntity.ok(sessionService.findSessionsByMovie(movieId));
    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<Mono<SessionResponse>> modifySession(@PathVariable("id") String id) {
//        return ResponseEntity.ok(sessionService.modifySession(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Mono<SessionResponse>> modifySessionEntirely(@PathVariable("id") String id) {
//        return ResponseEntity.ok(sessionService.modifySessionEntirely(id));
//    }
//
    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Result>> deleteSession(@PathVariable("id") String id) {
        return ResponseEntity.ok(sessionService.deleteSession(id));
    }
//
//    @PatchMapping("/{id}/occupySeat")
//    public ResponseEntity<Mono<SessionResponse>> occupySeat(@PathVariable("id") String id, @RequestParam("line") int line, @RequestParam("column") int column) {
//        return ResponseEntity.ok(sessionService.occupySeat(id, line, column));
//    }
//
//    @GetMapping("/{id}/isSeatOccupied")
//    public ResponseEntity<Mono<SessionResponse>> verifySeat(@PathVariable("id") String id, @RequestParam("line") int line, @RequestParam("column") int column) {
//        return ResponseEntity.ok(sessionService.verifySeat(id, line, column));
//    }
//
//    @PatchMapping("/{id}/vacateSeat")
//    public ResponseEntity<Mono<SessionResponse>> vacateSeat(@PathVariable("id") String id, @RequestParam("line") int line, @RequestParam("column") int column) {
//        return ResponseEntity.ok(sessionService.vacateSeat(id, line, column));
//    }
//
//    @GetMapping("/{id}/seats")
//    public ResponseEntity<Mono<SessionResponse>> fetchSessionSeats(@PathVariable("id") String id) {
//        return ResponseEntity.ok(sessionService.fetchSessionSeats(id));
//    }

}
