package com.bags.backendproject;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bags.dao.UserProcessDao;
import com.bags.model.UserProcess;

public class TestUserProcessDaoImpl {
	@Autowired
	UserProcessDao userProcessDao;

	/*
	 * @BeforeClass public static void executeFirst() {bbb
	 * AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(); 
	 * context.scan("com.bags");
	 * context.refresh(); userProcessDao=(UserProcessDao)
	 * context.getBean("userProcessDaoImpl"); }
	 */

	/* Add a user */
	@Ignore
	@Test
	public void addUserProcess() {
		UserProcess up = new UserProcess();
		up.setName("Bharani");
		up.setEmailid("bharani@gmail.com");
		up.setNumber("3214569870");
		up.setPassword("barani@barani");
		up.setUsername("barani");
		assertTrue("Problem in user process insertion", userProcessDao.saveUserProcess(up));
	}

	/* Delete a user */
	@Ignore
	@Test
	public void deleteUserProcess() {
		UserProcess up = new UserProcess();
		up.setId(4);
		assertTrue("Problem in user process deletion", userProcessDao.deleteUserProcess(up));
	}

	/* Update a user */
	@Ignore
	@Test
	public void updateUserProcess() {
		UserProcess up = new UserProcess();
		up.setId(6);
		up.setName("sample");
		up.setEmailid("sample@gmail.com");
		up.setUsername("sample");
		up.setPassword("smaple@bags");
		up.setNumber("1236547890");
		assertTrue("Problem in user process updation", userProcessDao.updateUserProcess(up));
	}

	/* Display a process by id */
	
	@Test
	public void displayUserProcess() {
		List<UserProcess> up = userProcessDao.getId(1);
		for (UserProcess userProcess : up)
			System.out.println(userProcess.getId() + " " + userProcess.getName() + " " + userProcess.getEmailid() + " " + userProcess.getNumber() + " " + userProcess.getUsername());
	}
}
