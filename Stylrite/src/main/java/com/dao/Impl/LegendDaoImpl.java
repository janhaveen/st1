package com.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.LegendDao;
import com.pojo.Legend;
import com.pojo.States;


@Repository("LegendDaoImpl")
@Transactional
public class LegendDaoImpl implements LegendDao {
	
	@PersistenceContext(unitName="demoRestPersistence")
	private EntityManager entityManager;

	@Override
	public List getLegendList() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select lng from Legend lng",Legend.class).getResultList();
	}

	@Override
	public List getAllState() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select st from States st",States.class).getResultList();
	}

}
