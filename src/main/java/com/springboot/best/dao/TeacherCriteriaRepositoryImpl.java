package com.springboot.best.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.springboot.best.dto.BookNameAndTitleDTO;
import com.springboot.best.dto.TeacherNameAndDeptNameDTO;
import com.springboot.best.model.Department;
import com.springboot.best.model.Teacher;

public class TeacherCriteriaRepositoryImpl implements TeacherCriteriaRepositroy {

	@PersistenceContext
	private EntityManager em;
/*	@Override
	public List<String> getTeacherNameList() {
		// TODO Auto-generated method stub
		 TypedQuery<String> query = em.createQuery(
			      "SELECT c.name FROM Teacher AS c", String.class);
		 
			  List<String> results = query.getResultList();
		return results;
	}
	*/
	@Override
	public List<TeacherNameAndDeptNameDTO> getTeacherNameAndDeptList() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb=em.getCriteriaBuilder();
	//	CriteriaQuery<Teacher> q=cb.createQuery(Teacher.class);
		 CriteriaQuery<TeacherNameAndDeptNameDTO> q = cb.createQuery(TeacherNameAndDeptNameDTO.class);
		Root<Teacher> c = q.from(Teacher.class);
		Join<Teacher,Department> p = c.join("department", JoinType.LEFT);
		 q.select(cb.construct(TeacherNameAndDeptNameDTO.class,
       	      c.get("name"), p.get("author")));
		 List<TeacherNameAndDeptNameDTO> results = em.createQuery(q).getResultList();
		return results;
	}

	/*@Override
	public List<TeacherNameAndDeptNameDTO> getTeacherListByDepartmentCriteria(Long deptId) {
		// TODO Auto-generated method stub
		String queryStr =
			      "SELECT NEW com.springboot.best.dto.TeacherNameAndDeptNameDTO(c.name as teacherName, d.name as deptName) " +
			      "FROM teacher AS c left join department d on c.department_id=d.id where c.department_id=:deptId";
		TypedQuery<TeacherNameAndDeptNameDTO> query =
			      em.createQuery(queryStr, TeacherNameAndDeptNameDTO.class);
		query.setParameter("deptId", deptId);
			  List<TeacherNameAndDeptNameDTO> results = query.getResultList();
		return results;
	}
	*/

}
