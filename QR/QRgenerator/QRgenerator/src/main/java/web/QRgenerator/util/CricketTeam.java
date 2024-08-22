package web.QRgenerator.util;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CricketTeam {
	
	@Id
	private int teamId;
	private String teamName;
	private String teamColor;
	private String managerName;
	private String teamEmail;
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamColor() {
		return teamColor;
	}
	public void setTeamColor(String teamColor) {
		this.teamColor = teamColor;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getTeamEmail() {
		return teamEmail;
	}
	public void setTeamMail(String teamEmail) {
		this.teamEmail = teamEmail;
	}
	
	

}
