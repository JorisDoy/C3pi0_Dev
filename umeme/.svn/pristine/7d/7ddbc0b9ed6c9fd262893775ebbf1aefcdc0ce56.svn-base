package com.indra.iopen.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.constraints.NotNull;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class BaseRepository<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Class<T> entityClass;

	// find count of rows in db
	public int count() {
		CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		cq.select(this.entityManager.getCriteriaBuilder().count(rt));
		javax.persistence.Query q = this.entityManager.createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}

	// merge object
	public void edit(@NotNull T entity) {
		this.entityManager.merge(entity);
	}

	// find all in the entity table
	public List<T> findAll() {
		CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return this.entityManager.createQuery(cq).getResultList();
	}

	// find by primary key
	public T findById(@NotNull Object id) {
		return this.entityManager.find(entityClass, id);
	}

	// find by range(for tables with pagination)
	public List<T> findRange(@NotNull int[] range) {
		CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		javax.persistence.Query q = this.entityManager.createQuery(cq);
		q.setMaxResults(range[1] - range[0]);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	public void remove(@NotNull Object object) {
		this.entityManager.remove(object);
	}

	// persist object
	public void save(@NotNull T entity) {
		this.entityManager.persist(entity);
	}
}
