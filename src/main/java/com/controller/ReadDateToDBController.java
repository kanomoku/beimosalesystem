package com.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.service.impl.ReadDateToDBServiceImpl;

@Controller
public class ReadDateToDBController {
	
	@Resource
	ReadDateToDBServiceImpl readDateToDBServiceImpl;
	
	@RequestMapping("upload")
		public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest req)
				throws IllegalStateException, IOException {
		int res = readDateToDBServiceImpl.saveDateToDB(file);
		if( res==0){
			return "/success/readDateToDBServiceSuccess.jsp";
		} else {
			return "index.jsp";
		}
	}
}
