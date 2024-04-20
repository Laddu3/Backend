package com.service.training.service;
/**
 * This is service implementation class and used for writing business logics
 * 
 * @author palagiriharsh.reddy@hcl.com
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.training.model.Training;
import com.service.training.repo.TrainingRepository;

@Service
public class TrainingServiceImp implements TrainingService {
	@Autowired
	TrainingRepository trainingRepository;

	@Override
	public List<Training> getTrainig(long eid) {

		return trainingRepository.findByEmployeeId(eid);
	}

	@Override
	public Training createTraining(Training t) {

		return trainingRepository.save(t);
	}

	@Override
	public List<Training> getAllTrainig() {
		// TODO Auto-generated method stub
		return (List<Training>) trainingRepository.findAll();
	}

}
