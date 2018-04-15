package xvr.mail;

import java.util.Stack;

public class Tree implements INode {

    private Node root; // head on tree

    public Tree() {
        root = null;
    }

    @Override
    public Node find(int key) {
        Node current = root;
        while (current.iDate != key) {
            if (key < current.iDate) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    @Override
    public void insert(int id) {
        Node newNode = new Node(); // Create new node;
        newNode.iDate = id; //insert data number of cell in decimal numbers
        //  newNode.x = xCord;
        //  newNode.y = yCord;
        if (root == null) {            // head Tree not exist;
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iDate) {           // move to left
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {                         // move to the right
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }
        }
    }

    @Override
    public void delete(int id) {

    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("..............");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++)
                System.out.print(" ");

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iDate);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;

                }

                else
                    {
                    System.out.print("- -");
                    localStack.push(null);
                    localStack.push(null);

                }

                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(" ");



            }
            System.out.println();
            nBlanks/=2;
            while (localStack.isEmpty()==false)
                globalStack.push(localStack.pop());
        }
        System.out.println("...........................");
    }


}
