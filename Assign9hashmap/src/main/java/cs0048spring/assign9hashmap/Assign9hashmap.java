/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cs0048spring.assign9hashmap;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.util.HashMap;
/**
 *
 * @author juliuspruss
 */
public class Assign9hashmap {

    public static void main(String[] args) {
        HashMap<String, Player> playerMap = new HashMap<>();

        try (ObjectInputStream oistream = new ObjectInputStream(new FileInputStream("PlayerList.dat"))) {
            while (true) {
                Player nextPlayer = (Player) oistream.readObject();
                playerMap.put(nextPlayer.getFullName(), nextPlayer);
            }
        } catch (EOFException e) {
            System.out.println("End of file reached.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }

        // Print the number of entries in the dictionary
        System.out.println("Number of entries in the dictionary: " + playerMap.size());

        // Print the value for Coby White
        System.out.println("Coby White: " + playerMap.get("Coby White"));

        // Delete the entries for Frank Jackson and Devon Dotson
        playerMap.remove("Frank Jackson");
        playerMap.remove("Devon Dotson");

        // Print the number of entries in the dictionary after deletion
        System.out.println("Number of entries after deletion: " + playerMap.size());

        // Decide if the player named "Luke Cornet" is in the dictionary
        System.out.println("Is Luke Cornet in the dictionary? " + playerMap.containsKey("Luke Cornet"));

        // Iterate through the hash table and calculate which player has the highest number of stocks per game
        Player highestStocksPlayer = null;
        double highestStocks = 0;

        for (Player player : playerMap.values())
            double stocks = player.getSteals() + player.getBlocks();
            if (stocks > highestStocks) {
                highestStocks = stocks;
                highestStocksPlayer = player;
            }
        }

        if (highestStocksPlayer != null) {
            System.out.println("Player with the highest stocks per game: " + highestStocksPlayer.getFullName());
        }
    }
}