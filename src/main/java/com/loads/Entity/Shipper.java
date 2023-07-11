package com.loads.Entity;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Shipper {

	    @Id
	    @GeneratedValue(generator = "uuid2")
	    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	    @Column(name = "shipper_id", columnDefinition = "VARCHAR(36)")
	    private String shipperId;

	    @Column(name = "shipper_name")
	    private String shipperName;

		
}
