/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalcraft;

public class ChoppableSpace extends Space implements isChoppable{

    public ChoppableSpace(){
        super("This is a space with a tree that can be cut down");
    }
    @Override
    public boolean chop(Player aPlayer) {
         if(aPlayer.canChop()){
            setDescription("The tree has been cut down");
            return true;
        }
        return false;
    }
 }
