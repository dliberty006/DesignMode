package com.dliberty.demo.observer;

public class WakeupEvent extends Event<Child> {
	
	private long time;
	private Child source;

	@Override
	Child getSource() {
		return source;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public WakeupEvent(long time, Child source) {
		super();
		this.time = time;
		this.source = source;
	}

	public WakeupEvent() {
		super();
	}

	
	
}
