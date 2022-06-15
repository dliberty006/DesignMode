package com.dliberty.demo.strategy;

/**
 * 策略模式也就是面向对象编程中的多态
 * @author v_guojt
 *
 */
public class Test {

	public static void main(String[] args) {
		Fire fire = new Fire("火焰");
		
		FireStrategy red = new RedFireStrategy();
		red.fire(fire);
		
		FireStrategy blue = new BlueFireStrategy();
		blue.fire(fire);
	}
}
