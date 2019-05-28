package com.datewiselogfiles;

import org.apache.log4j.Logger;

public class DailyRollingFileAppenderExample
{
//  private static final Object DailyRollingFileAppender;

  private void init()
  {
    int count = 0;
    for(int i =1; i<=10; i++)
    {
      Logger logger = Logger.getRootLogger();

      logger.info("Id: " + count++);
      logger.error("testing");
      logger.info("second testing");
      logger.info("******************************************");
      logger.debug("this is debug");
 
    }
  }
 
  public static void main(String args[])
  {
    DailyRollingFileAppenderExample dailyRollingFileAppender = new DailyRollingFileAppenderExample();
    dailyRollingFileAppender.init();
    
  }
}
