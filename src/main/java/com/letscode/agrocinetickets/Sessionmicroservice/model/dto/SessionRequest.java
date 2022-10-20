package com.letscode.agrocinetickets.Sessionmicroservice.model.dto;

import com.letscode.agrocinetickets.Sessionmicroservice.model.Movie;
import com.letscode.agrocinetickets.Sessionmicroservice.model.Room;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SessionRequest {
    private String id;
    private Movie movie;
    private Room room;
    private LocalDateTime startTime;
    private boolean[][] seats;
}

