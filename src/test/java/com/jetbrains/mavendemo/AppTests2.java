package com.jetbrains.mavendemo;

//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTests2 {

	@Test
	void contextLoads21() {
		assertThat("foo").isEqualTo("foo");

	}
		@Test
	void contextLoads22() {
		assertThat("foo").isEqualTo("foo");

	}
		@Test
	void contextLoads23() {
		assertThat("foo").isEqualTo("foo");

	}

}
