package com.file.ext.service;

import java.util.List;
import java.util.Map;

public interface ExtService {
	public List<Map<String, Object>> selectApplyExtList();
	
	public String insertExt(Map<String, Object> paramMap);
	
	public void toggleExt(Map<String, Object> paramMap);
	
	public void deleteExt(Map<String, Object> paramMap);
}
