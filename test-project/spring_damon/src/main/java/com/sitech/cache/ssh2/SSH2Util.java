package com.sitech.cache.ssh2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.sitech.entity.ConnInfo;
import com.sitech.util.DataCleaning;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

/**
*@author 段道博
*@date 2019年12月11日上午9:48:22
*@Description	连接Linux服务器并执行相关Shell命令
*/
public class SSH2Util {
	private static final Logger logger = Logger.getLogger(SSH2Util.class);
	
	private static String DEFAULTCHARTSET = "UTF-8";
	
	private static Connection conn;
	
	private static final int TIME_OUT = 1000 * 5 * 60;	
	/**
     * 
     * @Title: login  
     * @Description: 用户名密码方式  远程登录linux服务器
     * @return: Boolean     
     * @throws
     */
	public static Boolean login(ConnInfo connInfo) {
		boolean flag = false;
		try {
			conn = new Connection(connInfo.getIp(), connInfo.getPort());
			conn.connect();
			//连接服务器时的登录验证
			flag = conn.authenticateWithPassword(connInfo.getUsername(), connInfo.getPassword());
			if (flag == true) {
				logger.info("认证登录成功！");
			}else {
				logger.info("认证登录失败！");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
     * 
     * @Title: execute  
     * @Description: 远程执行shll脚本或者命令
     * @param cmd 脚本命令
     * @return: result 命令执行完毕返回结果     
     * @throws
     */
	public static String execute(String cmd) {
		String res = "";
		try {
			//打开一个会话
			Session session = conn.openSession();
			session.execCommand(cmd, DEFAULTCHARTSET);
			res = processStdout(session.getStdout(), DEFAULTCHARTSET);
			session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
			
			/*session.close();
			conn.close();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	 /**
     * 
	 * @Title: processStdout
	 * @Description: 解析脚本执行的返回结果
	 * @param in 输入流对象
	 * @param charset 编码
	 * @return String 以纯文本的格式返回
	 * @throws
     */
	public static String processStdout(InputStream in, String chartset) {
		InputStream stdout = new StreamGobbler(in);
		StringBuffer sb = new StringBuffer();
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new InputStreamReader(stdout, chartset));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	/**
     * 
    * @Title: scpGet
    * @Description: 从其他服务器获取文件到本服务器指定目录
    * @param host ip(其他服务器)
    * @param username 用户名(其他服务器)
    * @param password 密码(其他服务器)
    * @param remoteFile 文件位置(其他服务器)
    * @param localDir 本服务器目录
    * @throws IOException
    * @return void
    * @throws
     */
	public static void scpGet(String ip, String username, String password, 
			String remoteFile, String localDir)
			throws IOException {
		
		logger.info("ConnectLinuxCommand  scpGet===" + "ip:" + ip 
				+ "  username:" + username + "  remoteFile:"
				+ remoteFile + "  localDir:" + localDir);
		ConnInfo connInfo = new ConnInfo();
		connInfo.setIp(ip);
		connInfo.setUsername(username);
		connInfo.setPassword(password);
		if (login(connInfo)) {
			SCPClient client = new SCPClient(conn);
			client.get(remoteFile);
			conn.close();
		}
	}
	
	/**
	 * 
	* @Title: scpPut
	* @Description: 将文件复制到其他计算机中
	* @param host 
	* @param username
	* @param password
	* @param localFile
	* @param remoteDir
	* @throws IOException
	* @return void
	* @throws
	 */
	public static void scpPut(String ip, String username, String password, 
			String localFile, String remoteDir)
			throws IOException {
		logger.info("ConnectLinuxCommand  scpPut===" + "ip:" + ip + "  userName:" + username + "  localFile:"
				+ localFile + "  remoteDir:" + remoteDir);
 
		ConnInfo connInfo = new ConnInfo();
		connInfo.setIp(ip);
		connInfo.setUsername(username);
		connInfo.setPassword(password);
		if (login(connInfo)) {
			SCPClient client = new SCPClient(conn);
			client.put(localFile, 0L, remoteDir, "0600");
			conn.close();
		}
	}
	
	public static void main(String[] args) throws IOException, SQLException {
		ConnInfo connInfo = new ConnInfo();
		
		//插入连接信息
		connInfo.setIp("192.168.47.133");
		
		connInfo.setPort(22);
		
		connInfo.setUsername("e3base");
		
		connInfo.setPassword("18879230602duan");
		
		//执行的shell命令
		String out_top = "src\\main\\data\\top.txt";
		String cmd_top = "cd ~; cat top";
		
		String out_df = "src\\main\\data\\df.txt";
		String cmd_df = "cd ~; cat df";
		
		String out_uname = "src\\main\\data\\uname.txt";
		String cmd_uname = "cd ~; uname -a";
		
		
		Boolean login = SSH2Util.login(connInfo);
		
		//若登录成功，则将执行命令返回的数据写入对应的本地文件中
		if (login == true) {
			
			String res_top = SSH2Util.execute(cmd_top);
			
			System.out.println(res_top);
			
			DataCleaning.write_file(out_top, res_top);
			
			String res_df = SSH2Util.execute(cmd_df);
			
			System.out.println(res_df);
			
			DataCleaning.write_file(out_df, res_df);
			
			String res_uname = SSH2Util.execute(cmd_uname);
			
			System.out.println(res_uname);
			
			DataCleaning.write_file(out_uname, res_uname);
			
		}else {
			System.out.println("ERROR!!!");
		}
		
		//对得到的数据进行提取并存入对应的文件中
		DataCleaning.system_info();
		
		DataCleaning.task_info();
		
		DataCleaning.cpu_info();
		
		DataCleaning.mem_info();
		
		DataCleaning.swap_info();
		
		DataCleaning.disk_info();
		
		DataCleaning.uname_info();
	}
}
