package com.java.meetingRoom.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.meetingRoom.model.BookingDetails;
import com.java.meetingRoom.model.MeetingRoom;
import com.java.meetingRoom.repository.MeetingRoomRepository;

@RestController
public class MeetingRoomController {
	
	
	 @Autowired
	 private MeetingRoomRepository meetingRoomRepository;
	 
	 @PostMapping("/listMeetingRoom")
		public List<MeetingRoom> getListMeetingRooms(HttpServletRequest request) throws Exception {
			try {

			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return meetingRoomRepository.getListOfRooms();
		}
	 
	 @PostMapping("/bookMeeting")
		public BookingDetails bookMeeting(@RequestParam int meetingId ,HttpServletRequest request) throws Exception {
			
			return meetingRoomRepository.bookMeeting(meetingId);
		}
	 
	 @DeleteMapping("/cancelMeeting")
		public BookingDetails Meeting(@RequestParam int meetingId ,HttpServletRequest request) throws Exception {
			
			return meetingRoomRepository.cancelMeeting(meetingId);
		}
	 
//	 public  MeetingRoom getFirstYearGeneral(@RequestParam String rollNumber , HttpServletRequest request) throws Exception {
//		 try {
//		
//		 }catch (Exception e) {
//			e.printStackTrace();
//		}  
//		 return meetingRoomRepository.getListOfRooms(rollNumber);
//	    }

}
