package com.milind.sl4jpoc.service;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Component
public class LogRefresher {

    //@PostConstruct
    public void init()  {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    load();
                } catch (MalformedURLException | InterruptedException | JoranException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
    }

    public void load() throws JoranException, MalformedURLException, InterruptedException {
        String prev = null;
        URL url = new URL("http://localhost:9999/logconfig/logback.xml");
        while (true){
            if(!(getNewContentIfChanged(prev,url) == null)){
                LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
                context.reset();
                JoranConfigurator configurator = new JoranConfigurator();
                configurator.setContext(context);
                configurator.doConfigure(url);
                System.out.println("Log reloaded  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            }
            TimeUnit.SECONDS.sleep(15);
        }
    }

    private String getContent(URL url) throws IOException {
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()) {
            sb.append(sc.next());
        }
        return sb.toString();
    }

    private String getNewContentIfChanged(String previous, URL url) {
        boolean reload = false;
        try {
            String obj = getContent(url);
            if (previous == null) {
                previous = obj;
                reload = true;
            } else if (!previous.equalsIgnoreCase(obj)) {
                previous = obj;
                reload = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reload ? previous : null;
    }
}
