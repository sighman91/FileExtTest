package com.file.ext.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.file.ext.dao.ExtDao;
import com.file.ext.service.ExtService;

@Service
public class ExtServiceImpl implements ExtService {
	@Autowired
	ExtDao extDao;
	
	/**
	 * Ȯ���� ��� ��ȸ
	 */
	@Override
	public List<Map<String, Object>> selectApplyExtList() {
		return extDao.selectApplyExt();
	}
	
	/**
	 * Ȯ���� �ߺ��˻� �� ���
	 */
	@Override
	public String insertExt(Map<String, Object> paramMap) {
		Map<String, String> isDupl = extDao.selectDuplExt(paramMap);
		
		if(isDupl.get("DUPL_YN").equals("Y")) {
			return "FAIL";
		} else {
			extDao.insertExt(paramMap);
		}
		
		return "OK";
	}
	
	@Override
	public void toggleExt(Map<String, Object> paramMap) {
		extDao.toggleExt(paramMap);
	}
	
	@Override
	public void deleteExt(Map<String, Object> paramMap) {
		extDao.deleteExt(paramMap);
	}
}
