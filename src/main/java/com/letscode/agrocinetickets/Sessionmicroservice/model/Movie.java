package com.letscode.agrocinetickets.Sessionmicroservice.model;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
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
