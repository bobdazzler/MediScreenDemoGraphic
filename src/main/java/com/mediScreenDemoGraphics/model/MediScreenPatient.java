package com.mediScreenDemoGraphics.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "patient")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class MediScreenPatient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	 @NotNull(message = "Family Name cannot be null")
	 @Column(name = "family_name")
	String familyName;
	 @NotNull(message = "Patient Name cannot be null")
	 @Column(name = "patient_name")
	String patientName;
	 @NotNull(message = "Date of Bath cannot be null should follow this format yyyy-mm-dd")
	 @Column(name = "date_of_birth")
	String dateOfBirth;
	 @NotNull(message = "Sex cannot be null")
	 @Column(name = "sex")
	String sex;
	 @Column(name = "home_address")
	String homeAddress;
	 @Column(name = "phone_number")
	String phoneNumber;
	 public MediScreenPatient() {}
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
