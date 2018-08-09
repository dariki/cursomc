package com.netcracker.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.netcracker.cursomc.dao.CategoryDAO;
import com.netcracker.cursomc.dao.CityDAO;
import com.netcracker.cursomc.dao.ProductDAO;
import com.netcracker.cursomc.dao.StateDAO;
import com.netcracker.cursomc.domain.Category;
import com.netcracker.cursomc.domain.City;
import com.netcracker.cursomc.domain.Product;
import com.netcracker.cursomc.domain.State;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	StateDAO stateDAO;
	
	@Autowired
	CityDAO cityDAO;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category computers = new Category(null, "Computers");
		Category office = new Category(null, "Office");
		
		Product computer = new Product(null, "Computer", 2000d);
		Product printer = new Product(null, "Printer", 800d);
		Product mouse = new Product(null, "Mouse", 80d);
		
		computers.getProducts().addAll(Arrays.asList(computer,printer, mouse));
		office.getProducts().add(printer);
		
		computer.getCategories().add(computers);
		printer.getCategories().addAll(Arrays.asList(computers,office));
		mouse.getCategories().add(computers);
		
		categoryDAO.saveAll(Arrays.asList(computers,office));
		productDAO.saveAll(Arrays.asList(computer, printer, mouse));
		
		State minasGerais = new State(null, "Minas Gerais");
		State saoPauloState = new State(null, "São Paulo");
		
		City uberlandia = new City(null, "Uberlândia");
		City saoPauloCity = new City(null, "São Paulo");
		City campinas = new City(null, "Campinas");
		
		minasGerais.getCities().add(uberlandia);
		saoPauloState.getCities().addAll(Arrays.asList(saoPauloCity, campinas));
		
		uberlandia.setState(minasGerais);
		saoPauloCity.setState(saoPauloState);
		campinas.setState(saoPauloState);
		
		stateDAO.saveAll(Arrays.asList(minasGerais, saoPauloState));
		cityDAO.saveAll(Arrays.asList(uberlandia, saoPauloCity, campinas));
		
	}
}
