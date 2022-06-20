package com.dliberty.demo.builder;

public class Test {
	
	public static void main(String[] args) {
		Person person = new Person.PersonBuilder()
		.buildBasinInfo("张三", 28)
		.buildWeight(60)
		.buildHeight(178)
		.buildLocation("上海", "1302")
		.build();
		
		System.out.println(person);
	}

}

class Person {
	
	private String name;
	private int age;
	private int weight;
	private int height;
	
	private Location location;
	
	private Person() {}
	
	public static class PersonBuilder {
		Person p = new Person();
		
		public PersonBuilder buildBasinInfo(String name,int age) {
			p.name = name;
			p.age = age;
			return this;
		}
		
		public PersonBuilder buildWeight (int weight) {
			p.weight = weight;
			return this;
		}
		
		public PersonBuilder buildHeight (int height) {
			p.height = height;
			return this;
		}
		
		public PersonBuilder buildLocation(String address,String roomId) {
			Location l = new Location();
			l.setAddress(address);
			l.setRoomId(roomId);
			p.location = l;
			return this;
		}
		
		public Person build() {
			return p;
		}
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + ", height=" + height + ", location="
				+ location + "]";
	}
	
	
}

class Location {
	
	private String address;
	private String roomId;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	@Override
	public String toString() {
		return "Location [address=" + address + ", roomId=" + roomId + "]";
	}
	
	
}
