package cs0048.assign7;
// For Assignment 7 also download Player.java and NBADATA.txt
// Creating a package is up to you

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
// Complete the methods in this class following drections in the comments
// Do not change the main or method signatures


public class Assign7 {
	// global array to store player details
	// will not need to be passed
	public static Player[] players;  
        public static  int numPlayers;
	
	public static void main(String[] args) {
		int numPlayers = countPlayers();
		System.out.println("Number of players is " + numPlayers);
		// Create the array so it has no wasted space
		players = new Player[numPlayers]; 
		System.out.println("Adding the players...");
		fillPlayers();

		System.out.println("Player at index 123 is " + players[123]);
		// Prints the following
		// Jalen Brunson, Position: PG, Games Played: 68, MinsPG: 35
		// RebsPG: 3.5, AsstsPG: 6.2, StsPG: 0.9, BlksPG: 0.2, PtsPG: 24
			
		System.out.println("Josh Richardson played " + getMins("Josh Richardson") + " minutes per game.");
			
		System.out.println("How many players played Center? " + totalPlayersPosition("C"));
		System.out.println("Most efficient scorer (points per minute, minimum 15 minutes per game) " + mostEfficientScorer());
			
		System.out.println("List of players who averaged at least 2 blocks");
		System.out.println(moreBlocksThan(2).toString());
			
		whoPlayedMostTotalMinutes();
			
	}

	// Process the NBADATA.txt file to calculate and return how many records in the file
	// No need to create Objects yet
	public static int countPlayers() {
           int count = 0;
           try{
               Scanner fileInput = new Scanner(new File("NBADATA.txt"));
               
               while(fileInput.hasNextLine()){
                   fileInput.nextLine();
                   
                   count++;
               }
               
               
           }catch(FileNotFoundException e){
               System.out.println("File not found");
           }
           
         return count;      
    }
	

	// Read in information from the NBADATA.txt file and create Player objects
	// that are placed into the players array
	// Try to read one line at a time and then use the String.split method
	// Read in information from the NBADATA.txt file and create Player objects
	// that are placed into the players array
	// Try to read one line at a time and then use the String.split method
        public static void fillPlayers() {
            try{
                Scanner fileInput = new Scanner(new File("NBADATA.txt"));
                
                while(fileInput.hasNextLine()){
                    String line = fileInput.nextLine();
                    
                    String[] fields = line.split(",");
                    
                    String name = fields[0];
                    String position = fields[1];
                    int gamesPlayed = Integer.parseInt(fields[2]);
                    double minutes  = Double.parseDouble(fields[3]);
                    double rebounds = Double.parseDouble(fields[4]);
                    double assists = Double.parseDouble(fields[5]);
                    double steals = Double.parseDouble(fields[6]);
                    double blocks = Double.parseDouble(fields[7]);
                    double points = Double.parseDouble(fields[8]);
                    
                   Player player = new Player(name, position, gamesPlayed, minutes, rebounds, assists, steals, blocks, points);
                   
                   players[numPlayers++] = player;
                   
                   
                }
            }catch(FileNotFoundException e){
                System.out.println("File is not found");
            }





	}

	// Returns the mins per game for a player 
        public static double getMins(String s) {
            for(int i = 0; i < numPlayers; i++){
                if(players[i].getFullName().equals(s)){
                    return players[i].getMinutes();
                }
            }
          return 0;
    }
	// Returns the number of players who played at a certain
	// position during the season
	// Should include players who played that position
	// all of the time or some of the time
        public static int totalPlayersPosition(String pos) {
            int count = 0;
            
            for(int i = 0; i < numPlayers; i++){
                if(players[i].getPosition().equalsIgnoreCase(pos)){
                    count++;
                }
            }

            return count;
        }
	

	// Returns the name of the most efficient scorer - the player with the 
	// highest points per minute with minimum 15 minutes per game
        public static String mostEfficientScorer() {
            String mostEfficientPlayer = null;
            double highestPointsPerMinute = 0.0;
            
            for(int i = 0; i < numPlayers; i++){
                Player player = players[i];
                double minutes = player.getMinutes();
                double points = player.getPoints();
                
                if(minutes >= 15){
                    double pointsPerMinute = points / minutes;
                    
                    
                    if(pointsPerMinute > highestPointsPerMinute){
                        highestPointsPerMinute = pointsPerMinute;
                        mostEfficientPlayer = player.getFullName();
                    }
                }
            }

            return mostEfficientPlayer;
            
        }				


	// Return an ArrayList that contains the names of the players
	// who had more than a certain number of blocks per game
	public static ArrayList<String> moreBlocksThan(int limit) {
            ArrayList<String> playersWithMoreBlocks = new ArrayList<>();

            for (int i = 0; i < numPlayers; i++) {
                Player player = players[i];
                double blocksPerGame = player.getBlocks();
        
        // Check if blocks per game exceed the given limit
                if (blocksPerGame > limit) {
                    playersWithMoreBlocks.add(player.getFullName());
                }
            }

            return playersWithMoreBlocks;	

    }

	// Calculate and print the name and total minutes of the player
	// who played the most minutes in the whole season
	public static void whoPlayedMostTotalMinutes() {
            String playerName = "";
            double maxTotalMinutes = 0.0;
            
            for(int i = 0; i < numPlayers; i++){
                Player player = players[i];
                double totalMinutes = player.getMinutes();
                
                if(totalMinutes > maxTotalMinutes){
                    maxTotalMinutes = totalMinutes;
                    playerName = player.getFullName();
                }
            }
        System.out.println("Player who played the most total minutes: " + playerName);
        System.out.println("Total minutes played: " + maxTotalMinutes);
        }
        
    
}
			

