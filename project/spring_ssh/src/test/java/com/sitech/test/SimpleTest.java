package com.sitech.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import com.sitech.entity.SystemInfo;
import com.sitech.util.InsertData;

/**
*@author 段道博
*@date 2019年12月13日下午1:29:57
*
*/
public class SimpleTest {
	@Test
	public void entity_test() {
		SystemInfo systemInfo = new SystemInfo();
		String res = systemInfo.toString();
		String current_time = systemInfo.getCurrent_time();
		System.out.println(current_time);
		
		System.out.println(res);
	}
	
	@Test
	public void disk_test() throws IOException {
		FileReader fr = new FileReader(new File("src/main/data/disk_info.txt"));
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		StringBuffer sb = new StringBuffer();
		
		String str = "";
		while((str = br.readLine()) != null) {
			String res = str.replace("\t", ",");
			sb.append(res + "\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	@Test
	public void inser_sys() throws IOException, SQLException {
		InsertData.insert_sys_data();
	}
	
	@Test
	public void inset_cpu() throws IOException, SQLException {
		InsertData.insert_cpu_data();
	}
	
	
	@Test
	public void get_sys_data() throws IOException {
//		SystemInfo systemInfo = new SystemInfo();
		
		String path = "src/main/data/system_info.txt";
		String data = InsertData.read_file(path);
		System.out.println(data);
		String[] split = data.split(",");
		
		for (String string : split) {
			System.out.println(string);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
