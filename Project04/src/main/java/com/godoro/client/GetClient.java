package com.godoro.client;

import static com.godoro.utils.StreamUtilities.*;

public class GetClient {
	
	public static void main(String[] args) throws Exception {
		
		String address = "http://localhost:8080/Project04/get";
		String text = get(address);
		System.out.println("İçerik:\r\n"+text);
	}
}
