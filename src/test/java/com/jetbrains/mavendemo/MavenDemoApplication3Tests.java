package com.jetbrains.mavendemo;

//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import System;

@SpringBootTest
class MavenDemoApplication3Tests {

	@Test
	void contextLoads11() {
		System.setOut(new PrintStream(new ByteArrayOutputStream()));
		System.out.print("test output");
		System.setOut(System.out)
		assertThat("foo").isEqualTo("foo");

	}
		@Test
	void contextLoads32() {
		assertThat("foo").isEqualTo("foo");

	}
		@Test
	void contextLoads33() {
		assertThat("foo").isEqualTo("foo");

	}

}
