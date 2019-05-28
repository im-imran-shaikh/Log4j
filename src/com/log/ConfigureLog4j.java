package com.log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class ConfigureLog4j
{
  /* creating Logger instance */
  public static final Logger logger = 
    Logger.getLogger(ConfigureLog4j.class);
  /* crating RollingFileAppender instance */
  private  RollingFileAppender rollingFileAppender =
    new RollingFileAppender();  
  
  /* creating patternLayout */
  private PatternLayout setPatternLayout()
  {
    PatternLayout patternLayout = new PatternLayout();
    String conversionLayout =
      "%d{yyyy-MM-dd HH:mm:ss} [%-5p] %c %M - %m%n";
    patternLayout.setConversionPattern(conversionLayout);
    return patternLayout;
  }
  
  /* get current Date */
  private String getCurrentDate()
  {
    DateFormat dateFormat = new SimpleDateFormat("yyy MM dd");
    Date date = new Date();
    return dateFormat.format(date);
  }
  
  /* configure log4j file */
  public void setID(int ID)
  {
    rollingFileAppender.setFile("sample_" + ID + " " + getCurrentDate() + " " + ".log");
    rollingFileAppender.setMaxFileSize("10MB");
    rollingFileAppender.setMaxBackupIndex(10);
    rollingFileAppender.activateOptions();
    rollingFileAppender.setLayout(setPatternLayout());
    
    /* creating root Logger */
    Logger rootLogger = Logger.getRootLogger();
    rootLogger.setLevel(Level.DEBUG);
    rootLogger.addAppender(rollingFileAppender);
  }
  
  /* dummy statement */
  private void test()
  {
    logger.info("this is information log");
    logger.error("this is error log");
    logger.debug("this is debug log");
    logger.info("-----------------------------------");
  }
  
  public static void main(String[] args)
  {
    ConfigureLog4j configureLog4j =
      new ConfigureLog4j();
    
    configureLog4j.setID(1);
    configureLog4j.test();
    
    configureLog4j.setID(2);
    configureLog4j.test();
    
    configureLog4j.setID(1);
    configureLog4j.test();
  }
}
