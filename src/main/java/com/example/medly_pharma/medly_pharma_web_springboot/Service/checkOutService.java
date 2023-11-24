package com.example.medly_pharma.medly_pharma_web_springboot.Service;

import com.example.medly_pharma.medly_pharma_web_springboot.Modal.UserInfo;
import com.example.medly_pharma.medly_pharma_web_springboot.Modal.checkOut;
import org.bson.types.ObjectId;

import java.util.List;
public interface checkOutService {

    String processOrder(ObjectId id);
    List<checkOut>  getAllCustomers();

    checkOut saveCheckout(ObjectId id, checkOut checkOut, UserInfo userInfo) throws Exception;

    checkOut getAllCustomers(ObjectId id);

}
