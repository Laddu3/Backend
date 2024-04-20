package com.hcl.task;

public class HallBookingThread extends Thread{
	
	private List<HallBooking> hallBookingList;
	private static Map<String,Double> revenue = new TreeMap<>();
	
	public HallBookingThread() {

	}

	public HallBookingThread(List<HallBooking> hallBookingList) {
		this.hallBookingList=hallBookingList;
	}
	
	public List<HallBooking>
	getHallBookingList(){
		return hallBookingList;
	}
	
	public void setHallBookingList(List<HallBooking>hallbookingList) {
		this.hallBookingList=hallBookingList;
	}
	
	public static void SetRevenue(Map<String,Double>revenue) {
		HallBookingThread.revenue=revenue;
	}
	public void run() {
		for(HallBookinghb:hallBookingList) {
			Double calculatedRevenue=hb.getNoofBooking()*hb.getTotalBookingAmount();
			synchronized(revenue) {
				computeRevenue(hb,calculatedRevenue);
			}
		}
	}
	
	public static void computeRevenue(Hallbooking hb,Double revenue) {
		String ownerName=hb.getOwnerName();
		HallBookingThread.revenue.put(owner.Name,HallBookingThread.revenue.getOrDefault(ownerName,0.0)+revenue);
		
	}
}
