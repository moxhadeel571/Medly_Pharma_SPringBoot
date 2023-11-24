package com.example.medly_pharma.medly_pharma_web_springboot.ServiceImplementation;

import com.example.medly_pharma.medly_pharma_web_springboot.Modal.Medicine;
import com.example.medly_pharma.medly_pharma_web_springboot.Repository.ProductRepository;
import com.example.medly_pharma.medly_pharma_web_springboot.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ProductImplementation implements productService {
private ProductRepository productRepository;
@Autowired
    public ProductImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Page<Medicine> getAllEntities(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void save(Medicine medicine) {
    if (medicine != null) {
        Medicine medication = new Medicine();
        medication.setId(medicine.getId());
        medication.setProduct_name(medicine.getProduct_name());
        medication.setProduct_price(medicine.getProduct_price());
        medication.setProduct_manufactured(medicine.getProduct_manufactured());
        medication.setMedicine_desc(medicine.getMedicine_desc());
        medication.setDrugInteractions(medicine.getDrugInteractions());
        medication.setSide_effects(medicine.getSide_effects());
        medication.setId(medicine.getId());
        productRepository.save(medication);

    }


    }

    @Override
    public Page<Medicine> findAllBYPage(int offset, int limit) {
        Page<Medicine> products = productRepository.findAll(PageRequest.of(offset, limit));

    return products;
    }
}
