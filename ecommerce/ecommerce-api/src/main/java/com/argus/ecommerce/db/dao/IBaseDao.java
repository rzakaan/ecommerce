package com.argus.ecommerce.db.dao;

import java.io.Serializable;

import com.argus.ecommerce.db.model.DbModel;

public interface IBaseDao {

    <T extends DbModel> T findById(Class<T> clazz, Serializable id);

    <T extends DbModel> void save(T entity) throws Exception;

    /*
     * <T extends DbModel> void update(T entity);
     * 
     * <T extends DbModel> void saveOrUpdate(T entity);
     * 
     * <T extends DbModel> void delete(T entity);
     * 
     * <T extends DbModel> void flush(T entity);
     */
}
