package eventos.modelo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import eventos.modelo.javabeans.Evento;

@Repository
public class EventoDaoImplList implements EventoDao {
	private List<Evento> lista;
	private static int idAuto;
	
	static {
		idAuto=0;
	}
	public EventoDaoImplList() {
		lista = new ArrayList<>();
		cargarLista();
	}
	
	private void cargarLista() {
		TipoDaoImplList tipoDao = new TipoDaoImplList();
		lista.add(new Evento(1, "Enlace Pérez-Márquez","Celebración de enlace matrimonial", new Date(), "A", "S", 150, 100, 15000.00, tipoDao.findById(1)));
		lista.add(new Evento(2, "Cumpleaños Álvarez Nuñez, Jose Miguel","Fiesta de cumpleaños familiar", new Date(1707162401000L), "c", "S", 50, 25, 575.99, tipoDao.findById(2) ));
		lista.add(new Evento(3, "Despedida Pérez García, Laura","Despedida de soltera", new Date(1719863201000L), "A", "S", 35, 20, 199.99, tipoDao.findById(3) ));
		lista.add(new Evento(4, "Concierto Ladilla Rusa","Evento musical pop", new Date(1729021601000L), "a", "S", 1500, 1000, 57000.00, tipoDao.findById(4) ));
		idAuto = 5;
	}
	
	
	@Override
	public List<Evento> findAll() {
		return lista;
	}

	@Override
	public Evento findById(int idEvento) {
		for (int i = 0; i < lista.size();i++) {
			if (lista.get(i).getIdEvento() == idEvento)
				return lista.get(i);
		}
		return null;
	}

	@Override
	public int insert(Evento evento) {
		if (!lista.contains(evento)) {
			evento.setIdEvento(++idAuto);
			evento.setIdTipo(null);
			lista.add(evento);
			
			return 1;
		}
		return 0;
	}

	@Override
	public int delete(int idEvento) {
		Evento evento = findById(idEvento);
		if (evento == null) 
			return 0;
		
		return lista.remove(evento) ? 1 : 0;
	}

	@Override
	public int updateOne(Evento evento) {
		int pos = lista.indexOf(evento);
		if (pos == -1)
			return 0;
		lista.set(pos, evento);
		return 1;
	}

}
