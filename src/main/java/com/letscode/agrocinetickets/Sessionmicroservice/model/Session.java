package com.letscode.agrocinetickets.Sessionmicroservice.model;

import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.Map;

@DynamoDbBean
@Setter
public class Session {
    private String id;
    private Movie movie;
    private Room room;
    private String startTime;
    private String endTime;
    private Map<Integer, Boolean> seats;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("id")
    public String getId() {
        return id;
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

    @DynamoDbAttribute("seats")
    public Map<Integer, Boolean> getSeats() {
        return seats;
    }


    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                '}';
    }
}
