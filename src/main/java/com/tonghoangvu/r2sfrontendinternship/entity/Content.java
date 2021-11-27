package com.tonghoangvu.r2sfrontendinternship.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "contents")
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Must use for H2
	private Long id;

	private String userEmail;
	private String title;
	private String brief;
	private String content;
	private String createdDate;
}
