package com.event.myapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.event.myapp.domain.Event;
import com.event.myapp.domain.Join;
import com.event.myapp.domain.User;

@Transactional
@Repository
public class JoinDaoImpl extends BaseDao implements JoinDao {

	@SuppressWarnings("unchecked") //ワーニングを出ないようにするアノテーション
	@Override
	public List<Join> findAll() throws Exception {
		return getSession().createCriteria(Join.class).list();
	}

	@Override
	public Join findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Join join) throws Exception {
		getSession().save(join);
	}

	@Override
	public void update(Join join) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Join join) throws Exception {
		getSession().delete(join);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Join> findByEvent(Event event) throws Exception {
		return getSession()
				.createCriteria(Join.class)
				.setFetchMode("user", FetchMode.JOIN)
				.add(Restrictions.eq("event", event))
				.list();
	}

	@Override
	public Join findByUserAndEvent(User user, Event event) throws Exception {
		Join join = (Join) getSession()
				.createCriteria(Join.class)
				.add(Restrictions.eq("user", user))
				.add(Restrictions.eq("event", event))
				.uniqueResult();
		return join;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Join> findMyEvent(User user) throws Exception {
		return getSession()
				.createCriteria(Join.class)
				.setFetchMode("event", FetchMode.JOIN)
				.add(Restrictions.eq("user", user))	//Join table
				.list();
	}

}
