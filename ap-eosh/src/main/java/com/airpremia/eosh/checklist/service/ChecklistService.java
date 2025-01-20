package com.airpremia.eosh.checklist.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.checklist.dto.ChecklistDto;
import com.airpremia.eosh.checklist.dto.ChecklistQuestionResultDto;
import com.airpremia.eosh.checklist.repository.ChecklistQuestionResultRepository;
import com.airpremia.eosh.checklist.repository.ChecklistRepository;
import com.airpremia.eosh.checklist.request.ChecklistQuestionResultRequest;
import com.airpremia.eosh.checklist.request.ChecklistRequest;
import com.airpremia.eosh.checklist.request.ChecklistSearchRequest;
import com.airpremia.eosh.checklist.response.ChecklistQuestionResultResponse;
import com.airpremia.eosh.checklist.response.ChecklistResponse;
import com.airpremia.eosh.exceptions.ExceptionCode;
import com.airpremia.eosh.exceptions.ExpectedException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChecklistService {
    private final Logger logger = LoggerFactory.getLogger(ChecklistService.class);

    private final ChecklistRepository checklistRepository;
    private final ChecklistQuestionResultRepository checklistQuestionResultRepository;

    public Page<ChecklistResponse> selectChecklistPage(ChecklistSearchRequest req, Pageable pageable) {

        ChecklistDto searchDto = new ChecklistDto(req);
        Page<ChecklistDto> pageList =
            checklistRepository.selectChecklistPage(searchDto, pageable);

        return pageList.map(ChecklistResponse::new);
    }

    public ChecklistResponse selectChecklistDetail(Long checklistSeq) {
        ChecklistResponse result = checklistRepository.selectChecklist(checklistSeq).convertChecklistResponse();
        List<ChecklistQuestionResultResponse> checklistResultList =
            checklistQuestionResultRepository.selectChecklistQuestionResultList(checklistSeq).stream()
                .map(ChecklistQuestionResultDto::convertChecklistQuestionResultResponse).toList();
        result.setChecklistResultList(checklistResultList);
        return result;
    }

    @Transactional
    public Long insertChecklist(ChecklistRequest request) {
        ChecklistDto dto = new ChecklistDto(request);
        checklistRepository.insertChecklist(dto);
        saveChecklistQuestionResult(request.getChecklistResultList(), dto.getChecklistSeq());
        return dto.getChecklistSeq();
    }

    @Transactional
    public int updateChecklist(ChecklistRequest request) {
        ChecklistDto dto = new ChecklistDto(request);
        int result = 0;
        result += checklistRepository.updateChecklist(dto);
        result += saveChecklistQuestionResult(request.getChecklistResultList(), dto.getChecklistSeq());
        return result;
    }

    public int saveChecklistQuestionResult(
        List<ChecklistQuestionResultRequest> checklistResultList, long checklistSeq) {
        int result = 0;
        if (checklistResultList == null || checklistResultList.isEmpty()) {
            return result;
        }
        List<ChecklistQuestionResultDto> convertList = checklistResultList.stream().map(request -> {
            ChecklistQuestionResultDto dto = request.convertChecklistQuestionResultDto();
            dto.setChecklistSeq(checklistSeq);
            return dto;
        }).toList();

        List<ChecklistQuestionResultDto> insertList =
            convertList.stream().filter(item -> item.getChecklistQuestionResultSeq() == null).toList();

        List<ChecklistQuestionResultDto> updateList =
            convertList.stream().filter(item -> item.getChecklistQuestionResultSeq() != null).toList();

        if (!updateList.isEmpty()) {
            result += updateChecklistQuestionResult(updateList);
        }
        if (!insertList.isEmpty()) {
            result += insertChecklistQuestionResultList(insertList);
        }

        return result;
    }

    private int updateChecklistQuestionResult(List<ChecklistQuestionResultDto> checklistResultList) {
        if (checklistResultList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return checklistResultList.stream()
            .map(checklistQuestionResultRepository::updateChecklistQuestionResult)
            .reduce(0, Integer::sum);
    }

    private int insertChecklistQuestionResultList(List<ChecklistQuestionResultDto> checklistResultList) {
        if (checklistResultList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return checklistQuestionResultRepository.insertChecklistQuestionResultList(checklistResultList);
    }

    @Transactional
    public int deleteChecklist(List<ChecklistRequest> deleteList) {
        List<Long> deleteSeqList = deleteList.stream().map(ChecklistRequest::getChecklistSeq).toList();
        int result = 0;

        result += checklistQuestionResultRepository.deleteChecklistQuestionResultList(deleteSeqList);
        result += checklistRepository.deleteChecklist(deleteSeqList);

        return result;
    }
}
