package com.embassy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.embassy.dao.entity.Property;
import com.embassy.service.PropertyService;



@Controller
@RequestMapping("rest/fms/")
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	@GetMapping("properties")
	public ResponseEntity<List<Property>> getAllUsers() {
		List<Property> list = propertyService.getPropertyList();
		return new ResponseEntity<List<Property>>(list, HttpStatus.OK);
	}
	
	@PostMapping("property/create")
	public ResponseEntity<Void> addArticle(@RequestBody Property property, UriComponentsBuilder builder) {
		Property prop = propertyService.createProperty(property);
		if (prop == null) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/property/{id}").buildAndExpand(property.getPropertyId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
	@GetMapping("property/{id}")
	public ResponseEntity<Property> getPropertyById(@PathVariable("id") Integer id) {
		Property property = propertyService.getPropertyById(id);
		return new ResponseEntity<Property>(property, HttpStatus.OK);
	}
	
	@PostMapping("property/update")
	public ResponseEntity<Property> updateProperty(@RequestBody Property property){
	propertyService.updateProperty(property);
		return new ResponseEntity<Property>(property, HttpStatus.OK);
	}
	
	
	

}
