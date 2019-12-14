package com.sitech.cache;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

/**
*@author 段道博
*@date 2019年12月6日下午2:27:10
*@since 连接RedHat7.4并返回结果
*/
public class SSHUtil {
	
	/**主机地址*/
	private static String host="192.168.47.133";
	/**连接端口*/
	private static int port = 22;
	/**登入用户*/
	private static String userName="e3base";
	/**登入密码*/
	private static String userPass="18879230602duan";
	/**执行的命令*/
	private static String cmd = "uname -a";
	
	public static void main(String[] args) throws IOException, Exception {
		Connection conn = new Connection(host,port);
		conn.connect();
		
		//身份验证
		boolean login = conn.authenticateWithPassword(userName,userPass);
		if (!login) {
			System.out.println("登入结果:"+login);
			return;
		}
		
		System.out.println("登入成功。。。");
		
		//获取会话
		Session session = conn.openSession();
		
		//执行命令
		session.execCommand(cmd);
		Thread.sleep(3000);
		
		//拿到执行结果
		InputStream stdout = session.getStdout();
		InputStreamReader reader = new InputStreamReader(stdout);
		BufferedReader bufferedReader = new BufferedReader(reader);
		StringBuffer sb = new StringBuffer();
		String line = null;
		while((line = bufferedReader.readLine()) != null) {
			sb.append(line + "\n");
		}
		String res = sb.toString();
		System.out.println("Result : "+sb.toString());
		
		//将结果写入文件中
		String path = "src\\main\\data\\uname.txt";
		File file = new File(path);
		FileOutputStream fos = new FileOutputStream(file);
		byte[] bytes = res.getBytes();
		fos.write(bytes);
		fos.close();
		
		//退出工作
		stdout.close();
		reader.close();
		bufferedReader.close();
		session.getExitSignal();
		session.close();
		conn.close();
		System.out.println("Exit");
	
	}
}
