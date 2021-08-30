package com.tonghoangvu.r2sfrontendinternship.controller;

import com.tonghoangvu.r2sfrontendinternship.model.ContentForm;
import com.tonghoangvu.r2sfrontendinternship.model.ContentModel;
import com.tonghoangvu.r2sfrontendinternship.service.AuthService;
import com.tonghoangvu.r2sfrontendinternship.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ContentController {
	private final AuthService authService;
	private final ContentService contentService;

	@PostMapping("/content")
	public ContentModel addContent(@Valid ContentForm contentForm) {
		String myEmail = authService.getEmail();
		return new ContentModel(contentService.createContent(myEmail, contentForm));
	}
}
