package au.com.garvan.growth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.garvan.growth.dao.DiagnosisDao;
import au.com.garvan.growth.model.DiagnosisMaster;

@Service
public class DiagnosisService {
	
	@Autowired
	private DiagnosisDao diagnosisDao;
	
	public DiagnosisMaster save(DiagnosisMaster diagnosisMaster){
		return diagnosisDao.save(diagnosisMaster);
	}
	
	public Iterable<DiagnosisMaster> findAll(){
		return diagnosisDao.findAll();
	}
	
	public DiagnosisMaster findOne(int id){
		return diagnosisDao.findOne(id);
	}
}
