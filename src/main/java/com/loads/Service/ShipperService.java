package com.loads.Service;

import java.util.List;

import com.loads.Payloads.ShipperDTO;

public interface ShipperService {
	public ShipperDTO addShipper(ShipperDTO ShipperDTO);
	
	public List<ShipperDTO> listAllShipper();
	
	public ShipperDTO getShipperById(String id);
	
	public ShipperDTO updateShipper(ShipperDTO shipperDTO,String id);
	
	public void deleteShipper(String id);
}
