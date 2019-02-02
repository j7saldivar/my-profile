package com.jorgesaldivar.message;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Google bean that will be used to map the message
 * that will be sent to the recaptcha service
 *
 * @author Jorge.Saldivar
 */
public class GoogleCaptchaRequest {

    private String secret;
    private String response;
    private String remoteip;

    private GoogleCaptchaRequest() {
    }

    public static MultiValueMap<String, String> parameters(String secret, String response, String remoteip) {

        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();

        requestMap.add("secret", secret);
        requestMap.add("response", response);
        requestMap.add("remoteip", remoteip);

        return requestMap;

    }

}