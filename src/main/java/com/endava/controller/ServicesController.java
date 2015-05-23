package com.endava.controller;

import com.endava.dto.MockService;
import com.endava.dto.Rule;
import com.endava.persistance.PersistanceDao;
import com.endava.persistance.PersistanceService;
//import com.sun.deploy.net.HttpResponse;
import com.endava.server.RestServer;
import javassist.NotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * Created by astoica on 5/22/2015.
 */

@Controller
@RequestMapping(value = "/services")
public class ServicesController {
    private static String json_string = "Here is where the json's gonna be";
    private static String json_string2 = "Here is where the rules's gonna be";
    private static String returnedIDE = "3";
    private static String returnedIDE2 = "4";
    private static final String VIEW_INDEX = "services";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ServicesController.class);

    @Autowired
    private RestServer restServer;
    @Autowired
    private PersistanceService persistanceService;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public void startServer(@RequestParam Integer port) throws IOException {

        restServer.startServer(port);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView sendJson() {

        ModelAndView model = new ModelAndView("services");
        model.addObject("msg", json_string);
        return model;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<MockService>> getAll() {
        return new ResponseEntity<List<MockService>>(persistanceService.getAllServices(), null, HttpStatus.OK);
    }

    @RequestMapping(value="", method=RequestMethod.POST )
    public ResponseEntity<String> getID(){
//        persistanceService.persistService(mockService);
        return new ResponseEntity<String>(returnedIDE, null, HttpStatus.CREATED);
    }

//    @RequestMapping(value="", method=RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<List<MockService>> gID(@RequestBody MockService mockService){
//        System.out.println(mockService);
//        persistanceService.persistService(mockService);
//        return new ResponseEntity<List<MockService>>();
//        return "soemthing";
//    }

    @RequestMapping(value = "/rules", method = RequestMethod.GET)
    public ModelAndView getRulesPage() {

        ModelAndView model = new ModelAndView("rules");
        model.addObject("msg", json_string2);
        return model;
    }

    @RequestMapping(value="/{Id}/rule", method=RequestMethod.GET)
    public List<Rule> getJsonRule(@PathVariable Integer Id) {
        return persistanceService.getRulesForService(Id);
    }
    @RequestMapping(value="/{Id}/rule", method=RequestMethod.POST)
    @ResponseBody
    public String getRiule(){
        return "{id : " +returnedIDE2 +"}";
    }
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Url not found")
    void handleNotFound(NotFoundException exc) {}



}


