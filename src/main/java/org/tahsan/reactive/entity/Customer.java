package org.tahsan.reactive.entity;

import org.springframework.data.annotation.Id;



public class Customer {
    
	@Id
    private Long id;
    private String customer_name;
    private String customer_type;
    private String customer_status;

    public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Customer(Long id, String customer_name, String customer_type, String customer_status) {
		super();
		this.id = id;
		this.customer_name = customer_name;
		this.customer_type = customer_type;
		this.customer_status = customer_status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}

	public String getCustomer_status() {
		return customer_status;
	}

	public void setCustomer_status(String customer_status) {
		this.customer_status = customer_status;
	}

	public boolean hasId() {
        return id != null;
    }
}
