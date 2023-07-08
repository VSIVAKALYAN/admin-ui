package io.mosip.test.admintest.testcase;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.mosip.test.admintest.utility.BaseClass;
import io.mosip.test.admintest.utility.Commons;

public class DeviceSpecificationTest extends BaseClass{
 
 
  @Test(groups = "DS")
  public void deviceSpecCRUD() {
	  test=extent.createTest("DeviceSpecificationTest", "verify Login");
	  String devicespec="admin/masterdata/device-specs/view";
	    
    Commons.click(test,driver,By.xpath("//a[@href='#/admin/masterdata']"));
   
    Commons.click(test,driver,By.id(devicespec));
    test.log(Status.INFO, "Click on DeviceSpecification");
    Commons.click(test,driver,By.id("Create"));
    
  
    Commons.enter(test,driver,By.id("name"),data);
    Commons.enter(test,driver,By.id("description"),data);
    Commons.enter(test,driver,By.id("brand"),data);
    Commons.enter(test,driver,By.id("model"),data);
    Commons.enter(test,driver,By.id("minDriverversion"),data);
    Commons.dropdown(test,driver,By.id("deviceTypeCode"));
  
  
    Commons.create(test,driver);
    test.log(Status.INFO, "Click on Create");
   	Commons.filter(test,driver, By.id("name"), data);
   	

   	Commons.edit(test,driver,data+1,By.id("name"));
   	test.log(Status.INFO, "Click on Edit");
   	Commons.filter(test,driver, By.id("name"), data+1);
   	
   	Commons.activate(test,driver);
   	test.log(Status.INFO, "Click on Active");
   	Commons.edit(test,driver,data+2,By.id("name"));
   	Commons.filter(test,driver, By.id("name"), data+2);
   	Commons.deactivate(test,driver);
   	test.log(Status.INFO, "Click on Deactive");

       }
   }
