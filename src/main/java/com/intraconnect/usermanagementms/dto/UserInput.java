package com.intraconnect.usermanagementms.dto;

import lombok.Data;



@Data
public class UserInput {
    private String firstName;
    private  String lastName;
    private String dateOfBirth;
    private String email;
    private String address;
    private  String contactNumber;
    private String password;


}
