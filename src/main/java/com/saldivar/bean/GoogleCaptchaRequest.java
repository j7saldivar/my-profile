package com.saldivar.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Google bean that will be used to map the message
 * that will be sent to the recaptcha service
 * 
 * @author Jorge.Saldivar
 *
 */
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

	/**
	 * 
	 * @param response Google response from the form posted (g-recaptcha-response)
	 * @param ipAddress User IP address
	 * @return MultiValueMap containing the request that will be sent to Google reCaptcha service
	 */
	public MultiValueMap<String, String> httpRequest(String response, String ipAddress) {

		MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
		
		requestMap.add("secret", secret);
		requestMap.add("response", response);
		requestMap.add("remoteip", ipAddress);
		
		return requestMap;

	}

}
