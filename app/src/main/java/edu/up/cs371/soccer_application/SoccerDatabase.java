package edu.up.cs371.soccer_application;

import android.content.Context;
import android.util.Log;

import edu.up.cs371.soccer_application.soccerPlayer.SoccerPlayer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 * 
 * @author *** put your name here ***
 * @version *** put date of completion here ***
 *
 */
public class SoccerDatabase implements SoccerDB {

protected HashMap<String, SoccerPlayer> soccerPlayerHashMap = new HashMap<String, SoccerPlayer>();

    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    @Override
	public boolean addPlayer(String firstName, String lastName,
			int uniformNumber, String teamName) {
        String fullName = firstName.concat(lastName);
        if(soccerPlayerHashMap.containsKey(fullName)) return false;
        else {
            soccerPlayerHashMap.put(fullName, new SoccerPlayer(firstName, lastName, uniformNumber, teamName));
            return true;
        }
	}

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName) {
            String fullName = firstName.concat(lastName);
        if(soccerPlayerHashMap.containsKey(fullName))
        {
            soccerPlayerHashMap.remove(fullName);
            return true;
        }
        return false;
    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
	public SoccerPlayer getPlayer(String firstName, String lastName) {
        String fullName = firstName.concat(lastName);
        if(soccerPlayerHashMap.containsKey(fullName)) return soccerPlayerHashMap.get(fullName);
        else return null;
    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName) {
        String fullName = firstName.concat(lastName);
        if(soccerPlayerHashMap.containsKey(fullName))
        {
            soccerPlayerHashMap.get(fullName).bumpGoals();
            return true;
        }
        return false;
    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */
    @Override
    public boolean bumpAssists(String firstName, String lastName) {
        String fullName = firstName.concat(lastName);
        if(soccerPlayerHashMap.containsKey(fullName))
        {
            soccerPlayerHashMap.get(fullName).bumpAssists();
            return true;
        }
        return false;
    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @Override
    public boolean bumpShots(String firstName, String lastName) {
        String fullName = firstName.concat(lastName);
        if(soccerPlayerHashMap.containsKey(fullName))
        {
            soccerPlayerHashMap.get(fullName).bumpShots();
            return true;
        }
        return false;
    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @Override
    public boolean bumpSaves(String firstName, String lastName) {
        String fullName = firstName.concat(lastName);
        if(soccerPlayerHashMap.containsKey(fullName))
        {
            soccerPlayerHashMap.get(fullName).bumpSaves();
            return true;
        }
        return false;
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @Override
    public boolean bumpFouls(String firstName, String lastName) {
        String fullName = firstName.concat(lastName);
        if(soccerPlayerHashMap.containsKey(fullName))
        {
            soccerPlayerHashMap.get(fullName).bumpFouls();
            return true;
        }
        return false;
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName) {
        String fullName = firstName.concat(lastName);
        if(soccerPlayerHashMap.containsKey(fullName))
        {
            soccerPlayerHashMap.get(fullName).bumpYellowCards();
            return true;
        }
        return false;
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName) {
        String fullName = firstName.concat(lastName);
        if(soccerPlayerHashMap.containsKey(fullName))
        {
            soccerPlayerHashMap.get(fullName).bumpRedCards();
            return true;
        }
        return false;
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
	public int numPlayers(String teamName) {
        if(teamName.equals(null))
        {
            return soccerPlayerHashMap.size();
        }
        else
        {
            if(soccerPlayerHashMap.isEmpty())
            {
                return 0;
            }
            else
            {
                /*for(int i = 0; i < soccerPlayerHashMap.size(); i++)
                {
                    if((soccerPlayerHashMap.values().toArray()[i]).)
                    {

                    }
                }*/
                int i = 0;
                for(SoccerPlayer sp : soccerPlayerHashMap.values())
                {
                    if(sp.getTeamName().equals(teamName)) {
                        i++;
                    }
                }
                return i;
            }
        }
    }

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
	// get the nTH player
	@Override
    public SoccerPlayer playerNum(int idx, final String teamName) {
        if(teamName.equals(null))
        {
            SoccerPlayer soccerPlayerArray[] = soccerPlayerHashMap.values().toArray(new SoccerPlayer[0]);
            return soccerPlayerArray[idx];
        }
        else
        {
            SoccerPlayer soccerPlayerArray[] = soccerPlayerHashMap.values().toArray(new SoccerPlayer[0]);
            //soccerPlayerArray = Arrays.stream(soccerPlayerArray).filter(x -> x.getTeamName().equals(teamName)).toArray(new SoccerPlayer[0]);
            ArrayList <SoccerPlayer> soccerPlayerAL = new ArrayList();
            for(int i = 0; i < soccerPlayerArray.length; i++){
                if(soccerPlayerArray[i].getTeamName().equals(teamName))
                {
                    soccerPlayerAL.add(soccerPlayerArray[i]);
                }
            }
            return soccerPlayerAL.get(idx);
        }

    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
	// read data from file
    @Override
	public boolean readData(File file) {
        return file.exists();
	}

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
	// write data to file
    @Override
	public boolean writeData(File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            for(SoccerPlayer player : soccerPlayerHashMap.values()) {
                fileOutputStream.write((data + System.getProperty("line.separator")).getBytes());
            }
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        return false;
	}

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see edu.up.cs371.soccer_application.SoccerDB#getTeams()
     */
	// return list of teams
    @Override
	public HashSet<String> getTeams() {
        return new HashSet<String>();
	}

}
