package com.myproject.mytodolist.dto;

import com.myproject.mytodolist.entity.Member;
import com.myproject.mytodolist.entity.ProfileImg;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor

// 서비스에서 메소드 사용해서 쉽게 엔티티로 변환할수 있게
@Builder
public class MemberRequestDTO {
    private String nickname;
    private String password;
    private String email;
    private String phone;
    private String name;
    private MultipartFile profileImg;

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

    // 서비스에서 MemberRequest를 Member 엔티티로 바꿔주는 메소드
    public Member toMemberEntity(){
        return Member.builder()
                .nickname(nickname)
                .password(password)
                .email(email)
                .phone(phone)
                .name(name).build();
    }

    // 서비스에서 MemberRequst를 ProfileImg 엔티티로 바꿔주는 메소드
    public ProfileImg toProfileImgEntity(Member member, String imgPath, String storeFileName){
        return ProfileImg.builder()
                .member(member)
                .imgPath(imgPath)
                .storeFileName(storeFileName).build();
    }
}
