package com.laundry.myApp.controllers.dto;

import com.laundry.myApp.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Basic;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter @Setter @AllArgsConstructor
public class UserProfileDto {

    private String name;

    private String username;

    public UserProfileDto(User user){
        this.name = user.getName();
        this.username = user.getUsername();
    }

}
