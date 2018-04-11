package com.embassy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.embassy.dao.PropertyDAO;
import com.embassy.dao.entity.Property;

@Service
public class PropertyService {

	@Autowired
	private PropertyDAO propertyDAO;
	
	public List<Property> getPropertyList(){
		return propertyDAO.findAll();
	}
	
	public Property createProperty(Property property){
		return propertyDAO.add(property);
	}
	
	public Property updateProperty(Property property){
		return propertyDAO.update(property);
	}
	
	public Property getPropertyById(Integer id){
		return propertyDAO.getById(id);
	}
	
}
