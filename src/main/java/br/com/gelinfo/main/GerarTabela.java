package br.com.gelinfo.main;

import br.com.gelinfo.util.HibernateUtil;

public class GerarTabela {

	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();

	}

}
