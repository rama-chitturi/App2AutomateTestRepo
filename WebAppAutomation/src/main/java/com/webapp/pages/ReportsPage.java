package com.webapp.pages;

import java.io.IOException;

public class ReportsPage extends HTMLPageWebElements{
	
	public ReportsPage() throws IOException {
		HTMLPageWebElements htmlEleObj= new HTMLPageWebElements();
	}

	public void navigateToHome()
	{
		clickElement(reportsGoHomeEle);
	}

}
