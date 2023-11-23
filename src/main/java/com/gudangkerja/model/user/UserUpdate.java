package com.gudangkerja.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdate {
    private String name;

    private String phone;

    private String wa;

    private String password;

    private String address;
}
