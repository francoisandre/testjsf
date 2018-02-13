package fr.arquillian;

import org.jboss.arquillian.graphene.Graphene;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractPage {

	private PageAccueil pageAccueil;

	@FindBy(css = "#menuAccueil a")
	private WebElement lienAccueil;

	@FindBy(css = ".notificationbar-cookie")
	private WebElement bandeauCookie;

	@FindBy(css = "input[type='submit']")
	private WebElement boutonCookie;

	public boolean isBandeauCookieVisible() {
		return SeleniumUtils.isVisible(bandeauCookie);
	}

	public void masqueBandeauCookie() {
		if (boutonCookie != null) {
			boutonCookie.click();
		}
	}

	public PageAccueil getPageAccueil() {
		return pageAccueil;
	}

	public void setPageAccueil(final PageAccueil pageAccueil) {
		this.pageAccueil = pageAccueil;
	}

	public PageAccueil naviguerPageAccueil() {
		Graphene.guardHttp(lienAccueil).click();
		return getPageAccueil();
	}

	public abstract boolean estChargee();

}
