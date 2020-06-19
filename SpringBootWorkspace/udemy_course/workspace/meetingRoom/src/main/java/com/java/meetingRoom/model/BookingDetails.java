package com.java.meetingRoom.model;

public class BookingDetails {
	
	private int BookingId;
	private String BookingStatus;
	private int MeetingId;
	public int getBookingId() {
		return BookingId;
	}
	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}
	public String getBookingStatus() {
		return BookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		BookingStatus = bookingStatus;
	}
	public int getMeetingId() {
		return MeetingId;
	}
	public void setMeetingId(int meetingId) {
		MeetingId = meetingId;
	}
	

}
