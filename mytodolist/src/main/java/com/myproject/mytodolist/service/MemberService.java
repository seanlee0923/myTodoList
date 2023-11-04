package com.myproject.mytodolist.service;

import com.myproject.mytodolist.dto.MemberRequestDTO;
import org.springframework.stereotype.Service;

public interface MemberService {
    void registerMember(MemberRequestDTO member);
}
