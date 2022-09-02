package com.godoro.client;

import com.godoro.utils.StreamUtilities;

public class PostClient {
	public static void main(String[] args) throws Exception {
		String address = "http://localhost:8080/Project04/post";
		String input =StreamUtilities.post(address,"Giden");
		
		System.out.println("Girdi:\r\n"+input);
	}

	
}
