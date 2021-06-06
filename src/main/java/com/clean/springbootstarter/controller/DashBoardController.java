package com.clean.springbootstarter.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import com.clean.springbootstarter.beans.Complaint;
import com.clean.springbootstarter.services.EmailService;
import com.clean.springbootstarter.beans.Complaint;

@Controller
public class DashBoardController {

	@Autowired
	com.clean.springbootstarter.services.CleanCityService cleanCityService;
	
	@Autowired
	EmailService emailService;

	/**
	 * This is a demo method to show Application is running successfully.
	 * @return
	 */
	@RequestMapping("/user/cleancity")
	public ResponseEntity<String> index() {
		
		return new ResponseEntity<String> ("Welcome to clean city portal !", HttpStatus.OK);
	
	}

	/**
	 * Method to show reportBoard page to user.
	 * This page is used for complaint reporting.
	 * @return
	 */
	@GetMapping("/user/reportBoard")
	public String reportBoard() {
		return "ReportingBoard";

	}
	
	/**
	 * Search page for complaints.
	 * Here, we can search complaints by  pincode. 
	 * @return
	 */
	@GetMapping("/admin/fetch")
	public String fetchBoard() {
		return "cleanCityInfo";
	}
	
	/**
	 * This method is used to render user TicketBoard.
	 * @return
	 */
	@GetMapping("/user/ticketBoard")
	public String ticketBoard() {
		return "TicketBoard";
	}
	
	/**
	 * This method used for fetching ticket information from database.
	 * User functionality.
	 * @param ticketId
	 * @param model
	 * @return
	 */
	@PostMapping("/user/ticketBoard")
	public String getTicketStatus(String ticketId, Model model) {
		String status = cleanCityService.getTicketStatus(ticketId);
		if(status!=null) {
			if(status.equalsIgnoreCase("A")) {
				status= "Your ticket has been acknowledged successfully. Prompt action will be taken as soon as possible. Thank you!!";
			}
			else if(status.equalsIgnoreCase("D")) {
				status= "Your ticket has been closed successfully.Enjoy the cleanliness!!";
			}
			else if(status.equalsIgnoreCase("P")) {
				status= "Your ticket will be acknowledged as soon as our manpower is ready. It has not been acknowledged yet.";
			}
			else {
				status= "Something went wrong. We could not fetch the status of your ticket. Please try again after sometime.";
			}
		}
		else {
			status= "Something went wrong. We could not fetch the status of your ticket. Please try again after sometime.";
		}
		model.addAttribute("status", status);

		return "TicketResult";

	}
	
	/**
	 * This method is used for inserting complaints details into database.
	 * User functionality.
	 * @param form
	 * @param file
	 * @param model
	 * @return
	 */
	@PostMapping("/user/reportBoard")
	public String uploadForm(Complaint form, @RequestParam("image") MultipartFile file, Model model) {
		String status = "";
		FileInputStream fin  = null;

		try {
			if(null!=file){
			 fin = (FileInputStream) file.getInputStream();
			 
			}
			// FileInputStream fin = new
			// FileInputStream("/home/bhruguraj/Pictures/test.png");
			// System.out.println(fin);
			//Complaint complaint = new Complaint(form.getName(), form.getAddress(), form.getPin(), form.getPhone_number(),fin);
			Complaint complaint = new Complaint(0, form.getType(), form.getName(), form.getAddress(),
				form.getPin(), form.getPhone_number(), fin, form.getLongitude(), form.getLatitude());

			if (cleanCityService.insertComplaint(complaint) == 1) {

				status = "Your ticket has been logged sucessfully!!";
				emailService.sendSimpleMessage();
			} else {
				status = "Ticket logging failed due to technical issues. Please try again after sometime.";
			}
			model.addAttribute("ticketId", cleanCityService.getTicketID());
			model.addAttribute("status", status);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "ReportingResult";

	}
	
	/**
	 * Method to fetch all complaints and show in dashboard.
	 * @param pin
	 * @param start_date
	 * @param end_date
	 * @return
	 */

	@GetMapping("/admin/fetch/data")
	public  @ResponseBody Object fetchData(@RequestParam("pin") String pin,@RequestParam("start_date")String start_date,@RequestParam("end_date")String end_date) {

		String jsonStr = "";
		try {

			List<Complaint> complaints = cleanCityService.fetchAllComplaints(pin,start_date,end_date);
			if(complaints.isEmpty()) {
				
				throw new ResponseStatusException(
						  HttpStatus.NOT_FOUND, "records not found"
						);
			}
			ObjectMapper Obj = new ObjectMapper();
			jsonStr = Obj.writeValueAsString(complaints);

			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "No records found"
					);
			
		}

		return jsonStr;

	}
	
	/**
	 * Demo Page to show image retrieve and display in Browser.
	 * @param pin
	 * @return
	 */

	@GetMapping("/user/fetch/data_with_id")
	public ModelAndView fetchDemo(@RequestParam("id") String id) {

		ModelAndView model = new ModelAndView("incidentDetails");
		
		try {

			List<Complaint> complaints = cleanCityService.fetchComplaintWithImage(id);
			model.addObject("id", complaints.get(0).getId());
			model.addObject("name", complaints.get(0).getName());
			model.addObject("address", complaints.get(0).getAddress());
			model.addObject("phone", complaints.get(0).getPhone_number());
			model.addObject("pin", complaints.get(0).getPin());
			model.addObject("latitude", complaints.get(0).getLatitude());
			model.addObject("longitude", complaints.get(0).getLongitude());
			model.addObject("status", complaints.get(0).getStatus());
			model.addObject("type", complaints.get(0).getType());
			model.addObject("ComplaintSubmissionDate", complaints.get(0).getComplaintSubmissionDate());
			
			if(null!=complaints.get(0).getPhoto()) {
			InputStream inputStream = complaints.get(0).getPhoto();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			byte[] imageBytes = outputStream.toByteArray();

			String base64Image = Base64.getEncoder().encodeToString(imageBytes);

			inputStream.close();
			outputStream.close();
			model.addObject("photo", base64Image);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;

	}

}
