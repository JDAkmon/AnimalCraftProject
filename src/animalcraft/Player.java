/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalcraft;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kashi
 */
public class Player implements Serializable{
  private String name;
  
    //What the player owns
    private Island home; //island is one collection of spaces/a grid
    private ArrayList<Tool> tools; //player has a tool
    private String player;
    private ArrayList<Player> friends;
    private int locationX;
    private int locationY;

    public Player(String player) {
        this.player = player;
        home = new Island(this); //Initialize the island for the player 
        tools = new ArrayList<>(); //Player will start off with no tools 
        friends = new ArrayList<>();
        locationX = 0;
        locationY = 0;
    }

    public int getLocationX() {
        return locationX;
    }
    public void addTool(Tool tool){
        tools.add(tool);
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }
     public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }
    
    public void addFriend(Player friend){
        friends.add(friend);
    }
    //Needed to avoid same memory adress cant use equals
    public boolean isFriendOf(Player friend){
//        for(Player currentFriend: friends){
//            if(currentFriend.getPlayerName().equalsIgnoreCase(friend.getPlayerName())){
//                return true;
//            }
//        }
//        return false;

//contains calls the equals method overrideen below
        return friends.contains(friend);
    }

    public Island getHome() {
        return home;
    }

    public ArrayList<Tool> getTools() {
        return tools;
    }

    public String getPlayer() {
        return player;
    }
    public String getName() {
        return name;
    }
    //Can only dig if player has required tool
    public boolean canDig() {
        //Data Type, this for statemnt name, the array
        for (Tool tool : tools) {
            if (tool.getName().equalsIgnoreCase(Tool.SHOVEL)) {
                return true;
            }
        }
        return false;
    }
    public boolean canChop() {
        //Data Type, this for statemnt name, the array
        for (Tool tool : tools) {
            if (tool.getName().equalsIgnoreCase(Tool.AXE)) {
                return true;
            }
        }
        return false;
    }
    public boolean canBuild() {
        //Data Type, this for statemnt name, the array
        for (Tool tool : tools) {
            if (tool.getName().equalsIgnoreCase(Tool.HAMMER)) {
                return true;
            }
        }
        return false;
    }
      @Override
    public boolean equals(Object other){
        //If not the same class cant be equals already
        if(other.getClass() != getClass()){
            return false;
        }
        //Now if it is in the same class it is safe to now cast other player as object 
        Player otherPlayer = (Player)other;
        return  otherPlayer.getPlayer().equals(getPlayer());
    }
    public ArrayList<Player> getFriends() {
        return friends;
    }

} //End player 2047
