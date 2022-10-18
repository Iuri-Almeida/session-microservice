package com.letscode.agrocinetickets.Sessionmicroservice.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseRepository<T,K> {
    protected final DynamoDBMapper dynamoDBMapper;

    public T save(T obj) {
        dynamoDBMapper.save(obj);
        return obj;
    }

    public void deleteById(K id) {
        dynamoDBMapper.delete(findById(id));
    }

    public T findById(K id) {
        return Optional.ofNullable(dynamoDBMapper.load(getClassType(), getEntityName(), id))
                .orElseThrow(RuntimeException::new); //ItemNaoEncontradoException::new
    }

    public List<T> findAll() {

        Map<String, AttributeValue> eav = new HashMap<>();

        eav.put(":val1", new AttributeValue().withS(getEntityName()));

        DynamoDBQueryExpression<T> queryExpression = new DynamoDBQueryExpression<T>()
                .withKeyConditionExpression("tipo = :val1")
                .withExpressionAttributeValues(eav);

        return dynamoDBMapper.query(getClassType(), queryExpression);
    }

    protected abstract Class<T> getClassType();

    public String getEntityName() {
        return getClassType().getSimpleName().toLowerCase();
    }
}
