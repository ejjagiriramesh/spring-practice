package com.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RoleDao;
import com.entities.Roles;

@Service
public class RoleService {
	@Autowired
	private RoleDao roleDao;

	public Roles saveRole(Roles role) {
		// TODO Auto-generated method stub
		return roleDao.save(role);
	}

}
