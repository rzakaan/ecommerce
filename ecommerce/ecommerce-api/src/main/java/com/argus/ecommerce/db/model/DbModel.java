
package com.argus.ecommerce.db.model;

import java.io.Serializable;
import org.springframework.data.annotation.Transient;

public abstract class DbModel<T> implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    @Transient
    private DbStatus status = DbStatus.EXIST;

    // getter and setter
    public DbStatus getStatus() {
        return this.status;
    }

    public void setStatus(DbStatus status) {
        this.status = status;
    }

    public boolean equalsWithHashCode(DbModel object) {
        try {
            return (hashCode() + "").equals(object.hashCode() + "");
        } catch (Exception e) {
        }
        return false;
    }
}
