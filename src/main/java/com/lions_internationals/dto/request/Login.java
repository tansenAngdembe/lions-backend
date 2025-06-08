package com.lions_internationals.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login {
    private String email;
    private String password;
}
