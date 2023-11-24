package com.example.medly_pharma.medly_pharma_web_springboot.Controller;

import com.example.medly_pharma.medly_pharma_web_springboot.Modal.Medicine;
import com.example.medly_pharma.medly_pharma_web_springboot.Modal.UserInfo;
import com.example.medly_pharma.medly_pharma_web_springboot.Repository.ProductRepository;
import com.example.medly_pharma.medly_pharma_web_springboot.Repository.checkOutRepository;
import com.example.medly_pharma.medly_pharma_web_springboot.Service.UserInfoService;
import com.example.medly_pharma.medly_pharma_web_springboot.Service.checkOutService;
import com.example.medly_pharma.medly_pharma_web_springboot.Service.productService;
import jakarta.mail.MessagingException;
import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/users")
public class ProductsController {
private productService productService;
private checkOutRepository checkOutRepository;

private UserInfoService userInfoService;
private checkOutService checkoutService;
private ProductRepository productRepository;
@Autowired
    public ProductsController(productService productService, checkOutService checkoutService, ProductRepository productRepository , com.example.medly_pharma.medly_pharma_web_springboot.Repository.checkOutRepository checkOutRepository, UserInfoService userInfoService) {
        this.productService = productService;
    this.checkoutService = checkoutService;
    this.productRepository = productRepository;
    this.checkOutRepository = checkOutRepository;
    this.userInfoService = userInfoService;
}

    @GetMapping("/shop")
    public String products(Model model) throws IOException {
        Page<Medicine> products = productRepository.findAll(Pageable.ofSize(10));
        model.addAttribute("products", products);
        return "shop";
    }
    @GetMapping("/Pageable")
    private String getpage(@RequestParam("page") int page,Model model, @RequestParam("size") int size){
        Page<Medicine> products = productService.findAllBYPage(page, size);
        model.addAttribute("product", products);
        return "pageable";
    }
    @GetMapping("/Previous")
    private String getpage(Model model){
        Page<Medicine> products = productRepository.findAll((Pageable) Page.empty());
        model.addAttribute("previous", products);
        return "pageable";
    }

    @GetMapping("/view/{id}")
    public String getView(Model model,@PathVariable("id") ObjectId id) {
    Medicine medicine=productRepository.findById(id).orElse(null);
    model.addAttribute("medicine",medicine);
        return "product-single";
    }

    @GetMapping("/checkout/{id}")
    public String getCHeckout(@PathVariable("id")ObjectId id,Model model) {
        Medicine checkout= productRepository.findById(id).orElse(null);
        model.addAttribute("checkout",checkout);
        return "checkout";
    }
    @GetMapping(value = "/addcart/{id}")
    public String addCart(@PathVariable("id") ObjectId id) {
        return "redirect:/users/shop";
    }

    @PostMapping("/payment/success/{id}")
    public String showThankYouPage(@PathVariable("id") ObjectId    id, UserInfo userInfo,
                                   Medicine products
    ) throws MessagingException {
        userInfoService.saveCheckout(userInfo,products);
        return "thankyou";
    }






}
