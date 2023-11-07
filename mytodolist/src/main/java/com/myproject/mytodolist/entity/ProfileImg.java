package com.myproject.mytodolist.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class ProfileImg {

    @Id @GeneratedValue
    @Column(name = "img_id")
    private Long imgId;

    // 이미지 저장 경로
    private String imgPath;

    // 프로필 이미지가 저장될 이름
    private String storeFileName;

    @OneToOne @JoinColumn(name = "member_id")
    private Member member;
}
