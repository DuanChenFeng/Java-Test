package com.sitech.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import com.sitech.entity.SwapInfo;

/**
*@author 段道博
*@date 2019年12月12日下午12:58:04
*
*/
public class DataCleaning {
	
	//截取指定的文件内容中的指定数据
	private static String search_res(String path, String search) 
			throws FileNotFoundException, IOException {
		//读取文件路径
		File file = new File(path);

		FileReader fr = new FileReader(file);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		String str = "";
		StringBuffer sb = new StringBuffer();
		
		//截取指定的信息数据
		while((str = br.readLine()) != null) {
			if (str.indexOf(search) >= 0) {
				sb.append(str + "\n");
			}
		}
		return sb.toString();
	}
	
	//将文件流内容写入文件中
	public static void write_file(String path, String info) throws IOException {
		//path：写入文件路径； info：写入的内容
		File outfile = new File(path);
		FileWriter fw = new FileWriter(outfile);
		fw.write(info.toString());
		fw.close();
	}
	
	//清洗出系统信息表的数据写入对应文件中
	public static void system_info() throws IOException, SQLException{
		//读入文件路径
		String inpath = "src\\main\\data\\top.txt";
		String search = "top - ";	//要截取的数据
		
		//得到的数据样式：top - 15:49:50 up  4:54,  2 users,  load average: 0.00, 0.01, 0.05
		String info = search_res(inpath, search);
		
		//对数据进行切分
		String[] split = info.split("\n");	//按数据一条条切分
		StringBuffer result = new StringBuffer();
		for (String s : split) {
			String[] split2 = s.split("top - ");	//去除字符串首部的 top -
			//去掉字符中所有空格
			
			String[] split3 = split2[1].split(",");
			
			//split3[0]:15:49:50 up  4:54;
			//若运行时间小于1小时，数据：10:44:05 up 18 min
			String current_time = "";						//当前系统时间
			String run_time = "";							//已运行时间
			
			if (split3[0].indexOf("min") == 0) {
				String[] split4 = split3[0].split("up");
				current_time = split4[0].trim();			//当前系统时间
				
				run_time = split4[1].trim();				//已运行时间
			}else {
				String[] split4 = split3[0].split("up|min");
				
				current_time = split4[0].trim();		//当前系统时间
				
				run_time = split4[1].trim();			//已运行时间
			}
			
			//split3[1]:  2 users
			String user_num = split3[1].trim().split(" ")[0];	//获取用户数数据
			
			String load_avg = split3[4].trim();	//平均负载（选择15分钟平均负载）
			
			result.append(current_time + "," + run_time + "," + user_num + "," + load_avg + "\n");
			
		}
		
		//将要写入的结果信息
		String res = result.toString();
		
		InsertData.insert_sys_data(res);
		
	}
	
	//清洗出任务进程信息表的数据写入对应文件中
	public static void task_info() throws FileNotFoundException, IOException {
		//读取文件路径
		String inpath = "src/main/data/top.txt";
		String search = "Tasks:";		//需要截取的指定信息
		//得到的数据样式：Tasks: 244 total,   1 running, 243 sleeping,   0 stopped,   0 zombie
		String info = search_res(inpath, search);	
		
		//对数据进行切分
		String[] split = info.split("\n");
		StringBuffer result = new StringBuffer();
		
		for (String s : split) {
			String[] split2 = s.split(",");
			
			//split2[0]:Tasks: 244 total
			String task_total = split2[0].split(" ")[1].trim();
			
			//split2[1]:  1 running
			String task_run = split2[1].trim().split(" ")[0].trim();
			
			//split2[2]:243 sleeping
			String task_sleep = split2[2].trim().split(" ")[0].trim();
			
			//split2[3]:  0 stopped
			String task_stopped = split2[3].trim().split(" ")[0].trim();
			
			//split2[4]:  0 zombie
			String task_zombie = split2[4].trim().split(" ")[0].trim();
			
			result.append(task_total + "," + task_run + "," + task_sleep + 
					"," + task_stopped + "," + task_zombie + "\n");
		}
		
		//写入文件的内容
		String res = result.toString();
		
		String outpath = "src/main/data/task_info.txt";
		
		write_file(outpath, res);
		
	}
	
