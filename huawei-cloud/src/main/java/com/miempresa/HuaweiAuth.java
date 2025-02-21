package com.miempresa;

import com.huaweicloud.sdk.iam.v3.IamClient;
import com.huaweicloud.sdk.iam.v3.region.IamRegion;
import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.auth.ICredential;

public class HuaweiAuth {
    public static IamClient getIamClient() {
        ICredential auth = new BasicCredentials()
            .withAk(System.getenv("ISAZG2F4BHLWEAZKKIHU"))
            .withSk(System.getenv("2PDoa9pKqc9uedBqL9ktemUO3Ev8szzFRmpGM84Y"));

        return IamClient.newBuilder()
            .withCredential(auth)
            .withRegion(IamRegion.valueOf("LA-Mexico City2")) // Ajusta según tu región
            .build();
    }
}
