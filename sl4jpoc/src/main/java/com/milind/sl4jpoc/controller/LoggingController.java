package com.milind.sl4jpoc.controller;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.milind.sl4jpoc.service.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @Autowired
    LoggingService loggingService;


    @RequestMapping("/")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        loggingService.log();
        return System.currentTimeMillis()+"- Refreshed";
    }


    @RequestMapping("/changelevel")
    public String changeLogLevel(@RequestParam String loggerName, @RequestParam String level){
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        ch.qos.logback.classic.Logger logger = loggerName.equalsIgnoreCase("root")?
                loggerContext.getLogger(loggerName):loggerContext.exists(loggerName);
        if( logger !=null){
            logger.setLevel(Level.toLevel(level));
            return "Changed logger: "+loggerName+" to level : "+level;
        } else {
            return "Logger Not Found Make Sure that logger name is correct";
        }
    }
}
