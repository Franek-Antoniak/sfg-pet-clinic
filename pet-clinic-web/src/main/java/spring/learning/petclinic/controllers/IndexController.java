package spring.learning.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;

@Controller
public class IndexController {
	@RequestMapping(
			{
					"",
					"/",
					"index",
					"index.html"
			}
	)
	public String index() {
		return "index";
	}

	@ResponseStatus(value = NOT_IMPLEMENTED)
	@RequestMapping("/oups")
	public String oupsHendler() {
		return "notimplemented";
	}
}
