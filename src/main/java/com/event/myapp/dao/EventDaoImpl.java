package com.event.myapp.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.event.myapp.domain.Event;
import com.event.myapp.domain.User;


@Transactional
@Repository
public class EventDaoImpl extends BaseDao implements EventDao {

	@SuppressWarnings("unchecked") //ワーニングを出ないようにするアノテーション
	@Override
	public List<Event> findAll() throws Exception {//Eventのテーブルを持ってくる
		return getSession().createCriteria(Event.class)
				.setFetchMode("group", FetchMode.JOIN)
				.addOrder(Order.desc("startdate"))
				.list();
	}

	@Override
	public Event findById(Integer id) throws Exception {
		return (Event) getSession().createCriteria(Event.class)
				.setFetchMode("group", FetchMode.JOIN)
				.setFetchMode("user", FetchMode.JOIN)
				.setFetchMode("join", FetchMode.JOIN)
				.add(Restrictions.eq("eventId", id))
				.uniqueResult();
	}

	@Override
	public void insert(Event event) throws Exception {
		event.setCreatedate(new Date());
		getSession().save(event);
	}

	@Override
	public void update(Event event) throws Exception {
		event.setCreatedate(new Date());
		getSession().update(event);

	}

	@Override
	public void delete(Event event) throws Exception {
		getSession().delete(event);

	}

	@SuppressWarnings("unchecked") //ワーニングを出ないようにするアノテーション
	@Override
	public List<Event> findEventOfToday() throws Exception {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DATE,1);
		Date startdate=calendar.getTime();
		return getSession().createCriteria(Event.class)
				.setFetchMode("group", FetchMode.JOIN)
				.add(Restrictions.le("startdate", startdate))
				.add(Restrictions.gt("enddate", today))
				.list();
	}

	@SuppressWarnings("unchecked") //ワーニングを出ないようにするアノテーション
	@Override
	public List<Event> findMyEvent(User user) throws Exception {
		return getSession().createCriteria(Event.class)
				.setFetchMode("group", FetchMode.JOIN)
				.add(Restrictions.eq("user", user))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findNeedToMail(String tomail) throws Exception {
		return getSession().createCriteria(Event.class)
				.setFetchMode("user", FetchMode.JOIN)
				.add(Restrictions.eq("sendMail", tomail))
				.list();
	}

}
