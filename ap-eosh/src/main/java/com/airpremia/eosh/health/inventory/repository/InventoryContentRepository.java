package com.airpremia.eosh.health.inventory.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.health.inventory.entities.InventoryContentEntity;

@Repository
public interface InventoryContentRepository {
    List<InventoryContentEntity> selectInventoryContentByRootKey(Long inventorySeq);

    List<InventoryContentEntity> selectInventoryContentByRootKeyList(List<Long> inventorySeqList);

    void insertInventoryContent(InventoryContentEntity insertEntity);

    void updateInventoryContent(InventoryContentEntity updateEntity);

    void deleteInventoryContent(InventoryContentEntity deleteEntity);

    void deleteInventoryContentByRootKey(Long inventorySeq);
}
