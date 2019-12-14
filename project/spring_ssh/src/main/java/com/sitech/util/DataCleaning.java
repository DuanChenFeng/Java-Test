package com.sitech.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
			if (str.indexOf(search) == 0) {
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
	public static void system_info() throws IOException{
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
			String[] split3 = split2[1].split(",  ");
			
			//split3[0]:15:49:50 up  4:54
			String[] split4 = split3[0].split(" ");
			String current_time = split4[0];			//当前系统时间
			
			String run_time = split4[3].trim();			//已运行时间
			
			//split3[1]:2 users
			String user_num = split3[1].substring(0, split3[1].indexOf(" "));	//获取用户数数据
			
			//split3[2]:load average: 0.00, 0.01, 0.05; 截取到最后一个数据
			String[] load_avg_split = split3[2].split(", ");
			String load_avg = load_avg_split[2].trim();	//平均负载（选择15分钟平均负载）
			
			result.append(current_time + "," + run_time + "," + user_num + "," + load_avg + "\n");
		}
		
		//将要写入的结果信息
		String res = result.toString();
		
		//写入文件路径
		String outpath = "src/main/data/system_info.txt";
		write_file(outpath, res);
		
		
	}
	
	//清洗出任务进程信息表的数据写入对应文件中
	public static void task_info() throws FileNotFoundException, IOException {
		//读取文件路径
		String inpath = "src/main/data/top.txt";
		String search = "Tasks: ";		//需要截取的指定信息
		//得到的数据样式：Tasks: 244 total,   1 running, 243 sleeping,   0 stopped,   0 zombie
		String info = search_res(inpath, search);	
		
		//对数据进行切分
		String[] split = info.split("\n");
		StringBuffer result = new StringBuffer();
		
		for (String s : split) {
			String[] split2 = s.split(", ");
			
			//split2[0]:Tasks: 244 total
			String task_total = split2[0].split(" ")[1].trim();
			
			//split2[1]:  1 running
			String task_run = split2[1].split(" ")[2].trim();
			
			//split2[2]:243 sleeping
			String task_sleep = split2[2].split(" ")[0].trim();
			
			//split2[3]:  0 stopped
			String task_stopped = split2[3].split(" ")[2].trim();
			
			//split2[4]:  0 zombie
			String task_zombie = split2[4].split(" ")[2].trim();
			
			result.append(task_total + "," + task_run + "," + task_sleep + 
					"," + task_stopped + "," + task_zombie + "\n");
		}
		
		//写入文件的内容
		String res = result.toString();
		
		String outpath = "src/main/data/task_info.txt";
		
		write_file(outpath, res);
		
	}
	
	//清洗出cpu状态信息表的数据写入对应文件中
	public static void cpu_info() throws FileNotFoundException, IOException {
		String inpath = "src/main/data/top.txt";
		String search = "%Cpu(s):  ";		//需要截取的指定信息
		
		//得到的数据样式：%Cpu(s):  2.9 us,  8.6 sy,  0.0 ni, 88.6 id,  0.0 wa,  0.0 hi,  0.0 si,  0.0 st
		String info = search_res(inpath, search);
		
		//对数据进行切分
		String[] split = info.split("\n");
		StringBuffer result = new StringBuffer();
		
		for (String s : split) {
			String[] split2 = s.split(",  ");
			
			//split[0]:%Cpu(s):  2.9 us
			String user_cpu = split2[0].split(" ")[2].trim();
			
			//split[1]:8.6 sy
			String sys_cpu = split2[1].split(" ")[0].trim();
			
			//split[2]:0.0 ni, 88.6 id
			String pro_cpu = split2[2].split(", ")[0].split(" ")[0].trim();
			
			String free_cpu = split2[2].split(", ")[1].split(" ")[0].trim();
			
			//split[3]:0.0 wa
			String wait_cpu = split2[3].split(" ")[0].trim();
			
			//split[4]:0.0 hi
			String hard_cpu = split2[4].split(" ")[0].trim();
			
			//split[5]:0.0 si
			String soft_cpu = split2[5].split(" ")[0].trim();
			
			//split[6]:0.0 st
			String stoken_cpu = split2[6].split(" ")[0].trim();
			
			result.append(user_cpu + "," + sys_cpu + "," + pro_cpu + "," + free_cpu + 
					"," + wait_cpu + "," + hard_cpu + "," + soft_cpu + "," + stoken_cpu + "\n");
		}
		
		//写入文件的内容
		String res = result.toString();
		
		String outpath = "src/main/data/cpu_info.txt";
		
		write_file(outpath, res);
	}
	
	//清洗出内存状态信息表的数据写入对应文件中
	public static void mem_info() throws FileNotFoundException, IOException {
		String inpath = "src/main/data/top.txt";
		String search = "KiB Mem :  ";
		
		String info = search_res(inpath, search);
		
		String[] split = info.split("\n");
		StringBuffer result = new StringBuffer();
		
		for (String s : split) {
			String[] split2 = s.split(",   ");
			
			//split2[0]:KiB Mem :  1867052 total
			String mem_total = split2[0].split(" ")[4].trim();
			
			//split2[1]:443848 free
			String mem_free = split2[1].split(" ")[0].trim();
			
			//split2[2]:734848 used
			String mem_used = split2[2].split(" ")[0].trim();
			
			//split2[3]:688356 buff/cache
			String mem_buff = split2[3].split(" ")[0].trim();
			
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
		String search = "KiB Swap:  ";
		
		String info = search_res(inpath, search);
		
		String[] split = info.split("\n");
		StringBuffer result = new StringBuffer();
		
		for (String s : split) {
			String[] split2 = s.split(",  ");
			
			//split2[0]:KiB Swap:  2097148 total
			String swap_total = split2[0].split(" ")[3].trim();
			swapInfo.setSwap_total(Integer.parseInt(swap_total));
			
			//split2[1]:2097148 free
			String swap_free = split2[1].split(" ")[0].trim();
			swapInfo.setSwap_free(Integer.parseInt(swap_free));
			
			//split2[2]:      0 used.   919256 avail Mem
			String swap_used = split2[2].split(" ")[6].trim();
			swapInfo.setSwap_used(Integer.parseInt(swap_used));
			
			String swap_buff = split2[2].split(" ")[10].trim();
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
	
	
}
