package com.gcp.cloud.functions.api.gateway;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;

public class HelloFunctionTest {

	@Test
	public void testHelloFunction() throws Exception {
		
		HelloFunction function = new HelloFunction();

		HttpRequest request = Mockito.mock(HttpRequest.class);
		OutputStream outputStream = new ByteArrayOutputStream();
		HttpResponse response = Mockito.mock(HttpResponse.class);

		Mockito.when(response.getOutputStream()).thenReturn(outputStream);

		function.service(request, response);

		String output = outputStream.toString();
		assertTrue(output.contains("Hello from GCP Cloud Function!"));
	}
}