package com.Babu.response;

import com.Babu.model.USER_ROLE;
import com.Babu.model.User;
import lombok.Data;

@Data
public class AuthResponse {

    private  String jwt;

    private String message;

    private USER_ROLE role;

}
