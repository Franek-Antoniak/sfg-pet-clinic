package spring.learning.petclinic.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/owners/{ownerId}")
@RequiredArgsConstructor
public class PetController {

}
