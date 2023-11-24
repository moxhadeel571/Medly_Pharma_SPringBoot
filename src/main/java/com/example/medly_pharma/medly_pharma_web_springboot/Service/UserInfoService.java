package com.example.medly_pharma.medly_pharma_web_springboot.Service;

import com.example.medly_pharma.medly_pharma_web_springboot.Modal.Medicine;
import com.example.medly_pharma.medly_pharma_web_springboot.Modal.UserInfo;
import org.bson.types.ObjectId;

import java.util.Optional;

public interface UserInfoService {


    void saveCheckout(UserInfo userInfo, Medicine medicine);

}
