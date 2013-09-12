/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.basicmodule.impl;

/**
 *
 * @author Neeti
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.basicmodule.RadiologyGroup;
import org.openmrs.module.basicmodule.RadiologyGroupService;
import org.openmrs.module.basicmodule.db.RadiologyGroupDAO;

public class RadiologyGroupServiceImpl implements RadiologyGroupService {
	
	private RadiologyGroupDAO dao;
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Override
	public void setRadiologyGroupDAO(RadiologyGroupDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public RadiologyGroup saveRadiologyGroup(RadiologyGroup radiologyGroup) {
		return dao.saveRadiologyGroup(radiologyGroup);
	}
        
        @Override
	public RadiologyGroup getRadiologyGroupByUuid(String uuid) {
		return dao.getRadiologyGroupByUuid(uuid);
	}
	
	/**
	 * Parses a string into a date
	 *
	 * @param str String to be parsed (must be iso format)
	 * @return Date
	 */
	private Date getDateFromString(String str) {
		
		String[] supportedFormats = { "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd'T'HH:mm:ssZ",
		        "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd" };
		for (int i = 0; i < supportedFormats.length; i++) {
			try {
				Date date = new SimpleDateFormat(supportedFormats[i]).parse(str);
				return date;
			}
			catch (Exception ex) {
				log.error(ex.getMessage() + " Error parsing string " + str + " into Date");
			}
		}
		log.error("Date string is malformed");
		return null;
	}
	
	@Override
	public RadiologyGroup updateRadiologyGroup(RadiologyGroup radiologyGroup) {
		return dao.updateRadiologyGroup(radiologyGroup);
	}
	
	@Override
	public void onStartup() {
		log.info("Starting radiology service");
	}
	
	@Override
	public void onShutdown() {
		log.info("Stopping radiology service");
	}
        @Override
	public List<RadiologyGroup> getAllRadiologyGroup(boolean includeRetired) {
		return dao.getAllRadiologyGroup(includeRetired);
	}
}

