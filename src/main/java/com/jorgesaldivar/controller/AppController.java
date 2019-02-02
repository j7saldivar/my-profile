package com.jorgesaldivar.controller;

import com.jorgesaldivar.config.GoogleProperties;
import com.jorgesaldivar.exception.DockerProcessException;
import com.jorgesaldivar.exception.InvalidRecaptchaException;
import com.jorgesaldivar.message.GoogleCaptchaRequest;
import com.jorgesaldivar.message.GoogleCaptchaResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main Apps controller
 *
 * @author saldivar
 */
@Controller
@RequestMapping("/apps")
public class AppController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final GoogleProperties googleProperties;

    public AppController(GoogleProperties googleProperties) {
        this.googleProperties = googleProperties;
    }

    @GetMapping("/google-recaptcha")
    public String apps() {
        return "googleRecaptcha";
    }

    @GetMapping("/docker")
    public String docker(Model model) {

        StringBuilder result = new StringBuilder();

        try {
            Process process = Runtime.getRuntime().exec("docker ps | awk -F ' ' '{print $2}' | tail -n+2");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null)
                result.append("Image: " + line);

            model.addAttribute("dockerProcess", result.toString());
        } catch (Exception e) {
            throw new DockerProcessException();
        }

        if (StringUtils.isEmpty(result.toString()))
            model.addAttribute("dockerProcess", "There was an issue while trying to get the docker containers running at this instance");

        return "docker";

    }

    /**
     * Sends the post object to google re-captcha service
     *
     * @param request Object that will be sent to google
     * @return JSON google response
     * @see <a href="https://developers.google.com/recaptcha/docs/verify">Google documentation</a>
     */
    @PostMapping(value = "/google-recaptcha")
    @ResponseBody
    public GoogleCaptchaResponse postForm(HttpServletRequest request) {

        String responseRecaptcha = request.getParameter("g-recaptcha-response");
        if (StringUtils.isBlank(responseRecaptcha))
            throw new InvalidRecaptchaException();

        return restTemplate
                .postForObject(
                        googleProperties.getUrl(),
                        GoogleCaptchaRequest.parameters(googleProperties.getSecret(), responseRecaptcha, request.getRemoteAddr()),
                        GoogleCaptchaResponse.class);

    }

}
