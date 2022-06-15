package com.dliberty.demo.decorator;

/**
 * 狗实现类，继承动物类
 * @author v_guojt
 *
 */
public class Dog implements Animal {

	@Override
	public void run() {
		System.out.println("dog runing");
	}

	public Dog() {
		System.out.println("创建Dog构件角色");
	}
	
	

}