	//清洗出cpu状态信息表的数据写入对应文件中
	public static void cpu_info() throws FileNotFoundException, IOException, SQLException {
		String inpath = "src/main/data/top.txt";
		String search = "%Cpu(s):";		//需要截取的指定信息
		
		
		//得到的数据样式：%Cpu(s):  2.9 us,  8.6 sy,  0.0 ni, 88.6 id,  0.0 wa,  0.0 hi,  0.0 si,  0.0 st
		//得到的数据样式：%Cpu(s): 42.4 us, 39.4 sy,  0.0 ni, 15.2 id,  0.0 wa,  0.0 hi,  3.0 si,  0.0 st
		//得到的数据样式：%Cpu(s): 39.4 us, 54.5 sy,  0.0 ni,  6.1 id,  0.0 wa,  0.0 hi,  0.0 si,  0.0 st
		String info = search_res(inpath, search);
		
		//对数据进行切分
		String[] split = info.split("\n");
		StringBuffer result = new StringBuffer();
		
		for (String s : split) {
			
			String[] split2 = s.split(",");

			//split[0]:%Cpu(s):  2.9 us
			String user_cpu = split2[0].split("\\s+")[1].trim();
			
			//split[1]: 54.5 sy
			String sys_cpu = split2[1].trim().split(" ")[0].trim();
			
			//split[2]:  0.0 ni
			String pro_cpu = split2[2].trim().split(" ")[0].trim();
			
			//split[3]:  6.1 id
			String free_cpu = split2[3].trim().split(" ")[0].trim();
			
			//split[4]:  0.0 wa
			String wait_cpu = split2[4].trim().split(" ")[0].trim();
			
			//split[5]:0.0 hi
			String hard_cpu = split2[5].trim().split(" ")[0].trim();
			
			//split[6]:0.0 si
			String soft_cpu = split2[6].trim().split(" ")[0].trim();
			
			//split[7]:0.0 st
			String stoken_cpu = split2[7].trim().split(" ")[0].trim();
			
			result.append(user_cpu + "," + sys_cpu + "," + pro_cpu + "," + free_cpu + 
					"," + wait_cpu + "," + hard_cpu + "," + soft_cpu + "," + stoken_cpu + "\n");
		}
		
		//写入文件的内容
		String res = result.toString();
		
		InsertData.insert_cpu_data(res);
	}
	
	//清洗出内存状态信息表的数据写入对应文件中
	public static void mem_info() throws FileNotFoundException, IOException {
		String inpath = "src/main/data/top.txt";
		String search = "KiB Mem :";
		
		String info = search_res(inpath, search);
		
		String[] split = info.split("\n");
		StringBuffer result = new StringBuffer();
		
		//数据格式：KiB Mem :  1867052 total,   844348 free,   385096 used,   637608 buff/cache
		for (String s : split) {
			String[] split2 = s.split(",");
			
			//去掉search内容/split2[0]:KiB Mem :  1867052 total
			String mem_total = split2[0].split(":")[1].trim().split(" ")[0].trim();
			
			//split2[1]:   443848 free
			String mem_free = split2[1].trim().split(" ")[0].trim();
			
			//split2[2]:   734848 used
			String mem_used = split2[2].trim().split(" ")[0].trim();
			
			//split2[3]:   688356 buff/cache
			String mem_buff = split2[3].trim().split(" ")[0].trim();
			
			result.append(mem_total + "," + mem_free + "," + mem_used + "," + mem_buff + "\n");
			
		}
		
		String res = result.toString();
		
		String outpath = "src/main/data/mem_info.txt";
		
		write_file(outpath, res);
		
	}

