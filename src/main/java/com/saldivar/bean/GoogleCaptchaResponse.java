package com.saldivar.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * Google JSON response will be mapped
 * to the beans of this class
 * 
 * @author Jorge.Saldivar
 *
 */
public class GoogleCaptchaResponse {

	@JsonProperty("success")
	private boolean success;

	@JsonProperty("challenge_ts")
	private String challengeTs;

	@JsonProperty("hostname")
	private String hostname;

	@JsonProperty("error-codes")
	private List<String> errorCodes;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getChallengeTs() {
		return challengeTs;
	}

	public void setChallengeTs(String challengeTs) {
		this.challengeTs = challengeTs;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public List<String> getErrorCodes() {
		return errorCodes;
	}

	public void setErrorCodes(List<String> errorCodes) {
		this.errorCodes = errorCodes;
	}

	@Override
	public String toString() {
		return "GoogleCaptcha [success=" + success + ", challengeTs=" + challengeTs + ", hostname=" + hostname
				+ ", errorCodes=" + errorCodes + "]";
	}

}
