package com.dliberty.demo.observer;

/**
 * 观察者模式
 * 监听
 * 3个对象
 * 1： 事件源对象，被观察者 儿童
 * 2： 观察者 父母
 * 3： event 事件对象 wakeupEvent
 * @author v_guojt
 *
 */
public class Test {

	public static void main(String[] args) {
		Child child = new Child();
		child.addListener(new Dad());
		child.addListener(new Mom());
		child.wakeup();
	}
}
