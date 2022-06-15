package com.dliberty.demo.observer;

public class Dad extends Observer {

	@Override
	void action(WakeupEvent event) {
		System.out.println("dad");
	}

}
