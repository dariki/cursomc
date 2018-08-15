package com.netcracker.cursomc;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.netcracker.cursomc.dao.AddressDAO;
import com.netcracker.cursomc.dao.CategoryDAO;
import com.netcracker.cursomc.dao.CityDAO;
import com.netcracker.cursomc.dao.CustomerDAO;
import com.netcracker.cursomc.dao.OrderDAO;
import com.netcracker.cursomc.dao.ProductDAO;
import com.netcracker.cursomc.dao.StateDAO;
import com.netcracker.cursomc.dao.enums.CustomerType;
import com.netcracker.cursomc.domain.Address;
import com.netcracker.cursomc.domain.Category;
import com.netcracker.cursomc.domain.City;
import com.netcracker.cursomc.domain.Customer;
import com.netcracker.cursomc.domain.Order;
import com.netcracker.cursomc.domain.Product;
import com.netcracker.cursomc.domain.State;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private StateDAO stateDAO;
	
	@Autowired
	private CityDAO cityDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private OrderDAO orderDAO;

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
		
		Customer mariaSilva = new Customer(null, "Maria Silva", "mariasilva@gmail.com", "36378912377", CustomerType.PERSON);
		
		customerDAO.saveAll(Arrays.asList(mariaSilva));
		
		Address ruaFlores = new Address(null, "Rua Flores", "300", "Apto 203", "Jardins", "38220-834", uberlandia, mariaSilva);
		Address avenidaMatos = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777-012", saoPauloCity, mariaSilva);
		
		addressDAO.saveAll(Arrays.asList(ruaFlores, avenidaMatos));
		
		Order order1 = new Order(null, Calendar.getInstance(), mariaSilva, ruaFlores);
		Order order2 = new Order(null, Calendar.getInstance(), mariaSilva, avenidaMatos);
		
		orderDAO.saveAll(Arrays.asList(order1, order2));
		
	}
}
