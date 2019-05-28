package Screen.Util;

import NETPUG.Vertex;

import java.util.ArrayList;

public class BTree{

    private BTNode root;

    public BTree(){
        this.root = null;
    }

    public void add(Vertex data){
        if(this.root != null){
            root.add(data, data.getID());
        }
    }

    public Vertex getVertex(int ID){
        if(this.root != null){
            return root.getVertex(ID);
        }
        return null;
    }

    public Vector getPos(int ID){
        if(this.root != null){
            return root.getPos(ID);
        }
        return null;
    }

    public ArrayList<Vertex> vertexInList(){
        ArrayList<Vertex> list = new ArrayList<>();
        root.vertexInList(list);
        return list;
    }

    public ArrayList<BTNode> nodeInList(){
        ArrayList<BTNode> list = new ArrayList<>();
        root.nodeInList(list);
        return list;
    }
}
