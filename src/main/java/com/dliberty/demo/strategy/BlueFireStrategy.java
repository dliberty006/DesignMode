package com.dliberty.demo.strategy;

public class BlueFireStrategy implements FireStrategy {

	@Override
	public void fire(Fire fire) {
		System.out.println(fire.getName() + "是蓝色的");
	}

}
