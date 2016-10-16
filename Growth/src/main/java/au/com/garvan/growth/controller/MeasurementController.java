package au.com.garvan.growth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import au.com.garvan.growth.model.Measurement;
import au.com.garvan.growth.service.MeasurementService;
// /accounts/{accountId}/userprofiles/{profileId}/measurements
@RestController
public class MeasurementController implements ControllerConstants{
	
	@Autowired
	private MeasurementService measurementService;
	
	@RequestMapping(value=MEASUREMENT_BASE,method=RequestMethod.POST)
	public Measurement save(@PathVariable("accountId") int accountId,
			@PathVariable("profileId") int profileId, Measurement measurement){
		return measurementService.save(measurement);
	}
	
	@RequestMapping(value=MEASUREMENT_BASE)
	public Iterable<Measurement> findAll(@PathVariable("accountId") int accountId,
			@PathVariable("profileId") int profileId){
		return measurementService.findByProfileId(profileId);
	}
	
	@RequestMapping(value=ALL_MEASUREMENTS+"/diagnosisId/{diagnosisId}")
	public Iterable<Measurement> findMeasurementsByDiagnosisId(@PathVariable("diagnosisId") int diagnosisId){
		return measurementService.findMeasurementsByDiagnosis(diagnosisId);
	}
	
	@RequestMapping(value=MEASUREMENT_BASE+"/{measurementId}",method=RequestMethod.POST)
	public Measurement findOne(@PathVariable("accountId") int accountId,
			@PathVariable("profileId") int profileId,@PathVariable("measurementId") int measurementId){
		return measurementService.findOne(measurementId);
	}
	
	@RequestMapping(value=MEASUREMENT_BASE+"/{measurementId}",method=RequestMethod.PUT)
	public Measurement update(@PathVariable("accountId") int accountId,
			@PathVariable("profileId") int profileId, Measurement measurement){
		return measurementService.update(measurement);
	}
}
