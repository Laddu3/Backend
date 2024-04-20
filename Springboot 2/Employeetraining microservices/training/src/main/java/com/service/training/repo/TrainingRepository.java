package com.service.training.repo;
/**
 * This Repository creates automatic tables with the help of Entity and manage data in springboot application
 *  * @author palagiriharsh.reddy@hcl.com
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.service.training.model.Training;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {

	List<Training> findByEmployeeId(long eid);

}
