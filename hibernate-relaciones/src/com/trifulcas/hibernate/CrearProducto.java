package com.trifulcas.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.trifulcas.hibernate.entidades.*;

public class CrearProducto {

	public static void main(String[] args) {

		// Crear la configuraci�n cog�endola del xml y a�adiendo la clase Categorias
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Categorias.class).addAnnotatedClass(Productos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		// Crear la factor�a de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		// Crear la sesi�n
		Session session = factory.getCurrentSession();

		try {

			// Iniciar transacci�n
			session.beginTransaction();

			Productos tomate = new Productos("Tomate", "Rojo como el pecado", 10);
			Categorias cat = session.get(Categorias.class, 2);
			tomate.setCategoria(cat);
			session.save(tomate);

			Productos pimiento = new Productos("Pimiento", "Del Padr�n", 5);
			Productos coliflor = new Productos("Coliflor", "Blanca y radiante", 7);
			
			cat.addProductos(coliflor);
			cat.addProductos(pimiento);
			session.save(coliflor);
			session.save(pimiento);
			// commit de la transacci�n
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
