package com.myproject.mytodolist.dto;

import com.myproject.mytodolist.entity.ProfileImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDTO {
    private String nickname;
    private String password;
    private String email;
    private String phone;
    private String name;
    private ProfileImg profileImg;

    @Override
    public String toString() {
        return "MemberRequestDTO{" +
                "nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
