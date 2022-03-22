package com.tonghoangvu.r2sfrontendinternship;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class R2sFrontendInternshipApplicationTests {
	@Test
	void contextLoads(ApplicationContext context) {
		// https://www.jvt.me/posts/2021/06/25/spring-context-test/
		Assertions.assertThat(context).isNotNull();
	}
}
