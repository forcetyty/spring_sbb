package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class HelloLombok2 {
	
	// @RequerdArgsConstructor 를 활용한 생성자 생
	private final String hello;
	private final int lombok;
	
	public static void main(String[] args) {
		HelloLombok2 helloLombok2 = new HelloLombok2("헬로", 5);
		
		System.out.println(helloLombok2.getHello());
		System.out.println(helloLombok2.getLombok());
	}
	
	/*
	// 생성자 생성을 통한 접근 방
	public HelloLombok(String hello, int lombok) {
		this.hello = hello;
		this.lombok = lombok;
	}
	*/

}
