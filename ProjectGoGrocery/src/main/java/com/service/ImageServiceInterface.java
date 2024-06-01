package com.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.model.ImageModel;

public interface ImageServiceInterface {

	public ImageModel storeFile(MultipartFile file);
	public Optional<ImageModel> getFile(Long fileId);
}
