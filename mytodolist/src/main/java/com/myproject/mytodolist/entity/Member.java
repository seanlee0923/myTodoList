package com.myproject.mytodolist.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "member")
@Builder
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long memberId;

    // 로그인id로 사용
    private String nickname;
    private String password;
    private String email;
    private String phone;
    private String name;

    @OneToOne(mappedBy = "member")
    private ProfileImg profileImg;
    //유저가 가지고있는 plan들
    @OneToMany(mappedBy = "member")
    List<Plan> planList = new ArrayList<>();
}
