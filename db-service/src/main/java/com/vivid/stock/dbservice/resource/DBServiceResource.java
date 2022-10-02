package com.vivid.stock.dbservice.resource;

import org.springframework.web.bind.annotation.RestController;

import com.vivid.stock.dbservice.model.Symbol;
import com.vivid.stock.dbservice.model.Symbols;
import com.vivid.stock.dbservice.repository.SymbolsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value="/rest/db")
public class DBServiceResource {
	
@Autowired	
private SymbolsRepository symbolsRepository;

public DBServiceResource (SymbolsRepository symbolsRepository){
	this.symbolsRepository = symbolsRepository;
}
@GetMapping ("/{username}")
//@GetMapping(path = "/{username}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//@GetMapping ("/getsymbols/{username}")
	public List<String> getSymbols(@PathVariable("username") final String username){

		return getSymbolsByUserName(username);
	}

@GetMapping ("/getnumber/{whatever}")
	public int getNumber(@PathVariable("whatever") final String whatever){
		
		return 10;
	}
	
private List<String> getSymbolsByUserName(final String username){
	//private List<String> getSymbolsByUserName(@PathVariable("username") final String username){
		return symbolsRepository.findByUserName(username)
				.stream()
				.map(Symbol::getSymbol)
				.collect(Collectors.toList());
	}
	
@PostMapping("/add")
//@RequestMapping(value = "/rest/db/add", method = RequestMethod.POST) 
public List<String> add(@RequestBody final Symbols symbols){
	symbols.getSymbols()
	.stream()
	.map(symbol -> new Symbol(symbols.getUserName(), symbol) )
	.forEach(symbol -> {symbolsRepository.save(symbol);
	});
	//System.out.print("username passed is " + symbols.getUserName());
return getSymbolsByUserName(symbols.getUserName());
}


@PostMapping("/delete/{username}")
public List<String> delete(@PathVariable ("username") final String username){
	List<Symbol> symbols = symbolsRepository.findByUserName(username);
	symbolsRepository.deleteInBatch(symbols);
	return getSymbolsByUserName(username);
}
	
}


