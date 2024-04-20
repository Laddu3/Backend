/**
* Assignment Details: To read bean file and get bean object via Bean Factory 
* 
* Author: palagiriharsh.reddy@hcl.com
* 
*/
package com.smesession.sf.springdemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class StudentDemo {
	
/**

 * This is main method to create the student bean objects

 * @param args

 */


	public static void main(String[] args) {
		//Ctrl + Shift + O - organized import 
		
		//Bean via XML, Annotation, Java Configuration.. 
		
		Resource resource = new ClassPathResource("Beans.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		Student s = (Student) factory.getBean("studentbean");
		System.out.println(s);
		
		Student s2 = (Student) factory.getBean("studentbean2");
		System.out.println(s2);
	}

}
