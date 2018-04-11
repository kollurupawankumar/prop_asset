package com.embassy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.embassy.dao.AssetDAO;
import com.embassy.dao.AssetDAO;
import com.embassy.dao.entity.Asset;

@Service
public class AssetService {
	
	@Autowired
	private AssetDAO assetDAO;
	
	public List<Asset> getAssetList(){
		return assetDAO.findAll();
	}
	
	public Asset createAsset(Asset asset){
		return assetDAO.add(asset);
	}
	
	public Asset updateAsset(Asset asset){
		return assetDAO.update(asset);
	}
	
	public Asset getAssetById(Integer id){
		return assetDAO.getById(id);
	}
	

}
