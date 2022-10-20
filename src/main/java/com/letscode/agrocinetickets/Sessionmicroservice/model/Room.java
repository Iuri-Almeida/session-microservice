package com.letscode.agrocinetickets.Sessionmicroservice.model;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
@Data
public class Room {
    private String id;
    private String roomType;
}
