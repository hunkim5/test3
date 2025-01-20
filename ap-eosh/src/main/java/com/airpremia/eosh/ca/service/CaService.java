package com.airpremia.eosh.ca.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.ca.dto.CaCollectionSearchDto;
import com.airpremia.eosh.ca.dto.SubscribeCaItemWithSourceDto;
import com.airpremia.eosh.ca.entities.SubscribeCaItemEntity;
import com.airpremia.eosh.ca.entities.SubscribeCaItemInchargeEntity;
import com.airpremia.eosh.ca.repository.SubscribeCaItemComplexRepository;
import com.airpremia.eosh.ca.repository.SubscribeCaItemInchargeRepository;
import com.airpremia.eosh.ca.repository.SubscribeCaItemRepository;
import com.airpremia.eosh.ca.request.ca.CaCollectionRequest;
import com.airpremia.eosh.ca.request.ca.SubscribeCaItemRequest;
import com.airpremia.eosh.ca.request.incharge.SubscribeCaItemInchargeRequest;
import com.airpremia.eosh.ca.response.ca.CaCollectionResponse;
import com.airpremia.eosh.ca.response.ca.SubscribeCaItemResponse;
import com.airpremia.eosh.ca.response.incharge.SubscribeCaItemInchargeResponse;
import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.common.dto.HrDeptTreeDto;
import com.airpremia.eosh.common.enums.RoleEnum;
import com.airpremia.eosh.exceptions.ExceptionCode;
import com.airpremia.eosh.exceptions.ExpectedException;
import com.airpremia.eosh.usertoken.dto.UserTokenDto;
import com.airpremia.eosh.usertoken.service.UserTokenService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CaService {
    private final SubscribeCaItemInchargeRepository subscribeCaItemInchargeRepository;
    private final SubscribeCaItemComplexRepository subscribeCaItemComplexRepository;
    private final SubscribeCaItemRepository subscribeCaItemRepository;
    private final UserTokenService userTokenService;
    private final CommonFunction commonFunction;

    public Page<CaCollectionResponse> selectCaPage(CaCollectionRequest request, Pageable pageable) {
        UserTokenDto userToken = userTokenService.getUserToken();
        CaCollectionSearchDto searchDto = request.toSearchDto();

        if (request.getPageRoleEnum().isAdminPage()) {
            adjustRequestBasedOnRoles(searchDto, userToken);
        } else {
            searchDto.setAssignedUserId(userToken.getEmpNo());
        }

        Page<CaCollectionResponse> caPage = request.getPageRoleEnum().isAdminPage() ?
            subscribeCaItemComplexRepository.selectAdminPage(searchDto, pageable)
                .map(this::entityConvertResponse) :
            subscribeCaItemComplexRepository.selectPage(searchDto, pageable)
                .map(this::entityConvertResponse);

        return caPage;
    }

    private void adjustRequestBasedOnRoles(CaCollectionSearchDto searchDto, UserTokenDto userToken) {
        List<RoleEnum> roleEnumList = userToken.getRoles().stream().map(RoleEnum::fromRoleName).toList();

        boolean hasPriorityRole = roleEnumList.stream().anyMatch(role -> role.isSuperAdmin() || role.isAdmin());

        if (hasPriorityRole) {
            return;
        }

        boolean hasWorkSectorRole =
            roleEnumList.stream().anyMatch(RoleEnum::isMaster);

        if (hasWorkSectorRole) {
            List<String> deptFnCdList = List.of(userToken.getDeptFnCd().split(">"));

            if (deptFnCdList.size() < 2) {
                throw new ExpectedException(ExceptionCode.DATA_EMPTY);
            }

            List<HrDeptTreeDto> accessibleDeptCdList =
                commonFunction.selectHrDeptTree(deptFnCdList.get(1), false).getData();

            searchDto.setAccessibleDepartmentCdList(
                accessibleDeptCdList.stream().map(HrDeptTreeDto::getDeptCd).toList());

            return;
        }

        boolean hasDepartmentRole = roleEnumList.stream().anyMatch(RoleEnum::isMaster);

        if (hasDepartmentRole) {
            searchDto.setAccessibleDepartmentCdList(Collections.singletonList(userToken.getDeptCd()));
        }
    }

    public List<CaCollectionResponse> selectCaList(CaCollectionRequest request) {
        UserTokenDto userToken = userTokenService.getUserToken();
        CaCollectionSearchDto searchDto = request.toSearchDto();

        if (request.getPageRoleEnum().isAdminPage()) {
            adjustRequestBasedOnRoles(searchDto, userToken);
        } else {
            searchDto.setAssignedUserId(userToken.getEmpNo());
        }

        List<SubscribeCaItemWithSourceDto> caList = request.getPageRoleEnum().isAdminPage() ?
            subscribeCaItemComplexRepository.selectAdminList(searchDto) :
            subscribeCaItemComplexRepository.selectList(searchDto);

        return caList.stream().map(this::entityConvertResponse).toList();
    }

    public SubscribeCaItemResponse selectDetail(Long subscribeCaItemSeq) {
        SubscribeCaItemResponse result =
            new SubscribeCaItemResponse(subscribeCaItemRepository.selectSubscribeCaItemDetail(subscribeCaItemSeq));

        result.setInchargeList(
            subscribeCaItemInchargeRepository.selectItemInchargeList(result.getSubscribeCaUuid(), subscribeCaItemSeq)
                .stream().map(SubscribeCaItemInchargeResponse::new).toList());


        return result;
    }

    @Transactional
    public SubscribeCaItemResponse updateCaItem(Long subscribeCaItemSeq, SubscribeCaItemRequest request) {
        request.setSubscribeCaItemSeq(subscribeCaItemSeq);
        subscribeCaItemRepository.updateSubscribeCaItem(request.toEntity());

        updateCaItemInchargeList(subscribeCaItemSeq, request);

        return selectDetail(subscribeCaItemSeq);
    }

    @Transactional
    public SubscribeCaItemResponse updateCaItemAppvalprc(Long subscribeCaItemSeq, SubscribeCaItemRequest request) {
        request.setSubscribeCaItemSeq(subscribeCaItemSeq);
        subscribeCaItemRepository.updateSubscribeCaItemCaApprvalprcEnum(request.toEntity());
        return selectDetail(subscribeCaItemSeq);
    }

    public List<SubscribeCaItemInchargeResponse> updateCaItemInchargeList(
        Long subscribeCaItemSeq, SubscribeCaItemRequest request) {
        request.setSubscribeCaItemSeq(subscribeCaItemSeq);

        SubscribeCaItemInchargeEntity entity = new SubscribeCaItemInchargeEntity();
        entity.setSubscribeCaItemSeq(subscribeCaItemSeq);
        entity.setSubscribeCaUuid(request.getSubscribeCaUuid());

        subscribeCaItemInchargeRepository.deleteSubscribeCaInchargeListExclude(
            entity,
            request.getInchargeList().stream().map(
                SubscribeCaItemInchargeRequest::getSubscribeCaItemInchargeSeq).filter(Objects::nonNull).toList());

        request.getInchargeList().forEach(incharge -> {

            if (incharge.getSubscribeCaItemInchargeSeq() != null) {
                subscribeCaItemInchargeRepository.updateSubscribeCaIncharge(incharge.toEntity());
            } else {
                incharge.setSubscribeCaUuid(request.getSubscribeCaUuid());
                incharge.setSubscribeCaItemSeq(request.getSubscribeCaItemSeq());
                subscribeCaItemInchargeRepository.insertSubscribeCaIncharge(incharge.toEntity());
            }
        });

        return subscribeCaItemInchargeRepository.selectItemInchargeList(
                request.getSubscribeCaUuid(),
                request.getSubscribeCaItemSeq()
            ).stream()
            .map(SubscribeCaItemInchargeResponse::new).toList();
    }

    public SubscribeCaItemResponse updateCaItemCap(Long subscribeCaItemSeq, SubscribeCaItemRequest request) {
        SubscribeCaItemEntity requestEntity = subscribeCaItemRepository.selectSubscribeCaItemDetail(subscribeCaItemSeq);
        requestEntity.applyNewCapInfo(request);
        subscribeCaItemRepository.updateSubscribeCaItem(requestEntity);

        return selectDetail(subscribeCaItemSeq);
    }

    public SubscribeCaItemResponse updateCaItemCai(Long subscribeCaItemSeq, SubscribeCaItemRequest request) {
        SubscribeCaItemEntity requestEntity = subscribeCaItemRepository.selectSubscribeCaItemDetail(subscribeCaItemSeq);
        requestEntity.applyNewCaiInfo(request);
        subscribeCaItemRepository.updateSubscribeCaItem(requestEntity);

        return selectDetail(subscribeCaItemSeq);
    }

    private CaCollectionResponse entityConvertResponse(SubscribeCaItemWithSourceDto dto) {
        CaCollectionResponse result = new CaCollectionResponse(dto);

        result.setInchargeList(
            subscribeCaItemInchargeRepository.selectItemInchargeList(
                    result.getSubscribeCaUuid(),
                    result.getSubscribeCaItemSeq())
                .stream().map(SubscribeCaItemInchargeResponse::new)
                .toList());
        return result;
    }
}
