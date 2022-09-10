package com.godoro.library;

import java.lang.reflect.Method;

public class ReflectorTest {
	public static void main(String[] args) throws Exception {
		
		String className = "com.godoro.source.MyBean";
		ClassReflector classReflector = new ClassReflector(className);
		Object object = classReflector.newInstance();
		
		classReflector.setValue(object, "myId", 123);
		System.out.println("Özdeşliğim: "+classReflector.getValue(object, "myId"));
		
		classReflector.setValue(object, "myName","Godoro");
		System.out.println("Adım: "+classReflector.getValue(object, "myName"));
		
		classReflector.setValue(object, "myValue", 98.76);
		System.out.println("Değerim: "+classReflector.getValue(object, "myValue"));
	}
}
