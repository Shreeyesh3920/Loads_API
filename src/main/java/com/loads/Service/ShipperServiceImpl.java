package com.loads.Service;

import java.util.LinkedList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loads.Entity.Shipper;
import com.loads.Payloads.ShipperDTO;
import com.loads.Repository.LoadRepository;
import com.loads.Repository.ShipperRepository;

@Service
public class ShipperServiceImpl implements ShipperService{

	@Autowired
	LoadRepository loadRepository;
	@Autowired
	ShipperRepository shipperRepository;
	@Autowired
	ModelMapper modelMapper;
	@Override
	public ShipperDTO addShipper(ShipperDTO ShipperDTO) {
		
		this.shipperRepository.save(this.modelMapper.map(ShipperDTO, Shipper.class));
		return ShipperDTO;
	}

	@Override
	public List<ShipperDTO> listAllShipper() {
		List<Shipper> shipper=this.shipperRepository.findAll();
		List<ShipperDTO> shipperDTO=new LinkedList<>();
		for(Shipper s:shipper) 
		{
			shipperDTO.add(this.modelMapper.map(s, ShipperDTO.class));
		}
		return shipperDTO;
	}

	@Override
	public ShipperDTO getShipperById(String id) {
		Shipper shipper=this.shipperRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Shipper ID"));
		return this.modelMapper.map(shipper, ShipperDTO.class);
	}

	@Override
	public ShipperDTO updateShipper(ShipperDTO shipperDTO,String id) {
		Shipper shipper=this.shipperRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Shipper ID"));
		shipper.setShipperName(shipperDTO.getShipperName());
		this.shipperRepository.save(shipper);
		return shipperDTO;
	}

	@Override
	public void deleteShipper(String id) {
		this.shipperRepository.deleteById(id);
		
	}

}
