package au.com.garvan.growth.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the diagnosis_master database table.
 * 
 */
@Entity
@Table(name="diagnosis_master")
@NamedQuery(name="DiagnosisMaster.findAll", query="SELECT d FROM DiagnosisMaster d")
public class DiagnosisMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int diagnosisId;

	private String diagnosisDescription;

	private String diagnosisName;

	public DiagnosisMaster() {
	}

	public int getDiagnosisId() {
		return this.diagnosisId;
	}

	public void setDiagnosisId(int diagnosis_id) {
		this.diagnosisId = diagnosis_id;
	}

	public String getDiagnosisDescription() {
		return this.diagnosisDescription;
	}

	public void setDiagnosisDescription(String diagnosis_description) {
		this.diagnosisDescription = diagnosis_description;
	}

	public String getDiagnosisName() {
		return this.diagnosisName;
	}

	public void setDiagnosisName(String diagnosis_name) {
		this.diagnosisName = diagnosis_name;
	}

}