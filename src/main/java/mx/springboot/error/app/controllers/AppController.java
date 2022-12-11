package mx.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import mx.springboot.error.app.customErrors.UserNotFoundException;
import mx.springboot.error.app.domain.User;
import mx.springboot.error.app.services.UserService;

@Controller
public class AppController {

	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unused")	//No mostrar warning del integer
	@GetMapping( "/index")
	public String index(Model modelo) {
		Integer valor = 100/0;
//		Integer valor = Integer.parseInt("10f");
		return "index";
	}
	
	
	@GetMapping("/detalles/{id}")
	public String detalles(@PathVariable Integer id,Model modelo ) {
//		User usuario = userService.obtenerPorId(id);
//		
//		if(usuario == null) {	//Lanzar excepcion personalizada (package customErrors)
//			throw new UserNotFoundException(id.toString());
//		}
		//Version Optional
		User usuario = userService.obtenerPorIdOptional(id).orElseThrow(() -> new UserNotFoundException(id.toString()));
		modelo.addAttribute("titulo","Detalles de ".concat(usuario.getName()));
		modelo.addAttribute("user", usuario);
		return "detalles";
	}
	
	
}
