package fr.arquillian;

import java.io.File;
import java.net.URL;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocationContext;

import com.mkyong.common.CookieBean;

@RunWith(Arquillian.class)
public class NavigationTestCase {

	@Drone
	WebDriver driver;

	@Inject
	LocationContext context;
	
	private static final String WEBAPP_SRC = "src/main/webapp";
	
	@ArquillianResource
	URL contextPath;

	@Test
	public void testNavigation1(@InitialPage final PageAccueil pageAccueilInitial) {
		PageAccueil pageAccueil = pageAccueilInitial;
		Assert.assertTrue(pageAccueil.estChargee());
		PagePlanDeSite pagePlanDeSite = pageAccueil.naviguerPagePlanDeSite();
		Assert.assertTrue(pagePlanDeSite.estChargee());
		pageAccueil = pagePlanDeSite.naviguerPageAccueil();
		Assert.assertTrue(pageAccueil.estChargee());
		PageMentionsLegales pageMentionsLegales = pageAccueil.naviguerPageMentionsLegales();
		Assert.assertTrue(pageMentionsLegales.estChargee());
	}
	
	  @Deployment(testable = false)
	    public static WebArchive createDeployment() {
		  
	        return ShrinkWrap.create(WebArchive.class, "login.war")
	        	.setWebXML(new File(WEBAPP_SRC, "WEB-INF/web.xml"))
	            .addAsWebResource(new File(WEBAPP_SRC, "accueil.xhtml"))
	            .addAsWebResource(new File(WEBAPP_SRC, "planDuSite.xhtml"))
	            .addClass(CookieBean.class)
	            .addAsWebResource(new File(WEBAPP_SRC, "mentionsLegales.xhtml"))
	            .addAsLibrary(new File("C:/tmp/arquillian/el-ri-1.0.jar"))
	            .addAsLibrary(new File("C:/tmp/arquillian/jsf-api-2.1.7.jar"))
	            .addAsLibrary(new File("C:/tmp/arquillian/jsf-impl-2.1.7.jar"))
	            .addAsLibrary(new File("C:/tmp/arquillian/jsp-api-2.1.jar"))
	            .addAsLibrary(new File("C:/tmp/arquillian/jstl-1.2.jar"))
	            .addAsLibrary(new File("C:/tmp/arquillian/primefaces-6.1.jar"))
	            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
	            .addAsWebInfResource(
	                new StringAsset("<faces-config version=\"2.0\"/>"),
	                "faces-config.xml");
	    }
	
	@Test
	public void testFermetureBandeauCookiePageAccueil(@InitialPage final PageAccueil pageAccueilInitial) {
		PageAccueil pageAccueil = pageAccueilInitial;
		Assert.assertTrue(pageAccueil.estChargee());
		Assert.assertTrue(pageAccueil.isBandeauCookieVisible());
		pageAccueil.masqueBandeauCookie();
		Assert.assertFalse(pageAccueil.isBandeauCookieVisible());
		Assert.assertTrue(pageAccueil.estChargee());
		PagePlanDeSite pagePlanDeSite = pageAccueil.naviguerPagePlanDeSite();
		Assert.assertTrue(pagePlanDeSite.estChargee());
		Assert.assertFalse(pagePlanDeSite.isBandeauCookieVisible());
	}
}