package com.dliberty.demo.observer;

public class Mom extends Observer {

	@Override
	void action(WakeupEvent event) {
		System.out.println("mom");
	}

}