	//清洗出交换分区信息表的数据写入对应文件中
	public static void swap_info() throws FileNotFoundException, IOException {
		SwapInfo swapInfo = new SwapInfo();
		
		String inpath = "src/main/data/top.txt";
		String search = "KiB Swap:";
		
		String info = search_res(inpath, search);
		
		String[] split = info.split("\n");
		StringBuffer result = new StringBuffer();
		
		//数据格式：KiB Swap:  2097148 total,  2097148 free,        0 used.  1272024 avail Mem
		for (String s : split) {
			String[] split2 = s.split(",");
			
			//split2[0]:KiB Swap:  2097148 total
			String swap_total = split2[0].split(":")[1].trim().split(" ")[0].trim();
			swapInfo.setSwap_total(Integer.parseInt(swap_total));
			
			//split2[1]:  2097148 free
			String swap_free = split2[1].trim().split(" ")[0].trim();
			swapInfo.setSwap_free(Integer.parseInt(swap_free));
			
			//split2[2]:        0 used.  1321276 avail Mem
			String swap_used = split2[2].split("\\.")[0].trim().split(" ")[0].trim();
			swapInfo.setSwap_used(Integer.parseInt(swap_used));
			
			String swap_buff = split2[2].split("\\.")[1].trim().split(" ")[0].trim();
			swapInfo.setSwap_buff(Integer.parseInt(swap_buff));

			result.append(swap_total + "," + swap_free + "," + swap_used + "," + swap_buff + "\n");
			
		}
		
		String res = result.toString();
		
		String outpath = "src/main/data/swap_info.txt";
		
		write_file(outpath, res);
	}
	
	//清洗出磁盘空间占用情况信息表的数据写入对应文件中
	public static void disk_info() throws IOException {
		
		String inpath = "src/main/data/df.txt";
		
		File infile = new File(inpath);
		
		FileReader fr = new FileReader(infile);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		String str = "";
		int num = 0;
		StringBuffer result = new StringBuffer();
		
		while((str = br.readLine()) != null) {
			if (num != 0) {
				result.append(str + "\n");
			}
			num++;
		}
		
		String res = result.toString();
		
		String outpath = "src/main/data/disk_info.txt";
		
		write_file(outpath, res);
		
	}
	
	//清洗出当前系统参数信息表的数据写入对应文件中
	public static void uname_info() throws FileNotFoundException, IOException {
		String inpath = "src/main/data/uname.txt";
		String search = "Linux";
		
		String info = search_res(inpath, search);
		
		String[] split = info.split(" ");
		StringBuffer result = new StringBuffer();
		String kernel_version = "";
		
		for (int i=0; i<split.length; i++) {
			
			if (i>=3 && i<=10) {
				kernel_version += split[i];
			}
			
			if ((i < 3 || i > 10) && i < split.length-1 && i != 11) {
				result.append(split[i] + ",");
			}
			
			if (i == 11) {
				result.append(kernel_version + ",");
			}
			
			if (i == split.length -1) {
				result.append(split[i]);
			}
			
		}
		
		String res = result.toString();
		
		String outpath = "src/main/data/uname_info.txt";
		
		write_file(outpath, res);
		
	}
	
	//清洗出hadoop集群数据节点状态信息数据写入对应文件中
	public static void dn_info() throws FileNotFoundException, IOException, SQLException {
		//读入文件路径
		String inpath = "src\\main\\data\\dn.txt";
		String search = "Jan";
		
		String info = search_res(inpath, search);
		
		//数据格式： 192.168.47.131  dn01         Normal    140.91 GB
		//378.99 MB  32.93 GB   107.61 GB   0.26%     Dec 31 17:05
		
		//对数据进行切分
		String[] split = info.split("\n");	//按数据一条条切分
		StringBuffer result = new StringBuffer();
		
		for (String dnInfo : split) {
			//将数据按照空格字符划分为九个部分
			String[] split2 = dnInfo.split("\\s+");
			
			String node_ip = split2[1].trim();
			
			String host_name = split2[2].trim();
			
			String node_status = split2[3].trim();
			
			String node_capacity = split2[4].trim();
			
			String dfs_used = split2[6].trim();
			
			String non_dfs = split2[8].trim();
			
			String dfs_remain = split2[10].trim();
			
			String dfs_used_pro = split2[12].trim();
			
			String contact_time = split2[15].trim();
			
			result.append(node_ip + "," + host_name + "," + node_status + "," +
						node_capacity + "," + dfs_used + "," + non_dfs + "," +
						dfs_remain + "," + dfs_used_pro + "," + contact_time + "\n");
		}
		
		//将要写入的结果信息
		String res = result.toString();
		
		InsertData.insert_dn_data(res);

	}
}
