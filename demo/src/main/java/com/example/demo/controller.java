package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@ResponseBody
@RequestMapping("/get")
public class controller {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    Environment env;

    @Value("${best}")
    private String message;
    Logger logger = LoggerFactory.getLogger(String.class);
    @GetMapping
    public String getTheTable() {
        jdbcTemplate.execute("insert into test values('8', 'Rachel&saurabh');");
        logger.info("ok");
        logger.info(message);
        return message;
    }
}
