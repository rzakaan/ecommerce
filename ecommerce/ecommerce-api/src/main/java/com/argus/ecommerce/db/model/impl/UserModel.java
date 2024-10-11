package com.argus.ecommerce.db.model.impl;

import com.argus.ecommerce.constant.Schema;
import com.argus.ecommerce.db.model.DbModel;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDateTime;

@Entity
@Table(name = UserModel.TABLE_NAME, schema = UserModel.SCHEMA_NAME)
public class UserModel extends DbModel<UserModel> {
    public static final String SCHEMA_NAME = Schema.SCHEMA_ECOMMERCE;
    public static final String TABLE_NAME = "user";
    public static final String TABLE_ALIAS = SCHEMA_NAME + "." + TABLE_NAME;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "group_id")
    private Integer groupId;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "enabled")
    private String enabled;

    @Basic
    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @Basic
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Transient
    public String instanceName;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean isEnabled() {
        return "Y".equals(this.enabled) ? true : false;
    }

    public String getEnabled() {
        return this.enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
