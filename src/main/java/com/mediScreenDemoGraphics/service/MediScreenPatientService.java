package com.mediScreenDemoGraphics.service;

import java.util.List;

import com.mediScreenDemoGraphics.model.MediScreenPatient;

public interface MediScreenPatientService {
	public MediScreenPatient getPatientById(int id);

    public MediScreenPatient savePatient(MediScreenPatient patient);

    public void deletePatient(MediScreenPatient patient);

    public List<MediScreenPatient> getAllPatients();
}
