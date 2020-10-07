package com.springboot.best.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

import com.springboot.best.dao.UserHasPrivilegeRepository;
import com.springboot.best.dto.ManagePrivilegeDTO;
import com.springboot.best.model.UserHasPrivileges;

@Service
public class PrivilegeServiceImpl implements PrivilegeService{

	@Autowired
	private UserHasPrivilegeRepository userHasPrivilegesRepository;
	@Override
	public void savePrivilegeForUser(ManagePrivilegeDTO dto) {
		// TODO Auto-generated method stub
		List<UserHasPrivileges> userHasPrivilegeList=dto.getPrivilegeList().stream().filter(d->d.isSelected()==true).map(p->{
			UserHasPrivileges up=new UserHasPrivileges();
			up.getUser().setId(dto.getUserId());
			up.getPrivileges().setId(p.getId());
			return up;
		}
		).collect(Collectors.toList());
		userHasPrivilegesRepository.saveAll(userHasPrivilegeList);
		userHasPrivilegeList.forEach(p->{
			System.out.println("Privilege Id :"+p.getPrivileges().getId());
		});
	}

}
