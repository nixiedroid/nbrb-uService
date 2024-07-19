package com.nixiedroid.nbrb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import java.util.List;
import java.util.stream.Collectors;


/**
 * RootController is responsible for handling requests to the root URL ("/").
 * It provides an endpoint to retrieve a list of all registered endpoints in the application.
 */
@Controller
@RequestMapping("/")
public class RootController {

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;

    /**
     * Constructs a RootController with the specified RequestMappingHandlerMapping.
     *
     * @param requestMappingHandlerMapping the RequestMappingHandlerMapping used to retrieve handler methods.
     */
    @Autowired
    public RootController(RequestMappingHandlerMapping requestMappingHandlerMapping) {
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
    }

    /**
     * Handles GET requests to the root URL ("/").
     *
     * @return a ResponseEntity containing a list of all registered endpoints in the application.
     */
    @GetMapping("/")
    public ResponseEntity<List<String>> getEndpoints() {
        return new ResponseEntity<>(
                requestMappingHandlerMapping.getHandlerMethods().keySet()
                        .stream().map(RequestMappingInfo::toString)
                        .collect(Collectors.toList()), HttpStatus.OK);
    }
}