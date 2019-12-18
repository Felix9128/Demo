package com.chenm.ssm.service;

import com.chenm.ssm.domain.User;

public interface IUserService {
    User queryByUsername(String username);
}
