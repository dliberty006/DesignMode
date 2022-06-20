package com.dliberty.demo.chain_of_responsibility.filter;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		Request request = new Request("request");
		Response p = new Response("response");
		Filter htmlFilter = new HtmlFilter();
		Filter urlFilter = new UrlFilter();
		FilterChain chain = new FilterChain();
		chain.addFilter(htmlFilter);
		chain.addFilter(urlFilter);
		
		chain.doFilter(request, p);
		
		System.out.println(request.getStr());
		System.out.println(p.getStr());
		
	}

}
class Request{
	String str;
	
	public Request(String str) {
		super();
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	
}
class Response{
	String str;
	
	public Response(String str) {
		super();
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
interface Filter{
	boolean doFilter(Request request,Response response,FilterChain chain);
}

class FilterChain  {
	
	private List<Filter> filters = new ArrayList<>();
	
	int index = 0;
	
	public void addFilter(Filter filter) {
		filters.add(filter);
	}

	public boolean doFilter(Request request, Response response) {
		
		if (index == filters.size()) {
			return false;
		}
		
		Filter f = filters.get(index);
		
		index ++;
		return f.doFilter(request, response, this);
	}
	
}

class HtmlFilter implements Filter {

	@Override
	public boolean doFilter(Request request, Response response, FilterChain chain) {
		request.setStr(request.getStr() + "->html");
		chain.doFilter(request, response);
		response.setStr(response.getStr() + "->html");
		return true;
	}
	
}

class UrlFilter implements Filter {

	@Override
	public boolean doFilter(Request request, Response response, FilterChain chain) {
		request.setStr(request.getStr() + "->url");
		chain.doFilter(request, response);
		response.setStr(response.getStr() + "->url");
		return true;
	}
	
}