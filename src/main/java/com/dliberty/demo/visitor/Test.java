package com.dliberty.demo.visitor;

public class Test {

	public static void main(String[] args) {
		Visitor v = new PersonVisitor();
		Computer c = new Keyboard();
		int money = c.getMoney(v);
		System.out.println(money);
	}
}
interface Visitor{
	
	int getSale();
}

interface Computer{
	int getMoney(Visitor v);
	int accpet(Visitor v);
}

class Keyboard implements Computer {

	@Override
	public int getMoney(Visitor v) {
		return 500 * accpet(v) / 100;
	}

	@Override
	public int accpet(Visitor v) {
		return v.getSale();
	}
	
}

class PersonVisitor implements Visitor {

	@Override
	public int getSale() {
		return 7;
	}
	
}


