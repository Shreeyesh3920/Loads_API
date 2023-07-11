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
import org.springframework.web.bind.annotation.RestController;

import com.loads.Payloads.ShipperDTO;
import com.loads.Service.LoadService;
import com.loads.Service.ShipperService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/shipper")
public class ShipperController {

	@Autowired
	ShipperService shiperService;
	@Autowired
	LoadService loadService;
	
	@PostMapping
	  public ResponseEntity<String> createShipper(@Valid @RequestBody ShipperDTO shipperDTO) {
        this.shiperService.addShipper(shipperDTO);
        return ResponseEntity.ok("Shipper added successfully");
    }
	@GetMapping
	  public ResponseEntity<List<ShipperDTO>> getAllShipper() {
	        List<ShipperDTO> shipperDTO=this.shiperService.listAllShipper();
	        return new ResponseEntity<>(shipperDTO,HttpStatus.FOUND);
	    }
	@GetMapping("/{shipperId}")
	  public ResponseEntity<ShipperDTO> getShipperById(@PathVariable String shipperId) {
	        ShipperDTO shipperDTO=this.shiperService.getShipperById(shipperId);
	        return new ResponseEntity<>(shipperDTO,HttpStatus.FOUND);
	    }
	@PutMapping("/{shipperId}")
	  public ResponseEntity<ShipperDTO> updateShipperById(@Valid @RequestBody ShipperDTO shipperDTO,@PathVariable String shipperId) {
		 ShipperDTO shipperdto=this.shiperService.updateShipper(shipperDTO, shipperId);
	        return new ResponseEntity<>(shipperdto,HttpStatus.CREATED);
	    }
	@DeleteMapping("/{shipperId}")
	public ResponseEntity<String> deleteShipperById(@PathVariable String shipperId) {
			this.shiperService.deleteShipper(shipperId);
		 return ResponseEntity.ok("Shipper Deleted successfully");
	    }
	
}
