package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Sample {
@Test
public void open(){
	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.guru99.com/maven-jenkins-with-selenium-complete-tutorial.html");
	System.out.println("hdfjbj");
}
}
