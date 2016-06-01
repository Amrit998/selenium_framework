package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ObjectMethods {
	
	
	public static void inputText(String TextFieldDescription, String strTextToBeEntered) throws FrameworkException{
		WebElement objTextField = getElement(TextFieldDescription);
		objTextField.sendKeys(strTextToBeEntered);
	}
	
	public static void  clickElement(String TextFieldDescription) throws FrameworkException{
		WebElement objTextField = getElement(TextFieldDescription);
		objTextField.click();
	}
	
	
	
	
	public static void clearText(String TextField) throws FrameworkException{
		WebElement objTextField1 = getElement(TextField);
		objTextField1.clear();
	}
	
	
	
	public static void dropDownBox(String objMultipeOperation ,String objSelectByVisibleText) throws FrameworkException{
		WebElement objTextField =  getElement(objMultipeOperation);
//		objTextField.click();
		Select objTextField1 = new Select(objTextField);
		objTextField1.selectByVisibleText(objSelectByVisibleText);
		}
	
	
	
//	(xpath)//input[@name = 'userName']
	public static WebElement getElement(String objDescription) throws FrameworkException{
		WebElement objElement = null;
		if(objDescription.trim().toLowerCase().startsWith("(xpath)")){
			objElement = BrowserOperation.driver.findElement(By.xpath(objDescription.replace("(xpath)", "")));
			
		}else if(objDescription.trim().toLowerCase().startsWith("(id)")){
			objElement = BrowserOperation.driver.findElement(By.id(objDescription.replace("(id)", "")));
			
		}else if(objDescription.trim().toLowerCase().startsWith("(name)")){
			objElement = BrowserOperation.driver.findElement(By.name(objDescription.replace("(name)", "")));
			
		}else if(objDescription.trim().toLowerCase().startsWith("(tagName)")){
			objElement = BrowserOperation.driver.findElement(By.tagName(objDescription.replace("(tagName)", "")));	
			
		}else if(objDescription.trim().toLowerCase().startsWith("(linkText)")){
			objElement = BrowserOperation.driver.findElement(By.linkText(objDescription.replace("(linkText)", "")));
			
		}else if(objDescription.trim().toLowerCase().startsWith("(partialLinkText)")){
			objElement = BrowserOperation.driver.findElement(By.partialLinkText(objDescription.replace("(partialLinkText)", "")));
	    }else if(objDescription.trim().toLowerCase().startsWith("(cssSelector)")){
		objElement = BrowserOperation.driver.findElement(By.cssSelector(objDescription.replace("(cssSelector)", "")));
        }else 
        {
        	throw new FrameworkException("Invalid Locator found");
        }
		return objElement;
	}
	
	

	}
