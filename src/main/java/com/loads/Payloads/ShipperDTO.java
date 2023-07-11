package com.loads.Payloads;



import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ShipperDTO {
	
	 private String shipperId;
	 @NotEmpty(message="shipperName cannot be Null")
	 private String shipperName;
	
}
