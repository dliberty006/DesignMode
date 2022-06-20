package com.dliberty.demo.decorator;

/**
 * 装饰器模式
 * 1. 定义一个抽象类，一个抽象方法run
 * 2. 定义一个具体实现类，继承自抽象类，实现抽象方法run
 * 3. 定义一个抽象的装饰器，继承自抽象类，定义一个抽象类的成员变量，有参构造方法。
 * 		实现抽象方法run：调用成员变量的run方法
 * 4. 定义一个具体的装饰器，继承自抽象装饰器，实现抽象方法run
 * 		在处理父类的方法时，可以在处理前后可以加一些附加功能
 *       如果不调用父类的方法，表示完全改写方法，实现新功能
 *       
 *  主要优点：
 *		装饰器是继承的有力补充，比继承灵活，在不改变原有对象的情况下，动态的给一个对象扩展功能，即插即用
 *		通过使用装饰类及这些装饰类的排列组合，可以实现不同效果
 *		装饰器模式完全遵守开闭原则
 *	
 *  主要缺点：
 *		会出现更多的代码、更多的类，增加程序的复杂性。
 * @author v_guojt
 *
 */
public class Test {

	public static void main(String[] args) {
		Animal comp = new Dog();
		comp.run();
		System.out.println("---------------装饰之后------------------");
		Animal d = new DogDecorator(comp);
        d.run();
        Animal d2 = new Dog2Decorator(comp);
        d2.run();
	}
}
