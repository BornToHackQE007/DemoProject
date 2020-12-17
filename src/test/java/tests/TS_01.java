package tests;

import org.testng.annotations.Test;
import QEA.DemoProject.*;
public class TS_01 extends BaseClass{
	@Test(priority=0)
	public static void credentials() throws InterruptedException 
	{
		SignIn.find();
	}
@Test(priority=1)
public static void search() throws InterruptedException 
{
	Search.find();
}
}