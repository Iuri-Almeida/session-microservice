package com.letscode.agrocinetickets.Sessionmicroservice.model.dto;

import lombok.Data;

import java.util.Map;

@Data
public class SeatsSessionResponse {
    private int seatsFree;
    private int seatsOccupied;
    private Map<Integer, Boolean> seats;
}
