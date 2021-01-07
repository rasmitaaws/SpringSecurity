package com.apps.rasmi.ws.dto;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	private final Random RANDOM=new SecureRandom();
	private final String ALPHABET="012356789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public String generateUserId(int length)
	{
		return generateRandomString(length);
	}
	
	private String generateRandomString(int length)
	{
		StringBuffer returnString=new StringBuffer(length);
		for(int i=0;i<length;i++)
		{
			returnString.append(ALPHABET.charAt(RANDOM.nextInt(length)));
		}
		
		return returnString.toString();
		
	}
}
