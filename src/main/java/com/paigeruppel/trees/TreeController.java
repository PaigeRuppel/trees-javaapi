package com.paigeruppel.trees;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TreeController {

	@Resource
	private TreesRepository repo;
	
	@RequestMapping ("/trees")
	public String fetchTrees(Model model) {
		model.addAttribute("trees", repo.findAll());
		return "treesList";
	}
	
	@RequestMapping("/tree")
	public String fetchTreeDetail(@RequestParam("id") long id, Model model) {
		Tree selectedTree = repo.findOne(id);
		model.addAttribute(selectedTree);
		return "treeDetail";
	}
}
