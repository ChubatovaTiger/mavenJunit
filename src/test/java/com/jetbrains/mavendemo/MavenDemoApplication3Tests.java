package com.jetbrains.mavendemo;
import java.util.Vector;

//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.System.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Thread;

@SpringBootTest
class MavenDemoApplication3Tests {
private final PrintStream defaultOut = System.out;
private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outStream));
	}

	@AfterEach
	public void restoreStreams() {
		System.setOut(defaultOut);
	}
	
	@Test
	void outTest() {
		
		System.out.println("bober");

		assertThat("foo").isEqualTo("foo");
	}


		@Test
	void contextLoads32() {
		assertThat("foo").isEqualTo("foo");

	}

		@Test
	void contextLoads11() {
    Vector v = new Vector();
    while (true)
    {
      byte b[] = new byte[1048576];
      v.add(b);
      Runtime rt = Runtime.getRuntime();
      System.out.println( "free memory: " + rt.freeMemory() );
    }


}
