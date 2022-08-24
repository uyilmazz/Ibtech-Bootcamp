package com.godoro.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String,String> countryMap = new HashMap<>();
		countryMap.put("tr", "Türkiye");
		countryMap.put("ru", "Rusya");
		countryMap.put("tm", "Türkmenistan");
		countryMap.put("az", "Azerbaycan");
		countryMap.put("kr", "Kırgızistan");
		countryMap.put("kk", "Kazakistan");
		countryMap.put("uz", "Özbekistan");
		
		for (String country : countryMap.values()) {
			System.out.println("# " + country);
		}
		
		for (String code : countryMap.keySet()) {
			String country = countryMap.get(code);
			System.out.println(code + " : " + country);
		}
	}
}
