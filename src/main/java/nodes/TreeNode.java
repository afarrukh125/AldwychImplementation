package nodes;

import helpers.Constants;
import visitor.customised.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class TreeNode {

    public TreeNode() {
    }

    public abstract <T, D> T accept(CustomVisitor<T, D> v, D data);
}
