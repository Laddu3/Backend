/**
 * Assignment Details: To read bean file and get bean object via Bean Factory
 * 
 * Author: palagiriharsh.reddy@hcl.com
 * 
 */
package com.smesession.sf.springacdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentDemo {

	/**
	 * This is main method to create the student bean objects
	 * @param args
	 */
	public static void main(String[] args) {
		//Ctrl + Shift + O - organized import 
		
		//Bean via XML, Annotation, Java Configuration.. 
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
		Student s = (Student) factory.getBean("studentbean");
		System.out.println(s);
		
		Student s2 = (Student) factory.getBean("studentbean2");
		System.out.println(s2);
		
		Exam e1 = (Exam) factory.getBean("exambean");
		System.out.println(e1);
		
		Exam e2 = (Exam) factory.getBean("exambean2");
		System.out.println(e2);
	}

}
