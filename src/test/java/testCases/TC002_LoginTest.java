package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	public int add(int a, int b)
	{
		return a + b;
	}

	@Test(groups={"Sanity","Master"})
	public void verify_loginSums()
	{
		logger.info("****** Startign TC_002_LoginTest *****");
		
		try
		{
			int total = 8;
			int sum= add(4,4);
			assertEquals(sum, total);
			HomePage hp=new HomePage(driver); 
			hp.clickMyAccount();
			System.out.println("Title of Page: "+ driver.getTitle());
			assertEquals(driver.getTitle(),"Your Store");
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
		logger.info("****** Finished TC_002_LoginTest *****");
	}
	
}
