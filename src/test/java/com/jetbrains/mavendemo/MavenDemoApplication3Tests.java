package com.jetbrains.mavendemo;

//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.System.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@SpringBootTest
class MavenDemoApplication3Tests {
private final PrintStream defaultOut = System.out;
private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();


	@Test
	void outTest() {
		System.setOut(new PrintStream(outStream));
		System.out.print("test");
		System.setOut(defaultOut);
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
