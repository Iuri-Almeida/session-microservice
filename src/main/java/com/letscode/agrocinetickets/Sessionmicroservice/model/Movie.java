package com.letscode.agrocinetickets.Sessionmicroservice.model;

import lombok.Data;

@Data
public class Movie {
    private String id;
    private String title;
    private Long year;
    private Long runtime;
    private String director;
    private String poster;
    private boolean subtitle;
}
