package cs0048spring.assign9hashmap;
import java.io.Serializable;

public class Player implements Serializable  {
	private String fullName;
	private String position;
	private int gamesPlayed;
	private double minutes;
	private double rebounds;
	private double assists;
	private double steals;
	private double blocks;
	private double points;
	
	public Player() {
	
	}
	
	public Player(String f, String p, int gp, double mins, double rebs, double a, double s, double b,double pts) {
		fullName = f;
		position = p;
		gamesPlayed = gp;
		minutes = mins;
		rebounds = rebs;
		assists = a;
		steals = s;
		blocks = b;
		points = pts;
	}
	
	public Player(Player player) {
		fullName = player.fullName;
		position = player.getPosition();
		gamesPlayed = player.getGamesPlayed();
		minutes = player.getMinutes();
		rebounds = player.getRebounds();
		assists = player.getAssists();
		steals = player.getSteals();
		blocks = player.getBlocks();
		points = player.getPoints();
	}

	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String f) {
		fullName = f;
	}
	
	public String getPosition() {
		return position;
	}
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	public double getMinutes() {
		return minutes;
	}

	public double getPoints() {
		return points;
	}

	public double getRebounds() {
		return rebounds;
	}

	public double getAssists() {
		return assists;
	}

	public double getSteals() {
		return steals;
	}

	public double getBlocks() {
		return blocks;
	}

	public boolean equals(Player player) {
		if (fullName.equals(player.getFullName()) && position.equals(player.getPosition()) && 
			gamesPlayed == player.getGamesPlayed() && minutes == player.getMinutes() && 
			points == player.getPoints() && rebounds == player.getRebounds() && 
			assists == player.getAssists() && steals ==  player.getSteals() && blocks == player.getBlocks())
			return true;
		else
			return false;
	}
	
	public String toString() {
		return (fullName  + ", Position: " + position + ", Games Played: " + gamesPlayed + ", MinsPG: " + minutes +
			"\nRebsPG: " + rebounds + ", AsstsPG: " + assists + ", StsPG: " + steals + ", BlksPG: " + blocks + " PtsPG: " + points );
	}
}	
	
	