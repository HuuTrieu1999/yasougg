package com.paylinks.dto;

import lombok.Data;

@Data
public class MailRequest {
    String reciever;
    String content;
    String type;
    String authenToken;
}
