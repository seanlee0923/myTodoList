package com.myproject.mytodolist.service;

import com.myproject.mytodolist.dto.MemberRequestDTO;
import com.myproject.mytodolist.entity.Member;
import com.myproject.mytodolist.entity.ProfileImg;
import com.myproject.mytodolist.repository.MemberRepository;
import com.myproject.mytodolist.repository.ProfileImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class LoginServiceImpl implements LoginService{
    private MemberRepository memberRepository;
    private ProfileImgRepository profileImgRepository;

    @Autowired
    public LoginServiceImpl(MemberRepository memberRepository, ProfileImgRepository profileImgRepository) {
        this.memberRepository = memberRepository;
        this.profileImgRepository = profileImgRepository;
    }

    // 프로필사진이 업로드되는 경로
    private final String fileUploadPath = "/Users/sean/Documents/myTodoList/mytodolist/src/main/resources/static/profile_img/";
    //회원가입을 위한 메소드
    @Override
    public void register(MemberRequestDTO requestDTO){
        // 회원가입을 위해 기본 정보를 가진 엔티티 생성 후 db에 저장
        Member member = requestDTO.toMemberEntity();
        memberRepository.save(member);

        // 만약 프로필 파일이 존재하면 PrifileImg 엔티티 생성 후 db에 저장
        MultipartFile file = requestDTO.getProfileImg();
        if(file!=null){
            // 파일이 저장될 전체 경로 만들기
            String fullPath = fileUploadPath+file.getOriginalFilename();
            // 위에서 만든 경로로 실제 업로드될 파일 생성
            try {
                File dest = new File(fullPath);
                file.transferTo(dest);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 서버에 저장 후 DB에 저장할 ProfileImg 엔티티 생성 후 저장
            ProfileImg img = requestDTO.toProfileImgEntity(member,fullPath,file.getOriginalFilename());
            profileImgRepository.save(img);
        }else{
            System.out.println("프로필사진 없음");
        }
    }
}
