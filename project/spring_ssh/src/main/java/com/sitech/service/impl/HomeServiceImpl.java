package com.sitech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitech.entity.CpuInfo;
import com.sitech.entity.SystemInfo;
import com.sitech.entity.UnameInfo;
import com.sitech.mapper.HomeMapper;
import com.sitech.service.HomeService;

/**
*@author 段道博
*@date 2019年12月14日下午1:35:42
*
*/
@Service
public class HomeServiceImpl implements HomeService{
	@Autowired
	private HomeMapper homeMapper;
	
	@Override
	public SystemInfo getSysInfo() {
		return homeMapper.getSysInfo();
	}

	@Override
	public CpuInfo getCpuInfo() {
		return homeMapper.getCpuInfo();
	}

	@Override
	public UnameInfo getUnameInfo() {
		return homeMapper.getUnameInfo();
	}

	
}
