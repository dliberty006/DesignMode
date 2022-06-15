package com.dliberty.demo.singleton;

/**
 * 饿汉模式 推荐使用
 * 唯一缺点：不管类使用与否，都进行了加载
 * @author v_guojt
 *
 */
public class Mgr01 {

	private static final Mgr01 INSTANCE = new Mgr01();

	private Mgr01() {
	}

	public static Mgr01 getInstance() {
		return INSTANCE;
	}
}
