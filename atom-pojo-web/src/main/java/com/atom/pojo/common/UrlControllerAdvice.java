package com.atom.pojo.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Url Controller Advice
 * <p>
 * Created by Atom on 2017/4/9.
 */
@ControllerAdvice
public class UrlControllerAdvice {

    @Value("${info.domain}")
    private String domain;

    @ModelAttribute("domain")
    public String getDomain() {
        return domain;
    }
}
