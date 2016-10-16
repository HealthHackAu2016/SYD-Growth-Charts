package au.com.garvan.growth.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import au.com.garvan.growth.model.DiagnosisMaster;

@Transactional
public interface DiagnosisDao extends CrudRepository<DiagnosisMaster, Integer> {

}
