package com.nostra13.universalimageloader.core.download;

import com.alipay.sdk.cons.C0109b;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import p054u.aly.bi_常量类;

public interface ImageDownloader {

    public enum Scheme {
        HTTP("http"),
        HTTPS(C0109b.f275a),
        FILE("file"),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN(bi_常量类.f6358b_空串);
        
        private String scheme;
        private String uriPrefix;

        private Scheme(String scheme) {
            this.scheme = scheme;
            this.uriPrefix = scheme + "://";
        }

        public static Scheme ofUri(String uri) {
            if (uri != null) {
                for (Scheme s : values()) {
                    if (s.belongsTo(uri)) {
                        return s;
                    }
                }
            }
            return UNKNOWN;
        }

        private boolean belongsTo(String uri) {
            return uri.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        public String wrap(String path) {
            return this.uriPrefix + path;
        }

        public String crop(String uri) {
            if (belongsTo(uri)) {
                return uri.substring(this.uriPrefix.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[]{uri, this.scheme}));
        }
    }

    InputStream getStream(String str, Object obj) throws IOException;
}
