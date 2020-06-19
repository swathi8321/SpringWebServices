package com.java.meetingRoom.model;

import java.util.LinkedHashMap;

public class MeetingRoom {

	LinkedHashMap<String, Object> meetingRoomDetails = new LinkedHashMap<String, Object>();

	public LinkedHashMap<String, Object> getMeetingRoomDetails() {
		return meetingRoomDetails;
	}

	public void setMeetingRoomDetails(LinkedHashMap<String, Object> records) {
		this.meetingRoomDetails = records;
	}

}
