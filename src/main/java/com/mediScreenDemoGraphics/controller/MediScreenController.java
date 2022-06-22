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

	@GetMapping("patient/add")
	public ModelAndView addPatient(@ModelAttribute("MediScreenPatient") MediScreenPatient patient) {
		logger.info("patient form");
		return new ModelAndView("addPatient");
	}

	@PostMapping("patient/validate")
	public ModelAndView validatePatient(@Valid MediScreenPatient patient, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			mediScreenPatientServiceImpl.savePatient(patient);
			logger.info("patient detials saved");
			return new ModelAndView("redirect:/patientList");
		} else {
			return new ModelAndView("addPatient");
		}
	}
	@GetMapping("patient/list")
	public ModelAndView patientList(Model model) {
		model.addAttribute("patients", mediScreenPatientServiceImpl.getAllPatients());
		return new ModelAndView("patientList");
	}
	@GetMapping("/patient/update/{id}")
	public ModelAndView showUpdateForm(@PathVariable("id") Integer id, Model model) {
		MediScreenPatient patient = mediScreenPatientServiceImpl.getPatientById(id);
		model.addAttribute("patient", patient);
		return new ModelAndView("updatePatient");
	}
	@PostMapping("/patient/update/{id}")
	public ModelAndView updatePatientInfo(@PathVariable("id") Integer id, @Valid MediScreenPatient patient, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return new ModelAndView("patient/update");
		}
		patient.setId(id);
		mediScreenPatientServiceImpl.savePatient(patient);
		return new ModelAndView("redirect:/patient/list");
	}
	@GetMapping("/user/delete/{id}")
	public ModelAndView deletePatient(@PathVariable("id") Integer id, Model model) {
		MediScreenPatient patient = mediScreenPatientServiceImpl.getPatientById(id);
		mediScreenPatientServiceImpl.deletePatient(patient);
		return new ModelAndView("redirect:/patient/list");
	}
	@GetMapping("patient/info")
	public ModelAndView getPatientInfoById(@PathVariable("id") Integer id, Model model) {
		MediScreenPatient patient = mediScreenPatientServiceImpl.getPatientById(id);
		model.addAttribute("patientName",patient.getPatientName() );
		model.addAttribute("patientFamilyName", patient.getFamilyName());
		model.addAttribute("patientDateOfBirth", patient.getDateOfBirth());
		model.addAttribute("patientHomeAddress", patient.getHomeAddress());
		model.addAttribute("patientPhoneNumber", patient.getPhoneNumber());
		model.addAttribute("patientSex", patient.getSex());
		return new ModelAndView("patientInfo");
	}
}
