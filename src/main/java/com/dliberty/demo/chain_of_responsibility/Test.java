package com.dliberty.demo.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
 * @author v_guojt
 *
 */
public class Test {
	
	public static void main(String[] args) {
		
		Msg m = new Msg();
		m.setStr("<hello,dliberty.com^_^>");
		
		FilterChain chain = new FilterChain();
		chain.addFilter(new HtmlFilter()).addFilter(new FaceFilter());
		
		FilterChain chain2 = new FilterChain();
		
		chain2.addFilter(new UrlFilter());
		
		chain.addFilter(chain2);
		
		chain.doFilter(m);
		System.out.println(m);
	}

}

class Msg {
	private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "Msg [str=" + str + "]";
	}
	
}


interface Filter{
	boolean doFilter(Msg msg);
}

/**
 * filterChain 实现Filter的目的是为了不同的责任链串联起来
 * @author v_guojt
 *
 */
class FilterChain implements Filter{
	
	private List<Filter> filters = new ArrayList<>();
	
	public FilterChain addFilter(Filter filter) {
		filters.add(filter);
		return this;
	}

	@Override
	public boolean doFilter(Msg msg) {
		
		for (Filter filter : filters) {
			boolean doFilter = filter.doFilter(msg);
			if (!doFilter) {
				return false;
			}
		}
		return true;
	}
	
}

class HtmlFilter implements Filter{

	@Override
	public boolean doFilter(Msg msg) {
		String str = msg.getStr();
		str = str.replace("<", "[");
		str = str.replace(">", "]");
		msg.setStr(str);
		return true;
	}

	
}

class FaceFilter implements Filter{

	@Override
	public boolean doFilter(Msg msg) {
		String str = msg.getStr();
		str = str.replace("^_^", "o_o");
		msg.setStr(str);
		return true;
	}
}

class UrlFilter implements Filter{

	@Override
	public boolean doFilter(Msg msg) {
		String str = msg.getStr();
		str = str.replace("dliberty.com", "https://www.dliberty.com");
		msg.setStr(str);
		return true;
	}
	
}
