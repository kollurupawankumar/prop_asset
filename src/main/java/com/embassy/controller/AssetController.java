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

import com.embassy.dao.entity.Asset;
import com.embassy.service.AssetService;

@Controller
@RequestMapping("rest/fms/")
public class AssetController {
	
	@Autowired
	private AssetService assetService;
	
	@GetMapping("assets")
	public ResponseEntity<List<Asset>> getAllAssets() {
		List<Asset> list = assetService.getAssetList();
		return new ResponseEntity<List<Asset>>(list, HttpStatus.OK);
	}
	
	@PostMapping("asset/create")
	public ResponseEntity<Void> addAsset(@RequestBody Asset asset, UriComponentsBuilder builder) {
		Asset prop = assetService.createAsset(asset);
		if (prop == null) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/asset/{id}").buildAndExpand(asset.getAssetId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
	@GetMapping("asset/{id}")
	public ResponseEntity<Asset> getAssetById(@PathVariable("id") Integer id) {
		Asset Asset = assetService.getAssetById(id);
		return new ResponseEntity<Asset>(Asset, HttpStatus.OK);
	}
	
	@PostMapping("asset/update")
	public ResponseEntity<Asset> updateAsset(@RequestBody Asset asset){
		assetService.updateAsset(asset);
		return new ResponseEntity<Asset>(asset, HttpStatus.OK);
	}
	
	
	

}
