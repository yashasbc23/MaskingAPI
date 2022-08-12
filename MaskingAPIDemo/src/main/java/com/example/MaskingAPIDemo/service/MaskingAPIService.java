package com.example.MaskingAPIDemo.service;

import com.example.MaskingAPIDemo.UserData;
import org.springframework.data.repository.CrudRepository;

public interface MaskingAPIService extends CrudRepository<UserData,String> {
    UserData saveOrUpdate(UserData user);
}
