package com.clean.springbootstarter.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.clean.springbootstarter.beans.Complaint;

@Service
public class cleanCityService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * fetch cleancity data into table.
	 */

	//		public List<UserInfo> fetchAllUserInfo() {
	//			String sql = "SELECT *"+
	//					"FROM cleancity_records";
	//			
	//			
	//			
	//			List<UserInfo> userRecords = jdbcTemplate.query(sql,
	//					(resultSet, rowNum) -> new UserInfo(resultSet.getString("name"),
	//														resultSet.getString("address"),
	//														resultSet.getString("pin"),
	//														resultSet.getString("phone_number"),
	//														resultSet.getBinaryStream("photo")
	//														));
	//			
	//			return userRecords;
	//		}

/*	public List<Complaint> getAllComplaintsWithoutImage() {

		String sql = "SELECT * FROM cleancity_records";

		List<Complaint> complaints = jdbcTemplate.query(sql,
				(resultSet, rowNum) -> new Complaint(resultSet.getInt("id"),
						resultSet.getString("type"),
						resultSet.getString("name"),
						resultSet.getString("address"),
						resultSet.getString("pin"),
						resultSet.getString("phone_number"),
						resultSet.getString("longitude"),
						resultSet.getString("latitude")));

		return complaints;
	}*/
	
	public int getTicketID() {

		String sql = "SELECT max(id) FROM cleancity_records";
		int ticketId;
		ticketId = jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);
		return ticketId;
	}

	public String getTicketStatus(String ticketId) {

		String sql = "SELECT current_status FROM cleancity_records where id= " + ticketId;
		String status="";
		status = jdbcTemplate.queryForObject(sql, new Object[] {}, String.class);
		return status;
	}

	/**
	 * insert cleancity data into table.
	 */

	public int insertComplaint(Complaint complaint) {

		Date now = new Date();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String mysqlDateString = formatter.format(now);
		
		String sql = "INSERT INTO cleancity_records (type, name, address, pin, phone_number, photo, longitude, latitude,ComplaintSubmissionDate) "
				+ "VALUES (?, ?, ?, ?, ? , ?, ?, ?,?)";
		int queryStatus=jdbcTemplate.update(sql,complaint.getType(), complaint.getName(),
				complaint.getAddress(),	complaint.getPin(),complaint.getPhone_number(),
				complaint.getPhoto(), complaint.getLongitude(), complaint.getLatitude(),mysqlDateString);

		System.out.println("query status is "+queryStatus);

		return queryStatus;

	}
	public List<Complaint> fetchComplaintByPin(String pin,String startdate,String enddate) {


		String sql = "SELECT id,type,name,address,pin,phone_number,ComplaintSubmissionDate,status FROM cleancity_records"+" WHERE pin ="+pin+" AND ComplaintSubmissionDate BETWEEN '"+startdate+ "' AND '"+enddate+"'";



		List<Complaint> complaints = jdbcTemplate.query(sql,
				(resultSet, rowNum) -> new Complaint(resultSet.getInt("id"),
						resultSet.getString("type"),
						resultSet.getString("name"),
						resultSet.getString("address"),
						resultSet.getString("pin"),
						resultSet.getString("phone_number"),
						resultSet.getString("ComplaintSubmissionDate"),
						resultSet.getString("status")));
		return complaints;
	}


	public List<Complaint> fetchComplaintWithImage(String id) {


		String sql = "SELECT * FROM cleancity_records"+" WHERE id ="+id;



		List<Complaint> complaints = jdbcTemplate.query(sql,
				(resultSet, rowNum) -> new Complaint(resultSet.getInt("id"),
						resultSet.getString("type"),
						resultSet.getString("name"),
						resultSet.getString("address"),
						resultSet.getString("pin"),
						resultSet.getString("phone_number"),
						resultSet.getBinaryStream("photo"),
						resultSet.getString("longitude"),
						resultSet.getString("latitude"),
						resultSet.getString("ComplaintSubmissionDate"),
						resultSet.getString("status")));
						
		return complaints;
	}

}
