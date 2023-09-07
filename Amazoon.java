package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazoon {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriver d=new ChromeDriver();
		d.get("https://www.amazon.in/?tag=msndeskabkin-21&ref=pd_sl_7qhce485bd_");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions act=new Actions(d);
		WebElement findElement = d.findElement(By.id("nav-link-accountList"));
		act.moveToElement(findElement).click().perform();

		d.findElement(By.id("ap_email")).sendKeys("6382519651");
		d.findElement(By.id("continue")).click();
		
		d.findElement(By.id("ap_password")).sendKeys("Sudharsen");
		d.findElement(By.id("signInSubmit")).click();

		d.findElement(By.id("twotabsearchtextbox")).sendKeys("boat earphones");
		d.findElement(By.id("nav-search-submit-button")).click();
		act.scrollByAmount(0, 1000).perform();
		WebElement f2 = d.findElement(By.xpath("//img[contains(@src,'https://m.media-amazon.com"
				+ "/images/I/51zVOjYRNuL._AC_UY218_.jpg')]"));
		f2.click();
		Set <String> set=d.getWindowHandles();
		List<String> win = new ArrayList<String>(set);
		d.switchTo().window(win.get(1));
		act.scrollByAmount(0, 300).perform();
		d.findElement(By.id("add-to-cart-button")).click();
		d.findElement(By.id("attach-close_sideSheet-link")).click();
		d.findElement(By.id("nav-cart-count-container")).click();
		WebElement del = d.findElement(By.xpath("//input[@aria-label='Delete boAt Nirvana Ion with 120 Hrs "
				+ "Playback(24Hrs/Charge),Crystal Bionic Sound with Dual Eq Modes,"
				+ "Quad Mics Enx Technology,Low Latency(60Ms),in Ear Detection(Charcoal Black),Bluetooth']"));
		act.moveToElement(del).click().perform();
	}
}