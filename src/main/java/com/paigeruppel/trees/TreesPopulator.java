package com.paigeruppel.trees;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TreesPopulator implements CommandLineRunner {

	@Resource
	private TreesRepository treeRepo;

	@Resource
	private GenusRepository genRepo;

	@Override
	public void run(String... args) throws Exception {

		Genus quercus = new Genus("Quercus",
				"Quercus - English = Oak. Quercus belongs to the Beech family (Fagaceae). There are approximately 600 extant species of oaks.");
		Genus fraxinus = new Genus("Fraxinus",
				"Fraxinus - English = Ash. Genus of flowering plants in the olive and lilac family (Oleaceae).");
		
		genRepo.save(quercus);
		genRepo.save(fraxinus);

		treeRepo.save(new Tree("Fraxinaceae", fraxinus, "americana", "White Ash"));
		treeRepo.save(new Tree("Fagaceae", quercus, "prinus", "Pin Oak"));
		treeRepo.save(new Tree("Fagaceae", quercus, "rubra", "Northern Red Oak"));
		treeRepo.save(new Tree("Fagaceae", quercus, "coccinea", "Scarlet Oak"));

	}

}
