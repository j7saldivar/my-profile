package com.saldivar.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.saldivar.bean.GoogleCaptchaRequest;
import com.saldivar.bean.GoogleCaptchaResponse;

@Controller
@RequestMapping("/apps")
public class AppsController {

	@Autowired
	private GoogleCaptchaRequest googleCaptchaRequest;

	@RequestMapping("/google-recaptcha")
	public String apps() {
		return "googleRecaptcha";
	}

	@RequestMapping(value = "/google-recaptcha/post", method = RequestMethod.POST)
	@ResponseBody
	public GoogleCaptchaResponse postForm(HttpServletRequest request, Model model) {

		String responseRecaptcha = request.getParameter("g-recaptcha-response");
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.postForObject(googleCaptchaRequest.getUrl(),
				googleCaptchaRequest.httpRequest(responseRecaptcha, request.getRemoteAddr()),
				GoogleCaptchaResponse.class);

	}

}
