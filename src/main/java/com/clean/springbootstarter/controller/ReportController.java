package com.clean.springbootstarter.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clean.springbootstarter.beans.Complaint;
import com.clean.springbootstarter.services.CleanCityService;

@Controller
public class ReportController {

	@Autowired
	CleanCityService cleanCityService;

	@RequestMapping("/user/reportDashboard")
	public String report(Model model) {
		return "reportDashboard";
	} 
	
	@GetMapping("/user/getComplaintList")
	@ResponseBody
	public String getComplaintList(@RequestParam(name = "pin", required = false) String pin,
			@RequestParam(name = "start_date", required = false )String start_date,
			@RequestParam(name = "end_date", required = false)String end_date) {
		List<Complaint> complaints =cleanCityService.fetchAllComplaints(pin,start_date,end_date);
		ObjectMapper Obj = new ObjectMapper(); 
		String jsonStr=null;
		try {
			jsonStr = Obj.writeValueAsString(complaints);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStr;
	} 
	
	@GetMapping("/user/getComplaintListGrouped")
	@ResponseBody
	public String getCountGroupByType(@RequestParam(name = "pin", required = false) String pin,
			@RequestParam(name = "start_date", required = false )String start_date,
			@RequestParam(name = "end_date", required = false)String end_date,
			@RequestParam(name = "group")String group) {
		List<Complaint> complaints =cleanCityService.fetchAllComplaintsGrouped(pin, start_date, end_date, group);
		ObjectMapper Obj = new ObjectMapper(); 
		String jsonStr=null;
		try {
			jsonStr = Obj.writeValueAsString(complaints);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStr;
	} 

}
