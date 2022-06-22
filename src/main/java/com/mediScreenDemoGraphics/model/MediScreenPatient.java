package com.mediScreenDemoGraphics.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "patient")
public class MediScreenPatient {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	@NonNull
	 @Column(name = "family_name")
	String familyName;
	@NonNull
	 @Column(name = "patient_name")
	String patientName;
	@NonNull
	 @Column(name = "date_of_birth")
	String dateOfBirth;
	@NonNull
	 @Column(name = "sex")
	String sex;
	 @Column(name = "home_address")
	String homeAddress;
	 @Column(name = "phone_number")
	String phoneNumber;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
