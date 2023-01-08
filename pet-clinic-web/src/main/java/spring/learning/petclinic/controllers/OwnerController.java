package spring.learning.petclinic.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.learning.petclinic.service.OwnerService;


@RequestMapping("/owners")
@Controller
@RequiredArgsConstructor
public class OwnerController {
	private final OwnerService ownerService;

	@RequestMapping(
			{
					"",
					"/",
					"/index",
					"/index.html"
			}
	)
	public String listOwners(Model model) {
		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}
}
