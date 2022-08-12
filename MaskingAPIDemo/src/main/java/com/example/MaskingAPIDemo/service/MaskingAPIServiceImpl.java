package com.example.MaskingAPIDemo.service;

import com.example.MaskingAPIDemo.UserData;
import com.example.MaskingAPIDemo.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;

@Service
public class MaskingAPIServiceImpl {
    Logger log = LoggerFactory.getLogger(MaskingAPIServiceImpl.class);

    @Autowired
    @Lazy
    MaskingAPIService maskingApiService ;

    CommonUtils commonUtils = new CommonUtils();

    public UserData saveOrUpdate(UserData userData)
    {
        log.info("Saving user information to DB:");
        if (userData == null ) {
            log.error("Userdata is empty.");
        }
        UserData user = maskingApiService.save(userData);
        String maskedLastName = commonUtils.lastNameMasking(user.getLastName());
        String maskedEmail = commonUtils.emailMasking(user.getEmail());
        String maskedPhoneNumber = commonUtils.phoneNumberMasking(user.getPhoneNumber());
        return new UserData(user.getId(),user.getFirstName(),maskedLastName,user.getMiddleInitial(),
                maskedEmail,maskedPhoneNumber,user.getBillingAddress(),user.getShippingAddress());
    }


}
