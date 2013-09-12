/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.basicmodule.db.hibernate;

/**
 *
 * @author Neeti
 */
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.basicmodule.RadiologyGroup;
import org.openmrs.module.basicmodule.db.RadiologyGroupDAO;

public class HibernateRadiologyGroupDAO implements RadiologyGroupDAO {
	
	protected final Log log = LogFactory.getLog(getClass());
	private SessionFactory sessionFactory;
	
	/**
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public RadiologyGroup saveRadiologyGroup(RadiologyGroup radiologyGroup) throws DAOException {
		sessionFactory.getCurrentSession().saveOrUpdate(radiologyGroup);
		return radiologyGroup;
	}
	@Override
	public RadiologyGroup getRadiologyGroupByUuid(String uuid) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RadiologyGroup.class);
		criteria.add(Restrictions.eq("uuid", uuid));
		return (RadiologyGroup) criteria.uniqueResult();
	}
	
	@Override
	public List<RadiologyGroup> getRadiologyGroupByName(String name) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RadiologyGroup.class);
		criteria.add(Restrictions.like("name", name));
		criteria.add(Restrictions.like("retired", false));
		List<RadiologyGroup> groups = new ArrayList<RadiologyGroup>();
		groups.addAll(criteria.list());
		return groups;	
	}
	@Override
	public List<RadiologyGroup> getAllRadiologyGroup(boolean includeRetired) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RadiologyGroup.class);
		if (includeRetired == false) {
			criteria.add(Restrictions.eq("retired", false));
		}
		return criteria.list();
	}
	@Override
	public RadiologyGroup updateRadiologyGroup(RadiologyGroup radiologyGroup) throws DAOException {
		sessionFactory.getCurrentSession().update(radiologyGroup);
		return radiologyGroup;
	}
}

