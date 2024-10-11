package com.argus.ecommerce.db.dao.impl;

import com.argus.ecommerce.db.dao.BaseDao;
import com.argus.ecommerce.db.dao.IUserDao;
import com.argus.ecommerce.db.dto.UserDto;
import com.argus.ecommerce.db.model.impl.UserModel;
import org.springframework.stereotype.Repository;
import jakarta.persistence.Query;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao extends BaseDao<UserModel> implements IUserDao {

    // QUERIES
    public static String QUERY_CREATE_USER = "INSERT INTO ecommerce.user(username, email, enabled) VALUES(:name, :email, :enable)";

    @Override
    public boolean createUser(UserDto userDto) {
        Query query = createSqlQuery(QUERY_CREATE_USER);
        query.setParameter("name", userDto.getUsername());
        query.setParameter("email", userDto.getEmail());
        query.setParameter("enable", 1);
        int retVal = query.executeUpdate();
        entityManager.flush();
        entityManager.clear();
        return retVal == 0 ? false : true;
    }

    @Override
    public List<UserModel> getUser(Map<String, String> whereMap) {
        String sql = "SELECT * FROM " + UserModel.TABLE_ALIAS + " WHERE 1=1 ";
        StringBuilder s = new StringBuilder(sql);

        // add condition sql
        for (String key : whereMap.keySet()) {
            s.append(" AND " + key + " = " + "'" + whereMap.get(key) + "'");
        }

        s.append(" ORDER BY id");

        Query query = createSqlQuery(s.toString());
        List<Object> resultList = query.getResultList();
        List<UserModel> returnList = new ArrayList<>();

        for (Object obj : resultList) {
            Object[] objVal = (Object[]) obj;

            UserModel model = new UserModel();
            model.setId((int) objVal[0]);
            model.setGroupId((int) objVal[1]);
            model.setUsername((String) objVal[2]);
            model.setEmail((String) objVal[3]);
            model.setPassword((String) objVal[4]);
            model.setEnabled((String) objVal[5]);
            model.setCreationTime(((Timestamp) objVal[6]).toLocalDateTime());
            model.setUpdateTime(((Timestamp) objVal[7]).toLocalDateTime());
            returnList.add(model);
        }

        return returnList;
    }
}
