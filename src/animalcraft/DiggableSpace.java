
package animalcraft;

public class DiggableSpace extends Space implements isDiggable{
    
    //Sets description of the space via inheritance
    public DiggableSpace(){
        super("This is an empty space that can be dug up");
    }
    
    
    
//if parent class has a ctor with arguments it must be called otherwise it doesnt
    //This class calls the no arg space ctor by default
    @Override
    public boolean dig(Player aPlayer) {
        if(aPlayer.canDig()){
            setDescription("Digged a hole here");
            return true;
        }
        return false;
    }
}
