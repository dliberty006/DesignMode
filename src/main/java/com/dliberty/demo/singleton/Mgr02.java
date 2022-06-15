package com.dliberty.demo.singleton;

/**
 * 懒汉模式
 * 使用时加载
 * 线程不安全
 * 
 * @author v_guojt
 *
 */
public class Mgr02 {

	private static Mgr02 INSTANCE;

	private Mgr02() {
	}

	public static Mgr02 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Mgr02();
		}
		return INSTANCE;
	}
}
