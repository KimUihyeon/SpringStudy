package com.safetia.nothwind.study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:/properties/test.properties")
public class TestClsee {
	
	@Value("${test}")
	private String test;
	
	@Value("classpath:/properties/kkk.txt")
	private Resource txtFileContext;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public Resource getTxtFileContext() {
		return txtFileContext;
	}

	public void setTxtFileContext(Resource txtFileContext) {
		this.txtFileContext = txtFileContext;
	}
}
