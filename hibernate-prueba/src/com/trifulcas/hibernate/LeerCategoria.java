package com.trifulcas.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.trifulcas.hibernate.entidades.Categorias;

public class LeerCategoria {

	public static void main(String[] args) {
		// Crear la configuraci�n cog�endola del xml y a�adiendo la clase Categorias
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Categorias.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		// Crear la factor�a de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		// Crear la sesi�n
		Session session = factory.getCurrentSession();

		try {

			// Iniciar transacci�n
			session.beginTransaction();

			// Creamos una categor�a

			Categorias cat = session.get(Categorias.class, 1);
			System.out.println(cat);
			
			@SuppressWarnings("unchecked")
			List<Categorias> lista = session
					.createQuery("from Categorias c where c.nombre like '%cat%' ").getResultList();

			for (Categorias c : lista) {
				System.out.println(c);
			}
			// commit de la transacci�n
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
