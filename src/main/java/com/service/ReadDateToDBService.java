package com.service;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.web.multipart.MultipartFile;

public interface ReadDateToDBService {

	int saveDateToDB(MultipartFile file) throws IOException, ParseException;


}
