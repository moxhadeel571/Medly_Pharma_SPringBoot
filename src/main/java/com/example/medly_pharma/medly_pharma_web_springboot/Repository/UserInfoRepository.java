package com.example.medly_pharma.medly_pharma_web_springboot.Repository;

import com.example.medly_pharma.medly_pharma_web_springboot.Modal.UserInfo;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends MongoRepository<UserInfo,ObjectId> {

    @Query("{ 'email' : ?0 }")
    SecurityProperties.User findByEmail(String email);
}
