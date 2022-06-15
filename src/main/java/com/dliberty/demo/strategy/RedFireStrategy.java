package com.dliberty.demo.strategy;

public class RedFireStrategy implements FireStrategy {

	@Override
	public void fire(Fire fire) {
		System.out.println(fire.getName() + "是红色的");
	}

}
