package com.experitest.auto;

import org.junit.Before;
import org.junit.Test;


public class AndroidDemoTest extends BaseTest {

	@Before
	public void setUp() throws Exception{
		init("@os='android' and @serialnumber='CB512DLQDM'", "AndroidDemoTest");
	}
	
	@Test
	public void test(){
		client.deviceAction("HOME");
		client.launch("chrome:http://www.screensavers.com", true, false);
		
		client.waitForElement("WEB", "xpath=//*[@id='backButton']", 0, 20000);
		
		client.verifyElementFound("WEB", "xpath=//*[@id='backButton']", 0);
		
		client.report("Able to redirect to SecureNet blockage page", client.isElementFound("WEB", "xpath=//*[@id='backButton']"));		
	}	
}