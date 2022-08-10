package com.external.mock.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

import static com.external.mock.util.ShopName.*;

public class Constant {

    public static final Map<ShopName, Map<String, Endpoint>> ENDPOINT_MAP = new HashMap<>();
    public static final String PRODUCT_INFO = "product_info";
    public static final String PRODUCT_PRICE_INFO = "product_price_info";
    public static final String ALL_INFO = "all_info";

    Constant() {
        ENDPOINT_MAP.put(ALDI, Aldi.ENDPOINT_MAP);
        ENDPOINT_MAP.put(LIDL, null);
        ENDPOINT_MAP.put(MORRISONS, null);
        ENDPOINT_MAP.put(POUNDLAND, null);
        ENDPOINT_MAP.put(SAINSBURY, null);
    }


    public static class Aldi {
        public static final String HOST = "/aldi";
        public static final String PRODUCT_INFO = "/product/code/{product-id}";
        public static final String PRODUCT_PRICE_INFO = "/product/calculatePrices/{product-id}";

        public static final String PAYMENT = "/product/payment";
        public static final Map<String, Endpoint> ENDPOINT_MAP = new HashMap<>();

        static {
            ENDPOINT_MAP.put(PRODUCT_INFO, new Endpoint(HOST, HttpMethod.GET, PRODUCT_INFO));
            ENDPOINT_MAP.put(PRODUCT_PRICE_INFO, new Endpoint(HOST, HttpMethod.GET, PRODUCT_PRICE_INFO));
            ENDPOINT_MAP.put(PAYMENT, new Endpoint(HOST, HttpMethod.POST, PAYMENT));
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class EndpointInfo {
        public static final String API_V1 = "/api/v1";
        public static final String ITEM = "/item";
        public static final String CATEGORY = "/category";
    }

}
