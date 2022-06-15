package com.dliberty.demo.singleton;

/**
 * 懒汉模式
 * 使用时加载
 * 使用synchronized 加锁，效率低
 * 
 * @author v_guojt
 *
 */
public class Mgr03 {

	private static Mgr03 INSTANCE;

	private Mgr03() {
	}

	public static synchronized Mgr03 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Mgr03();
		}
		return INSTANCE;
	}
}
