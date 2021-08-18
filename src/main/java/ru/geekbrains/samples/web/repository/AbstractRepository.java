package ru.geekbrains.samples.web.repository;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractRepository<T,Id> {
    private final EntityManager entityManager;
    private final Class<T> type;

    public AbstractRepository(EntityManager entityManager, Class<T> type) {
        this.entityManager = entityManager;
        this.type = type;
    }

    public List<T> findAll() {
        return entityManager.createQuery("select st from " + type.getSimpleName() + " as st order by st.id asc ",type).getResultList();
    }

    public T findById(Id id) {
        return entityManager.find(type,id);
    }

    public T save(T entity) {
        return entityManager.merge(entity);
    }

    public void removeById(Id id) {
        entityManager.remove(findById(id));
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

}
