package web.QRgenerator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.QRgenerator.repository.CricketTeamRepository;
import web.QRgenerator.util.CricketTeam;

@Service
public class CricketTeamService {
	
	@Autowired
	private CricketTeamRepository cricketTeamRepository;
	
	public CricketTeam addTeam(CricketTeam cricketTeam) {
		return cricketTeamRepository.save(cricketTeam);
	}
	
	public CricketTeam fetchTeamById(int id) {
		return cricketTeamRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Team not found"));
	}
	
	public List<CricketTeam> fetchTeam(){
		return cricketTeamRepository.findAll();
	}

}
