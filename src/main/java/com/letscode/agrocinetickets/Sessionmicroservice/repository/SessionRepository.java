package com.letscode.agrocinetickets.Sessionmicroservice.repository;

import com.letscode.agrocinetickets.Sessionmicroservice.model.Session;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.PagePublisher;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SessionRepository extends BaseRepository<Session, String> {

    public SessionRepository(DynamoDbEnhancedAsyncClient enhancedAsyncClient) {
        super(enhancedAsyncClient);
    }

    public PagePublisher<Session> findByMovie(String movieId) {
        Map<String, AttributeValue> expVal = new HashMap<>();
        expVal.put(":val1", AttributeValue.builder().s(movieId).build());
        Expression exp = Expression.builder().expression("movie.id = :val1").expressionValues(expVal).build();
        ScanEnhancedRequest req = ScanEnhancedRequest.builder().filterExpression(exp).build();

        return dynamoDbAsyncTable.scan(req);
    }

    public PagePublisher<Session> findByRoom(String roomId) {
        Map<String, AttributeValue> expVal = new HashMap<>();
        expVal.put(":val1", AttributeValue.builder().s(roomId).build());
        Expression exp = Expression.builder().expression("room.id = :val1").expressionValues(expVal).build();
        ScanEnhancedRequest req = ScanEnhancedRequest.builder().filterExpression(exp).build();

        return dynamoDbAsyncTable.scan(req);
    }

    @Override
    protected Class<Session> getClassType() {
        return Session.class;
    }

    @Override
    protected Key getKeyBuild(String id) {
        return Key.builder().partitionValue(id).build();
    }
}
