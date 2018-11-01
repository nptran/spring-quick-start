package com.mystudent.repository;

public class Processor {
	
	public static String processName(String name) {

		name = name.trim();
		name = name.replaceAll("\\s+", " ");
		String[] words = name.split("\\s");
		name = "";
		for(int i=0; i<words.length; i++) {
			name+=String.valueOf(words[i].charAt(0)).toUpperCase() + words[i].substring(1).toLowerCase();
			if(i<words.length-1) {
				name+=" ";
			}
		}
		return name;
	}

}
