package com.example.MaskingAPIDemo.contoller;

import com.example.MaskingAPIDemo.UserData;
import com.example.MaskingAPIDemo.service.MaskingAPIService;
import com.example.MaskingAPIDemo.service.MaskingAPIServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@ConfigurationProperties("masking")
public class MaskingAPIController {

    Logger log = LoggerFactory.getLogger(MaskingAPIController.class);

    @Autowired
    @Lazy
    MaskingAPIServiceImpl maskingAPIServiceImpl;

    @Autowired
    private Environment env;


    @PostMapping("/saveUserData")
    public UserData addUser(@Valid @RequestBody UserData userdata){
        log.info("Enviro."+env.getProperty("spring.masking.firstname"));
        log.info("Add user/users to the system:");
        log.info("Requested user data to be added:"+new JSONObject(userdata));
        UserData userInfo = maskingAPIServiceImpl.saveOrUpdate(userdata);
        log.info("Response from MaskingAPI:"+new JSONObject(userInfo));
        // return the saved data and an Okay.
        return userInfo;
    }

    @GetMapping("/propertyfileSaveUserData")
    public UserData propertyFieUser(){
       UserData user = new UserData();
       user.setFirstName(env.getProperty("spring.masking.firstname"));
       user.setLastName(env.getProperty("spring.masking.lastname"));
       user.setMiddleInitial(env.getProperty("spring.masking.middleinitial"));
       user.setEmail(env.getProperty("spring.masking.email"));
       user.setPhoneNumber(env.getProperty("spring.masking.phonenumber"));
       user.setBillingAddress(env.getProperty("spring.masking.billingaddress"));
       user.setShippingAddress(env.getProperty("spring.masking.shippingadress"));

        log.info("Add property file user/users to the system:");
        log.info("Requested user data to be added:"+new JSONObject(user));
        UserData userInfo = maskingAPIServiceImpl.saveOrUpdate(user);
        log.info("Response from MaskingAPI:"+new JSONObject(userInfo));
        // return the saved data and an Okay.
        return userInfo;
    }

}
