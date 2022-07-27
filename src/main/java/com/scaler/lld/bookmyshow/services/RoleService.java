package com.scaler.lld.bookmyshow.services;

import com.scaler.lld.bookmyshow.exception.ServiceException;
import com.scaler.lld.bookmyshow.models.Role;

public interface RoleService {

    public Role getRoleById(Long id);

    public Role getRole(String name) throws ServiceException;
}
