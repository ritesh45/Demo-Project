package com.example.ritesh.demo.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Dublicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list=Arrays.asList("A","A","B","C","D","E","E","Ritesh","Ritesh","Ritesh","AB");
		//list.forEach(lis -> System.out.println("List "+ lis));
	List<String> dublicate=	list.stream().distinct().collect(Collectors.toList());
	System.out.println("Dublicate "+dublicate);
	dublicate.forEach(du -> System.out.println("ForEach "+du));
	}

}
