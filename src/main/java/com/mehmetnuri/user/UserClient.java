package com.mehmetnuri.user;


import com.mehmetnuri.user.model.UserInformation;

public interface UserClient {

    UserInformation getUserInformation(String userId);
}
