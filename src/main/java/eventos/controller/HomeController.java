package eventos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eventos.modelo.dao.EventoDaoImplList;
import eventos.modelo.javabeans.Evento;

@Controller
public class HomeController {
	@Autowired
	private EventoDaoImplList evdao;
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<Evento> evActivo = new ArrayList<>();
		List<Evento> evCancel = new ArrayList<>();
		for (Evento evento : evdao.findAll()) {
			if ((evento.getEstado()== "A") || (evento.getEstado()== "a" ))
				evActivo.add(evento);
			else
				evCancel.add(evento);
		}
		model.addAttribute("eventosA",evActivo);
		model.addAttribute("eventosC",evCancel);
		return "home";
	}
}
