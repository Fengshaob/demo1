package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class BaseController {

    @Autowired
    protected HttpServletResponse httpServletResponse;
    @Autowired
    protected HttpServletRequest httpServletRequest;

}
