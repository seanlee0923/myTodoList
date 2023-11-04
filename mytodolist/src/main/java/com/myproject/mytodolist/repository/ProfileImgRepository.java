package com.myproject.mytodolist.repository;

import com.myproject.mytodolist.entity.ProfileImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileImgRepository extends JpaRepository<ProfileImg,Long> {
}
