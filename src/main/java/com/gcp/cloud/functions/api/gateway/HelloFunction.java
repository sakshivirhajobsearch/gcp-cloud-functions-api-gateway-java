package com.gcp.cloud.functions.api.gateway;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;

public class HelloFunction implements HttpFunction {
	
	@Override
	public void service(HttpRequest request, HttpResponse response) throws IOException {
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8));
		writer.write("Hello from GCP Cloud Function!");
		writer.flush();
	}
}
