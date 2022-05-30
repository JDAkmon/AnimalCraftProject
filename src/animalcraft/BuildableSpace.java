/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package animalcraft;


public class BuildableSpace extends Space implements isBuildable{

    public BuildableSpace(){
        super("This is a space that is good for building");
    }
    @Override
    public boolean build(Player aPlayer) {
         if(aPlayer.canBuild()){
            setDescription("You built a base here");
            return true;
        }
        return false;
    }
 }
