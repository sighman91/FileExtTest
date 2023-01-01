package com.file.ext.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.file.ext.service.ExtService;

@Controller
public class ExtController {

	@Autowired
	ExtService extService;
	
	@ResponseBody
	@RequestMapping(value="/check.do", method = RequestMethod.GET)
	public List<Map<String, Object>> extCheck(HttpServletRequest request, HttpServletResponse response) {
		return extService.selectApplyExtList();
	}
	
	@ResponseBody
	@RequestMapping(value="/add.do", method = RequestMethod.POST)
	public String addExt(@RequestBody Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
		return extService.insertExt(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/toggle.do", method = RequestMethod.POST)
	public void toggleExt(@RequestBody Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
		extService.toggleExt(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/del.do", method = RequestMethod.POST)
	public void delExt(@RequestBody Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
		extService.deleteExt(map);
	}
}
