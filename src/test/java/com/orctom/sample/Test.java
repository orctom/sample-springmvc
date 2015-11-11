package com.orctom.sample;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {

	@org.junit.Test
	public void test() throws Exception {
		String s1 = "/products/{id}/attributes/{attid}";
		String s2 = "/products/234235234/attributes/222222";
		// Assert.assertEquals(s1, s2);

		String template = "jython/was.py";
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(template);
		System.out.println("input = " + input);

		InputStreamReader isr = new InputStreamReader(input);
		BufferedReader br = new BufferedReader(isr);
		String line;
		System.out.println("==========================");
		while ((line = br.readLine()) != null) {
			System.out.println(">> " + line);
		}
		System.out.println("==========================");
		br.close();
		isr.close();
		input.close();
	}
}
