package com.airpremia.eosh.health.inventory.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.health.inventory.dto.InventorySearchDto;
import com.airpremia.eosh.health.inventory.entities.InventoryEntity;

@Repository
public interface InventoryRepository {
    Page<InventoryEntity> selectInventoryPage(
        @Param(value = "searchDto") InventorySearchDto searchDto,
        Pageable pageable);

    InventoryEntity selectInventoryDetail(Long inventorySeq);

    Integer selectSerialNoCount(String serialNo);

    void insertInventory(InventoryEntity insertEntity);

    void updateInventory(InventoryEntity updateEntity);

    void deleteInventory(InventoryEntity deleteEntity);
}
