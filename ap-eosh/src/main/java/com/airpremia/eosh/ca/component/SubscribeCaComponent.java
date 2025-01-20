package com.airpremia.eosh.ca.component;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.airpremia.eosh.ca.entities.SubscribeCaEntity;
import com.airpremia.eosh.ca.entities.SubscribeCaItemEntity;
import com.airpremia.eosh.ca.entities.SubscribeCaItemInchargeEntity;
import com.airpremia.eosh.ca.repository.SubscribeCaItemInchargeRepository;
import com.airpremia.eosh.ca.repository.SubscribeCaItemRepository;
import com.airpremia.eosh.ca.repository.SubscribeCaRepository;
import com.airpremia.eosh.ca.request.ca.SubscribeCaItemRequest;
import com.airpremia.eosh.ca.request.ca.SubscribeCaRequest;
import com.airpremia.eosh.ca.request.incharge.SubscribeCaItemInchargeRequest;
import com.airpremia.eosh.ca.response.ca.SubscribeCaItemResponse;
import com.airpremia.eosh.ca.response.ca.SubscribeCaResponse;
import com.airpremia.eosh.ca.response.incharge.SubscribeCaItemInchargeResponse;
import com.airpremia.eosh.inteface.SubscribeActionInterface;
import com.airpremia.eosh.usertoken.dto.UserTokenDto;
import com.airpremia.eosh.usertoken.service.UserTokenService;
import com.github.f4b6a3.uuid.UuidCreator;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SubscribeCaComponent implements SubscribeActionInterface<SubscribeCaRequest> {
    private final SubscribeCaRepository subscribeCaRepository;
    private final SubscribeCaItemRepository subscribeCaItemRepository;
    private final SubscribeCaItemInchargeRepository subscribeCaItemInchargeRepository;

    private final UserTokenService userTokenService;


    public SubscribeCaResponse selectDetail(String subscribeCaUuid) {
        SubscribeCaResponse result = new SubscribeCaResponse(subscribeCaRepository.selectDetail(subscribeCaUuid));
        result.setItemList(
            subscribeCaItemRepository.selectList(subscribeCaUuid)
                .stream()
                .map(SubscribeCaItemResponse::new)
                .toList());

        if (result.getItemList() != null) {
            result.getItemList().forEach(eachData ->
                eachData.setInchargeList(
                    subscribeCaItemInchargeRepository
                        .selectItemInchargeList(
                            subscribeCaUuid,
                            eachData
                                .getSubscribeCaItemSeq()).stream().map(SubscribeCaItemInchargeResponse::new).toList()
                )
            );
        }
        return result;
    }

    @Override
    public String saveAndUuid(SubscribeCaRequest request) {
        String subscribeCaUuid = request.getSubscribeCaUuid();
        if (subscribeCaUuid == null || subscribeCaUuid.isEmpty()) {
            subscribeCaUuid = UuidCreator.getTimeOrderedEpoch().toString();
            request.setSubscribeCaUuid(subscribeCaUuid);
            subscribeCaRepository.insertSubscribeCa(request.toEntity());
        } else {
            subscribeCaRepository.updateSubscribeCa(request.toEntity());
        }
        saveAndUuidItemList(request, subscribeCaUuid);

        return subscribeCaUuid;
    }

    private void saveAndUuidItemList(SubscribeCaRequest request, String subscribeCaUuid) {
        List<SubscribeCaItemRequest> deleteTargetList = request.getDeleteTargetList();
        if (deleteTargetList != null && !deleteTargetList.isEmpty()) {
            deleteTargetList.forEach(
                each -> subscribeCaItemRepository.deleteSubscribeCaItem(each.toEntity()));
        }
        List<SubscribeCaItemRequest> saveTargetList = request.getItemList();
        if (saveTargetList != null && !saveTargetList.isEmpty()) {
            saveTargetList.stream()
                .filter(SubscribeCaItemRequest::getEditBool)
                .forEach(each -> {
                    each.setSubscribeCaUuid(subscribeCaUuid);
                    Long subscribeCaItemSeq = each.getSubscribeCaItemSeq();
                    if (subscribeCaItemSeq == null) {
                        UserTokenDto userToken = userTokenService.getUserToken();
                        SubscribeCaItemEntity saveEntity = each.toEntity();
                        saveEntity.applyCurrentInchargeUserInfo(userToken);
                        saveEntity.setCaId(createCaId());

                        subscribeCaItemRepository.insertSubscribeCaItem(saveEntity);
                        each.setSubscribeCaItemSeq(saveEntity.getSubscribeCaItemSeq());
                    } else {
                        subscribeCaItemRepository.updateSubscribeCaItem(each.toEntity());
                    }

                    saveAndUuidItemInchargeData(each);
                });
        }
    }

    private void saveAndUuidItemInchargeData(SubscribeCaItemRequest caItemObjectDto) {
        SubscribeCaItemInchargeEntity entity = new SubscribeCaItemInchargeEntity();
        entity.setSubscribeCaItemSeq(caItemObjectDto.getSubscribeCaItemSeq());
        entity.setSubscribeCaUuid(caItemObjectDto.getSubscribeCaUuid());

        subscribeCaItemInchargeRepository
            .deleteSubscribeCaInchargeListExclude(
                entity,
                caItemObjectDto.getInchargeList().stream().map(
                    SubscribeCaItemInchargeRequest::getSubscribeCaItemInchargeSeq).toList());

        if (caItemObjectDto.getInchargeList() != null) {
            caItemObjectDto.getInchargeList()
                .forEach(eachInchargeData -> {
                    eachInchargeData.setSubscribeCaUuid(caItemObjectDto.getSubscribeCaUuid());
                    eachInchargeData.setSubscribeCaItemSeq(caItemObjectDto.getSubscribeCaItemSeq());
                    if (eachInchargeData.getSubscribeCaItemInchargeSeq() == null) {
                        subscribeCaItemInchargeRepository.insertSubscribeCaIncharge(
                            eachInchargeData.toEntity());
                    } else {
                        subscribeCaItemInchargeRepository.updateSubscribeCaIncharge(
                            eachInchargeData.toEntity());
                    }
                });
        }
    }

    @Override
    public boolean delete(String uuid) {
        SubscribeCaEntity request = new SubscribeCaEntity();
        request.setSubscribeCaUuid(uuid);

        subscribeCaItemRepository.deleteSubscribeCaItemByUuid(request);
        return true;
    }

    private synchronized String createCaId() {
        LocalDate date = LocalDate.now();
        int year = date.getYear();

        StringBuilder caId = new StringBuilder();

        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year + 1, 1, 1);

        int count =
            subscribeCaItemRepository.selectCaCountByRange(start, end);

        caId
            .append("MTG")
            .append("-")
            .append(year)
            .append("-")
            .append(String.format("%04d", count + 1));

        return String.valueOf(caId);
    }

}
