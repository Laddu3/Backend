package com.service.training.service;
/**
 * This is service Interface used for writing all method defination here.
 * 
 * @author palagiriharsh.reddy@hcl.com
 *
 */
import java.util.List;

import com.service.training.model.Training;

public interface TrainingService {
	public List<Training> getTrainig(long eid);
	public List<Training> getAllTrainig();
	public Training createTraining(Training t);

}
