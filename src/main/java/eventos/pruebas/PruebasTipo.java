package eventos.pruebas;

import eventos.modelo.dao.EventoDaoImplList;
import eventos.modelo.dao.TipoDaoImplList;

public class PruebasTipo {

	public static void main(String[] args) {
		TipoDaoImplList tipoDao = new TipoDaoImplList();
		System.out.println(tipoDao.findAll());
		EventoDaoImplList evdao = new EventoDaoImplList();
		System.out.println(evdao.findAll());
	}

}
