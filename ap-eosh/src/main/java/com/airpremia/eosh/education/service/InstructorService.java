package com.airpremia.eosh.education.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.education.controller.InstructorDeleteRequest;
import com.airpremia.eosh.education.controller.InstructorRequest;
import com.airpremia.eosh.education.controller.InstructorResponse;
import com.airpremia.eosh.education.dto.InstructorDto;
import com.airpremia.eosh.education.repository.InstructorRepository;
import com.airpremia.eosh.exceptions.ExceptionCode;
import com.airpremia.eosh.exceptions.ExpectedException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public List<InstructorResponse> selectEducationInstructorList() {
        List<InstructorDto> listDto =
            instructorRepository.selectEducationInstructorList();
        List<InstructorResponse> resultList = new ArrayList<>();
        for (InstructorDto dataDto : listDto) {
            InstructorResponse resultResponse = new InstructorResponse(dataDto);
            resultList.add(resultResponse);
        }

        return resultList;
    }

    public Page<InstructorResponse> selectEducationInstructorPage(Pageable pageable) {
        Page<InstructorDto> pageDto =
            instructorRepository.selectEducationInstructorPage(pageable);

        return pageDto.map(InstructorResponse::new);
    }

    @Transactional
    public int insertInstructor(List<InstructorRequest> requestList) {
        int insertCount = 0;
        for (InstructorRequest request : requestList) {

            int duplicateCount = instructorRepository.duplicateCheck(request.getUserId());
            if (duplicateCount == 0) {
                if (request.getUserId() == null) {
                    String lastExteranlUserId = instructorRepository.selectExternalUserId();
                    if (lastExteranlUserId == null) {
                        request.setUserId("ETN0000");
                    } else {
                        int externalUserSeq = Integer.parseInt(lastExteranlUserId.substring(3, 7));
                        String externalUserId = String.format("%04d", externalUserSeq + 1);
                        request.setUserId("ETN" + externalUserId);
                    }
                }
                InstructorDto dataDto = new InstructorDto(request);
                instructorRepository.insertInstructor(dataDto);
                insertCount += 1;
            } else {
                throw new ExpectedException(ExceptionCode.INSTRUCTOR_DUPLICATE);
            }
        }
        return insertCount;
    }

    @Transactional
    public int deleteInstructor(List<InstructorDeleteRequest> deleteRequest) {
        int resultCount = 0;
        for (InstructorDeleteRequest request : deleteRequest) {
            resultCount += instructorRepository.deleteInstructor(request.getInstructorSeq());
        }

        return resultCount;
    }
}
