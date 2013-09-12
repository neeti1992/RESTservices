/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.basicmodule.db;

/**
 *
 * @author Neeti
 */
import java.util.List;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.basicmodule.RadiologyGroup;

public interface RadiologyGroupDAO {
	
	/**
	 * @param RadiologyGroup to be saved
	 * @throws DAOException 
	 */
	public RadiologyGroup saveRadiologyGroup(RadiologyGroup radiologyGroup) throws DAOException;
	public RadiologyGroup getRadiologyGroupByUuid(String uuid);
	public List<RadiologyGroup> getRadiologyGroupByName(String name);
	public List<RadiologyGroup> getAllRadiologyGroup(boolean includeRetired);
	public RadiologyGroup updateRadiologyGroup(RadiologyGroup radiologyGroup) throws DAOException;
}

