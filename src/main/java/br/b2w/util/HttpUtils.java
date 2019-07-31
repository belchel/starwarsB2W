package br.b2w.util;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

public class HttpUtils {

	public static HttpEntity<String> getServiceHeader() {		
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return new HttpEntity<String>("parameters", headers);
	}
	
	public static String getServiceUrl(String url, String endpoint,String filter) {		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+endpoint)
		        .queryParam("search", filter);
		return builder.toUriString();
	}
	
}
