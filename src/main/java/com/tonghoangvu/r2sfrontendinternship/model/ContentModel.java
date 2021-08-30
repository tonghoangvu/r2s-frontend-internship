package com.tonghoangvu.r2sfrontendinternship.model;

import com.tonghoangvu.r2sfrontendinternship.entity.Content;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentModel {
	private Long id;
	// private String userEmail;
	private String title;
	private String brief;
	private String content;
	private String createdDate;

	public ContentModel(Content content) {
		id = content.getId();
		// userEmail = content.getUserEmail();
		title = content.getTitle();
		brief = content.getBrief();
		this.content = content.getContent();
		createdDate = content.getCreatedDate();
	}
}
