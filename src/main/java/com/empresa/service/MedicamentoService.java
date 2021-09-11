package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {

	public Medicamento insertaMedicamento(Medicamento obj);

	public List<Medicamento> listaMedicamento();

	public Optional<Medicamento> buscaPorId(int idMedicamento);

	public abstract List<Medicamento> buscaPorNombre(String nombre);

	public abstract List<Medicamento> buscaPorStock(int num1, int num2);
}
