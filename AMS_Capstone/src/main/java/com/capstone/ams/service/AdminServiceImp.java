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

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.ams.exception.HangarAlreadyExistsException;
import com.capstone.ams.exception.NoSuchHangarExistsException;
import com.capstone.ams.exception.NoSuchPilotExistsException;
import com.capstone.ams.exception.NoSuchPlaneExistsException;
import com.capstone.ams.exception.PilotAlreadyExistsException;
import com.capstone.ams.exception.PlaneAlreadyExistsException;
import com.capstone.ams.model.Admin;
import com.capstone.ams.model.Hangar;
import com.capstone.ams.model.Pilot;
import com.capstone.ams.model.Plane;
import com.capstone.ams.repo.AdminRepository;
import com.capstone.ams.repo.HangarRepository;
import com.capstone.ams.repo.PilotRepository;
import com.capstone.ams.repo.PlaneRepository;

//AdminService implementation class 
@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	AdminRepository adminRepo; // injecting adminrepository into adminserviceimp
	@Autowired
	PlaneRepository planeRepo; // injecting planerepository into adminserviceimp
	@Autowired
	PilotRepository pilotRepo; // injecting pilotrepository into adminserviceimp
	@Autowired
	HangarRepository hangarRepo; // injecting hangarrepository into adminserviceimp

	// admin registration
	@Override
	public String registration(Admin admin) {

		if (adminRepo.save(admin).getAdminId() > 0) {

			return "Success";
		}
		return "Failed";
	}

	// admin login
	@Override
	public Admin login(String email) {

		return adminRepo.getByEmail(email);
	}

	// business logic on plane details
	// adding plane details
	@Override
	public String addPlane(Plane plane) {
		Plane existingPlane = planeRepo.findById(plane.getPlaneId()).orElse(null);
		if (existingPlane == null) {
			planeRepo.save(plane);
			return "plane details added successfully";
		} else
			throw new PlaneAlreadyExistsException("Plane already exists!");// exceptionhandling for adding plane

	}

	// getting all plane details using list
	@Override
	public List<Plane> getAllPlanes() {

		return planeRepo.findAll();
	}

	// deleting plane using planeId
	@Override
	public String deletePlane(Long planeId) {
		try {
			planeRepo.deleteById(planeId);
			return " Plane Deleted SucussFully";
		} catch (NoSuchPlaneExistsException e) {
			throw new NoSuchPlaneExistsException("No such plane exists");// exceptionhandling for deleting plane
		}

	}

	// updating plane details
	@Override
	public String updatePlane(Plane plane) {
		Plane existPlane = planeRepo.findById(plane.getPlaneId()).orElse(null);
		if (existPlane == null)
			throw new NoSuchPlaneExistsException("No such plane exists!");// exceptionhandling for updating plane
		else {
			existPlane.setPlaneName(plane.getPlaneName());
			planeRepo.save(existPlane);

			return "plane details updated successfully ";
		}
	}

	// business logic on pilot details
	// adding pilot deatils
	@Override
	public String addPilot(Pilot pilot) {
		Pilot existingPilot = pilotRepo.findById(pilot.getPilotId()).orElse(null);
		if (existingPilot == null) {
			pilotRepo.save(pilot);
			return "Pilot added successfully!";
		} else
			throw new PilotAlreadyExistsException("Pilot already exists!");// exceptionhandling for adding pilot
	}

	// getting all pilot details using list
	@Override
	public List<Pilot> getAllPilots() {
		return pilotRepo.findAll();
	}

	// deleting pilot details using pilotId
	@Override
	public String deletePilot(Long pilotId) {
		try {
			pilotRepo.deleteById(pilotId);
			return " Pilot Deleted SucussFully";
		} catch (NoSuchPilotExistsException e) {
			throw new NoSuchPlaneExistsException("No such pilot exists");// exceptionhandling for deleting pilot
		}
	}

	// updating pilot deatils
	@Override
	public String updatePilot(Pilot pilot) {
		Pilot existPilot = pilotRepo.findById(pilot.getPilotId()).orElse(null);
		if (existPilot == null) {
			throw new NoSuchPilotExistsException("No such pilot exists!");// exceptionhandling for updating pilot
		}
		try {
			existPilot.setPilotName(pilot.getPilotName());
			existPilot.setAge(pilot.getAge());
			pilotRepo.save(existPilot);
		} catch (NoSuchPilotExistsException e) {
			throw new NoSuchPilotExistsException("No such pilot exists!");
		}
		return "Pilot details updated successfully!";
	}

	// business logic for Hangar
	// adding hangar details
	@Override
	public String addHangar(Hangar hangar) {
		Hangar existingHangar = hangarRepo.findById(hangar.getHangarId()).orElse(null);
		if (existingHangar == null) {
			hangarRepo.save(hangar);
			return "Hangar details added successfully!";
		} else
			throw new HangarAlreadyExistsException("Hangar already exists!");// exceptionhandling for addinghangar

	}

	// deleting hangar using hangarId
	@Override
	public String deleteHangar(Long hangarId) {
		try {
			hangarRepo.deleteById(hangarId);
			return " Hangar Deleted SucussFully";
		} catch (NoSuchHangarExistsException e) {
			throw new NoSuchHangarExistsException("No such hangar exists");// exceptionhandling for deleting hangar
		}
	}

	// getting all hangar details using list
	@Override
	public List<Hangar> getAllHangar() {

		return hangarRepo.findAll();
	}

	// updating hangar details
	@Override
	public String updateHangar(Hangar hangar) {
		Hangar existHangar = hangarRepo.findById(hangar.getHangarId()).orElse(null);
		if (existHangar == null)
			throw new NoSuchHangarExistsException("No such hangar exists!");// exceptionhandling for updating hangar
		else {
			existHangar.setHangarName(hangar.getHangarName());
			existHangar.setHangarSize(hangar.getHangarSize());
			existHangar.setPlane(hangar.getPlane());
			hangarRepo.save(existHangar);

			return "Hangar details updated successfully !";
		}
	}

	// getting a hangar deatils using hangarId
	@Override
	public Hangar getHangarById(Long hangarId) {
		Optional<Hangar> han = hangarRepo.findById(hangarId);
		if (han.isPresent()) {
			return han.get();
		}
		throw new RuntimeException("Hangar not found with id " + hangarId);// exceptionhandling for getting hangarId
	}
}