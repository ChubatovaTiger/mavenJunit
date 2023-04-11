package com.jetbrains.mavendemo;

//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.System.*;

@SpringBootTest
class MavenDemoApplicationTests {

	@Test
	void contextLoads11() {
		assertThat("foo").isEqualTo("bar");

	}
		@Test
	void contextLoads12() {
		System.out.println("lisa");
		assertThat("foo").isEqualTo("foo");

	}
		@Test
	void contextLoads13() {
		assertThat("foo").isEqualTo("bar");

	}

}
