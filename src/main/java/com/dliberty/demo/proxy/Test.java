package com.dliberty.demo.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 静态代理模式
 * 和decorator 没啥区别
 * 
 * @author v_guojt
 *
 */
public class Test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		new TankLogProxy(
//				new TankTimeProxy(
//						new Tank())).move();
		
		
		Method[] methods = Tank.class.getMethods();
		Tank tank = Tank.class.newInstance();
		for (Method method : methods) {
			method.invoke(tank);
		}
	}
}

interface Movable {

	void move();
}

class Tank implements Movable {

	@Override
	public void move() {
		System.out.println("tank moving");
//		try {
//			Thread.sleep(new Random().nextInt(10000));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

}

class TankLogProxy implements Movable {

	private Movable movable;

	public TankLogProxy(Movable movable) {
		super();
		this.movable = movable;
	}

	@Override
	public void move() {
		System.out.println("tank 开始移动");
		movable.move();
		System.out.println("tank 结束移动");
	}

}

class TankTimeProxy implements Movable {

	private Movable movable;

	public TankTimeProxy(Movable movable) {
		super();
		this.movable = movable;
	}

	@Override
	public void move() {
		long startTime = System.currentTimeMillis();
		movable.move();
		long endTime = System.currentTimeMillis();
		System.out.println("tank 移动" + (endTime - startTime) + "毫秒");
	}

}
