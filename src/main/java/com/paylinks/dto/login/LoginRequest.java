package com.paylinks.dto.login;

import lombok.Data;

@Data
public class LoginRequest {
  String phone;
  String password;
}
