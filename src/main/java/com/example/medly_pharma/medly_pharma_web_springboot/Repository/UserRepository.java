package com.example.medly_pharma.medly_pharma_web_springboot.Repository;

import com.example.medly_pharma.medly_pharma_web_springboot.Modal.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {


    User findFirstByEmail(String email);
}