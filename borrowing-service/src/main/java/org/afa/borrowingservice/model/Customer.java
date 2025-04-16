package org.afa.borrowingservice.model;

import lombok.*;

@Getter
@Setter
public class Customer {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
}
