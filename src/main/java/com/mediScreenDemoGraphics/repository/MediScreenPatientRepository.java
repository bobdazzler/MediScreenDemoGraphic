package com.mediScreenDemoGraphics.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mediScreenDemoGraphics.model.MediScreenPatient;
public interface MediScreenPatientRepository extends JpaRepository <MediScreenPatient, Integer> {

}
