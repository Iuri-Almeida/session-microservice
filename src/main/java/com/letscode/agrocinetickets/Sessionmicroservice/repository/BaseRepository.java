package com.letscode.agrocinetickets.Sessionmicroservice.repository;

import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.PagePublisher;

import java.util.concurrent.CompletableFuture;

public abstract class BaseRepository<T, K> {
    protected final DynamoDbAsyncTable<T> dynamoDbAsyncTable;

    public BaseRepository(DynamoDbEnhancedAsyncClient enhancedAsyncClient) {
        this.dynamoDbAsyncTable = enhancedAsyncClient.table(getEntityName(), TableSchema.fromBean(getClassType()));
    }

    public CompletableFuture<Void> save(T obj) {
        dynamoDbAsyncTable.putItem(obj);
        return dynamoDbAsyncTable.putItem(obj);
    }

    public CompletableFuture<T> findById(K id) {
        return dynamoDbAsyncTable.getItem(getKeyBuild(id));
    }

    public CompletableFuture<T> updateById(T obj) {
        return dynamoDbAsyncTable.updateItem(obj);
    }

    public CompletableFuture<T> deleteById(K id) {
        return dynamoDbAsyncTable.deleteItem(getKeyBuild(id));
    }

    public PagePublisher<T> findAll() {
        return dynamoDbAsyncTable.scan();
    }

    protected abstract Class<T> getClassType();

    public String getEntityName() {
        return getClassType().getSimpleName().toLowerCase();
    }

    protected abstract Key getKeyBuild(K id);
}
