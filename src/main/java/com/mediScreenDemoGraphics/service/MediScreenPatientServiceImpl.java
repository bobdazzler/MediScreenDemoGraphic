package com.mediScreenDemoGraphics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediScreenDemoGraphics.model.MediScreenPatient;
import com.mediScreenDemoGraphics.repository.MediScreenPatientRepository;
@Service
public class MediScreenPatientServiceImpl implements MediScreenPatientService{
	@Autowired
	private MediScreenPatientRepository patientRepository;
	@Override
	public MediScreenPatient getPatientById(int id) {
		return patientRepository.getReferenceById(id);
	}
	@Override
	public MediScreenPatient savePatient(MediScreenPatient patient) {
		return patientRepository.save(patient);
	}
	@Override
	public void deletePatient(MediScreenPatient patient) {
		patientRepository.delete(patient);	
	}
	@Override
	public List<MediScreenPatient> getAllPatients() {
		return patientRepository.findAll();
	}
}
