package com.airpremia.eosh.personaldetail.userhealthcounselreservation.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.personaldetail.userhealthcounselreservation.dto.UserHealthCounselReservationDto;

@Repository
public interface UserHealthCounselReservationRepository {

    Page<UserHealthCounselReservationDto> selectUserHealthCounselReservationPage(
        @Param(value = "searchDto") UserHealthCounselReservationDto dto, Pageable pageable);

    UserHealthCounselReservationDto selectUserHealthCounselReservation(long userHealthCounselReservationSeq);

    int insertUserHealthCounselReservation(UserHealthCounselReservationDto dto);

    int updateUserHealthCounselReservation(UserHealthCounselReservationDto dto);

    int deleteUserHealthCounselReservation(long userHealthCounselReservationSeq);
}
