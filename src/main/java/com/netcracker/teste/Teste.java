package com.netcracker.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Teste {

	
	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<Person>();
		
		Person person1 = new Teste().new Person();
		person1.setAddress("Address Person 1");
		person1.setAge(37);
		person1.seteMail("person1@email.com");
		person1.setGender(Gender.MALE);
		person1.setGivenName("Daniel");
		person1.setPhone("9999-9999");
		person1.setSurName("Ariki");
		
		persons.add(person1);
		
		Person person2 = new Teste().new Person();
		person2.setAddress("Address Person 2");
		person2.setAge(32);
		person2.seteMail("person2@email.com");
		person2.setGender(Gender.FEMALE);
		person2.setGivenName("Raquel");
		person2.setPhone("9999-9999");
		person2.setSurName("Luz");
		
		persons.add(person2);
		
		Person person3 = new Teste().new Person();
		person3.setAddress("Address Person 3");
		person3.setAge(21);
		person3.seteMail("person3@email.com");
		person3.setGender(Gender.MALE);
		person3.setGivenName("John");
		person3.setPhone("9999-9999");
		person3.setSurName("Doe");
		
		persons.add(person3);
		
		Predicate<Teste.Person> predDrivers = person -> person.getAge() >= 16;
		showDrivers(persons, predDrivers);
		
		Predicate<Teste.Person> predDraftee = person -> person.getAge() >= 18 && person.getAge() <= 25 && person.getGender() == Gender.MALE;
		showDraftees(persons, predDraftee);
		
		Predicate<Teste.Person> predPilot = person -> person.getAge() >= 23 && person.getAge() <= 65;
		showPilots(persons, predPilot);
		
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
		private String eMail;
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
		public String geteMail() {
			return eMail;
		}
		public void seteMail(String eMail) {
			this.eMail = eMail;
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
		
	}
	
	enum Gender {
		MALE, FEMALE;
	}
	
}
