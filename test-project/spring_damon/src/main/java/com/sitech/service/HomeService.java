package com.sitech.service;

import java.util.List;

import com.sitech.entity.CpuInfo;
import com.sitech.entity.DnInfo;
import com.sitech.entity.SystemInfo;
import com.sitech.entity.UnameInfo;

/**
*@author 段道博
*@date 2019年12月14日下午1:35:03
*
*/
public interface HomeService {
	SystemInfo getSysInfo();
	
	CpuInfo getCpuInfo();
	
	UnameInfo getUnameInfo();
	
	List<DnInfo> getDnInfo();
	
	DnInfo getInfoById(Integer id);

}
