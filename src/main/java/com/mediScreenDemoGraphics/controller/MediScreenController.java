package com.mediScreenDemoGraphics.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mediScreenDemoGraphics.exception.PatientIdNotFoundException;
import com.mediScreenDemoGraphics.model.MediScreenPatient;
import com.mediScreenDemoGraphics.service.MediScreenPatientServiceImpl;

@RestController
public class MediScreenController {
	Logger logger = LoggerFactory.getLogger(MediScreenController.class);
	private MediScreenPatientServiceImpl mediScreenPatientServiceImpl;

	@Autowired
	MediScreenController(MediScreenPatientServiceImpl mediScreenPatientServiceImpl) {
		this.mediScreenPatientServiceImpl = mediScreenPatientServiceImpl;
	}
	@GetMapping("/")
	public ModelAndView landingPage() {
		return new ModelAndView("home");
	}
	/**
	 * 
	 * @param patient
	 * @return a form to add patient
	 */

	@GetMapping("/patient/add")
	public ModelAndView showPatientForm(@ModelAttribute("mediScreenPatient") MediScreenPatient patient) {
		logger.info("patient form");
		return new ModelAndView("addPatient");
	}
	/**
	 * 
	 * @param patient
	 * @param result
	 * @param model
	 * @return if all data are entered correctly a list of patient is display else a patient form is displayed
	 */
	@PostMapping("/patient/validate")
	public ModelAndView validatePatient(@Valid MediScreenPatient patient, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			mediScreenPatientServiceImpl.savePatient(patient);
			logger.info("patient detials saved");
			return new ModelAndView("redirect:/patient/list");
		} else {
			return new ModelAndView("addPatient");
		}
	}
	/**
	 * 
	 * @param model
	 * @return a list of all patients in DB is displayed in a UI Format
	 */
	@GetMapping("/patient/list")
	public ModelAndView patientList(Model model) {
		model.addAttribute("patients", mediScreenPatientServiceImpl.getAllPatients());
		return new ModelAndView("patientList");
	}
/**
 * 
 * @param id
 * @param model
 * @return a form for modifying data stored in DB
 * @throws PatientIdNotFoundException 
 */
	@GetMapping("/patient/update/{id}")
	public ModelAndView showUpdateForm(@PathVariable("id") Integer id, Model model) throws PatientIdNotFoundException {
		MediScreenPatient patient = mediScreenPatientServiceImpl.getPatientById(id);
		if(patient == null) {
			throw new PatientIdNotFoundException(id);
		}
		model.addAttribute("patient", patient);
		return new ModelAndView("updatePatient");
	}
	/**
	 * 
	 * @param id
	 * @param patient
	 * @param result
	 * @param model
	 * @return save modified patient information to db and displays a list of patients
	 */
	@PostMapping("/patient/update/{id}")
	public ModelAndView updatePatientInfo(@PathVariable("id") Integer id, @Valid MediScreenPatient patient,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return new ModelAndView("patient/update");
		}
		patient.setId(id);
		mediScreenPatientServiceImpl.savePatient(patient);
		return new ModelAndView("redirect:/patient/list");
	}
	/**
	 * 
	 * @param id
	 * @param model
	 * @return deletes a patient info by patient id
	 * @throws PatientIdNotFoundException 
	 */

	@GetMapping("/patient/delete/{id}")
	public ModelAndView deletePatient(@PathVariable("id") Integer id, Model model) throws PatientIdNotFoundException {
		MediScreenPatient patient = mediScreenPatientServiceImpl.getPatientById(id);
		if(patient==null) {
			throw new PatientIdNotFoundException(id);
		}
		mediScreenPatientServiceImpl.deletePatient(patient);
		return new ModelAndView("redirect:/patient/list");
	}
	/**
	 * 
	 * @param id
	 * @return patient info by id
	 * @throws PatientIdNotFoundException 
	 */
	@GetMapping("/patient/info/{id}")
	public MediScreenPatient getPatientInfoById(@PathVariable("id") Integer id) throws PatientIdNotFoundException {
		MediScreenPatient patient = mediScreenPatientServiceImpl.getPatientById(id);
		if (patient==null) {
			throw new PatientIdNotFoundException(id);
		}
		return patient;
	}
}
