package com.letscode.agrocinetickets.Sessionmicroservice.controller;

import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionRequest;
import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionResponse;
import com.letscode.agrocinetickets.Sessionmicroservice.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @PostMapping
    public ResponseEntity<SessionResponse> createSession(@RequestBody SessionRequest sessionRequest) {

    }

    @GetMapping
    public ResponseEntity<SessionResponse> findSessions() {

    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionResponse> findSession(@PathVariable("id") String id) {

    }

    @GetMapping
    public ResponseEntity<SessionResponse> findSessionsByRoom(@RequestParam("roomId") String roomId) {

    }

    @GetMapping
    public ResponseEntity<SessionResponse> findSessionsByTime(@RequestParam("time") String timeId) {

    }

    @GetMapping
    public ResponseEntity<SessionResponse> findSessionsByMovie(@RequestParam("movieId") String movieId) {

    }

    @PatchMapping("/{id}")
    public ResponseEntity<SessionResponse> modifySession(@PathVariable("id") String id) {

    }

    @PutMapping("/{id}")
    public ResponseEntity<SessionResponse> modifySessionEntirely(@PathVariable("id") String id) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SessionResponse> deleteSession(@PathVariable("id") String id) {

    }

    @PatchMapping("/{id}/occupySeat")
    public ResponseEntity<SessionResponse> occupySeat(@PathVariable("id") String id, @RequestParam("line") int line, @RequestParam("column") int column) {

    }


}
