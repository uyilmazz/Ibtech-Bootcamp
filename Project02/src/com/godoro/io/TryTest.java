package com.godoro.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TryTest {

public static void main(String[] args) {
		
		String path = "C:\\Users\\Unal\\Desktop\\java\\Ibtech\\out.txt";
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter(path));
			bw.write("Java\r\n");
			bw.write("JDBC\r\n");
			bw.write("JAXP\r\n");
			bw.write("JSON-P\r\n");
			bw.write("JSON");
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(bw != null) {
					bw.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
