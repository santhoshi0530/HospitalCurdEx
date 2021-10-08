package in.nit.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nit.hospital.Exception.PatientNotFoundException;
import in.nit.hospital.entity.Patient;
import in.nit.hospital.service.IPatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private IPatientService service;

	@GetMapping("/register")
	public String showRegister(@RequestParam(value = "message", required = false) String message, Model model) {
		model.addAttribute("message", message);
		return "PatientRegister";
	}

	@PostMapping("save")
	public String savePatient(@ModelAttribute Patient patient, RedirectAttributes attribute) {
		Long id = service.saveData(patient);
		attribute.addAttribute("message", id + " is created");
		return "redirect:register";
	}

	@GetMapping("/all")
	public String showAll(@RequestParam(value = "message", required = false) String message, Model model) {
		List<Patient> patients = service.showAll();
		model.addAttribute("message", message);
		model.addAttribute("patients", patients);
		return "ShowAllPatients";
	}

	@GetMapping("/delete")
	public String deletePatient(@RequestParam Long id, RedirectAttributes attribute) {

		String message = "";
		try {
			service.deleteById(id);
			message = "Patient removed";
		} catch (PatientNotFoundException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		attribute.addAttribute("message", message);
		return "redirect:all";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model, RedirectAttributes attributes) {
		Patient patient = null;
		try {
			patient = service.findById(id);
			model.addAttribute("patient", patient);
			return "PatientEdit";
		} catch (PatientNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			return "redirect:all";
		}

	}
	
	@PostMapping("/update")
	public String updatePatient(@ModelAttribute Patient patent, RedirectAttributes attributes) {
		String message = "";
		try {
		service.updatePatient(patent);
		message= patent.getId()+" updated";
		}catch(PatientNotFoundException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		attributes.addAttribute("message", message);
		return "redirect:all";
	}
}
