package com.service.training.controller;
/**
 * This is Training controller class
 * 
 * @author palagiriharsh.reddy@hcl.com
 *
 */
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.training.model.Training;
import com.service.training.service.TrainingService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class TrainingController {
	@Autowired
	TrainingService trainingService;

	@GetMapping("/Training/{eid}")
	public List<Training> getTrainig(@PathVariable long eid) {
		return trainingService.getTrainig(eid);
	}

	@GetMapping("/Trainings")
	public List<Training> getAllTrainig(){
		return trainingService.getAllTrainig();
	}
	
	@PostMapping("/training")
	public String createTraining(@Valid @RequestBody Training t, BindingResult result) {
		log.info("createTraining method is called.");
		if (result.hasErrors()) {
			String errMsg = "";
			for (ObjectError err : result.getAllErrors()) {
				errMsg += err.getDefaultMessage() + ",";
			}
			log.error("Error occurred in createtraining method due to data validation:" + errMsg);
			return errMsg;
		}
		log.info("createStudent method completed successfully.");
		trainingService.createTraining(t);
		log.debug("Training Id:" + t.getTrainingId());
		return "Success";
	}
}
