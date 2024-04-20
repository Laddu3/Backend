package com.capstone.ams.service;

/**
 * This is used for writing business logics
 * 
 * @author jakkula.ramesh@hcl.com
 *         manneusha.sri@hcl.com
 *         kurapati.kavyasree@hcl.com
 *         ramasrujana.meka@hcl.com
 */

import java.util.List;

import com.capstone.ams.model.Admin;
import com.capstone.ams.model.Hangar;
import com.capstone.ams.model.Pilot;
import com.capstone.ams.model.Plane;

//AdminService Interface 
public interface AdminService {

	// admin registration
	public String registration(Admin admin);

	// admin login
	public Admin login(String email);

	// CRUD operations on Plane
	// adding plane as an admin
	public String addPlane(Plane plane);

	// view all plane details using list
	public List<Plane> getAllPlanes();

	// deleting plane using planeId
	public String deletePlane(Long planeId);

	// updating plane details
	public String updatePlane(Plane plane);

	// CRUD operations on pilot details
	// adding pilot details as an admin
	public String addPilot(Pilot pilot);

	// view all pilot details by using list
	public List<Pilot> getAllPilots();

	// deleting piolt using pilotId
	public String deletePilot(Long pilotId);

	// updating pilot details
	public String updatePilot(Pilot pilot);

	// CRUD operations on Hangar
	// alloting hangar details as an admin
	public String addHangar(Hangar hangar);

	// deleting hangar by using hangarId
	public String deleteHangar(Long hangarId);

	// view all hangar details by using list
	public List<Hangar> getAllHangar();

	// updating hangar details
	public String updateHangar(Hangar hangar);

	// getting a hangar by using hangarId
	public Hangar getHangarById(Long hangarId);
}
