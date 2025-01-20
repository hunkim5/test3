package com.airpremia.eosh.ca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.ca.component.SubscribeCaComponent;
import com.airpremia.eosh.ca.response.ca.SubscribeCaResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/ca/bridge")
@Tag(name = "SubscribeCa")
public class CaBridgeController {
    private final SubscribeCaComponent subscribeCaComponent;

    public CaBridgeController(SubscribeCaComponent subscribeCaComponent) {
        this.subscribeCaComponent = subscribeCaComponent;
    }

    @Operation(summary = "selectDetail")
    @GetMapping("{subscribeCaUuid}")
    public ResponseEntity<SubscribeCaResponse> selectDetail(
        @PathVariable String subscribeCaUuid) {
        SubscribeCaResponse result = subscribeCaComponent.selectDetail(subscribeCaUuid);
        return ResponseEntity.ok(result);
    }

}
