package com.threads;

public class A2AThreadTest extends Thread{
	
	String browserName, threadName;
	A2ABaseThread baseObj;
	public A2AThreadTest(String browserName, String threadName)
	{
		super(threadName);
		this.browserName=browserName;
		baseObj = new A2ABaseThread();
		
	}

	public void run()
	{
		System.out.println("Thread name is: "+Thread.currentThread().getName());
		try {
			baseObj.setupDriver(browserName);
			baseObj.openotherURl();
			baseObj.HandleWindows();
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		finally
		{
			//baseObj.closeBrowser();
		}
	}
	

}
