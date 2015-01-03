package model;

import java.util.ArrayList;

public class Person {
	private String name;
	private String gender;
	private int age;
	private static ArrayList<String> personParams = new ArrayList<String>();
	private ArrayList<Object> paramValues = new ArrayList<Object>();	
	
	public Person(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		
		personParams.add("name");
		personParams.add("gender");
		personParams.add("age");
		
		paramValues.add(this.name);
		paramValues.add(this.gender);
		paramValues.add(this.age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public static ArrayList<String> getPersonParams() {
		return personParams;
	}
	
	public static int getNumOfPersonParams() {
		return personParams.size();
	}
	
	public ArrayList<Object> getParamValues() {
		return paramValues;
	}
}
