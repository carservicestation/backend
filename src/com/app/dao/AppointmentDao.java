package com.app.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.pojos.Appointment;
import com.app.pojos.Customer;
import com.app.pojos.Owner;
import com.app.pojos.Payment;
import com.app.pojos.ServiceCenter;
import com.app.pojos.Services;
import com.app.pojos.Status;
import com.app.pojos.Vehicle;

@Repository
public class AppointmentDao implements IAppointmentDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Integer addAppointment(Appointment a) {
		
		System.out.println(a);
		
		Session s = sf.getCurrentSession();
		Vehicle uv = a.getVehicle();
		String jpql = "Select v from Vehicle v where v.make=:m and v.model=:mm and v.fuelType=:f";
		Vehicle v = s.createQuery(jpql, Vehicle.class).setParameter("m", uv.getMake()).setParameter("mm", uv.getModel())
				.setParameter("f", uv.getFuelType()).getSingleResult();
		a.setVehicle(v);
		a.setStatus(Status.NEW);
		
		Payment p = a.getPayment();
		
		s.save(p);
		
		a.setPayment(p);
	
	//	Date cdate = a.getDate();
		
//		String jpql1 = "Select a.time from Appointment a where a.date=:cd";
//		
//		List<Appointment> t = s.createQuery(jpql1, Appointment.class).setParameter("cd", cdate).getResultList();
//		
//		
//		Criteria cr = s.createCriteria(Appointment.class);
//				
//				cr.setProjection(Projections.projectionList().add(Projections.property("time"), "time"));
//				
//				cr.addOrder(Order.desc("time"));
//				
//				cr.setMaxResults(1);
//				
//				cr.setResultTransformer(Transformers.aliasToBean(Appointment.class));
//
//		List<LocalTime> ti = cr.list();
//		
//		LocalTime ttt = null; 
//		
//		if(ti != null)
//		{
//			a.setTime(LocalTime.of(10,0,0));
//		}
//		else
//		{
//			for (LocalTime tt : ti) {
//				ttt = tt;
//			}
//			a.setTime(LocalTime.of(ttt.getHour()+1, 0, 0));
//		}
		
		return (Integer) sf.getCurrentSession().save(a);
	}

	public List<Appointment> getCustomerAppointments(@PathVariable Integer cid) {
		// using cust
		Session s = sf.getCurrentSession();
		Customer c = s.get(Customer.class, cid);
		
		c.getAppointments().size();
		
		System.out.println(c.getAppointments());
		
		System.out.println("kkkkkkkkkkkk");
		
		return c.getAppointments();
	}

	public void deleteCustomerAppointment(int apid) {
		// using cust
		Appointment a = sf.getCurrentSession().get(Appointment.class, apid);
		sf.getCurrentSession().remove(a);
	}

	@Override
	public Appointment getAppointmentById(int apid) {
		return sf.getCurrentSession().get(Appointment.class, apid);
	}

	@Override
	public List<Appointment> getAppointments() {
		String jpql = "Select a from Appointment a";
		
//		Session s = sf.getCurrentSession();
//		
//		CriteriaBuilder b = s.getCriteriaBuilder();
//		
//		CriteriaQuery<Appointment> c = b.createQuery(Appointment.class);

		return sf.getCurrentSession().createQuery(jpql, Appointment.class).getResultList();
	}

	@Override
	public Status cancelAppointment(int apid) {
		Appointment a = sf.getCurrentSession().get(Appointment.class, apid);
		a.setStatus(Status.CANCELLED);
		sf.getCurrentSession().update(a);
		return a.getStatus();
	}

	@Override
	public List<Appointment> getServiceCenterAppointments(Integer oid) {
		Session s = sf.getCurrentSession();
		Owner o = s.get(Owner.class, oid);
		
		List<Appointment> apps = o.getServiceCenter().getAppointments();
		
		System.out.println(apps);
		
		return o.getServiceCenter().getAppointments();
	}

	@Override
	public Status acceptAppointment(Integer apid) {
		Session s = sf.getCurrentSession();
		Appointment a = s.get(Appointment.class, apid);
		a.setStatus(Status.ACCEPTED);
		double custWa = a.getCustomer().getWallet();
		double scWa = a.getServiceCenter().getWallet();
		double am = a.getPayment().getAmount();
		custWa = custWa - am;
		scWa = scWa + am;
		a.getCustomer().setWallet(custWa);
		a.getServiceCenter().setWallet(scWa);
		s.update(a);
		return a.getStatus();
	}

	@Override
	public Set<Services> getServicesByAppointmentById(Integer apid) {
		return sf.getCurrentSession().get(Appointment.class, apid).getServices();
	}
}
