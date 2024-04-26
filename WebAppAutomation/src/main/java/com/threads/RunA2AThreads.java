package com.threads;

public class RunA2AThreads {
	public static void main(String ar[])
	{
	
	Thread t1Obj = new A2AThreadTest("edge","edgeThread");
	Thread t2Obj = new A2AThreadTest("edge","edgeThread");
	
	t1Obj.start();
	t2Obj.start();
	}

}
