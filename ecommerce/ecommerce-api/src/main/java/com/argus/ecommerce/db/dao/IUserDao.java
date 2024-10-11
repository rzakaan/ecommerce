package com.argus.ecommerce.db.dao;

import com.argus.ecommerce.db.dto.UserDto;
import com.argus.ecommerce.db.model.impl.UserModel;

import java.util.List;
import java.util.Map;

public interface IUserDao extends IBaseDao {

    public boolean createUser(UserDto userDto);

    public List<UserModel> getUser(Map<String, String> whereMap);
}