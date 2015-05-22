package com.endava.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by astoica on 5/22/2015.
 */

@Controller
@RequestMapping(value = "/services")
public class ServicesController {
    private static String json_string = "Here is where the json's gonna be";
    private static String returnedIDE = "3";
    private static final String VIEW_INDEX = "services";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ServicesController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView sendJson() {

        ModelAndView model = new ModelAndView("services");
        model.addObject("msg", json_string);
        return model;
    }

    @RequestMapping(value="/apost", method=RequestMethod.POST)
    @ResponseBody
    public String getID(){
        return "{id : " +returnedIDE+"}";
    }

}
