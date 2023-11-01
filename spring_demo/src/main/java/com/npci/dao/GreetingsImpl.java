package com.npci.dao;

import java.util.HashMap;
import java.util.Map;

public class GreetingsImpl implements Greetings {

	// stores hello in different language
	private static Map <String,String> map;
	public GreetingsImpl()
	{
		map=new HashMap<>();
		map.put("HINDI", "Namaskar");
		map.put("Marathi", "Jai Shree Ram");
		map.put("KANNADA", "Namaskara");
		map.put("TAMIL", "Vanakam");
		map.put("FRENCH", "Bonjour");
		map.put("ENGLISH", "Hello");
	}
	
	@Override
	public String greet(String name, String Language) {
		String  lang=Language.toUpperCase();
		String value=map.get(lang);
		return value;
	}
	
	
}
