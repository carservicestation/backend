package com.app.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;

@Repository
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Object validateUser(User u) throws RuntimeException {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		User dbu = sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", u.getEmail())
				.setParameter("pass", u.getPassword()).getSingleResult();

		if (dbu != null) {
			if (dbu.getRole().equals(Role.CUSTOMER)) {
				String jpql1 = "select c from Customer c where c.email=:em";
				return sf.getCurrentSession().createQuery(jpql1, Customer.class).setParameter("em", u.getEmail())
						.getSingleResult();
			} else if (dbu.getRole().equals(Role.OWNER)) {

				String jpql2 = "select o from Owner o where o.email=:em";
				return sf.getCurrentSession().createQuery(jpql2, Owner.class).setParameter("em", u.getEmail())
						.getSingleResult();

				// Session session = sf.getCurrentSession();

				/*
				 * CriteriaQuery cq =
				 * 
				 * cr.setProjection(Projections.max("salary"));
				 * 
				 * 
				 * Criteria cr = session.createCriteria(Owner.class)
				 * .setProjection(Projections.projectionList() .add(Projections.property("id"),
				 * "id") .add(Projections.property("name"), "name")
				 * .add(Projections.property("email"), "email")
				 * .add(Projections.property("phone"), "phone")
				 * .add(Projections.property("password"), "password")
				 * .add(Projections.property("role"), "role") .add((Projection)
				 * Restrictions.eq("email", dbu.getEmail())))
				 * .setResultTransformer(Transformers.aliasToBean(Owner.class));
				 * 
				 * //Criterion email = Restrictions.gt("email",dbu.getEmail());
				 * 
				 * 
				 * cr.setMaxResults(1);
				 * 
				 * 
				 * Owner o = (Owner) cr.uniqueResult();
				 * 
				 * return o;
				 */
			} else {
				return dbu;
			}
		}
		return null;
	}

	@Override
	public User addUser(User u) {
		sf.getCurrentSession().save(u);
		return u;
	}

	@Override
	public Object changePassword(User u) throws RuntimeException {
		
		Session s = sf.getCurrentSession();

		String jpql = "select u from User u where u.email=:em and u.password=:pass";

		User dbu = sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", u.getEmail())
				.setParameter("pass", u.getPassword()).getSingleResult();

		if (dbu != null && dbu.getPassword().equals(u.getPassword())) {

			dbu.setPassword(u.getNewPassword());
			s.update(dbu);
			
			if (u.getRole().equals(Role.ADMIN)) {
				return dbu;
			} else if (u.getRole().equals(Role.CUSTOMER)) {
				String jpql1 = "select c from Customer c where c.email=:em";
				Customer c = s.createQuery(jpql1, Customer.class).setParameter("em", u.getEmail()).getSingleResult();
				c.setPassword(u.getNewPassword());
				s.update(c);
				return c;
			} else if (u.getRole().equals(Role.OWNER)) {
				String jpql2 = "select o from Owner o where o.email=:em";
				Owner o = s.createQuery(jpql2, Owner.class).setParameter("em", u.getEmail()).getSingleResult();
				o.setPassword(u.getNewPassword());
				s.update(o);
				return o;
			}
		}
		return null;
	}
}
