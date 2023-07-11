package com.loads.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loads.Entity.Load;
import com.loads.Entity.Shipper;
public interface LoadRepository extends JpaRepository<Load,Long>{
	List<Load> findByShipperId(String shipperId);
}
