package com.argus.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.Transient;

public class BaseRestController {
    public static final String BASE_URL = "/api";

    @Transient
    protected final Logger logger = LoggerFactory.getLogger(getClass());
}
