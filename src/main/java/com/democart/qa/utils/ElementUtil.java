package com.democart.qa.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doSendkey(By locator, String value) {
		WebElement element=getElement(locator);
		element.clear();
		element.sendKeys(value);
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public String doGetAttribute(By locator, String attribute) {
		return getElement(locator).getAttribute(attribute);
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public void clickElement(By locator, String value) {
		List<WebElement> elementList = getElements(locator);
		for (WebElement element : elementList) {
			String text = element.getText();
			if (text.equals(value)) {
				element.click();
				break;
			}
		}
	}

	public boolean checkElement(By locator) {
		if (getElements(locator).size() > 1) {
			return true;
		}
		return false;
	}

	public void doSelectByIndex(By locator, int index) {
		Select dropdown = new Select(getElement(locator));
		dropdown.selectByIndex(index);
	}

	public void doSelectByVisibleText(By locator, String visibleText) {
		Select dropdown = new Select(getElement(locator));
		dropdown.selectByVisibleText(visibleText);
	}

	public void doSelectByValue(By locator, String value) {
		Select dropdown = new Select(getElement(locator));
		dropdown.selectByValue(value);
	}

	public List<String> getDropdownOptions(By locator) {
		List<WebElement> optionsList = getElements(locator);
		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement element : optionsList) {
			optionsTextList.add(element.getText());
		}
		return optionsTextList;
	}

	//JQuery dropdown
	public void selectChoiceFromDropdown(By locator, String... value) {
		List<WebElement> elementList = getElements(locator);
		if (!value[0].equalsIgnoreCase("All")) {
			for (WebElement element : elementList) {
				for (int i = 0; i < value.length; i++) {
					String text = element.getText();
					if (text.equals(value[i])) {
						element.click();
						break;
					}
				}
			}
		} else {
			try {
				for (WebElement element : elementList) {
					element.click();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void doActionsClick(By locator) {
		Actions actions=new Actions(driver);
		actions.moveToElement(getElement(locator)).click().build().perform();
	}
	
	public void doActionsMoveToElement(By locator) {
		Actions actions=new Actions(driver);
		actions.moveToElement(getElement(locator)).perform();
	}
	
	public void doActionsSendkeys(By locator,String text) {
		Actions actions=new Actions(driver);
		actions.moveToElement(getElement(locator)).sendKeys(text).build().perform();
	}
	
	public void clickOnSubMenu(By parentMenu,By firstMenu) {
		doActionsMoveToElement(parentMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doActionsClick(firstMenu);
	}
	
	public void clickOnSubMenu(By parentMenu,By firstMenu,By secondMenu) {
		doActionsMoveToElement(parentMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doActionsMoveToElement(firstMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doActionsClick(secondMenu);
	}
	
	public void clickWhenReady(By locator,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
		element.click();
	}
	
	public void sendKeys(By locator,String value,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement element=wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
		element.clear();
		element.sendKeys(value);
	}
	
	public WebElement waitForVisibilityOfElement(By locator,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));	
	}
	
	public WebElement waitForPresenceOfElement(By locator,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
	}
	
	public boolean waitForUrl(String urlFraction,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	public String waitForTitle(String titleFraction,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.titleContains(titleFraction));
		return driver.getTitle();
	}
	
	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptJSAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	public void dismissJSAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	
	public String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}
	
	public List<WebElement> waitForVisiblityOfAllElements(By locator,int timeOut){
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public void getPageElementText(By locator, int timeOut) {
		waitForVisiblityOfAllElements(locator, timeOut).stream().forEach(element -> System.out.println(element.getText()));
	}
	
	public void jseWaitForPageToLoad(int timeOut) {
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		String command="return document.readyState;";
		 if(jse.executeScript(command).toString().equals("complete")) {
			 System.out.println("The page is fully loaded!");
			 return;
		 }
		 
		 for(int i=1;i<=timeOut;i++) {
			 try {
				Thread.sleep(1000);
				if(jse.executeScript(command).toString().equals("complete")) {
					System.out.println("Page is fully loaded!");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}
	
	public WebElement waitForElementPresentWithFluentWait(By locator,int timeOut,int pollingTime) {
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}