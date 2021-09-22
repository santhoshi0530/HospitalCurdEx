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

import in.nit.hospital.Exception.DoctorNotFoundException;
import in.nit.hospital.entity.Doctor;
import in.nit.hospital.service.IDoctorService;
import in.nit.hospital.service.ISpecializationService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private IDoctorService service;
	
	
	@Autowired
	private ISpecializationService specService;
	
	private void createDynamicUI(Model model) {
		model.addAttribute("specializaions", specService.getSpecIdAndName());
	}

	@GetMapping("/register")
	public String showRegister(@RequestParam(value = "message", required = false) String message,
								Model model) {
		createDynamicUI(model);
		model.addAttribute("message", message);
		return "DoctorRegister";
	}

	@PostMapping("/save")
	public String saveDoctor(@ModelAttribute Doctor doc, RedirectAttributes attributes) {
		Long id = service.saveDoctor(doc);
		attributes.addAttribute("message", id + " is created");
		return "redirect:register";
	}

	@GetMapping("/all")
	public String getAllDoctors(@RequestParam(value = "message", required = false) String message,
								Model model) {
		List<Doctor> list = service.getAllDoctor();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "DoctorData";
	}

	@GetMapping("/delete")
	public String removeDoctor(@RequestParam Long id, RedirectAttributes attributes) {
		String message = "";

		try {
			service.removeDoctor(id);
			message = id + ", removed";

		} catch (DoctorNotFoundException e) {
			e.printStackTrace();
			message = id + " not exist";
		}

		attributes.addAttribute("message", message);
		return "redirect:all";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model, RedirectAttributes attributes) {
		try {
			Doctor doc = service.getOneDoctor(id);
			model.addAttribute("Doctor", doc);
			createDynamicUI(model);
			return "DoctorEdit";
		} catch (DoctorNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", id + " not exist");
			return "redirect:all";
		}
	}

	@PostMapping("/update")
	public String updateDoctor(@ModelAttribute Doctor doc, RedirectAttributes attributes) {
		service.updateDoctor(doc);
		attributes.addAttribute("message", doc.getId() + " is updated");
		return "redirect:all";
	}

}
