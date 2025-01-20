package com.airpremia.eosh.health.healthcounselresult.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.airpremia.eosh.health.healthcounselresult.controller.UserHealthCounselResultRequest;
import com.airpremia.eosh.health.healthcounselresult.controller.UserHealthCounselResultResponse;
import com.airpremia.eosh.health.healthcounselresult.dto.UserHealthCounselResultDto;
import com.airpremia.eosh.health.healthcounselresult.repository.UserHealthCounselResultRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserHealthCounselResultService {

    private final UserHealthCounselResultRepository userHealthCounselResultRepository;

    public Page<UserHealthCounselResultResponse> selectUserHealthCounselResultPage(
        UserHealthCounselResultRequest
            userHealthCounselResultRequest, Pageable pageable) {

        UserHealthCounselResultDto dto =
            new UserHealthCounselResultDto(userHealthCounselResultRequest);
        Page<UserHealthCounselResultDto> pageDto =
            userHealthCounselResultRepository.selectUserHealthCounselResultPage(dto, pageable);

        return pageDto.map(UserHealthCounselResultResponse::new);
    }

    public UserHealthCounselResultResponse selectUserHealthCounselResult(
        Long userHealthCounselResultSeq) {
        UserHealthCounselResultDto dto =
            userHealthCounselResultRepository.selectUserHealthCounselResult(
                userHealthCounselResultSeq);
        if (dto == null) {
            dto = new UserHealthCounselResultDto();
        }
        return new UserHealthCounselResultResponse(dto);
    }

    public int updateUserHealthCounselResult(UserHealthCounselResultRequest req) {
        UserHealthCounselResultDto dto = new UserHealthCounselResultDto(req);
        return userHealthCounselResultRepository.updateUserHealthCounselResult(dto);
    }

    public int insertUserHealthCounselResult(UserHealthCounselResultRequest req) {
        UserHealthCounselResultDto dto = new UserHealthCounselResultDto(req);
        return userHealthCounselResultRepository.insertUserHealthCounselResult(dto);
    }

    public int deleteUserHealthCounselResult(Long userHealthCounselResultSeq) {
        return userHealthCounselResultRepository.deleteUserHealthCounselResult(
            userHealthCounselResultSeq);
    }
}
