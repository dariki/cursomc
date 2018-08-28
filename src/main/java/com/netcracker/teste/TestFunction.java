package com.netcracker.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestFunction {

	
	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<Person>();
		
		Person person1 = new TestFunction().new Person();
		person1.setAddress("Address Person 1");
		person1.setAge(37);
		person1.setEmail("person1@email.com");
		person1.setGender(Gender.MALE);
		person1.setGivenName("Daniel");
		person1.setPhone("9999-9999");
		person1.setSurName("Ariki");
		
		persons.add(person1);
		
		Person person2 = new TestFunction().new Person();
		person2.setAddress("Address Person 2");
		person2.setAge(32);
		person2.setEmail("person2@email.com");
		person2.setGender(Gender.FEMALE);
		person2.setGivenName("Raquel");
		person2.setPhone("9999-9999");
		person2.setSurName("Luz");
		
		persons.add(person2);
		
		Person person3 = new TestFunction().new Person();
		person3.setAddress("Address Person 3");
		person3.setAge(21);
		person3.setEmail("person3@email.com");
		person3.setGender(Gender.MALE);
		person3.setGivenName("John");
		person3.setPhone("9999-9999");
		person3.setSurName("Doe");
		
		persons.add(person3);
		
		for (Person person : persons){
			System.out.println(person.printCustom(p -> "Name: " + p.getGivenName() + " EMail: " + p.getEmail()));
		}
		
		for (Person person : persons) {
			System.out.println(
					person.printCustom(person.getEasternStyle())
			);
		}
		
		for (Person person : persons) {
			System.out.println(
					person.printCustom(person.getWesternStyle())
			);
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
	}
	
	enum Gender {
		MALE, FEMALE;
	}
	
}
