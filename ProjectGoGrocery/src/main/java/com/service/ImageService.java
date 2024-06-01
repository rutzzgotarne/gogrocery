package com.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.ImageRepository;
import com.model.ImageModel;

@Service
public class ImageService implements ImageServiceInterface {

	@Autowired
	ImageRepository imgRepository;
	
	
	public ImageModel storeFile(MultipartFile file)
	{
		 String fileName = file.getOriginalFilename();
	        try
	        {
	            ImageModel image = new ImageModel();
	            image.setName(fileName);;
	            image.setImageData(file.getBytes());
	            return imgRepository.save(image);
	        }
	        catch (IOException ex)
	        {
	            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
	        }
    }
	
	public Optional<ImageModel> getFile(Long fileId)
	{

		System.out.println(fileId+"Inside service");
        return imgRepository.findById(fileId); 
	}


}
