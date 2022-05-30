
package animalcraft;

import java.io.Serializable;

public class Space  implements Serializable{

    private String description;
    private Tool tool;

    public Space(String description) {
        this.description = description;
        
    }

    public Space() {
        this("");
    }

    public void setDescription(String description) {
this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
    
    
    public boolean hasTool(){
        return tool != null;
    }

} //end space calss
