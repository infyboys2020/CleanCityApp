package com.clean.springbootstarter.services;

import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class EmailService {
	private static final String URL ="https://api.mailgun.net/v3/";
	private static final String YOUR_DOMAIN_NAME ="sandbox27f2c1264c8840c6960a59226435272a.mailgun.org";
	private static final String API_KEY ="7c608df8916639df7729438b97b02126-6ae2ecad-c9907610";
	
	public JsonNode sendSimpleMessage() throws UnirestException {

        HttpResponse<JsonNode> request = Unirest.post(URL + YOUR_DOMAIN_NAME + "/messages")
            .basicAuth("api", API_KEY)
            .field("from", "Clean City Manager <alerts@cleancity.COM>")
            .field("to", "infyboys2020@gmail.com")
            .field("subject", "Complaint registered")
            .field("text", "testing")
            .asJson();

        return request.getBody();
    }
}
