package com.sitech.test.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

/**
*@author 段道博
*@date 2019年12月11日上午11:02:00
*
*/
public class SSHTest {
	
	//对服务器连接进行测试，并将执行的命令返回结果打印至控制
	@Test
	public void testDemo1() {
		/*ConnInfo connInfo = new ConnInfo();
		connInfo.setIp("192.168.47.133");
		connInfo.setPort(22);
		connInfo.setUsername("e3base");
		connInfo.setPassword("18879230602duan");
		Boolean login = SSH2Util.login(connInfo);
		if (login == true) {
			String cmd = "cd /home/e3base/software;cat student.txt";
			String res = SSH2Util.execute(cmd);
			System.out.println(res);
		}else {
			System.out.println("ERROR!!!");
		}*/
	}
	
	//测试top命令打印的信息
	@Test
	public void testDemo2() {
		/*ConnInfo connInfo = new ConnInfo();
		connInfo.setIp("192.168.47.133");
		connInfo.setPort(22);
		connInfo.setUsername("e3base");
		connInfo.setPassword("18879230602duan");
		Boolean login = SSH2Util.login(connInfo);
		if (login == true) {
			String cmd = "top";
			String res = SSH2Util.execute(cmd);
			System.out.println(res);
		}else {
			System.out.println("ERROR!!!");
		}*/
	}
	
	@Test
	public void testMin() throws IOException, SQLException {
//		DataCleaning.system_info();
		
//		DataCleaning.task_info();
		
//		DataCleaning.cpu_info();
		
//		DataCleaning.mem_info();
		
//		DataCleaning.swap_info();
		
//		DataCleaning.dn_info();
		
		/*String t = "10:44:05     up 18 min";
		
		String[] res = t.split("up|min");
		for (String string : res) {
			System.out.println(string);
		}*/
	}
	
	@Test 
	public void testCpu() throws FileNotFoundException, IOException, SQLException {
//		DataCleaning.cpu_info();
	}
	
	
	@Test
	public void testSwap() throws FileNotFoundException, IOException {
//		DataCleaning.swap_info();
	}
}
