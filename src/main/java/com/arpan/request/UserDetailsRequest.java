package com.arpan.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.arpan.validation.ValidAmount;
import com.arpan.validation.ValidEmail;
import com.arpan.validation.ValidMobileNumber;
import com.arpan.validation.ValidName;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsRequest {

	@ValidName
    private String name;
    
    @ValidAmount
    private double balance;
    
    @ValidEmail
    private String email;

    @ValidMobileNumber
    private String mobile;
}
