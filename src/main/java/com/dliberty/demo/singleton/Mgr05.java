package com.dliberty.demo.singleton;

/**
 * 静态内部类方式
 * 加载外部类的时候不会加载内部类，这样可以实现懒加载
 * @author v_guojt
 *
 */
public class Mgr05 {

	
	private static class InstanceInside {
		private static Mgr05 INSTANCE = new Mgr05();
	}

	private Mgr05() {
	}

	public static Mgr05 getInstance() {
		return InstanceInside.INSTANCE;
	}
}
