package Reports.Reporters.HtmlTestReporter.Model.Extention;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

public abstract class NodeWithChildren extends Node {
    
    @Getter
    @Setter
    public List<Node> children;

    public NodeWithChildren()
    {
    }

    public NodeWithChildren(String name){
        super(name);
    
    }

    public boolean IsChildWithNameExists(String name)
    {
        return GetChildWithName(name) != null;
    }

    public Node GetChildWithName(String name)
    {
        if (null == children)
        {
            return null;
        }
        for (Node node : children)
        {
            if (node.name.equals(name))
            {
                return node;
            }
        }
        return null;
    }

    public void AddChild(Node node) {
        if (null == children) {
            children = new ArrayList<Node>();
        }
        node.parent = this;
        children.add(node);
    }
    }
