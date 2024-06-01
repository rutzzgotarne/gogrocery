package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class ImageModel {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private Long id;

	    private String name;

	    @Lob
	    @Column(length=100000)
	    private byte[] imageData;

		public ImageModel() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ImageModel(Long id, String name, byte[] imageData) {
			super();
			this.id = id;
			this.name = name;
			this.imageData = imageData;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public byte[] getImageData() {
			return imageData;
		}

		public void setImageData(byte[] imageData) {
			this.imageData = imageData;
		}
	    
	    

}
