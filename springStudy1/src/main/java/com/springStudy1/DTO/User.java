package com.springStudy1.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	private String id;
	private String userId;
	private String userPw;
	private String userEmail;
	private String userJob;
	private String userAddr;
	private String userLike;
}
