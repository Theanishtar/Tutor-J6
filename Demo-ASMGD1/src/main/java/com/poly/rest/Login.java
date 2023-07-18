package com.poly.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poly.bean.Account;
import com.poly.bean.StatusLogin;

import jakarta.servlet.http.HttpSession;


@CrossOrigin("*")
@RestController
public class Login {
	@PostMapping("/rest/login")
	public ResponseEntity<StatusLogin> login(HttpSession session, @RequestBody Account a){
		// xử lý

		session.setAttribute("session1", "user123");
		StatusLogin status = new StatusLogin();
		status.setSesionId(session.getId());
		/*
		 * 1. admin -> lưu session
		 * 2. user -> lưu session, cookie (token)
		 */
		
		// giả lập
		if(a.getEmail().equalsIgnoreCase("admin@gmail.com")) {
			status.setRole("admin");
			System.out.println(a.getEmail());
		} else {
			status.setRole("user");
			System.out.println(a.getEmail());
		}
		
		return ResponseEntity.status(200).body(status);
	}
}
