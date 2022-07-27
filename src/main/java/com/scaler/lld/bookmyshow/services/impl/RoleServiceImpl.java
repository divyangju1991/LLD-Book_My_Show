package com.scaler.lld.bookmyshow.services.impl;

import com.scaler.lld.bookmyshow.exception.ServiceException;
import com.scaler.lld.bookmyshow.models.Role;
import com.scaler.lld.bookmyshow.repositories.RoleRepository;
import com.scaler.lld.bookmyshow.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleById(Long id) {
        return roleRepository.getById(id);
    }

    public Role getRole(String name) throws ServiceException {
        Optional <Role> role = roleRepository.getRoleByName(name);
        if(!role.isPresent()){
            throw new ServiceException("No Role found for name : "+name, null);
        }

        return role.get();
    }
}
