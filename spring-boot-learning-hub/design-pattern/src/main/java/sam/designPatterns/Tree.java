package sam.designPatterns;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Tree {
    private String type;

    public abstract void copy();

}
