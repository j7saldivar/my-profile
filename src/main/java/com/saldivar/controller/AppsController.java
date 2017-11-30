package com.saldivar.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.saldivar.bean.GoogleCaptchaRequest;
import com.saldivar.bean.GoogleCaptchaResponse;

/**
 * Main Apps controller
 * 
 * @author saldivar
 *
 */
@Controller
@RequestMapping("/apps")
public class AppsController {

	@Autowired
	private GoogleCaptchaRequest googleCaptchaRequest;

	@RequestMapping("/google-recaptcha")
	public String apps() {
		return "googleRecaptcha";
	}

	/**
	 * Docker page. How to run docker and listing currently running containers
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("docker")
	public String docker(Model model) {

		StringBuilder result = new StringBuilder();

		try {
			Process process = Runtime.getRuntime().exec("docker ps | awk -F ' ' '{print $2}' | tail -n+2");

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			
			while ((line = reader.readLine()) != null) {

				result.append("Image: " + line);

			}

			model.addAttribute("dockerProcess", result.toString());
		} catch (Exception e) {
			// TODO : Remove exception and handle it well
			// docker command might not work
		}

		if (StringUtils.isEmpty(result.toString()))
			model.addAttribute("dockerProcess", "There was an issue while trying to get the docker containers running at this instance");
		return "docker";
	}

	/**
	 * Sends the post object to google recaptcha service
	 * 
	 * @param request
	 *            Object that will be sent to google
	 * @param model
	 * @return JSON google response
	 */
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
