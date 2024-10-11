package com.argus.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argus.ecommerce.db.dao.impl.UserDao;
import com.argus.ecommerce.db.dto.UserDto;
import com.argus.ecommerce.db.model.impl.UserModel;
import com.argus.ecommerce.service.BaseService;
import com.argus.ecommerce.util.JDate;

@Service
public class UserService extends BaseService {
    @Autowired
    private UserDao userDAO;

    public UserDto createUser(UserDto dto) {
        logger.trace("Begin createUser()");

        UserModel entity = new UserModel();
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setCreationTime(JDate.getDateTime());
        entity.setUpdateTime(JDate.getDateTime());
        entity.setGroupId(1);
        entity.setEnabled("1");

        try {
            userDAO.save(entity);
            logger.debug("save UserModel <" + entity.getId() + ">");
            logger.trace("End createdUser()");
            return dto;
        } catch (Exception e) {
            logger.error("Error catch ", e);
        }
        return null;
    }
}