package com.jetbrains.mavendemo;

//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
 import java.lang.Thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MavenDemoApplication4Tests {

	@Test
	void contextLoads11() {
		try 
            {
                Thread.sleep(6000);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
		assertThat("🐳").isEqualTo("foo1");

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
