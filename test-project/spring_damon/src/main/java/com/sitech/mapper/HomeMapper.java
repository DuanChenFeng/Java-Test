package com.sitech.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sitech.entity.CpuInfo;
import com.sitech.entity.DnInfo;
import com.sitech.entity.SystemInfo;
import com.sitech.entity.UnameInfo;

/**
*@author 段道博
*@date 2019年12月14日下午1:24:52
*
*/
@Mapper
public interface HomeMapper {
	@Select("select * from system_info order by id desc limit 1")
	SystemInfo getSysInfo();
	
	//查询最后一行数据
	@Select("select user_cpu,sys_cpu,pro_cpu,free_cpu,wait_cpu,hard_cpu,soft_cpu,stoken_cpu"
			+ " from cpu_info order by id desc limit 1")
	CpuInfo getCpuInfo();
	
	@Select("select * from uname_info order by id desc limit 1")
	UnameInfo getUnameInfo();
	
	//展示datanode数据节点数据
	@Select("select id,node_ip,host_name,node_status,dfs_used_pro,contact_time "
			+ "from dn_info order by id desc limit 2")
	List<DnInfo> getDnInfo();
	
	@Select("select node_capacity,dfs_used,non_dfs,"
			+ "dfs_remain from dn_info where id=#{id} ")
	DnInfo getInfoById(Integer id);
	
	
}
