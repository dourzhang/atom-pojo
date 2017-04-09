package com.atom.pojo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Pojo Controller
 * <p>
 * Created by Atom on 2017/4/9.
 */
@Controller
@RequestMapping("/pojo")
public class PojoController {

    @RequestMapping("/view")
    public String toHello(ModelMap model) {

        model.put("msg", "msg");
        return "pojo/hello";
    }
}
