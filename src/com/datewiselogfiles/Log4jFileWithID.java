package com.datewiselogfiles;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class Log4jFileWithID
{

  /* creating pattern layout */
  private static PatternLayout setPatternLayout()
  {
    // Creates Pattern Layout
    PatternLayout patternLayout = new PatternLayout();
    String conversionPattern =
      "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n";
    patternLayout.setConversionPattern(conversionPattern);
    return patternLayout;
  }

  /* get current date */
  private static String getDate()
  {
    DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");
    Date date = new Date();
    return dateFormat.format(date);
  }

  private void createLogFile()
  {
    RollingFileAppender rollingAppender = new RollingFileAppender();
    for (int i = 1; i <= 4; i++)
    {
      rollingAppender.setFile("sample_" + i + " " + getDate() + " " +
                              ".log");
      rollingAppender.setMaxFileSize("10MB");
      rollingAppender.setMaxBackupIndex(10);

      //      rollingAppenderObj.setDatePattern("' 'yyyy-MM-dd-hh-mm '.log' ");
      rollingAppender.setLayout(setPatternLayout());
      rollingAppender.activateOptions();

      // Configure the Root Logger
      Logger rootLogger = Logger.getRootLogger();
      rootLogger.setLevel(Level.DEBUG);
      rootLogger.addAppender(rollingAppender);

      // Create a Customer Logger & Logs Messages

      Logger logger = Logger.getLogger(Log4jFileWithID.class);
      logger.info("current date : " + getDate());
      logger.info("Id : " + i);
      logger.debug("This is a debug log message");
      logger.info("This is an information log message");
      logger.warn("This is a warning log message");
      logger.info("----------------------------------------------------------");
    }
  }

  public static void main(String[] args)
  {
    Log4jFileWithID log4jFileWithID = new Log4jFileWithID();
    log4jFileWithID.createLogFile();
  }
}
