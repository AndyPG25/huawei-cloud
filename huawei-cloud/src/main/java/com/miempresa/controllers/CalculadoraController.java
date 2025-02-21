package com.miempresa.controllers;

import com.huaweicloud.sdk.bss.v2.BssClient;
import com.huaweicloud.sdk.bss.v2.model.ListRateOnPeriodDetailRequest;
import com.huaweicloud.sdk.bss.v2.model.ListRateOnPeriodDetailResponse;
import com.huaweicloud.sdk.bss.v2.model.PeriodProductInfo;
import com.huaweicloud.sdk.bss.v2.model.RateOnPeriodReq;
import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.auth.ICredential;
import com.huaweicloud.sdk.bss.v2.region.BssRegion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    @GetMapping("/pricing")
    public ListRateOnPeriodDetailResponse getPricing() {
        ICredential auth = new BasicCredentials()
                .withAk(System.getenv("HUAWEICLOUD_SDK_AK"))
                .withSk(System.getenv("HUAWEICLOUD_SDK_SK"));

        BssClient client = BssClient.newBuilder()
                .withCredential(auth)
                .withRegion(BssRegion.CN_NORTH_1)
                .build();

        PeriodProductInfo productInfo = new PeriodProductInfo()
            .withCloudServiceType("hws.service.type.ecs")
            .withResourceType("hws.resource.type.vm")
            .withRegion("la-region-deseada")
            .withProductSpecId("ecs.g6.large")
            .withPeriodType(2) // Facturación mensual
            .withPeriodNum(1);  // 1 mes

        ListRateOnPeriodDetailRequest request = new ListRateOnPeriodDetailRequest()
            .withBody(new RateOnPeriodReq()
                .withProductInfos(Collections.singletonList(productInfo))
            );

        try {
            return client.listRateOnPeriodDetail(request);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
