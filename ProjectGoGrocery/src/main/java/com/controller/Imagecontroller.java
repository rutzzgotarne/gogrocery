package com.controller;

import java.net.http.HttpHeaders;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.model.ImageModel;
import com.service.ImageServiceInterface;

import jakarta.annotation.Resource;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Imagecontroller
{

    
		@Autowired
		private  ImageServiceInterface service;

		@PostMapping("/upload")
	   	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) 
		{
	   		ImageModel image = service.storeFile(file);
	        return ResponseEntity.ok("File uploaded successfully: " + image.getName());
	    }
	
//		@GetMapping("/download/{id}")
//		 public ResponseEntity<Resource> downloadFile(@PathVariable Long id)
//		{
//		 Optional<ImageModel> imageOptional = service.getFile(id);
//
//		        if (!imageOptional.isPresent()) 
//		        {
//		            return ResponseEntity.notFound().build();
//		            
//		        }
//		        
//		        ImageModel image = imageOptional.get();
//		        return ResponseEntity.ok()
//		        		 .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + image.getName() + "\"")
//		        		 .body(new ByteArrayResource(image.getImageData()));
//		       
//		    }

		
}
