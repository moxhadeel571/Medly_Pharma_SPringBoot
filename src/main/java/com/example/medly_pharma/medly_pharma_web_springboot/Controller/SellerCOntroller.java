package com.example.medly_pharma.medly_pharma_web_springboot.Controller;

import com.example.medly_pharma.medly_pharma_web_springboot.Modal.Medicine;
import com.example.medly_pharma.medly_pharma_web_springboot.Repository.ProductRepository;
import com.example.medly_pharma.medly_pharma_web_springboot.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SellerCOntroller {
private productService productService;
private ProductRepository productRepository;
@Autowired
    public SellerCOntroller(com.example.medly_pharma.medly_pharma_web_springboot.Service.productService productService, ProductRepository productRepository) {
        this.productService = productService;
    this.productRepository = productRepository;
}

    @GetMapping("/seller")
    public String getSeller(Model model, @ModelAttribute("medicine") Medicine medicine){
        List<Medicine> medicineList=productRepository.findAll();
        model.addAttribute("medicine",medicineList);
    return "Seller";
}
@PostMapping("/medicine/save")
    public String getSave(Medicine medicine) {
    productService.save(medicine);


    return "redirect:/seller";
}


}
