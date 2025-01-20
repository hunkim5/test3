package com.airpremia.eosh.personaldetail.basicinfo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.personaldetail.basicinfo.dto.UserSafetyOfficeLogDto;

@Repository
public interface UserSafetyOfficeLogRepository {

    int insertUserSafetyOfficeLog(UserSafetyOfficeLogDto insertDto);

    int updateUserSafetyOfficeLog(UserSafetyOfficeLogDto updateDto);

    int deleteUserSafetyOfficeLog(UserSafetyOfficeLogDto updateDto);

    List<UserSafetyOfficeLogDto> selectUserSafetyOfficeLog(long userSeq);
}
