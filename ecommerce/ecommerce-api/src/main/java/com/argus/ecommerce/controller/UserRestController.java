package com.argus.ecommerce.controller;

import com.argus.ecommerce.db.dao.IUserDao;
import com.argus.ecommerce.db.dto.UserDto;
import com.argus.ecommerce.db.model.impl.UserModel;
import com.argus.ecommerce.response.BaseResponse;
import com.argus.ecommerce.response.ServiceError;
import com.argus.ecommerce.response.impl.UserResponse;
import com.argus.ecommerce.service.impl.UserService;
import com.argus.ecommerce.util.JDate;
import com.argus.ecommerce.util.JUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping(UserRestController.USERS_URL)
public class UserRestController extends BaseRestController {
    public static final String USERS_URL = BASE_URL + "/users";

    @Autowired
    private UserService userService;

    @Autowired
    private IUserDao userDAO;

    @GetMapping("/{id}")
    public BaseResponse getUserById(@PathVariable Integer id) {
        logger.debug("GET users/" + id);

        BaseResponse response = new BaseResponse();
        try {
            UserModel model = userDAO.findById(UserModel.class, id);

            // create response data
            UserResponse content = new UserResponse();
            JUtil.copyValue(model, content);
            response.setContent(Arrays.asList(content));
            response.setStatusCode(HttpStatus.CREATED);

        } catch (Exception e) {
            logger.error(e.getMessage());
            response.setError(Arrays.asList(new ServiceError(1, e.getMessage())));
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.setTime(JDate.getDateTime());
        return response;
    }

    @GetMapping("/name/{name}")
    public List<UserModel> getUserByName(@PathVariable String name) {
        logger.debug("GET users/name/" + name);

        Map<String, String> whereMap = new HashMap<>();
        whereMap.put("username", name);
        List<UserModel> list = userDAO.getUser(whereMap);

        return list;
    }

    @GetMapping("/create/{name}")
    public UserResponse createUser(@PathVariable String name) {
        logger.debug("GET users/create/" + name);

        UserDto dto = new UserDto();
        dto.setUsername(name);
        UserDto returnDto = userService.createUser(dto);
        UserResponse response = new UserResponse();
        JUtil.copyValue(returnDto, response);
        return response;
    }
}