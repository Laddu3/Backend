/**
 * This is the Medicial Monitoring Application 
 * 
 * Authors mandala.kamalkishore@hcl.com
 * 		  palagiriharsh.reddy@hcl.com
 * 		  jeevanandham_r@hcl.com
 * 		  santhanam.r@hcl.com
 * 
 */
package com.mms.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class MmsApplication {

	/**
	 * This is required for running as Java Application
	 */

	public static void main(String[] args) {
		log.info("Main method execution started successfully");
		SpringApplication.run(MmsApplication.class, args);
	}
}