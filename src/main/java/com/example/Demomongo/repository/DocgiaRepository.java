package com.example.Demomongo.repository;

import com.example.Demomongo.entity.DocgiaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocgiaRepository extends MongoRepository<DocgiaEntity,String> {

}
