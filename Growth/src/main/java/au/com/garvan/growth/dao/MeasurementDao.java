package au.com.garvan.growth.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import au.com.garvan.growth.model.Measurement;

@Transactional
public interface MeasurementDao extends CrudRepository<Measurement, Integer> {
	
	public Iterable<Measurement> findByUserProfileId(@Param("profileId") int profileId);
	public Iterable<Measurement> findByDiagnosisMasterDiagnosisId(@Param("diagnosisId") int diagnosisId);
	
}
