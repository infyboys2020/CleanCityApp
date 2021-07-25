package com.clean.springbootstarter.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.clean.springbootstarter.beans.Complaint;

@Service
public class CleanCityService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * fetch cleancity data into table.
	 */
	public int getTicketID() {

		String sql = "SELECT max(id) FROM cleancity_records";
		int ticketId;
		try {
			ticketId = jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ticketId=1;
		}
		return ticketId;
	}

	public String getTicketStatus(String ticketId) {

		String sql = "SELECT status FROM cleancity_records where id= " + ticketId;
		String status="";
		try {
			status = jdbcTemplate.queryForObject(sql, new Object[] {}, String.class);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public List<Complaint> fetchAllComplaints(String pin,String startdate,String enddate) {


		String sql = "SELECT id,type,name,address,pin,longitude,latitude,phone_number,ComplaintSubmissionDate,status FROM cleancity_records";

		if(!StringUtils.isEmpty(pin) || !StringUtils.isEmpty(startdate) || !StringUtils.isEmpty(enddate)) {
			sql += " WHERE ";
			if(!StringUtils.isEmpty(pin))
				sql += "pin =" + pin +" AND ";
			if(!StringUtils.isEmpty(startdate))
				sql += "ComplaintSubmissionDate >='" + startdate+"' AND ";
			if(!StringUtils.isEmpty(enddate))
				sql += "ComplaintSubmissionDate<='" + enddate+"' AND ";
			sql = sql.substring(0, sql.length()-4);
		}


		List<Complaint> complaints = jdbcTemplate.query(sql,
				(resultSet, rowNum) -> new Complaint(resultSet.getInt("id"),
						resultSet.getString("type"),
						resultSet.getString("name"),
						resultSet.getString("address"),
						resultSet.getString("pin"),
						resultSet.getString("longitude"),
						resultSet.getString("latitude"),
						resultSet.getString("phone_number"),
						resultSet.getString("ComplaintSubmissionDate"),
						resultSet.getString("status")));
		return complaints;
	}
	
	public int updateStatusById(String id,String status) {


		String sql = "UPDATE cleancity_records SET status = '"+status+"' WHERE id ="+id;



		int queryResult = jdbcTemplate.update(sql);
		return queryResult;
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
	public List<Complaint> fetchAllComplaintsGrouped(String pin,String startdate,String enddate, String group) {
		String sql = "SELECT type, pin, count(*) as count FROM cleancity_records";

		if(!StringUtils.isEmpty(pin) || !StringUtils.isEmpty(startdate) || !StringUtils.isEmpty(enddate)) {
			sql += " WHERE ";
			if(!StringUtils.isEmpty(pin))
				sql += "pin =" + pin +" AND ";
			if(!StringUtils.isEmpty(startdate))
				sql += "ComplaintSubmissionDate >='" + startdate+"' AND ";
			if(!StringUtils.isEmpty(enddate))
				sql += "ComplaintSubmissionDate<='" + enddate+"' AND ";
			sql = sql.substring(0, sql.length()-4);
		}
		sql += " group by "+group;

		List<Complaint> complaints = jdbcTemplate.query(sql,
				(resultSet, rowNum) -> {
					Complaint complaint =new Complaint();
					complaint.setCount(resultSet.getString("count"));
					if(group.equals("pin"))
						complaint.setPin(resultSet.getString("pin"));
					else
						complaint.setType(resultSet.getString("type"));
					return complaint;
				});
		return complaints;
	}

}
