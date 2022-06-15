package com.dliberty.demo.decorator;

/**
 * 动物装饰器，继承自动物类
 * 有一个动物的有参构造方法
 * @author v_guojt
 *
 */
public class AnimalDecorator implements Animal {

	private Animal component;
	
	public AnimalDecorator(Animal component) {
        this.component = component;
    }
	
	@Override
	public void run() {
		component.run();
	}

}
