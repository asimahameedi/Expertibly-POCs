package com.vivid.stock.stockservice.resource;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(value="/rest/price")
//@RequestMapping("/rest/price")
public class StockResource {
	
//@Autowired - marks a constructor, field, or setter method to be autowired by Spring.I
	//Inject the object dependency implicitly
	@Autowired
	RestTemplate restTemplate;
	 @Autowired
	   private DiscoveryClient discoveryClient;
	 
	   @RequestMapping("/lookup/{serviceId}")
	   public List<ServiceInstance> lookup(@PathVariable String serviceId) {
//	      return discoveryClient.getInstances(serviceId);
	      return discoveryClient.getInstances(serviceId);
	   }
//	@GetMapping("/{username}")
//	public List<Stock> getStock(@PathVariable("username") final String userName){
//		
////		List<String> symbols=restTemplate.getForObject("http://localhost:8300/rest/db/"+userName, List.class);
//		List<String> symbols=restTemplate.getForObject("http://db-service/rest/db/"+userName, List.class);
//		
//		//ResponseEntity<List<String>> symbolResponse = restTemplate.exchange("http://localhost:8300/rest/db/"+userName, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
//		//List<String> symbols = symbolResponse.getBody();
//		System.out.println("getStock *******");
//		return symbols
//		.stream()
//		.map(this::getStockPrice)
//		.collect(Collectors.toList());
//		
//		
//	}
	
	
@GetMapping("/{username}")
public List<Quote> getQuote(@PathVariable("username") final String userName){
	System.out.println("BEFORE Connecting to PROD ");
//	List<String> symbols=restTemplate.getForObject("http://DB-SERVICE-LOCAL/rest/db/"+userName, List.class);
//	List<String> symbols=restTemplate.getForObject("http://DB-SERVICE-PROD/rest/db/"+userName, List.class);
	System.out.println("Connected to PROD asima");
		List<String> symbols=restTemplate.getForObject("http://db-service/rest/db/"+userName, List.class);
//	List<String> symbols=restTemplate.getForObject("http://18.221.153.248:8300/rest/db/"+userName, List.class);
//		List<String> symbols=restTemplate.getForObject("http://0.0.0.0:8081/db-service/rest/db/"+userName, List.class);
//	List<String> symbols=restTemplate.getForObject("http://localhost:8080/db-service/rest/db/"+userName, List.class);
	
		return symbols
				.stream()
				.map(symbol ->{
					Stock stock = getStockPrice(symbol);
					System.out.println("stock is: "+ stock.toString());
					return new Quote(symbol, stock.getQuote().getPrice());
				})
				.collect(Collectors.toList());
		
	}
	private Stock getStockPrice(String symbol){
		try {
		return YahooFinance.get(symbol);
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//empty stock
			return new Stock(symbol);
		}
		
	}

	private class Quote{
		private String quote;
		private BigDecimal price;
		
		public Quote(String quote, BigDecimal price) {
			super();
			this.quote = quote;
			this.price = price;
		}
		public String getQuote() {
			return quote;
		}
		public void setQuote(String quote) {
			this.quote = quote;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		
	}
}
