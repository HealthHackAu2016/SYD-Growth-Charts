package au.com.garvan.growth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import au.com.garvan.growth.model.DiagnosisMaster;
import au.com.garvan.growth.service.DiagnosisService;

@RestController
public class DiagnosisController implements ControllerConstants {
	
	@Autowired
	private DiagnosisService diagnosisService;
	
	@RequestMapping(value=DIAGNOSIS_BASE, method=RequestMethod.POST)
	public DiagnosisMaster save(@RequestBody DiagnosisMaster measurement){
		return diagnosisService.save(measurement);
	}
	
	@RequestMapping(value=DIAGNOSIS_BASE)
	public Iterable<DiagnosisMaster> findAll(){
		return diagnosisService.findAll();
	}
	
	@RequestMapping(value=DIAGNOSIS_BASE+"/{diagnosisId}")
	public DiagnosisMaster findOne(@PathVariable("diagnosisId") int id){
		return diagnosisService.findOne(id);
	}
}
