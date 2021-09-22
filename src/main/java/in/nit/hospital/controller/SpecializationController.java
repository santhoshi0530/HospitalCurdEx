
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.nit.hospital.entity.Specialization;
import in.nit.hospital.service.ISpecializationService;
import in.nit.hospital.view.SpecializationExcelView;

@Controller
@RequestMapping("/specialization")
public class SpecializationController {

	@Autowired
	private ISpecializationService service;

	@GetMapping("/register")
	public String showPage() {
		return "SpecializationRegister";
	}

	@PostMapping("/save")
	public String saveData(@ModelAttribute Specialization specialization, Model model) {
		int id = service.saveData(specialization);
		model.addAttribute("message", "Specialization Added successfully " + id);
		return "SpecializationRegister";
	}

	@GetMapping("/showall")
	public String showAll(Model model) {
		List<Specialization> list = service.showAll();
		model.addAttribute("list", list);
		return "ShowAllSpecialization";
	}

	@GetMapping("/delete")
	public String deleteSpecialization(@RequestParam Integer id, Model model) {
		service.delete(id);
		model.addAttribute("message", id + " deleted successfully");

		List<Specialization> list = service.showAll();
		model.addAttribute("list", list);
		return "ShowAllSpecialization";
	}

	@GetMapping("/edit")
	public String editSpecialization(@RequestParam Integer id, Model model) {
		Specialization spec = service.findById(id);
		model.addAttribute("specialization", spec);
		return "SpecializationEdit";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Specialization spec) {
		service.updateData(spec);
		return "redirect:showall";
	}

	@GetMapping("/checkCode")
	@ResponseBody
	public String validateSpecCode(@RequestParam String specCode) {
		String message = "";

		if (service.isSepcCodeExist(specCode)) {
			message = specCode + " alredy exist";
		}
		return message;
	}

	@GetMapping("/checkName")
	@ResponseBody
	public String validateSpecName(@RequestParam String specName) {
		String message = "";
		if (service.isSpecNameExist(specName)) {
			message = specName + " already exist";
		}

		return message;
	}

	/***
	 * 8. export data to excel file
	 */
	@GetMapping("/excel")
	public ModelAndView exportToExcel() {
		ModelAndView m = new ModelAndView();
		m.setView(new SpecializationExcelView());

		// read data from DB
		List<Specialization> list = service.showAll();
		// send to Excel Impl class
		m.addObject("list", list);

		return m;
	}

}
