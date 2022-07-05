package com.mediScreenDemoGraphics.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mediScreenDemoGraphics.model.MediScreenPatient;
@Repository
public interface MediScreenPatientRepository extends JpaRepository <MediScreenPatient, Integer> {

}
