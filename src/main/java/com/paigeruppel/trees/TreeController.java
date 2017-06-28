package com.paigeruppel.trees;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TreeController {

	@Resource
	private TreesRepository treeRepo;
	
	@Resource
	private GenusRepository genusRepo;
	
	@RequestMapping("/genera")
	public String fetchGenera(Model model) {
		model.addAttribute("genera", genusRepo.findAll());
		return "generaList";
	}

	@RequestMapping("/genus")
	public String fetchGenus(@RequestParam("id") int id, Model model) {
		model.addAttribute(genusRepo.findOne(id));
		return "genusDetail";
	}
	
	
	@RequestMapping ("/trees")
	public String fetchTrees(Model model) {
		model.addAttribute("trees", treeRepo.findAll());
		return "treesList";
	}
	
	@RequestMapping("/tree")
	public String fetchTreeDetail(@RequestParam("id") long id, Model model) {
		Tree selectedTree = treeRepo.findOne(id);
		model.addAttribute(selectedTree);
		return "treeDetail";
	}
	
	@RequestMapping("/addSpecies") 
	public String addSpecies(@RequestParam("genusId") int id, @RequestParam("name") String newSpeciesName, Model model) {
		Genus selected = genusRepo.findOne(id);
		Tree newSpecies = new Tree("X", selected, newSpeciesName, "X");
		treeRepo.save(newSpecies);
		
		return "redirect:/genus?id=" + id;
	}
	
	@RequestMapping("/species/delete")
	public String deleteSpecies(@RequestParam("speciesId") long speciesId) {
		Tree toDelete = treeRepo.findOne(speciesId);
		int genusId = toDelete.getGenus().getId();
		
		treeRepo.delete(toDelete);
		
		return "redirect:/genus?id=" + genusId;
	}
	
}
