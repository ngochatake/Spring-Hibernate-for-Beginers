package com.example.tdadm.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	JdbcTemplate primaryJdbcTemplate;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	JdbcTemplate secondaryJdbcTemplate;

	@GetMapping
	public String check() {
		
		List<Map<String, Object>> queryForList = primaryJdbcTemplate.queryForList("select * from Subject");
		System.out.println(queryForList);

		List<Map<String, Object>> queryForList2 = secondaryJdbcTemplate.queryForList("SELECT * FROM hb_student_tracker.student");
		System.out.println(queryForList2);
		return "home";
	}
}
