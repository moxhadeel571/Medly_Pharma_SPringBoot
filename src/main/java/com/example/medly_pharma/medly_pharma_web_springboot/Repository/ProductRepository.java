package com.example.medly_pharma.medly_pharma_web_springboot.Repository;

import com.example.medly_pharma.medly_pharma_web_springboot.Modal.Medicine;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Medicine,ObjectId> {
    Page<Medicine> findAll(Pageable pageable);
}
