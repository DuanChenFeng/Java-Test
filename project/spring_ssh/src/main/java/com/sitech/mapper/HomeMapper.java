package com.sitech.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sitech.entity.CpuInfo;
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
	@Select("select * from cpu_info order by id desc limit 1")
	CpuInfo getCpuInfo();
	
	@Select("select * from uname_info order by id desc limit 1")
	UnameInfo getUnameInfo();
	
	
}
