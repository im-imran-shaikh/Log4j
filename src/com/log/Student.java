package com.log;

import org.apache.log4j.Logger;


public class Student
{
  /* creating Logger instance */
  public static final Logger logger = 
    Logger.getLogger(Student.class);
  
  private void studentDetails()
  {
    ConfigureLog4j setID = new ConfigureLog4j();
    setID.setID(92);
    
    logger.info("Student name : Imran Shaikh");
    logger.info("Studetn class : 10-A");
    logger.info("Student RollNo : 92");
  }
  public static void main(String[] args)
  {
    Student student = new Student();
    student.studentDetails();
  }
}
