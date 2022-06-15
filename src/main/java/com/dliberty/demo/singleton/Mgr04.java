package com.dliberty.demo.singleton;

/**
 * 懒汉模式
 * 使用时加载
 * 双重锁判断，减轻锁力度
 * volatile 关键字防止指令重排序，导致错误
 * @author v_guojt
 *
 */
public class Mgr04 {

	private static volatile Mgr04 INSTANCE;

	private Mgr04() {
	}

	public static Mgr04 getInstance() {
		if (INSTANCE == null) {
			synchronized (Mgr04.class) {
				if (INSTANCE == null) {
					INSTANCE = new Mgr04();
				}
			}
		}
		return INSTANCE;
	}
}
