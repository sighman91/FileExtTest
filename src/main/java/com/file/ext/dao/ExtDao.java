package com.file.ext.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExtDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String, Object>> selectApplyExt() {
		return this.sqlSessionTemplate.selectList("fileExt.selectApplyFileExtList", null);
	}
	
	public Map<String, String> selectDuplExt(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("fileExt.selectDuplExt", map);
	}
	
	public void insertExt(Map<String, Object> map) {
		this.sqlSessionTemplate.insert("fileExt.insertExt", map);
	}
	
	public void toggleExt(Map<String, Object> map) {
		this.sqlSessionTemplate.insert("fileExt.toggleExt", map);
	}
	
	public void deleteExt(Map<String, Object> map) {
		this.sqlSessionTemplate.delete("fileExt.deleteExt", map);
	}
}
