package com.vivid.stock.dbservice.model;

import java.util.List;

public class Symbols {
	
	private String userName;
	private List<String> symbols;
	
	
	public Symbols(){
		
	}
	
	public Symbols(String userName, List<String> symbols) {
			this.userName = userName;
			this.symbols = symbols;
		}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getSymbols() {
		return symbols;
	}
	public void setSymbols(List<String> symbols) {
		this.symbols = symbols;
	}
	
}
