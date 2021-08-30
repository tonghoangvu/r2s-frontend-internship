package com.tonghoangvu.r2sfrontendinternship.service;

import com.tonghoangvu.r2sfrontendinternship.entity.Content;
import com.tonghoangvu.r2sfrontendinternship.model.ContentForm;
import com.tonghoangvu.r2sfrontendinternship.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentService {
	private final ContentRepository contentRepository;

	public Content createContent(String userEmail, ContentForm contentForm) {
		var content = new Content();
		content.setUserEmail(userEmail);
		content.setTitle(contentForm.getTitle());
		content.setBrief(contentForm.getBrief());
		content.setContent(contentForm.getContent());
		content.setCreatedDate(contentForm.getCreatedDate());
		return contentRepository.save(content);
	}
}
