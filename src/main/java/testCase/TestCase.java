package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Supplier;

public class TestCase {
	
	private static Supplier<RemoteWebDriver> chromeSupplier = () -> {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		return new ChromeDriver(options);
	};
	
	private static Supplier<RemoteWebDriver> firefoxSupplier = () -> {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver_64 bit.exe");
		FirefoxOptions opt = new FirefoxOptions();
		opt.addPreference("dom.webnotifications.enabled", false);
		return new FirefoxDriver(opt);
	};

	private static Supplier<RemoteWebDriver> IESupplier = () -> {
		System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
		return new InternetExplorerDriver();
	};
	
	public static void main(String[] args) {
		RemoteWebDriver driver = IESupplier.get();
		driver.get("https://www.redbus.in/");
	}

}
