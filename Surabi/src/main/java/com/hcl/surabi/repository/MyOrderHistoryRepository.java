package com.hcl.surabi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.surabi.entity.MyOrderHistory;

@Repository
public interface MyOrderHistoryRepository extends JpaRepository<MyOrderHistory, Long> {

	// this function is used to find details by username
	public List<MyOrderHistory> findByUserName(String uname);

	// this function is used to find details by date
	public List<MyOrderHistory> findByDate(LocalDate ld);

	// this function is used to find total monthly bills
	@Query("From MyOrderHistory where date between '2022/12/01' AND '2022/12/31'")
	public List<MyOrderHistory> totalMonthlyBills();

}