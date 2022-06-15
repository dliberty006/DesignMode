package com.dliberty.demo.singleton;

/**
 * 枚举模式，jvm 保证单类，可以预防反序列化
 * @author v_guojt
 *
 */
public enum Mgr06 {

	INSTANCE;

	public static Mgr06 getInstance() {
		return Mgr06.INSTANCE;
	}
}
