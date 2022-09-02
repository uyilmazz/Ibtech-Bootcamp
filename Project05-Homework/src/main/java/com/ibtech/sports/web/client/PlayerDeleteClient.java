package com.ibtech.sports.web.client;

import java.io.IOException;
import java.net.URLConnection;

import com.ibtech.core.utils.StreamHelper;
import com.ibtech.core.utils.WebHelper;

public class PlayerDeleteClient {

	public static void main(String[] args) {
		try {
			long playerId = 14;
			String address = String.format("http://localhost:8080/Project05-Homework/player/delete?playerId=%d",playerId);
			URLConnection connection = WebHelper.connect(address);
			String result = StreamHelper.read(connection.getInputStream());
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
