package com.dliberty.demo.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 享元模式->共享元对象模式
 * 经典案例：String 常量池，Integer 常量池
 * 线程池
 * @author v_guojt
 *
 */
public class Test {

	public static void main(String[] args) {
		BulletPool pool = new BulletPool();
		for(int i = 0;i<20;i++) {
			Bullet b = pool.getBullet();
			System.out.println(b.getUUID());
		}
	}
}

/**
 * 坦克大战，子弹从子弹池中获取
 * @author v_guojt
 *
 */
class Bullet {
	
	private boolean alive = false;
	
	private String uuid = UUID.randomUUID().toString();

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public String getUUID() {
		return this.uuid;
	}
	
}

class BulletPool {
	
	private List<Bullet> bullets = new ArrayList<>();
	
	{
		for (int i =0;i<10;i++) {
			bullets.add(new Bullet());
		}
	}
	
	public Bullet getBullet() {
		for (Bullet b : bullets) {
			if (!b.isAlive()) {
				b.setAlive(true);
				return b;
			}
		}
		return new Bullet();
	}
	
}
