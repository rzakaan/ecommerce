package com.argus.ecommerce.db.dao;

import java.io.Serializable;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import com.argus.ecommerce.db.model.DbModel;

@Transactional
public abstract class BaseDao<T> implements IBaseDao, Serializable {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected EntityManager entityManager;

    // * ------------------ SQL QUERY ------------------
    protected Query createSqlQuery(String sql) {
        return entityManager.createNativeQuery(sql);
    }

    // * ------------------ CRUD FUNCTIONS ------------------
    @Override
    public <T extends DbModel> T findById(Class<T> clazz, Serializable id) {
        try {
            T entity = entityManager.find(clazz, id);
            logger.trace("findById  <" + id + ">");
            return entity;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public <T extends DbModel> void save(T entity) throws Exception {
        try {
            entityManager.persist(entity);
            entityManager.setFlushMode(FlushModeType.COMMIT);
            entityManager.flush();
            entityManager.clear();
            logger.trace("save <" + entity.hashCode() + ">");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}