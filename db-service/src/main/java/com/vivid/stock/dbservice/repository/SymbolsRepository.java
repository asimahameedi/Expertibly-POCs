package com.vivid.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivid.stock.dbservice.model.Symbol;


public interface SymbolsRepository extends JpaRepository<Symbol, Integer>{
	
	List<Symbol> findByUserName(String user_name);
	

}
