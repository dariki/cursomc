package com.netcracker.teste;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchCriteria {
	
	private final Map<String, Predicate<Person>> searchMap = new HashMap<>();
	
	private SearchCriteria() {
		super();
		initSearchMap();
	}
	
	private void initSearchMap() {
	
		Predicate<Person> allDrivers = p -> p.getAge() >= 16;
		Predicate<Person> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
		Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;
		
		searchMap.put("allDrivers", allDrivers);
		searchMap.put("allDraftees", allDraftees);
		searchMap.put("allPilots", allPilots);
		
	}
	
	public Predicate<Person> getCriteria(String PredicateName) {
		
		Predicate<Person> target;
		
		target = searchMap.get(PredicateName);
		
		if (target == null) {
		
			System.out.println("Search Criteria not found... ");
			System.exit(1);
		
		}
		
		return target;
		
	}
		
	public static SearchCriteria getInstance() {
		return new SearchCriteria();
	}
	
	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<Person>();
		
		Person person1 = new SearchCriteria().new Person();
		person1.setAddress("Address Person 1");
		person1.setAge(37);
		person1.setEmail("person1@email.com");
		person1.setGender(Gender.MALE);
		person1.setGivenName("Daniel");
		person1.setPhone("9999-9999");
		person1.setSurName("Ariki");
		
		persons.add(person1);
		
		Person person2 = new SearchCriteria().new Person();
		person2.setAddress("Address Person 2");
		person2.setAge(32);
		person2.setEmail("person2@email.com");
		person2.setGender(Gender.FEMALE);
		person2.setGivenName("Raquel");
		person2.setPhone("9999-9999");
		person2.setSurName("Luz");
		
		persons.add(person2);
		
		Person person3 = new SearchCriteria().new Person();
		person3.setAddress("Address Person 3");
		person3.setAge(21);
		person3.setEmail("person3@email.com");
		person3.setGender(Gender.FEMALE);
		person3.setGivenName("Melissa");
		person3.setPhone("9999-9999");
		person3.setSurName("Luz Ariki");
		
		persons.add(person3);
		
		SearchCriteria search = SearchCriteria.getInstance();
		
		System.out.println("\n=== Western Phone List ===");
		persons.forEach( p -> p.printWesternName());
		
		System.out.println("\n=== Eastern Phone List ===");
		persons.forEach(Person::getEasternStyle);
		
		System.out.println("\n=== Custom Phone List ===");
		persons.forEach(p -> { System.out.println(p.printCustom(r -> "Name: " + r.getGivenName() + " EMail: " + r.getEmail())); });
		
		//----------------
		System.out.println("\n=== Western Pilot Phone List ===");
		persons.stream().filter(search.getCriteria("allPilots")).forEach(Person::printWesternName);

		System.out.println("\n=== Eastern Draftee Phone List ===");
		persons.stream().filter(search.getCriteria("allDraftees")).forEach(Person::printEasternName);
		
		//-----------------
		List<Person> pilotList = persons.stream().filter(search.getCriteria("allPilots")).collect(Collectors.toList());
 
		System.out.println("\n=== Western Pilot Phone List ===");
		pilotList.forEach(Person::printWesternName);
		
		// Calc average age of pilots old style
		System.out.println("== Calc Old Style ==");
		int sum = 0;
		int count = 0;

		for (Person p : persons){
			if (p.getAge() >= 23 && p.getAge() <= 65){
				sum = sum + p.getAge();
				count++;
			}
		}

		long average = sum / count;
		System.out.println("Total Ages: " + sum);
		System.out.println("Average Age: " + average);

		// Get sum of ages
		System.out.println("\n== Calc New Style ==");
		long totalAge = persons
		        .stream()
		        .filter(search.getCriteria("allPilots"))
		        .mapToInt(p -> p.getAge())
		        .sum();

		// Get average of ages
		OptionalDouble averageAge = persons
		        .parallelStream()
		        .filter(search.getCriteria("allPilots"))
		        .mapToDouble(p -> p.getAge())
		        .average();

		System.out.println("Total Ages: " + totalAge);
		System.out.println("Average Age: " + averageAge.getAsDouble());
		
		TreeMap<Person, Integer> marks = new TreeMap<>((p1,p2) -> p2.getGivenName().compareTo(p1.getGivenName()));
		
		marks.put(person1, 1);
		marks.put(person2, 2);
		marks.put(person3, 3);
		
		for (int personId : marks.values()) {
			System.out.println(personId);
		}
		
	}
	
	static void showDrivers(List<Person> persons, Predicate<Person> aTest) {
		//Drivers: Persons over the age of 16
		for (Person person : persons) {
			if(aTest.test(person)) {
				System.out.println("Drivers: Persons over the age of 16 - name:  " + person.getSurName() +" " + person.getGivenName() + "; age: " + person.getAge() + "; phone: " + person.getPhone());
			}
		}
	}
	
	static void showDraftees(List<Person> persons, Predicate<Person> aTest) {
		//Draftees: Male persons between the ages of 18 and 25
		for (Person person : persons) {
			if(aTest.test(person)) {
				System.out.println("Draftees: Male persons between the ages of 18 and 25 - name:  " + person.getSurName() +" " + person.getGivenName() + "; age: " + person.getAge() + "; phone: " + person.getPhone());
			}
		}
	}
		
	static void showPilots(List<Person> persons, Predicate<Person> aTest) {
		//Pilots (specifically commercial pilots): Persons between the ages of 23 and 65
		for (Person person : persons) {
			if(aTest.test(person)) {
				System.out.println("Pilots: Persons between the ages of 23 and 65 - name:  " + person.getSurName() +" " + person.getGivenName() + "; age: " + person.getAge() + "; phone: " + person.getPhone());
			}
		}
	}
	
	
	class Person {
		private String givenName;
		private String surName;
		private int age;
		private Gender gender;
		private String email;
		private String phone;
		private String address; 
		
		public String getGivenName() {
			return givenName;
		}
		public void setGivenName(String givenName) {
			this.givenName = givenName;
		}
		public String getSurName() {
			return surName;
		}
		public void setSurName(String surName) {
			this.surName = surName;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		public String printCustom(Function<Person, String> f){
			return f.apply(this);
		}
		
		public Function<Person, String> getWesternStyle(){
			return person -> "\nName: " + person.getGivenName() + " " + person.getSurName() + "\n" +
					"Age: " + person.getAge() + "  " + "Gender: " + person.getGender() + "\n" +
					"EMail: " + person.getEmail() + "\n" + 
					"Phone: " + person.getPhone() + "\n" +
					"Address: " + person.getAddress();
		}
		
		public Function<Person, String> getEasternStyle(){
			return person -> "\nName: " + person.getSurName() + " " + person.getGivenName() + "\n" +
					"Age: " + person.getAge() + "  " + "Gender: " + person.getGender() + "\n" +
					"EMail: " + person.getEmail() + "\n" + 
					"Phone: " + person.getPhone() + "\n" +
					"Address: " + person.getAddress();
		}
		
		public void printWesternName(){
			  
		    System.out.println("\nName: " + this.getGivenName() + " " + this.getSurName() + "\n" +
		             "Age: " + this.getAge() + "  " + "Gender: " + this.getGender() + "\n" +
		             "EMail: " + this.getEmail() + "\n" + 
		             "Phone: " + this.getPhone() + "\n" +
		             "Address: " + this.getAddress());
		  }

		    
		  public void printEasternName(){
		      
		    System.out.println("\nName: " + this.getSurName() + " " + this.getGivenName() + "\n" +
		             "Age: " + this.getAge() + "  " + "Gender: " + this.getGender() + "\n" +
		             "EMail: " + this.getEmail() + "\n" + 
		             "Phone: " + this.getPhone() + "\n" +
		             "Address: " + this.getAddress());
		    
		    
		    
		  }
		
	}
	
	enum Gender {
		MALE, FEMALE;
	}
	
	
}
