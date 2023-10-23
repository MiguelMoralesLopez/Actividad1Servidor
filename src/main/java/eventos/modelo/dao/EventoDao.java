package eventos.modelo.dao;

import java.util.List;

import eventos.modelo.javabeans.Evento;


public interface EventoDao {
	List<Evento> findAll();
	Evento findById(int idEvento);
	int insert (Evento evento);
	int delete(int idEvento);
	int updateOne(Evento evento);
}
