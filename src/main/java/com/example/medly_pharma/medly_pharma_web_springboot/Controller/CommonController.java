package com.example.medly_pharma.medly_pharma_web_springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CommonController {
    @GetMapping("/gallery")
    public String getGallery() {
        return "gallery";
    }
        @GetMapping("/home")
    public String getHome() {
        return "index";
    }
    @GetMapping("/services")
    public String getservices() {
        return "services";
    }
    @GetMapping("/about")
    public String getABout() {
        return "about";
    }


    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }
}
