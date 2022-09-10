package com.godoro.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MyActorReflect {
	public static void main(String[] args) throws Exception {
		
		Class<?> clazz = Class.forName("com.godoro.source.MyActor");
		Constructor<?> constructor = clazz.getConstructor();
		Object object = constructor.newInstance();
		
		for(Method method : clazz.getDeclaredMethods()) {
			System.out.print(method.getReturnType().getName() + " ");
			System.out.print(method.getName() +" ");
			for(Parameter parameter : method.getParameters()) {
				System.out.println(parameter.getType() +" " + parameter.getName() +"," );
			}
			System.out.println();
		}
		
		Method processMethod = clazz.getMethod("process");
		processMethod.invoke(object);
		
		Class<?>[] parameterTypes = {int.class,String.class,double.class};
		Method transformMethod = clazz.getMethod("transform", parameterTypes);
		Object[] arguements = {123,"godoro",98.76};
		Object result = transformMethod.invoke(object, arguements);
		System.out.println("Sonuç " + result);
		
	}
}
