package fr.arquillian;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageMentionsLegales extends AbstractPage {

	@Drone
	private WebDriver browser;

	@FindBy(css = "#aUrlCNIL")
	private WebElement lienCnil;

	public PageMentionsLegales() {

	}

	@Override
	public boolean estChargee() {
		return SeleniumUtils.isVisible(lienCnil);
	}

}
