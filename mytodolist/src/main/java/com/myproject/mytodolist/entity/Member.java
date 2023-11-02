package com.myproject.mytodolist.entity;

import lombok.AllArgsConstructor;
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
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String nickname;
    private String password;
    private String email;
    private String phone;
    private String name;

    private String profileImg; // 프로필사진
    //유저가 가지고있는 plan들
    @OneToMany(mappedBy = "member")
    List<Plan> planList = new ArrayList<>();
}
