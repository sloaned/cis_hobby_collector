package com.catalyst.collector.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.collector.daos.hibernate.UserDaoHibernate;
import com.catalyst.collector.entities.Username;

public class UserServiceImplTests {

	UserServiceImpl userServiceImpl;
    UserDaoHibernate mockUserDao;
	
    @Before
    public void setup() {
        userServiceImpl = new UserServiceImpl();
        mockUserDao = mock(UserDaoHibernate.class);
        userServiceImpl.setUserDao(mockUserDao);
    }
    
    @Test
    public void happyGetUserByIdTest(){
    	Username sample = new Username();
    	when(mockUserDao.getUserById(1)).thenReturn(sample);
    	assertEquals(userServiceImpl.getUserById(1), sample);
    }
    
    @Test
    public void sadGetUserByIdTestIdIsLessThanOne(){
    	Username sample = new Username();
    	when(mockUserDao.getUserById(0)).thenReturn(sample);
    	assertEquals(userServiceImpl.getUserById(0), null);
    }
    
    @Test
    public void happyAddUserTest(){
    	Username sample = new Username();
    	sample.setUsername("testname");
    	sample.setPassword("testPassword");
    	when(mockUserDao.addUser(sample)).thenReturn(true);
    	assertTrue(userServiceImpl.addUser(sample));
    }
    
    @Test
    public void sadAddUserTestUsernameIsNull(){
    	Username sample = new Username();
    	sample.setPassword("testPassword");
    	when(mockUserDao.addUser(sample)).thenReturn(true);
    	assertFalse(userServiceImpl.addUser(sample));
    }
    
    @Test
    public void sadAddUserTestUsernameIsEmpty(){
    	Username sample = new Username();
    	sample.setUsername("");
    	sample.setPassword("testPassword");
    	when(mockUserDao.addUser(sample)).thenReturn(true);
    	assertFalse(userServiceImpl.addUser(sample));
    }
    
    @Test
    public void sadAddUserTestPasswordIsNull(){
    	Username sample = new Username();
    	sample.setUsername("testname");
    	when(mockUserDao.addUser(sample)).thenReturn(true);
    	assertFalse(userServiceImpl.addUser(sample));
    }
    
    @Test
    public void sadAddUserTestPasswordIsEmpty(){
    	Username sample = new Username();
    	sample.setUsername("testname");
    	sample.setPassword("");
    	when(mockUserDao.addUser(sample)).thenReturn(true);
    	assertFalse(userServiceImpl.addUser(sample));
    }
    
    @Test
    public void happyUpdateUserTest(){
    	Username sample = new Username();
    	sample.setId(1);
    	sample.setUsername("testname");
    	sample.setPassword("testPassword");
    	when(mockUserDao.updateUser(sample)).thenReturn(true);
    	assertTrue(userServiceImpl.updateUser(sample));
    }
    
    @Test
    public void sadUpdateUserTestIdIsNull(){
    	Username sample = new Username();
    	sample.setUsername("testname");
    	sample.setPassword("testPassword");
    	when(mockUserDao.updateUser(sample)).thenReturn(true);
    	assertFalse(userServiceImpl.updateUser(sample));
    }
    
    @Test
    public void sadUpdateUserTestIdIsLessThanOne(){
    	Username sample = new Username();
    	sample.setId(0);
    	sample.setUsername("testname");
    	sample.setPassword("testPassword");
    	when(mockUserDao.updateUser(sample)).thenReturn(true);
    	assertFalse(userServiceImpl.updateUser(sample));
    }
    
    @Test
    public void sadUpdateUserTestUsernameIsNull(){
    	Username sample = new Username();
    	sample.setId(1);
    	sample.setPassword("testPassword");
    	when(mockUserDao.updateUser(sample)).thenReturn(true);
    	assertFalse(userServiceImpl.updateUser(sample));
    }
    
    @Test
    public void sadUpdateUserTestUsernameIsEmpty(){
    	Username sample = new Username();
    	sample.setId(1);
    	sample.setUsername("");
    	sample.setPassword("testPassword");
    	when(mockUserDao.updateUser(sample)).thenReturn(true);
    	assertFalse(userServiceImpl.updateUser(sample));
    }
    
    @Test
    public void sadUpdateUserTestPasswordIsNull(){
    	Username sample = new Username();
    	sample.setId(1);
    	sample.setUsername("testname");
    	when(mockUserDao.updateUser(sample)).thenReturn(true);
    	assertFalse(userServiceImpl.updateUser(sample));
    }
    
    @Test
    public void sadUpdateUserTestPasswordIsEmpty(){
    	Username sample = new Username();
    	sample.setId(1);
    	sample.setUsername("testname");
    	sample.setPassword("");
    	when(mockUserDao.updateUser(sample)).thenReturn(true);
    	assertFalse(userServiceImpl.updateUser(sample));
    }
    
    @Test
    public void happyDeleteUserTest(){
    	when(mockUserDao.deleteUser(1)).thenReturn(true);
    	assertTrue(userServiceImpl.deleteUser(1));
    }
    
    @Test
    public void sadDeleteUserTestIdLessThanOne(){
    	when(mockUserDao.deleteUser(0)).thenReturn(true);
    	assertFalse(userServiceImpl.deleteUser(0));
    }
    
    
}
