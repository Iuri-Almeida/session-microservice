package com.letscode.agrocinetickets.Sessionmicroservice.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.letscode.agrocinetickets.Sessionmicroservice.model.Session;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SessionRepository extends BaseRepository<Session, String> {

    public SessionRepository(DynamoDBMapper dynamoDBMapper) {
        super(dynamoDBMapper);
    }

    @Override
    protected Class<Session> getClassType() {
        return Session.class;
    }

    public List<Session> findSessionsByRoom(String roomId) {

        Map<String, AttributeValue> eav = new HashMap<>();

        eav.put(":val1", new AttributeValue().withS(getEntityName()));
        eav.put(":val2", new AttributeValue().withS(roomId));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("tipo = :val1")
                .withExpressionAttributeValues(eav);

        return dynamoDBMapper.scan(getClassType(),scanExpression);
    }
}
