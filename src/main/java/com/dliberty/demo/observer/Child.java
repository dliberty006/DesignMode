package com.dliberty.demo.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件源对象
 * @author v_guojt
 *
 */
public class Child {
	
	private List<Observer> observers = new ArrayList<>();
	
	public void addListener(Observer observer) {
		observers.add(observer);
	}
	
	public void wakeup() {
		WakeupEvent event = new WakeupEvent(System.currentTimeMillis(), this);
		for (Observer observer : observers) {
			observer.action(event);
		}
	}

}
