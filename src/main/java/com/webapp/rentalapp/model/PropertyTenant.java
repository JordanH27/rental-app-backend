package com.webapp.rentalapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class PropertyTenant implements Serializable {

	private static final long serialVersionUID = -8612574935320894381L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	Long propertyTenantID;
	Long propertyID;
	Long tenantID;
	
//	@JsonBackReference
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "propertyID")
//	private Property property;
//	
//	@JsonBackReference
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "tenantID")
//	private Tenant tenant;
		
//	@JsonManagedReference
//	@OneToMany(mappedBy = "propertyTenant", cascade = CascadeType.ALL)
//	private Set<Invoice> invoice;

		public PropertyTenant(Long propertyTenantID, Long propertyID, Long tenantID) {
			this.propertyTenantID = propertyTenantID;
			this.propertyID = propertyID;
			this.tenantID = tenantID;
		}

		public PropertyTenant(Long propertyID, Long tenantID) {
			this.propertyID = propertyID;
			this.tenantID = tenantID;
		}
		
	
		
		

		
	    
}
