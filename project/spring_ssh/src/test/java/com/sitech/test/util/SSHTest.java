package com.sitech.test.util;

import org.junit.Test;

import com.sitech.cache.ssh2.SSH2Util;
import com.sitech.entity.ConnInfo;

/**
*@author 段道博
*@date 2019年12月11日上午11:02:00
*
*/
public class SSHTest {
	
	//对服务器连接进行测试，并将执行的命令返回结果打印至控制
	@Test
	public void testDemo1() {
		ConnInfo connInfo = new ConnInfo();
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
		}
	}
	
	//测试top命令打印的信息
	@Test
	public void testDemo2() {
		ConnInfo connInfo = new ConnInfo();
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
		}
	}

}
