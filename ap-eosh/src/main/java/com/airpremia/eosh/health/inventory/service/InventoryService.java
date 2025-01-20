package com.airpremia.eosh.health.inventory.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.health.inventory.entities.InventoryContentEntity;
import com.airpremia.eosh.health.inventory.entities.InventoryEntity;
import com.airpremia.eosh.health.inventory.enums.SerialNoCheckEnum;
import com.airpremia.eosh.health.inventory.repository.InventoryContentRepository;
import com.airpremia.eosh.health.inventory.repository.InventoryRepository;
import com.airpremia.eosh.health.inventory.request.InventoryContentRequest;
import com.airpremia.eosh.health.inventory.request.InventoryInsertRequest;
import com.airpremia.eosh.health.inventory.request.InventoryRequest;
import com.airpremia.eosh.health.inventory.request.InventorySearchRequest;
import com.airpremia.eosh.health.inventory.request.InventoryUpdateRequest;
import com.airpremia.eosh.health.inventory.response.InventoryContentResponse;
import com.airpremia.eosh.health.inventory.response.InventoryResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryContentRepository inventoryContentRepository;

    public Page<InventoryResponse> selectInventoryPage(InventorySearchRequest searchRequest) {
        Page<InventoryResponse> entityPage =
            inventoryRepository.selectInventoryPage(searchRequest.toDto(), searchRequest.getPageable())
                .map(InventoryResponse::new);

        List<InventoryResponse> responseList = entityPage.getContent();

        if (!responseList.isEmpty()) {
            List<Long> inventorySeqList = responseList.stream()
                .map(InventoryResponse::getInventorySeq)
                .toList();

            List<InventoryContentEntity> contentEntityList =
                inventoryContentRepository.selectInventoryContentByRootKeyList(inventorySeqList);

            Map<Long, List<InventoryContentEntity>> contentMap = contentEntityList.stream()
                .collect(Collectors.groupingBy(InventoryContentEntity::getInventorySeq));

            responseList.forEach(response -> {
                List<InventoryContentEntity> groupContentList =
                    contentMap.getOrDefault(response.getInventorySeq(), Collections.emptyList());
                response.setInventoryContentList(groupContentList.stream().map(InventoryContentResponse::new).toList());
            });
        }

        return entityPage;
    }

    public InventoryResponse selectInventoryDetail(Long inventorySeq) {
        InventoryEntity entity = inventoryRepository.selectInventoryDetail(inventorySeq);
        InventoryResponse response = new InventoryResponse(entity);
        response.setInventoryContentList(
            inventoryContentRepository.selectInventoryContentByRootKey(inventorySeq).stream()
                .map(InventoryContentResponse::new).toList());
        return response;
    }

    public SerialNoCheckEnum selectSerialNoCount(String serialNo) {
        Integer serialNoCount = inventoryRepository.selectSerialNoCount(serialNo);

        if (serialNoCount == 0) {
            return SerialNoCheckEnum.APPROVED;
        } else {
            return SerialNoCheckEnum.DUPLICATED;
        }
    }

    public List<InventoryContentResponse> selectInventoryContentList(Long inventorySeq) {
        List<InventoryContentEntity> entityList =
            inventoryContentRepository.selectInventoryContentByRootKey(inventorySeq);

        return entityList.stream().map(InventoryContentResponse::new).toList();
    }

    @Transactional
    public InventoryResponse insertInventory(InventoryInsertRequest insertRequest) {
        InventoryEntity insertEntity = insertRequest.toEntity();
        inventoryRepository.insertInventory(insertEntity);

        if (!insertRequest.getInventoryContentList().isEmpty()) {
            List<InventoryContentEntity> contentEntityList = insertRequest.getInventoryContentList().stream().map(
                InventoryContentRequest::toEntity).toList();
            for (InventoryContentEntity contentEntity : contentEntityList) {
                contentEntity.setInventorySeq(insertEntity.getInventorySeq());
                inventoryContentRepository.insertInventoryContent(contentEntity);
            }
        }

        return selectInventoryDetail(insertEntity.getInventorySeq());
    }

    @Transactional
    public InventoryResponse updateInventory(Long inventorySeq, InventoryUpdateRequest updateRequest) {
        InventoryEntity updateEntity = updateRequest.toEntity();
        updateEntity.setInventorySeq(inventorySeq);
        inventoryRepository.updateInventory(updateEntity);

        if (!updateRequest.getDeleteInventoryContentList().isEmpty()) {
            List<InventoryContentEntity> deleteEntityList =
                updateRequest.getDeleteInventoryContentList().stream().map(InventoryContentRequest::toEntity).toList();

            for (InventoryContentEntity deleteEntity : deleteEntityList) {
                inventoryContentRepository.deleteInventoryContent(deleteEntity);
            }
        }

        if (!updateRequest.getInventoryContentList().isEmpty()) {
            List<InventoryContentEntity> contentEntityList = updateRequest.getInventoryContentList().stream().map(
                InventoryContentRequest::toEntity).toList();

            for (InventoryContentEntity contentEntity : contentEntityList) {
                if (contentEntity.getInventorySeq() != null) {
                    inventoryContentRepository.updateInventoryContent(contentEntity);
                } else {
                    contentEntity.setInventorySeq(inventorySeq);
                    inventoryContentRepository.insertInventoryContent(contentEntity);
                }
            }
        }

        return selectInventoryDetail(inventorySeq);
    }

    @Transactional
    public List<InventoryResponse> deleteMultipleInventory(List<InventoryRequest> deleteRequestList) {
        List<InventoryEntity> deleteEntityList = deleteRequestList.stream().map(InventoryRequest::toEntity).toList();

        for (InventoryEntity deleteEntity : deleteEntityList) {
            inventoryContentRepository.deleteInventoryContentByRootKey(deleteEntity.getInventorySeq());
            inventoryRepository.deleteInventory(deleteEntity);
        }

        return deleteEntityList.stream().map(InventoryResponse::new).toList();
    }
}
