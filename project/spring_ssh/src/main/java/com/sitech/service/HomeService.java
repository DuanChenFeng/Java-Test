package com.sitech.service;

import com.sitech.entity.CpuInfo;
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

}
