package com.techtask.user.dao.abstraction;

import com.techtask.baseservices.dao.BaseDaoService;
import com.techtask.user.model.UserModel;

public interface UserDaoService extends BaseDaoService<UserModel> {
    UserModel findByEmail(String email);
}
