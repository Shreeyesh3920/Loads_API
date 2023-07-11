package com.loads.Service;

import java.util.List;

import com.loads.Payloads.LoadDTO;

public interface LoadService {

	
	public LoadDTO addLoadDetails(LoadDTO loadDTO);
	
	public List<LoadDTO> listAllLoadDetails();
	
	public LoadDTO listLoadDetailsById(Long id);
	
	public List<LoadDTO> getLoadDetailsByShipperId(String ShipperId);
	
	public LoadDTO updateLoadDetails(LoadDTO loadDTO,Long id);
	
	public void deleteLoadDetails(Long id);
	
	
}
