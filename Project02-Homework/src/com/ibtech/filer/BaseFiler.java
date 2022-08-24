package com.ibtech.filer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseFiler<T> {

	private String filePath;
	public final static String DELIMETER = ";";
	
	public BaseFiler(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void store(List<T> entityList) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
		for(T entity : entityList) {
			String line = format(entity);
			bw.write(line);
			bw.write("\r\n");
		}
		bw.close();
	}
	
	public List<T> load() throws IOException{
		List<T> entityList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = null;
		while( (line=br.readLine())!=null) {
			T entity = parse(line);
			entityList.add(entity);
		}
		br.close();
		return entityList;
	}
	
	abstract protected String format(T entity);
	abstract protected T parse(String line);
	
}
