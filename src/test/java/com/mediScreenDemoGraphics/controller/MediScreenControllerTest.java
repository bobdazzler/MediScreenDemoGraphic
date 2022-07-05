package com.mediScreenDemoGraphics.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.mediScreenDemoGraphics.exception.PatientIdNotFoundException;
import com.mediScreenDemoGraphics.model.MediScreenPatient;
import com.mediScreenDemoGraphics.service.MediScreenPatientServiceImpl;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MediScreenControllerTest {
	@Mock
	MediScreenPatientServiceImpl patientService;

	@InjectMocks
	MediScreenController mediScreenController;

	@Mock
	Model model;

	@Mock
	BindingResult bindingResult;

	@Test
	public void testMediScreenController() {

	}

	@Test
	public void testAddPatient() {
		MediScreenPatient patient = new MediScreenPatient();
		patient.setId(1);
		patient.setPatientName("PatientName");
		patient.setFamilyName("FamilyName");
		patient.setSex("M");
		patient.setDateOfBirth("1967/04/05");
		patient.setHomeAddress("address of patient");
		patient.setPhoneNumber("08129549883");
		ModelAndView modelAndView = mediScreenController.showPatientForm(patient);
		Assert.assertEquals("addPatient", modelAndView.getViewName());
	}

	@Test
	public void testValidatePatient() {
		MediScreenPatient patient = new MediScreenPatient();
		patient.setId(1);
		patient.setPatientName("PatientName");
		patient.setFamilyName("FamilyName");
		patient.setSex("M");
		patient.setDateOfBirth("1967/04/05");
		patient.setHomeAddress("address of patient");
		patient.setPhoneNumber("08129549883");
		when(patientService.savePatient(Mockito.any())).thenReturn(patient);
		ModelAndView modelAndView = mediScreenController.validatePatient(patient, bindingResult, model);
		Assert.assertEquals("redirect:/patient/list", modelAndView.getViewName());
	}

	@Test
	public void testPatientList() {
		ModelAndView modelAndView = mediScreenController.patientList(model);
		Assert.assertEquals("patientList", modelAndView.getViewName());
	}

	@Test
	public void testShowUpdateForm() throws PatientIdNotFoundException {
		MediScreenPatient patient = new MediScreenPatient();
		patient.setPatientName("PatientName");
		patient.setFamilyName("FamilyName");
		patient.setSex("M");
		patient.setDateOfBirth("1967/04/05");
		patient.setHomeAddress("address of patient");
		patient.setPhoneNumber("08129549883");
		ModelAndView modelAndView = mediScreenController.showUpdateForm(1, model);
		Assert.assertEquals("updatePatient", modelAndView.getViewName());
	}

	@Test
	public void testUpdateUser() {
		MediScreenPatient patient = new MediScreenPatient();
		patient.setPatientName("PatientName");
		patient.setFamilyName("FamilyNameRecorded");
		patient.setSex("M");
		patient.setDateOfBirth("1967/04/05");
		patient.setHomeAddress("address of patient");
		patient.setPhoneNumber("08129549883");
		when(patientService.savePatient(Mockito.any())).thenReturn(patient);
		ModelAndView modelAndView = mediScreenController.updatePatientInfo(1, patient, bindingResult, model);
		Assert.assertEquals("redirect:/patient/list", modelAndView.getViewName());
	}

	@Test
	public void testDeleteUser() throws PatientIdNotFoundException {
		MediScreenPatient patient = new MediScreenPatient();
		patient.setId(1);
		patient.setPatientName("PatientName");
		patient.setFamilyName("FamilyName");
		patient.setSex("M");
		patient.setDateOfBirth("1967/04/05");
		patient.setHomeAddress("address of patient");
		patient.setPhoneNumber("08129549883");
		when(patientService.getPatientById(Mockito.anyInt())).thenReturn(patient);
		doNothing().when(patientService).deletePatient(patient);
		ModelAndView modelAndView = mediScreenController.deletePatient(1,  model);
		verify(patientService,times(1)).deletePatient(patient);
		Assert.assertEquals("redirect:/patient/list", modelAndView.getViewName());
	}

	@Test
	public void testgetPatientInfoById() throws PatientIdNotFoundException {
		MediScreenPatient patient = new MediScreenPatient();
		patient.setId(1);
		patient.setPatientName("PatientName");
		patient.setFamilyName("FamilyName");
		patient.setSex("M");
		patient.setDateOfBirth("1967/04/05");
		patient.setHomeAddress("address of patient");
		patient.setPhoneNumber("08129549883");
		when(patientService.getPatientById(Mockito.anyInt())).thenReturn(patient);
		MediScreenPatient patientTest = mediScreenController.getPatientInfoById(1);
		Assert.assertEquals(patientTest.getPatientName(),patient.getPatientName());
	}

}
