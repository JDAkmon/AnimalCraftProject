package animalcraft;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Island implements Serializable{

    //2D array list 
    ArrayList<ArrayList<Space>> grid;
    ArrayList<Player> players;
    Player owner;

    public Island(Player owner) {
        this.owner = owner;
        //initialize the arraylist for players and friends
        players = new ArrayList<>();

        //This allows each island to get its own grid of spaces
        //Making an array list of array lists of spaces
        grid = new ArrayList<ArrayList<Space>>();
        Random random = new Random();
        //If a 2D array is an array of arrays the 10 rows are 10 arrays of underetmined length (columns)
        for (int rowIndex = 0; rowIndex < 10; rowIndex++) {
            grid.add(new ArrayList<Space>()); //make a row 10 times (does one for each loop)
            //The rows are the length of each array
            for (int columnIndex = 0; columnIndex < 12; columnIndex++) {
                Space newSpace = new Space("empty space");
                int randomNumber = random.nextInt(10);

               if (randomNumber == 4) {
                    newSpace = new BuildableSpace();
                } else if (randomNumber == 5) {
                    newSpace = new ChoppableSpace();
                } else if (randomNumber == 6) {
                    newSpace = new DiggableSpace();
                } else if (randomNumber == 7) {
                    newSpace = new Space("space with a hammer");
                    newSpace.setTool(new Tool(Tool.HAMMER));
                } else if (randomNumber == 8) {
                    newSpace = new Space("space with an axe");
                    newSpace.setTool(new Tool(Tool.AXE));
                } else if (randomNumber == 9) {
                    newSpace = new Space("space with a shovel");
                    newSpace.setTool(new Tool(Tool.SHOVEL));
                }
                grid.get(rowIndex).add(newSpace);
            }
        } //whole thing repeats for 10 loops

    }
    public String getOwnerNmae(){
        return owner.getName();
    }
     public boolean isValidLocation(int rowIndex, int columnIndex){
        return 0 <= rowIndex && rowIndex < grid.size() && 
                0 <= columnIndex && columnIndex < grid.get(rowIndex).size();
    }

    //String builder is used to modifty output
    //Peformance gain from not having to make new strings all the time as text will be modified in place
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        //Row = verticle spaces aka each array, column index is what space of the array for each array at a time
        for (int rowIndex = 0; rowIndex < grid.size(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < grid.get(rowIndex).size(); columnIndex++) {
                builder.append("Row: ");
                builder.append(rowIndex);
                builder.append(" Column: ");
                builder.append(columnIndex);
                builder.append(": ");
                builder.append(grid.get(rowIndex).get(columnIndex).getDescription());
                builder.append("\n");

            }
        }
        return builder.toString();
    }

    //to add player to a existing island in the form of player arraylist
    public void addPlayer(Player player) {
        players.add(player);
    }
//     public String getOwnersName(){
//        return owner.getPlayerName();
//    }

    //Once the player is done visiting the island
    public boolean removePlayer(Player player) {
        return players.remove(player);
    }

    public Space getSpace(int rowIndex, int columnIndex) {
        return grid.get(rowIndex).get(columnIndex);
    }

    public boolean canDigSpace(Player player) {
        return player.canDig()
                && isDiggable.class.isAssignableFrom(
                        grid.get(player.getLocationX()).get(player.getLocationY()).getClass())
                && (player.equals(owner) || owner.getFriends().contains(player));

    }

    public boolean canChopSpace( Player player) {
        return player.canChop()
                && isChoppable.class.isAssignableFrom(
                          grid.get(player.getLocationX()).get(player.getLocationY()).getClass())
                && (player.equals(owner) || owner.getFriends().contains(player));

    }

    public boolean canBuildSpace( Player player) {
        return player.canBuild()
                && isBuildable.class.isAssignableFrom(
                         grid.get(player.getLocationX()).get(player.getLocationY()).getClass())
                && (player.equals(owner) || owner.getFriends().contains(player));

    }

    //The player will have a location of x and y for their space so it is not needed as a parameter
    public Tool pickupTool(Player player) {
        Tool tool = null;

        Space space = grid.get(player.getLocationX()).get(player.getLocationY());
        if (space.hasTool() && (player.equals(owner) || owner.getFriends().contains(player))) {
            tool = space.getTool();
            space.setTool(null);
            space.setDescription("there was a tool here once");
        }

        return tool;
    }

}//end island class
