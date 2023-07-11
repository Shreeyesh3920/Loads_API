package com.loads.Service;


import java.util.LinkedList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loads.Entity.*;
import com.loads.Payloads.LoadDTO;

import com.loads.Repository.LoadRepository;
import com.loads.Repository.ShipperRepository;

@Service
public class LoadServiceImpl implements LoadService{
	@Autowired
	LoadRepository loadRepository;
	@Autowired
	ShipperRepository shipperRepository;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public LoadDTO addLoadDetails(LoadDTO loadDTO) {
		Load load = new Load();
		
		
        load.setLoadingPoint(loadDTO.getLoadingPoint());
        load.setUnloadingPoint(loadDTO.getUnloadingPoint());
        load.setProductType(loadDTO.getProductType());
        load.setTruckType(loadDTO.getTruckType());
        load.setNoOfTrucks(loadDTO.getNoOfTrucks());
        load.setWeight(loadDTO.getWeight());
        load.setComment(loadDTO.getComment());
        load.setDate(loadDTO.getDate());
        load.setShipperId(loadDTO.getShipperId());
        load.setShipper(this.shipperRepository.findById(loadDTO.getShipperId()).orElseThrow(() -> new IllegalArgumentException("Invalid Shipper ID")));
        this.loadRepository.save(load);
		return this.modelMapper.map(load, LoadDTO.class);
	}

	@Override
	public List<LoadDTO> listAllLoadDetails() {
		List<Load> loads = loadRepository.findAll();
		List<LoadDTO> loadDTOList = new LinkedList<>();
		for (Load load : loads) {
			LoadDTO loadDTO = modelMapper.map(load, LoadDTO.class);
			loadDTOList.add(loadDTO);
		}
		return loadDTOList;
	}

	@Override
	public List<LoadDTO> getLoadDetailsByShipperId(String id) {
		if(id==null) 
		{	List<LoadDTO> loadDTOList = new LinkedList<>();
			List<Load> loadlist=this.loadRepository.findAll();
			for (Load load : loadlist) {
			
				loadDTOList.add(this.modelMapper.map(load, LoadDTO.class));
			}
			return loadDTOList;
		}
		List<Load> loads = loadRepository.findByShipperId(id);
		List<LoadDTO> loadDTOList = new LinkedList<>();
		for (Load load : loads) {
			LoadDTO loadDTO = modelMapper.map(load, LoadDTO.class);
			loadDTOList.add(loadDTO);
		}
		return loadDTOList;
	}

	@Override
	public LoadDTO updateLoadDetails(LoadDTO loadDTO, Long id) {
		Load load = loadRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid Load ID"));
		load.setUnloadingPoint(loadDTO.getUnloadingPoint());
		load.setComment(loadDTO.getComment());
		load.setDate(loadDTO.getDate());
		load.setLoadingPoint(loadDTO.getLoadingPoint());
		load.setNoOfTrucks(loadDTO.getNoOfTrucks());
		load.setProductType(loadDTO.getProductType());
		
		load.setWeight(loadDTO.getWeight());
		loadRepository.save(load);
		return modelMapper.map(load, LoadDTO.class);
	}

	@Override
	public void deleteLoadDetails(Long id) {
		loadRepository.deleteById(id);
	}

	@Override
	public LoadDTO listLoadDetailsById(Long id) {
		Load load = loadRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid Load ID"));
		return modelMapper.map(load, LoadDTO.class);
	}
	
	
}
