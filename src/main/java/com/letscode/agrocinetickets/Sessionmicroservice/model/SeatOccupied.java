package com.letscode.agrocinetickets.Sessionmicroservice.model;

public enum SeatOccupied {
    TRUE(true), FALSE(true);

    private final Boolean occupied;

    SeatOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public Boolean getOccupied() {
        return occupied;
    }
}
