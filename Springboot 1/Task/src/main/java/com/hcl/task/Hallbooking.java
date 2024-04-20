package com.hcl.task;

import java.util.*;

public class Hallbooking {


	private String hallName;
	    private Integer noOfBooking;
	    private Double totalBookingAmount;
	    private String ownerName;
	    private Double revenue;
		public String getHallName() {
			return hallName;
		}
		public void setHallName(String hallName) {
			this.hallName = hallName;
		}
		public Integer getNoOfBooking() {
			return noOfBooking;
		}
		public void setNoOfBooking(Integer noOfBooking) {
			this.noOfBooking = noOfBooking;
		}
		public Double getTotalBookingAmount() {
			return totalBookingAmount;
		}
		public void setTotalBookingAmount(Double totalBookingAmount) {
			this.totalBookingAmount = totalBookingAmount;
		}
		public String getOwnerName() {
			return ownerName;
		}
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		public Double getRevenue() {
			return revenue;
		}
		public void setRevenue(Double revenue) {
			this.revenue = revenue;
		}
		public Hallbooking(String hallName, Integer noOfBooking, Double totalBookingAmount, String ownerName,
				Double revenue) {
			super();
			this.hallName = hallName;
			this.noOfBooking = noOfBooking;
			this.totalBookingAmount = totalBookingAmount;
			this.ownerName = ownerName;
			this.revenue = revenue;
		}
	    


}
