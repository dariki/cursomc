package com.netcracker.teste;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Teste {

	public static void main(String[] args) {
		//Stream<String> stream = Stream.of("A", "B", "C", "D");
		
		//System.out.println(
//		Stream<String> teste = stream.peek(new Consumer<String>() {
//			public void accept(String t) {
//				System.out.println(t);
//			}; 
//		});
//		
//		System.out.println(stream.findFirst());
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2017);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DAY_OF_MONTH, 24);
		
		System.out.println(new SimpleDateFormat("EEEE").format(calendar.getTime()));
		
	}
	
	public static String getNames() {
		String[] firstArray = {"Daniel", "Maria", "John", "Tim", "Carlos", "Eduardo"};
		String[] secondArray = {"Tim", "Maria", "Eduardo", "John"};
		
		List<String> firstList = new ArrayList<String>(Arrays.asList(firstArray));
		List<String> secondList = new ArrayList<String>(Arrays.asList(secondArray));
 
		for (String listExist : secondList) {
			// remove firstList names exist on secondList
			firstList.removeIf(name -> listExist.equals(name));
		}
		
		return firstList.toString();
		
	}
}


