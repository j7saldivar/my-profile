package com.saldivar.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class GoogleCaptchaRequest {

	@Value("${google.recaptcha.url}")
	private String url;

	@Value("${google.recaptcha.secret}")
	private String secret;
	private String response;
	private String remoteIp;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getRemoteIp() {
		return remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	@Override
	public String toString() {
		return "GoogleCaptchaRequest [url=" + url + ", secret=" + secret + ", response=" + response + ", remoteIp="
				+ remoteIp + "]";
	}

	public MultiValueMap<String, String> httpRequest(String response, String ipAddress) {

		MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
		
		requestMap.add("secret", secret);
		requestMap.add("response", response);
		requestMap.add("remoteip", ipAddress);
		
		return requestMap;

	}

}
