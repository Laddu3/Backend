package com.service.employee.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 * This Repository creates automatic tables with the help of Entity and manage data in springboot application
 *  * @author jakkula.ramesh@hcl.com
 *
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.service.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("select t from Employee t where t.trainingId = ?1")
	List<Employee> findTrainingById(Long trainingId);

}
