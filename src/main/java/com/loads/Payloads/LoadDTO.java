package com.loads.Payloads;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class LoadDTO {
	@NotEmpty(message="loadingPoint cannot be Null")
    private String loadingPoint;
	@NotEmpty(message="unloadingPoint cannot be Null")
    private String unloadingPoint;
	@NotEmpty(message="productType cannot be Null")
    private String productType;
	@NotEmpty(message="truckType cannot be Null")
    private String truckType;
	@NotNull(message = "noOfTrucks must not be null")
    private int noOfTrucks;
	@NotNull(message = "Weight must not be null")
    private double weight;
    
    private String comment;
    
    @NotEmpty(message="shipperId cannot be Null")
    @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}"
	,message="Invalid ShipperID")
	
    private String shipperId;
    
    private LocalDate date;
}
