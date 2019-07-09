package org.openmrs.module.amrsextension.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.openmrs.Patient;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.amrsextension.api.db.ModuleLabOrderDAO;
import org.openmrs.module.amrsextension.models.LabOrder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HibernateModuleLabOrderDAO implements ModuleLabOrderDAO {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected DbSessionFactory sessionFactory;
	
	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public HibernateModuleLabOrderDAO() {
	}
	
	@Override
	public List<LabOrder> getPatientLabOrders(Patient patient) {
		log.error("at DAO" +patient.getUuid());
		String stringQuery = "SELECT   "
		        + "    t1.order_number AS orderNumber, t1.concept_id AS order_type, t12.name AS display,  "
		        + "    t13.uuid AS conceptUuid, t1.uuid AS uuid, t7.uuid AS obs_uuid,  t1.date_activated AS date_activated,  "
		        + "    t1.patient_id AS patient_id, t9.name AS sample_drawn, DATE(t7.obs_datetime) AS sample_collection_date,  "
		        + "    t3.given_name AS given_name, t3.middle_name AS middle_name, t3.family_name AS family_name,  "
		        + "    GROUP_CONCAT(DISTINCT t4.identifier) AS identifiers,  CONCAT(COALESCE(t3.given_name, ''),  ' ', COALESCE(t3.middle_name, ''),  "
		        + "    ' ',  COALESCE(t3.family_name, '')) AS person_name, t5.name AS location_name, t5.uuid AS locationUuid,  "
		        + "    t5.location_id AS location_id, t6.uuid AS patient_uuid, t10.uuid AS provider_uuid, CONCAT(COALESCE(t11.given_name, ''),  "
		        + "    ' ',  COALESCE(t11.middle_name, ''),  ' ',  COALESCE(t11.family_name, '')) AS provider_name  "
		        + "	FROM  orders `t1`  LEFT OUTER JOIN encounter `t2` ON (t1.encounter_id = t2.encounter_id)  "
		        + "        LEFT OUTER JOIN  person_name `t3` ON (t1.patient_id = t3.person_id AND (t3.voided IS NULL || t3.voided = 0))  "
		        + "        LEFT OUTER JOIN  patient_identifier `t4` ON (t1.patient_id = t4.patient_id)  LEFT OUTER JOIN  location `t5` ON (t2.location_id = t5.location_id)  "
		        + "        LEFT OUTER JOIN  person `t6` ON (t1.patient_id = t6.person_id)  LEFT OUTER JOIN  obs `t7` ON (t1.order_id = t7.order_id AND (t7.voided IS NULL || t7.voided = 0))  "
		        + "        LEFT OUTER JOIN  concept_name `t8` ON (t7.concept_id = t8.concept_id) LEFT OUTER JOIN  concept_name `t9` ON (t7.value_coded = t9.concept_id)  "
		        + "        LEFT OUTER JOIN  provider `t10` ON (t1.orderer = t10.provider_id)  LEFT OUTER JOIN  person_name `t11` ON (t10.person_id = t11.person_id) "
		        + "        LEFT OUTER JOIN  concept `t13` ON (t1.concept_id = t13.concept_id)  LEFT OUTER JOIN  concept_name `t12` ON (t1.concept_id = t12.concept_id)  "
		        + " WHERE  ((t1.voided IS NULL || t1.voided = 0)  AND t6.uuid = 'e91ea148-37d7-4290-a826-a43c23828b9d' ) GROUP BY t1.order_id ";
		
//		if (patient != null) {
//			log.error("patient uuid " + patient.getUuid());
//			stringQuery += " AND t6.uuid = ? )";
//		}
//		stringQuery += "  GROUP BY t1.order_id ";
		
		Query query = sessionFactory.getCurrentSession().createSQLQuery(stringQuery);
		
//		if (patient != null) {
//			query.setParameter(0, patient.getUuid());
//		}
		
		List<LabOrder> labOrders = new ArrayList<LabOrder>();
		List<Object[]> values = query.list();
		for (Object[] obj : values) {
			LabOrder val = new LabOrder();
			val.setConceptUuid(obj[3].toString());
			val.setDateActivated((Date) obj[6]);
			val.setDisplay(obj[2].toString());
			val.setFamilyName(obj[12].toString());
			val.setIdentifiers(obj[13].toString());
			val.setLocationUuid(obj[16].toString());
			val.setLocationId((Integer) obj[17]);
			val.setLocationName(obj[15].toString());
			val.setMiddleName(obj[11].toString());
			val.setObs_uuid(obj[5].toString());
			val.setOrderNumber(obj[0].toString());
			val.setOrderType((Integer) obj[1]);
			val.setPatientId((Integer) obj[7]);
			val.setPatientUuid(obj[18].toString());
			val.setPersonName(obj[14].toString());
			val.setProviderName(obj[20].toString());
			val.setProviderUuid(obj[19].toString());
			val.setSampleCollectioDate((Date) obj[9]);
			val.setSampleDrawn(obj[8].toString());
			val.setUuid(obj[4].toString());
			labOrders.add(val);
		}
		log.error("I was here at service dao");
		return new ArrayList<>();
	}
}
