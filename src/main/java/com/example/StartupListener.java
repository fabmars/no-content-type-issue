package com.example;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.event.ApplicationStartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class StartupListener implements ApplicationEventListener<ApplicationStartupEvent> {

  Logger logger = LoggerFactory.getLogger(StartupListener.class);

  @Override
  public void onApplicationEvent(ApplicationStartupEvent event) {
    logger.info("something");
  }
}
