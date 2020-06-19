package com.java.meetingRoom.repository;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.java.meetingRoom.model.BookingDetails;
import com.java.meetingRoom.model.MeetingRoom;

@Repository
public class MeetingRoomRepository extends JdbcDaoSupport {
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@PreDestroy
	private void shutdown() {
		System.out.println("Shutdown All Resources");
		try {
			dataSource.getConnection().close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public List<MeetingRoom> getListOfRooms() {

		String sql = "SELECT * FROM projectdb.meeting left join projectdb.floor\r\n" + 
				"on meeting.meetingId = floor.meetingId\r\n" + 
				"left join projectdb.offices\r\n" + 
				"on offices.floorId = floor.floorId where availability='Y'";
		
		return  getJdbcTemplate().query(sql, new ActorMapper());

	}
	
	public BookingDetails bookMeeting(int id) {
		
		BookingDetails bookingDetails =new BookingDetails();
		int result = -1;
		
		String sql = "select trim(availability) from projectdb.meeting where  meetingId = ?";
		
		String status = getJdbcTemplate().queryForObject(sql,  new Object[] { id }, String.class);
		
		if(status.contains("N")) {
			bookingDetails.setBookingId(0);
			bookingDetails.setBookingStatus("This meeting Id "+id +" is already booked");
			bookingDetails.setMeetingId(id);
			
		}else {
		
			sql = "update projectdb.meeting set availability = 'N',startTime=now(),endTime=now() where meetingId = ?";
			result =  getJdbcTemplate().update(sql, id);
			bookingDetails.setBookingId(id+result);
			bookingDetails.setBookingStatus("Your meeting is successfully booked");
			bookingDetails.setMeetingId(id);
		}
		
		return bookingDetails;
		
	}
	
	public BookingDetails cancelMeeting(int id) {
		
		String sql = "update projectdb.meeting set availability = 'Y',startTime=now(),endTime=now() where meetingId = ?";
		BookingDetails bookingDetails =new BookingDetails();
		int result =  getJdbcTemplate().update(sql, id);
		bookingDetails.setBookingId(id+100);
		bookingDetails.setBookingStatus("Your meeting is successfully cancelled");
		bookingDetails.setMeetingId(id);
		
		return bookingDetails;
		
	}
	
	

	private static final class ActorMapper implements RowMapper<MeetingRoom> {
		public MeetingRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
			MeetingRoom meetingRoom = new MeetingRoom();
			ResultSetMetaData rm = rs.getMetaData();
			LinkedHashMap<String, Object> records = new LinkedHashMap<String, Object>();
			int cols = rm.getColumnCount();
			records = new LinkedHashMap<String, Object>(cols);
			for (int i = 1; i <= cols; i++) {
				String columnName = rm.getColumnName(i);
				Object columnValue = rs.getObject(i);
				records.put(columnName.trim(), columnValue);
				meetingRoom.setMeetingRoomDetails(records);
			}

			return meetingRoom;
		}
	}
	

	
}