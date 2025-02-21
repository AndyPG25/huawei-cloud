package com.miempresa;

import com.huaweicloud.sdk.iam.v3.IamClient;
import com.huaweicloud.sdk.iam.v3.region.IamRegion;
import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.auth.ICredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

return IamClient.newBuilder()
    .withCredential(auth)
    .withRegion(IamRegion.valueOf(CN_NORTH_1)) // Usa IamRegion en lugar de Region
    .build();


@Component
public class HuaweiAuth {

    @Value("${huawei.ak}")
    private String accessKey;

    @Value("${huawei.sk}")
    private String secretKey;

    @Value("${huawei.region}")
    private String region;

    public IamClient getIamClient() {
        ICredential auth = new BasicCredentials()
                .withAk(accessKey)
                .withSk(secretKey);

        return IamClient.newBuilder()
                .withCredential(auth)
                .withRegion(IamRegion.valueOf(region))
                .build();
    }
}
