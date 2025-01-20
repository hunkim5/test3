package com.airpremia.eosh.personaldetail.basicinfo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.personaldetail.basicinfo.dto.UserQualificationItemDto;

@Repository
public interface UserQualificationItemRepository {

    int insertUserQualificationItem(UserQualificationItemDto insertDto);

    int updateUserQualificationItem(UserQualificationItemDto updateDto);

    int deleteUserQualificationItem(UserQualificationItemDto deleteDto);

    List<UserQualificationItemDto> selectUserQualificationItem(long userSeq);

    List<UserQualificationItemDto> selectUserQualificationItemByUserId(String userId);
}
