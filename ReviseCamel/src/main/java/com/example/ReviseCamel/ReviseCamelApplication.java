package com.example.ReviseCamel;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ReviseCamelApplication extends RouteBuilder {

	public static void main(String[] args) {

		SpringApplication.run(ReviseCamelApplication.class, args);
	}

	@Override
	public void configure() throws Exception {
		fun();
	}

	private void fun() {

		from("file:input").to("file:output");
		from("file:input?noop=true").to("file:output?fileName=ajay.csv");
		from("file:input").filter(header(Exchange.FILE_NAME).startsWith("ajendra")).to("file:output");
		from("file:input").filter(body().contains("ajendra")).to("file:output");
		from("file:input").filter(body().startsWith("ajendra")).to("file:output");

		from("file:input").process(p->{
			String body= p.getIn().getBody(String.class);
			StringBuilder sb=new StringBuilder();
			Arrays.stream(body.split(" ")).forEach(e->{
				sb.append(e);
			});
			p.getIn().getBody(sb);
		}).to("file:output");

		from("file:input").unmarshal().csv().split(body().tokenize(","))
				.choice().when(body().contains("close")).to("file:output");
	}
}
