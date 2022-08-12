package com.example.MaskingAPIDemo.utils;

public class CommonUtils {

    public String lastNameMasking(String lastname){
        String maskedLastName = null;
        if(lastname!=null){
            maskedLastName=lastname.substring(0,1)+lastname.substring(1,lastname.length()).replaceAll("[a-zA-Z]","*");
        }
        return maskedLastName;
    }

    public String phoneNumberMasking(String phoneNumber){
        String maskedPhoneNum;
        maskedPhoneNum=phoneNumber.substring(0,5).replaceAll("[0-9]","*")+phoneNumber.substring(6,phoneNumber.length());

        return maskedPhoneNum;
    }

    public String emailMasking(String email){
        String maskedEmail;
        String emailName=email.substring(0,email.indexOf('@'));
        maskedEmail=emailName.substring(0,1)+emailName.substring(1,emailName.length()).replaceAll("[a-zA-Z0-9]","*")+email.substring(email.indexOf("@"));

        return maskedEmail;
    }

}
