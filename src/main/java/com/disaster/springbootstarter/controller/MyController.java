package com.disaster.springbootstarter.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.disaster.springbootstarter.APIController.NewsAPIController;
import com.disaster.springbootstarter.beans.Disaster;
import com.disaster.springbootstarter.beans.History;


@Controller
public class MyController {
	
	@Autowired
	com.disaster.springbootstarter.APIController.MapAPIController MapAPIController;
	
	@Autowired
	com.disaster.springbootstarter.service.Services services;
	
	@Autowired
	NewsAPIController NewsAPIController;

	@GetMapping("/helloPage")
	@ResponseBody
	public String index() {
		//services.getDisaster();
		return "Greetings from Spring Boot! hvjv";
		
	}
	
	@RequestMapping(value = "/map", method=RequestMethod.GET)
	public String map(Model model) {
		try {
			List<Disaster> disasters =   services.getDisaster();
			 ObjectMapper Obj = new ObjectMapper(); 
			 String jsonStr = Obj.writeValueAsString(disasters);
			 model.addAttribute("disasterList", jsonStr);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hereMap";
	}
	
	@RequestMapping(value = "/get", method=RequestMethod.GET)
	public String place(Model model, String place) {
		 String location = MapAPIController.getLocation(place);
		 model.addAttribute("message", location);
		return "textResponse";
	}
	
	@RequestMapping(value = "/news", method=RequestMethod.GET)

	public String news(Model model, String disaster, String place, String start, String end) {
		try {
			List<History> historyRecord =   services.getHistory("","","");
			 ObjectMapper Obj = new ObjectMapper(); 
			 String jsonStr = Obj.writeValueAsString(historyRecord);
			 model.addAttribute("message", jsonStr);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "textResponse";
	}
	
	@RequestMapping(value = "/history", method=RequestMethod.GET)
	public String news(Model model,HttpServletRequest request, HttpServletResponse response,String disaster, String startDate, String endDate) {
		try {
			List<History> historyRecord =   services.getHistory(disaster,startDate,endDate);
			
			if(historyRecord.size() != 0) {
				 ObjectMapper Obj = new ObjectMapper(); 
				 String jsonStr = Obj.writeValueAsString(historyRecord);
				 model.addAttribute("message", jsonStr);
				 response.setStatus(200);
			}else {
				model.addAttribute("message", "No Data Found");
				response.setStatus(400);
			}
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "textResponse";
	}
	
	@RequestMapping(value = "/load", method=RequestMethod.GET)
	public String loadHistory(Model model) {
		 services.loadHistoryTable();
		return "textResponse";
	}
}
