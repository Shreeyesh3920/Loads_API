package com.loads.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.loads.Payloads.LoadDTO;

import com.loads.Service.LoadService;
import com.loads.Service.ShipperService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/load")
public class LoadsController {
	@Autowired
	LoadService loadService;
	@Autowired    
	ShipperService shipperService;
	
	@PostMapping
	public ResponseEntity<String> addLoadDetails(@Valid @RequestBody LoadDTO loadDTO) {
		loadService.addLoadDetails(loadDTO);
		return ResponseEntity.ok("loads details added successfully");
	}
	
	@GetMapping
	public ResponseEntity<List<LoadDTO>> getLoadDetailsByShipperId(@RequestParam(value="shipperId", required = false) String shipperId) {
		List<LoadDTO> loadDTOList = loadService.getLoadDetailsByShipperId(shipperId);
		return new ResponseEntity<>(loadDTOList, HttpStatus.OK);
	}
	
	@GetMapping("/{loadId}")
	public ResponseEntity<LoadDTO> getLoadDetailsById(@PathVariable("loadId") Long loadId) {
		LoadDTO loadDTO = loadService.listLoadDetailsById(loadId);
		return new ResponseEntity<>(loadDTO, HttpStatus.OK);
	}
	
	@PutMapping("/{loadId}")
	public ResponseEntity<String> updateLoadDetails(@Valid @RequestBody LoadDTO loadDTO, @PathVariable("loadId") Long id) {
		loadService.updateLoadDetails(loadDTO, id);
		return ResponseEntity.ok("Load Details Updated successfully");
	}
	
	@DeleteMapping("/{loadId}")
	public ResponseEntity<String> deleteLoadDetails(@PathVariable("loadId") Long id) {
		loadService.deleteLoadDetails(id);
		return ResponseEntity.ok("Load Detail Deleted Successfully");
	}
	
	
	
	    
}
