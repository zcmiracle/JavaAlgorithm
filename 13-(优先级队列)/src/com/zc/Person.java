package com.zc;

public class Person implements Comparable<Person> {

	private String name;
	private Integer age; // 温度

	// 构造方法
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person person) {
		// TODO Auto-generated method stub
		return (this.age - person.age);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person [name =" + name + ", age=" + age + "]";
	}
}
