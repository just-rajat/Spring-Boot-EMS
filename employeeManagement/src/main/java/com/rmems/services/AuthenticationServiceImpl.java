package com.rmems.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmems.entities.Employee;
import com.rmems.repositories.EmployeeRepository;
import com.rmems.utils.AuthenticationUtils;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    AuthenticationUtils authenticationUtils;

    @Override
    public boolean checkEmailIdExists(String emailId) throws Exception {
        log.info("Inside checkEmailIdExists method of AuthenticationServiceImpl");
        int countEmployee = employeeRepository.countEmployeeByEmployeeEmailId(emailId);
        log.info("countEmployee based on EmailId: " + countEmployee);
        return countEmployee > 0;
    }

    @Override
    public boolean authenticatedLogin(String emailId, String password) throws Exception {
        log.info("Inside authenticatedLogin method of AuthenticationServiceImpl");
        String passwordHash = authenticationUtils.getHashValue(password);
        log.info("Created passwordHash >>>>");
        int countEmployee = employeeRepository.countEmployeeByEmployeeEmailIdAndEmpPassword(emailId, passwordHash);
        log.info("countEmployee based on EmailId: " + countEmployee);
        return countEmployee > 0;
    }

    @Override
    public Employee getEmployeeByEmailId(String emailId) throws Exception {
        return employeeRepository.findEmployeeByEmployeeEmailId(emailId);
    }
}