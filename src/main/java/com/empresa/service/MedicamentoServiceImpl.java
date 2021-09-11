package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Medicamento;
import com.empresa.repository.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

	@Autowired
	private MedicamentoRepository repository;

	@Override
	public Medicamento insertaMedicamento(Medicamento obj) {
		return repository.save(obj);
	}

	@Override
	public List<Medicamento> listaMedicamento() {
		return repository.findAll();
	}

	@Override
	public Optional<Medicamento> buscaPorId(int idMedicamento) {
		return repository.findById(idMedicamento);
	}

	@Override
	public List<Medicamento> buscaPorNombre(String nombre) {
		return repository.findByNombreLike(nombre);
	}

	@Override
	public List<Medicamento> buscaPorStock(int num1, int num2) {
		return repository.findByStockBetween(num1, num2);
	}

}
