package com.godoro.orm.relation.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class BaseRepository<E> {
	
	private Class<E> clazz;
	public static EntityManagerFactory factory;
	
	public BaseRepository(Class<E> clazz) {
		this.clazz = clazz;
	}

	protected static EntityManagerFactory getFactory() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
			System.out.println("Varlık işletmecisi üretimliği yaratıldı.");
		}
		return factory;
	}
	
	public EntityManager newManager() {
		return getFactory().createEntityManager();
	}
	
	public void insert(E entity) {
		EntityManager manager = newManager();
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public E find(long id) {
		EntityManager manager = newManager();
		E entity = manager.find(clazz, id);
		manager.close();
		return entity;
	}
	
	private static final String  SELECT = "Select * from %s e";
	public List<E> list(){
		String jpql = String.format(SELECT, clazz.getSimpleName());
		TypedQuery<E> query = newManager().createQuery(jpql,clazz);
		List<E> entityList = query.getResultList();
		return entityList;
	}
}
