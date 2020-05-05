package com.playground.mcsv2.controller;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/v1.0/admin")
public class AdminController {

    @Autowired
    private Tracer tracer;

    @GetMapping(path = "/test")
    public String test(){

        log.info("req received");
        printTrace();

        return tracer.toString();
    }

    private void printTrace () {
        String traceId = tracer.currentSpan().context().traceIdString();
        String spanId = tracer.currentSpan().context().spanIdString();
        log.info("--- Tracer ---  traceId: {} & spanId: {}", traceId, spanId);
    }
}
