package com.e4a.runtime.components.impl.android.p020;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

/* renamed from: com.e4a.runtime.components.impl.android.支付宝类库.SignUtils */
public final class SignUtils {
    private static final String ALGORITHM = "RSA";
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    public static String sign(String str, String str2) {
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance(ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str2)));
            Signature instance = Signature.getInstance("SHA1WithRSA");
            instance.initSign(generatePrivate);
            instance.update(str.getBytes(DEFAULT_CHARSET));
            return Base64.encode(instance.sign());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
