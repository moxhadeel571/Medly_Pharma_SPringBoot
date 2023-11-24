package com.example.medly_pharma.medly_pharma_web_springboot.ServiceImplementation;

import com.example.medly_pharma.medly_pharma_web_springboot.Modal.Medicine;
import com.example.medly_pharma.medly_pharma_web_springboot.Modal.UserInfo;
import com.example.medly_pharma.medly_pharma_web_springboot.Repository.UserInfoRepository;
import com.example.medly_pharma.medly_pharma_web_springboot.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoServiceImpl implements UserInfoService {
  private UserInfoRepository userInfoRepository;
@Autowired
    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public void saveCheckout(UserInfo userInfo, Medicine medicine) {
        // Set user information from checkoutUser to userInfo
        userInfo.setFirstName(userInfo.getFirstName());
        userInfo.setLastName(userInfo.getLastName());
        userInfo.setUsername(userInfo.getUsername());
        userInfo.setEmail(userInfo.getEmail());
        userInfo.setPhone(userInfo.getPhone());
        userInfo.setAddressLine1(userInfo.getAddressLine1());
        userInfo.setAddressLine2(userInfo.getAddressLine2());
        userInfo.setCountry(userInfo.getCountry());
        userInfo.setCity(userInfo.getCity());
        userInfo.setState(userInfo.getState());
        userInfo.setZipcode(userInfo.getZipcode());
        userInfo.setId(userInfo.getId());

// Save the UserInfo object to the database
        userInfoRepository.save(userInfo);
    }





}
