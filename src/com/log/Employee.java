package com.log;

import org.apache.log4j.Logger;


public class Employee
{
  /* creating Logger instance */
  public final Logger logger = 
    Logger.getLogger(this.getClass());
  
  private void employeeDetail()
  {
    ConfigureLog4j setId = new ConfigureLog4j();
    setId.setID(704);
    
    logger.info("employee name : imran " + this.getClass().getSimpleName());
    logger.info("employee address : ghatkopar");
    logger.info("employee ID : emp704");
  }
  
  public static void main(String[] args)
  {
    Employee employee = new Employee();
    employee.employeeDetail();
    
  }
}
