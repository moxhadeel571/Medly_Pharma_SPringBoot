package com.example.medly_pharma.medly_pharma_web_springboot.Service;

import com.example.medly_pharma.medly_pharma_web_springboot.Modal.User;
import org.springframework.stereotype.Service;

public interface UserService {



 User saveUser(User User);


 void removeSuccessMessage();
}