package Screen.Util;

import NETPUG.Vertex;

import java.util.ArrayList;

public class BTNode {

    private Vertex data;
    private BTNode left;
    private BTNode right;

    public BTNode(Vertex data) {
        this.data = data;
    }

    public BTNode(Vertex data, BTNode left, BTNode right) {
        new BTNode(data);
        this.left = left;
        this.right = right;
    }

    public void add(Vertex other, int ID) {
        int thisID = data.getID();
        if (ID > thisID) {
            if (this.right != null) {
                right.add(other, ID);
            } else {
                right = new BTNode(other);
            }
        } else if (ID < thisID) {
            if (this.left != null) {
                left.add(other, ID);
            } else {
                left = new BTNode(other);
            }
        }
    }

    public int getMax(){
        if(this.right == null){
            return this.data.getID();
        }
        return this.right.getMax();
    }

    public void vertexInList(ArrayList<Vertex> list){
        if(this.left != null){
            left.vertexInList(list);
        }
        list.add(data);
        if(this.right != null){
            right.vertexInList(list);
        }
    }

    public void nodeInList(ArrayList<BTNode> list){
        if(this.left != null){
            left.nodeInList(list);
        }
        list.add(this);
        if(this.right != null){
            right.nodeInList(list);
        }
    }

    public Vertex getVertex(int ID){
        int thisID = data.getID();
        if(ID == thisID){
            return this.data;
        }
        if(ID > thisID && this.right != null){
            return right.getVertex(ID);
        }
        if(ID < thisID && this.left != null){
            return left.getVertex(ID);
        }
        return null;
    }

    public void setPos(Vector pos){
        this.data.setVector(pos);
    }

    public Vector getPos(){
        return this.data.getVector();
    }

    public Vector getPosFromID(int ID){
        int thisID = data.getID();
        if(ID == thisID){
            return this.getData().getVector();
        }
        if(ID > thisID && this.right != null){
            return right.getPosFromID(ID);
        }
        if(ID < thisID && this.left != null){
            return left.getPosFromID(ID);
        }
        return null;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public BTNode getRight() {
        return right;
    }

    public Vertex getData(){
        return this.data;
    }

    public void setData(Vertex vertex){
        this.data = vertex;
    }
}
