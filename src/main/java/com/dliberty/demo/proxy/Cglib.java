package com.dliberty.demo.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 生成一个被代理类的子类
 * 如果被代理类是final的话则无法生成，jdkproxy可以
 * cglib 的底层也是asm
 * @author v_guojt
 *
 */
public class Cglib {
	
	public static void main(String[] args) {
		Enhancer e = new Enhancer();
		e.setSuperclass(Car.class);
		e.setCallback(new CarLogInterceptor());
		Car carProxy = (Car)e.create();
		carProxy.move();
	}

}

class CarLogInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("begin");
		Object invoke = proxy.invokeSuper(obj, args);
		System.out.println("end");
		return invoke;
	}
	
}

class Car {
	public void move() {
		System.out.println("car moving");
	}
}
