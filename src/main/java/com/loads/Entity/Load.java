package com.loads.Entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Load {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	 	@Column(name = "loading_point")
	    private String loadingPoint;
	 	
	 	@Column(name = "unloading_point")
	    private String unloadingPoint;
	 	
	 	@Column(name = "product_type")
	    private String productType;
	 	
	 	 @Column(name = "truck_type")
	    private String truckType;
	 	 
	 	@Column(name = "no_of_trucks")
	    private int noOfTrucks;
	 	
	    private double weight;
	    
	    private String comment;
	    
	    private String shipperId;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "shipper")
	    private Shipper shipper;
	    
	    @Column(name = "load_date")
	    private LocalDate date;

}
