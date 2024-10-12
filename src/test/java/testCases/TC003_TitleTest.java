package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC003_TitleTest extends BaseClass{
	
	public int sub(int a, int b)
	{
		return a - b;
	}
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("****** Startign TC_003_TitleTest *****");
		
		try
		{
			int total = 0;
			int sub= sub(4,4);
			assertEquals(sub, total);
			HomePage hp=new HomePage(driver); 
			hp.clickMyAccount();
			
			/*
			 * //HomePage HomePage hp=new HomePage(driver); hp.clickMyAccount();
			 * hp.clickLogin();
			 * 
			 * //Login LoginPage lp=new LoginPage(driver);
			 * lp.setEmail(p.getProperty("email"));
			 * lp.setPassword(p.getProperty("password")); lp.clickLogin();
			 * 
			 * //MyAccount MyAccountPage macc=new MyAccountPage(driver); boolean
			 * targetPage=macc.isMyAccountPageExists();
			 * 
			 * Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage,
			 * true,"Login failed");
			 */		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****** Finished TC_003_TitleTest *****");
	}
	
}
