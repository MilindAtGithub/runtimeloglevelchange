package com.milind.sl4jpoc.service;

import com.milind.sl4jpoc.controller.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingService {

    Logger logger = LoggerFactory.getLogger(LoggingService.class);
    public void log(){
        logger.trace("A TRACE Message ....................");
        logger.debug("A DEBUG Message...................");
        logger.info("An INFO Message....................");
        logger.warn("A WARN Message.......................");
        logger.error("An ERROR Message.....................");

    }
}
