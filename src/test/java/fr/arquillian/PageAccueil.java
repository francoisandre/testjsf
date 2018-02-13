package fr.arquillian;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Location("accueil.xhtml")
public class PageAccueil extends AbstractPage {

	@Page
	private PagePlanDeSite pagePlanDeSite;

	@Page
	private PageMentionsLegales pageMentionsLegales;

	@FindBy(xpath = "//a[text()='Plan du site']")
	private WebElement lienPlanDuSite;

	@FindBy(xpath = "//a[text()='Mentions Legales']")
	private WebElement lienMentionsLegales;

	@FindBy(css = "#footer")
	private WebElement piedDePage;

	public PagePlanDeSite naviguerPagePlanDeSite() {
		Graphene.guardHttp(lienPlanDuSite).click();
		pagePlanDeSite.setPageAccueil(this);
		return pagePlanDeSite;
	}

	public PageMentionsLegales naviguerPageMentionsLegales() {
		Graphene.guardHttp(lienMentionsLegales).click();
		pageMentionsLegales.setPageAccueil(this);
		return pageMentionsLegales;
	}

	@Override
	public boolean estChargee() {
		return SeleniumUtils.isVisible(piedDePage);
	}

}
