package com.example.medly_pharma.medly_pharma_web_springboot.Service;

import com.example.medly_pharma.medly_pharma_web_springboot.Modal.Medicine;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface productService {


    Page<Medicine> getAllEntities(Pageable pageable);

    void save(Medicine medicine);

    Page<Medicine> findAllBYPage(int offset, int limit);
}
