package com.ibtech.console;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract public class BaseFiler<E> {
	
	protected String filePath;
	public final static String DELIMETER = ";";
	
	public BaseFiler(String filePath) {
		this.filePath = filePath;
	}
	
	public void store(List<E> entityList) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
		for(E entity : entityList) {
			String line = format(entity);
			bw.write(line);
			bw.write("\r\n");
		}
		bw.close();
	}
	
	public List<E> load() throws IOException{
		List<E> entityList = new ArrayList<>();
		String line = null;
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		while( (line = br.readLine()) != null) {
			E entity = parse(line);
			entityList.add(entity);
		}
		br.close();
		return entityList;
	}
	
	abstract protected E parse(String line);
	abstract protected String format(E entity);

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
