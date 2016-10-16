package au.com.garvan.growth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.garvan.growth.dao.MeasurementDao;
import au.com.garvan.growth.model.Measurement;

@Service
public class MeasurementService {
	
	@Autowired
	private MeasurementDao measurementDao;
	
	public Measurement save(Measurement measurement){
		return measurementDao.save(measurement);
	}
	
	public Iterable<Measurement> findByProfileId(int profileId){
		return measurementDao.findByUserProfileId(profileId);
	}
	
	public Iterable<Measurement> findMeasurementsByDiagnosis(int diagnosisId){
		return measurementDao.findByDiagnosisMasterDiagnosisId(diagnosisId);
	}
	
	public Measurement findOne(int id){
		return measurementDao.findOne(id);
	}
	
	public Measurement update(Measurement measurement){
		Measurement  persistedMeasurement = measurementDao.findOne(measurement.getMeasurementId());
		//TODO add update method to Measurement  
		return measurementDao.save(persistedMeasurement);
	}
}
