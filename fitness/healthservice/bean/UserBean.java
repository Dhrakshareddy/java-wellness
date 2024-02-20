package com.healthservice.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserBean {
	private Long userId;
	private String userName;
	private String password;
	private String dob;
	private Integer age;

}
