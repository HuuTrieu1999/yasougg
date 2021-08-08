package com.paylinks.dto;

import lombok.Data;

@Data
public class MailRequest {
    String reciever;
    String subject;
    String content;
    String type;
    String authenToken;
}
