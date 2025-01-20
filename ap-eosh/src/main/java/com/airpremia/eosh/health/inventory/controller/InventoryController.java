package com.airpremia.eosh.health.inventory.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.health.inventory.enums.SerialNoCheckEnum;
import com.airpremia.eosh.health.inventory.request.InventoryInsertRequest;
import com.airpremia.eosh.health.inventory.request.InventoryRequest;
import com.airpremia.eosh.health.inventory.request.InventorySearchRequest;
import com.airpremia.eosh.health.inventory.request.InventoryUpdateRequest;
import com.airpremia.eosh.health.inventory.response.InventoryContentResponse;
import com.airpremia.eosh.health.inventory.response.InventoryResponse;
import com.airpremia.eosh.health.inventory.service.InventoryService;
import com.airpremia.esmsfos.core.annotation.OpenApiFilter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "재고 관리")
@RestController
@RequestMapping(value = "/api/v1/health/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @Operation(summary = "재고 페이지 검색")
    @GetMapping()
    @OpenApiFilter()
    public ResponseEntity<Page<InventoryResponse>> selectInventoryPage(
        @ParameterObject InventorySearchRequest searchRequest
    ) {
        Page<InventoryResponse> page = inventoryService.selectInventoryPage(searchRequest);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "재고 디테일 검색")
    @GetMapping(value = "/{inventorySeq}")
    @OpenApiFilter()
    public ResponseEntity<InventoryResponse> selectInventoryDetail(
        @PathVariable Long inventorySeq
    ) {
        InventoryResponse response = inventoryService.selectInventoryDetail(inventorySeq);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "재고 시리얼 중복 체크")
    @GetMapping(value = "/{serialNo}/duplicate-check")
    @OpenApiFilter()
    public ResponseEntity<SerialNoCheckEnum> selectSerialNoCount(
        @PathVariable String serialNo
    ) {
        return ResponseEntity.ok(inventoryService.selectSerialNoCount(serialNo));
    }

    @Operation(summary = "재고 내용물 리스트 검색")
    @GetMapping(value = "/{inventorySeq}/content")
    @OpenApiFilter()
    public ResponseEntity<List<InventoryContentResponse>> selectInventoryContentList(
        @PathVariable Long inventorySeq
    ) {
        List<InventoryContentResponse> list = inventoryService.selectInventoryContentList(inventorySeq);
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "재고 등록")
    @PostMapping()
    public ResponseEntity<InventoryResponse> insertInventory(
        @OpenApiFilter()
        @RequestBody InventoryInsertRequest insertRequest
    ) {
        InventoryResponse response = inventoryService.insertInventory(insertRequest);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "재고 수정")
    @PutMapping(value = "/{inventorySeq}")
    public ResponseEntity<InventoryResponse> updateInventory(
        @OpenApiFilter()
        @PathVariable Long inventorySeq,
        @RequestBody InventoryUpdateRequest updateRequest) {
        InventoryResponse response = inventoryService.updateInventory(inventorySeq, updateRequest);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "재고 삭제")
    @DeleteMapping()
    public ResponseEntity<List<InventoryResponse>> deleteMultipleInventory(
        @OpenApiFilter()
        @RequestBody List<InventoryRequest> deleteRequestList) {
        List<InventoryResponse> list =
            inventoryService.deleteMultipleInventory(deleteRequestList);
        return ResponseEntity.ok(list);
    }
}
