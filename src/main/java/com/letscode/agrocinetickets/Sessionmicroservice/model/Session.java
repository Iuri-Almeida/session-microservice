package com.letscode.agrocinetickets.Sessionmicroservice.model;

import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.time.LocalDateTime;
import java.util.Date;

@DynamoDbBean
@Setter
public class Session {
    private String id;
    private String type;
    private Movie movie;
    private Room room;
    private String startTime;
    private String endTime;
//    private boolean[][] seats;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("sessionID")
    public String getId() {
        return id;
    }

    @DynamoDbAttribute("type")
    public String getType() {
        return type;
    }

    @DynamoDbAttribute("movie")
    public Movie getMovie() {
        return movie;
    }

    @DynamoDbAttribute("room")
    public Room getRoom() {
        return room;
    }

    @DynamoDbAttribute("startTime")
    public String getStartTime() {
        return startTime;
    }

    @DynamoDbAttribute("endTime")
    public String getEndTime() {
        return endTime;
    }

//    @DynamoDbAttribute("seats")
//    public boolean[][] getSeats() {
//        return seats;
//    }


    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
