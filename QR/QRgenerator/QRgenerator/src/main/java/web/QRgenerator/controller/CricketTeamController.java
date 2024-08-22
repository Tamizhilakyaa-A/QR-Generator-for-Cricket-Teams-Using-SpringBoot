package web.QRgenerator.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;

import web.QRgenerator.generate.QRGenerator;
import web.QRgenerator.service.CricketTeamService;
import web.QRgenerator.util.CricketTeam;

@RestController
@RequestMapping("/cricketteam")
public class CricketTeamController {
	
	@Autowired
	private CricketTeamService cricketTeamService;
	
	@PostMapping("/add")
	public CricketTeam addTeam(@RequestBody CricketTeam cricketTeam) {
		return cricketTeamService.addTeam(cricketTeam);
	}
	
	@GetMapping("/{id}")
	public CricketTeam fetchTeamById(@PathVariable int id) {
		return cricketTeamService.fetchTeamById(id);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CricketTeam>> fetchTeam() throws WriterException, IOException{
		List<CricketTeam> cricket = cricketTeamService.fetchTeam();
		if(cricket.size() != 0 ) {
			for(CricketTeam cricketTeam : cricket) {
				QRGenerator.generateQRCode(cricketTeam);
			}
		}
		
		return ResponseEntity.ok( cricketTeamService.fetchTeam());
	}

}
