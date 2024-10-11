package com.argus.ecommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.persistence.Transient;

public abstract class BaseService {
    @Transient
    protected final Logger logger = LoggerFactory.getLogger(getClass());
}