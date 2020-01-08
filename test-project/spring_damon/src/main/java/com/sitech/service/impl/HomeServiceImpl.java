package com.sitech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitech.entity.CpuInfo;
import com.sitech.entity.DnInfo;
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
	
	public SystemInfo getSysInfo() {
		return homeMapper.getSysInfo();
	}

	public CpuInfo getCpuInfo() {
		return homeMapper.getCpuInfo();
	}

	public UnameInfo getUnameInfo() {
		return homeMapper.getUnameInfo();
	}

	public List<DnInfo> getDnInfo() {
		return homeMapper.getDnInfo();
	}

	public DnInfo getInfoById(Integer id) {
		return homeMapper.getInfoById(id);
	}

	
}
