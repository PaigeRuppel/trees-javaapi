package com.paigeruppel.trees;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TreesPopulator implements CommandLineRunner {
	
	@Resource
	private TreesRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Tree("Fagaceae", "Fagus", "grandifolia", "American Beech"));
		repo.save(new Tree("Fraxinaceae", "Fraxinus", "americana", "White Ash"));
		repo.save(new Tree("Fagaceae", "Quercus", "prinus", "Pin Oak"));
		repo.save(new Tree("Sapindaceae", "Acer", "saccharum", "Sugar Maple"));
		repo.save(new Tree("Platanaceae", "Platanus", "occidentalis", "Sycamore", "platanus-occidentalis.jpg"));
	}

}
