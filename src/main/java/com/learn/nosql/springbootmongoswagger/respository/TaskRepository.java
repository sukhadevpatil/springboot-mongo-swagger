package com.learn.nosql.springbootmongoswagger.respository;

import com.learn.nosql.springbootmongoswagger.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findBySeverity(String severity);

    @Query("{assignee: ?0}")
    List<Task> findByAssignee(String assignee);
}
