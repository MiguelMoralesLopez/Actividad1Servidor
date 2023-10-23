package eventos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eventos.modelo.dao.EventoDao;
import eventos.modelo.javabeans.Evento;

@Controller
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
	private EventoDao evdao;
	
	@GetMapping("/detalle/{id}")
	public String verEvento(@PathVariable("id") int idEvento, Model model) {
		
		Evento evento = evdao.findById(idEvento);
		if (evento != null) {
			model.addAttribute("evento", evento);
			return "verDetalle";
		}
		else {
			model.addAttribute("mensaje", "Este cliente no existe");
			return "forward:/";
		}
	}
	
	@PostMapping("/alta")
	public String procesarFormAlta(Evento evento) {
		if (evdao.insert(evento) == 1) 
			System.out.println(evento);
		return "redirect:/";
	}
	
	@GetMapping("/alta")
	public String mostrarFormAltaEvento() {
		return"formAlta";
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelarCliente(@PathVariable("id") int idCliente, Model model) {
		Evento evento = evdao.findById(idCliente);
		if (evento != null) {
			evento.setEstado("C");
			model.addAttribute("eventoC", evento);
			}
		return "redirect:/";
		
	}
	
	@GetMapping("/activar/{id}")
	public String activarCliente(@PathVariable("id") int idEvento, Model model) {
		Evento evento = evdao.findById(idEvento);
		if (evento != null) {
			evento.setEstado("A");
			model.addAttribute("eventoA", evento);
			}
		return "redirect:/";
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarEvento(@PathVariable("id") int idEvento, Model model) {
		
		if (evdao.delete(idEvento) == 1)
			model.addAttribute("mensaje", "Cliente eliminado correctamente");
		else
			model.addAttribute("mensaje", "Cliente NOO se ha podido eliminar");
		
		return "redirect:/";
		
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
