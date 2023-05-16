package com.samar.voitures.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.samar.voitures.dto.VoitureDTO;
import com.samar.voitures.entities.Marque;
import com.samar.voitures.entities.Voiture;
import com.samar.voitures.repos.VoitureRepository;

@Service
public class VoitureServiceImpl implements VoitureService{

	@Autowired
	VoitureRepository voitureRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public VoitureDTO saveVoiture(VoitureDTO v) {
		 return convertEntityToDto( voitureRepository.save(convertDtoToEntity(v)));
	}

	@Override
	public VoitureDTO updateVoiture(VoitureDTO v) {
		 return convertEntityToDto(voitureRepository.save(convertDtoToEntity(v)));

	}

	@Override
	public void deleteVoiture(Voiture v) {
		voitureRepository.delete(v);
		
	}

	@Override
	public void deleteVoitureById(Long id) {
		voitureRepository.deleteById(id);		
	}

	@Override
	public VoitureDTO getVoiture(Long id) {
		return convertEntityToDto( voitureRepository.findById(id).get());

	}

	@Override
	public List<VoitureDTO> getAllVoitures() {
		return voitureRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
		
	}

	@Override
	public Page<Voiture> getAllVoituresParPage(int page, int size) {
		return voitureRepository.findAll(PageRequest.of(page, size));

	}

	@Override
	public List<Voiture> findByModeleVoiture(String nom) {
		return  voitureRepository.findByModeleVoiture(nom);

	}

	@Override
	public List<Voiture> findByModeleVoitureContains(String nom) {
		return  voitureRepository.findByModeleVoitureContains(nom);

	}

	@Override
	public List<Voiture> findByModeleVoiturePrixVoiture(String nom, Double prix) {
		return  voitureRepository.findByModeleVoiturePrixVoiture(nom,prix);
 
	}

	@Override
	public List<Voiture> findByMarque(Marque marque) {
		return  voitureRepository.findByMarque(marque);

	}

	@Override
	public List<Voiture> findByMarqueIdMarque(Long id) {
		return  voitureRepository.findByMarqueIdMarque(id);

	}
	
//	@Override
//	public VoitureDTO convertEntityToDto(Voiture voiture) {
//		VoitureDTO voitureDTO = new VoitureDTO();
//		voitureDTO.setIdVoiture(voiture.getIdVoiture());
//		voitureDTO.setModeleVoiture(voiture.getModeleVoiture());
//		voitureDTO.setPrixVoiture(voiture.getPrixVoiture());
//		voitureDTO.setDateFabrication(voiture.getDateFabrication());
//		voitureDTO.setMarque(voiture.getMarque());
//	 return voitureDTO;
//
//
//	}
	
	

	@Override
	public VoitureDTO convertEntityToDto(Voiture voiture) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		VoitureDTO voitureDTO = modelMapper.map(voiture, VoitureDTO.class);
		return voitureDTO;
	 }
	
	@Override
	public Voiture convertDtoToEntity(VoitureDTO voitureDTO) {
		Voiture voiture = new Voiture();
		voiture = modelMapper.map(voitureDTO, Voiture.class);
		voiture.setIdVoiture(voitureDTO.getIdVoiture());
		voiture.setModeleVoiture(voitureDTO.getModeleVoiture());
		voiture.setPrixVoiture(voitureDTO.getPrixVoiture());
		voiture.setDateFabrication(voitureDTO.getDateFabrication());
		voiture.setMarque(voitureDTO.getMarque());
	 return voiture;
	}
}