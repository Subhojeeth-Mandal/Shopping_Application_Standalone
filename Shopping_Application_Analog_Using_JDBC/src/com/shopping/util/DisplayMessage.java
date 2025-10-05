package com.shopping.util;

public class DisplayMessage 
{
	public static void getMessage(String message)
	{
		for(int i=0;i<message.length();i++)
		{
			System.out.print(message.charAt(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
