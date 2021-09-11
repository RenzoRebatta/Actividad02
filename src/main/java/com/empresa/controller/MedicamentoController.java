package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;

@RestController
@RequestMapping("/rest/medicamento")
public class MedicamentoController {

	@Autowired
	private MedicamentoService service;

	@GetMapping("/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Medicamento> buscaPorId(@PathVariable("paramId") int idMedicamento) {
		Optional<Medicamento> optMedicamento = service.buscaPorId(idMedicamento);
		if (optMedicamento.isPresent()) {
			return ResponseEntity.ok(optMedicamento.get());
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listarMedicamento() {
		List<Medicamento> lista = service.listaMedicamento();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Medicamento> insertaAlumno(@RequestBody Medicamento obj) {
		Medicamento objSalida = service.insertaMedicamento(obj);
		return ResponseEntity.ok(objSalida);
	}

	@GetMapping("/nombre/{paramNombre}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> buscarPorNombre(@PathVariable("paramNombre") String nombre) {
		List<Medicamento> lista = service.buscaPorNombre(nombre);
		if (CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

	@GetMapping("/stock1/{param1}/stock2/{param2}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> buscarPorStock(@PathVariable("param1") int num1,
			@PathVariable("param2") int num2) {
		List<Medicamento> lista = service.buscaPorStock(num1, num2);
		if (CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

}
