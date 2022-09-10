package com.godoro.library;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ClassReflector {
	private Class<?> type;
	private Constructor<?> constructor;
	private Map<String,PropertyReflector> properties = new HashMap<>();
	
	public ClassReflector(Class<?> type) throws NoSuchMethodException, SecurityException {
		setType(type);
	}
	
	public ClassReflector(String className) throws Exception {
		setType(Class.forName(className));
	}
	
	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) throws NoSuchMethodException, SecurityException {
		this.type = type;
		constructor = type.getConstructor();
		findProperties();
	}
	
	private void findProperties() throws NoSuchMethodException, SecurityException {
		for(Method method : type.getDeclaredMethods()) {
			if(method.getName().startsWith("get") && method.getParameterCount() == 0) {			
				String sub = method.getName().substring(3);
				String property = Character.toLowerCase(sub.charAt(0)) + sub.substring(1);
				String title = Character.toUpperCase(property.charAt(0)) + property.substring(1);
				String get = "get" + title;
				Method getter = type.getMethod(get);
				String set = "set" + title;
				Class<?> parameterTypes[] = {getter.getReturnType()};
				Method setter = type.getMethod(set, parameterTypes);
				PropertyReflector propertyReflector = new PropertyReflector(this, set, getter, setter);
				properties.put(property, propertyReflector);
			}
		}
	}
	
	public Map<String, PropertyReflector> getProperties() {
		return properties;
	}
	
	public PropertyReflector getPropertyReflectory(String propertyName) {
		return properties.get(propertyName);
	}
	
	public Object newInstance() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return constructor.newInstance();
	}
	
	public void setValue(Object object,String property,Object value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		PropertyReflector propertyReflectory = getPropertyReflectory(property);
		Method setter = propertyReflectory.getSetter();
		Object arguments[] = {98.76};
		setter.invoke(object, arguments);
	}

	public Object getValue(Object object,String property) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		PropertyReflector propertyReflectory = getPropertyReflectory(property);
		Method getter = propertyReflectory.getGetter();
		Object result = getter.invoke(object);
		return result;
	}
}