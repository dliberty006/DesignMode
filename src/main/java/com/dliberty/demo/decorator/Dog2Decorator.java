package com.dliberty.demo.decorator;

/**
 * 狗装饰器，继承自动物装饰器
 * 1.为狗绑个绳
 * 2.狗运动完给狗洗澡
 * @author v_guojt
 *
 */
public class Dog2Decorator extends AnimalDecorator {

	public Dog2Decorator(Animal component) {
		super(component);
	}
	
	@Override
	public void run() {
		 // 在处理父类的方法时，可以在处理前后可以加一些附加功能
        // 如果不调用父类的方法，表示完全改写方法，实现新功能
		beforeFunction();
        super.run();
        afterFunction();
	}
	
	public void beforeFunction() {
		System.out.println("dog没有绑绳子");
	}
	
	public void afterFunction() {
		System.out.println("dog咬人了");
		System.out.println("给人打狂犬疫苗");
	}
	
	

}
