package com.airpremia.eosh.personaldetail.userhealthcounselreservation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.personaldetail.userhealthcounselreservation.controller.UserHealthCounselReservationRequest;
import com.airpremia.eosh.personaldetail.userhealthcounselreservation.controller.UserHealthCounselReservationResponse;
import com.airpremia.eosh.personaldetail.userhealthcounselreservation.dto.UserHealthCounselReservationDto;
import com.airpremia.eosh.personaldetail.userhealthcounselreservation.repository.UserHealthCounselReservationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserHealthCounselReservationService {
    private final UserHealthCounselReservationRepository userHealthCounselReservationRepository;
    private final CommonFunction commonFunction;

    public Page<UserHealthCounselReservationResponse> selectUserHealthCounselReservationPage(
        UserHealthCounselReservationRequest request, Pageable pageable) {
        UserHealthCounselReservationDto searchDto = new UserHealthCounselReservationDto(request);
        Page<UserHealthCounselReservationDto> pageList =
            userHealthCounselReservationRepository.selectUserHealthCounselReservationPage(searchDto, pageable);

        return pageList.map(UserHealthCounselReservationResponse::new);
    }

    public UserHealthCounselReservationResponse selectUserHealthCounselReservation(
        long userHealthCounselReservationSeq) {
        UserHealthCounselReservationDto dto =
            userHealthCounselReservationRepository.selectUserHealthCounselReservation(
                userHealthCounselReservationSeq);
        return new UserHealthCounselReservationResponse(dto);
    }

    @Transactional
    public int insertUserHealthCounselReservation(UserHealthCounselReservationRequest request) {
        UserHealthCounselReservationDto dto = new UserHealthCounselReservationDto(request);
        return userHealthCounselReservationRepository.insertUserHealthCounselReservation(dto);
    }

    @Transactional
    public int updateUserHealthCounselReservation(UserHealthCounselReservationRequest request) {
        UserHealthCounselReservationDto dto = new UserHealthCounselReservationDto(request);
        return userHealthCounselReservationRepository.updateUserHealthCounselReservation(dto);
    }

    @Transactional
    public int deleteUserHealthCounselReservation(long userHealthCounselReservationSeq) {
        return userHealthCounselReservationRepository.deleteUserHealthCounselReservation(
            userHealthCounselReservationSeq);
    }
}
