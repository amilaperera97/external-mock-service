package com.external.mock.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpMethod;

@Builder
@AllArgsConstructor
@Data
public class Endpoint {
    private String host;
    private HttpMethod httpMethod;
    private String url;
}
