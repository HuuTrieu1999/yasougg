package com.paylinks.dto.login;

import lombok.Data;

@Data
public class LoginResponse {

  int sessionId;

  int code;
  String discription;
}
