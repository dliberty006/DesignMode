package com.dliberty.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk 动态代理 必须面向接口
 * 使用asm 生成
 * asm 对二进制进行修改
 * 
 * @author v_guojt
 *
 */
public class JdkProxy {

	public static void main(String[] args) {

		Movable2 m = new Bike();
		
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

		Movable2 p = (Movable2) Proxy.newProxyInstance(m.getClass().getClassLoader(), new Class[] { Movable2.class },
				new LogProxy(m));
		p.move();
	}

}

interface Movable2 {
	void move();
}

class Bike implements Movable2 {

	@Override
	public void move() {
		System.out.println("bike moving");
	}

}

class LogProxy implements InvocationHandler {

	Movable2 m;

	public LogProxy(Movable2 m) {
		super();
		this.m = m;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("bike 开始移动");
		Object invoke = method.invoke(m, args);
		System.out.println("bike 移动结束");
		return invoke;
	}

}
