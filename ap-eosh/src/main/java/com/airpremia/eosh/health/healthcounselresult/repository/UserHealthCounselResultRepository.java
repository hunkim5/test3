package com.airpremia.eosh.health.healthcounselresult.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.health.healthcounselresult.dto.UserHealthCounselResultDto;


@Repository
public interface UserHealthCounselResultRepository {

    Page<UserHealthCounselResultDto> selectUserHealthCounselResultPage(
        @Param(value = "searchDto") UserHealthCounselResultDto dto, Pageable pageable);

    UserHealthCounselResultDto selectUserHealthCounselResult(long userHealthCounselReservationSeq);

    int insertUserHealthCounselResult(UserHealthCounselResultDto dto);

    int updateUserHealthCounselResult(UserHealthCounselResultDto dto);

    int deleteUserHealthCounselResult(long userHealthCounselReservationSeq);
}
