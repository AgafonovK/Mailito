package xvr.mail;

import java.util.Random;

public class Islands {

    private static int mass[][] = {
            {1, 1, 1, 0, 0, 0, 0, 1, 1, 0},
            {1, 1, 0, 1, 1, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 1, 1, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 1, 1, 0},
            {1, 0, 0, 1, 1, 1, 0, 0, 1, 0},
            {1, 1, 0, 1, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    };

    private static boolean massChecked[][] = new boolean[7][10];

    private static Random random = new Random();

    private static int rnd(int max) {

        return 0 + random.nextInt(max - 0);
    }

    private static void initArray(int mass[][], boolean massChecked[][]) {
        // this.mass=mass;
        //this.massChecked=massChecked;

        for (int a = 0; a < mass.length; a++) {
            for (int b = 0; b < mass[0].length; b++) {
                if (mass[a][b] == 1) massChecked[a][b] = true;
                else {
                    massChecked[a][b] = false;
                }
            }
        }
    }

    public static void main(String[] args)  throws ArrayIndexOutOfBoundsException{

        for (int a = 0; a < mass.length; a++) {
            for (int b = 0; b < mass[0].length; b++) {
                if (mass[a][b] == 1) massChecked[a][b] = true;
                else {
                    massChecked[a][b] = false;
                }
            }
        }

        int massColumn = mass[0].length;
        toDec(mass.length, massColumn);

        Tree tree;
        tree = new Tree();
        for (int x = 0; x < mass.length; x++) {
            for (int y = 0; y < massColumn; y++) {


                boolean flag = false;
                //flags of cells around
                int xPlus = 0;
                int xMinus = 0;
                int yPlus = 0;
                int yMinus = 0;


                if (mass[x][y] == 1 && massChecked[x][y]!=false) {
                    massChecked[x][y]=false;
                    mass[x][y]=0;

                    int id;

                    //first check on borderlane (i+-1);
                    if (x - 1 < 0) {
                        if (!flag) {
                            flag = true;
                            tree.insert(toDec(x, y));
                        }
                        //second check if cell around is not border check cell status
                    } else {
                        if (mass[x - 1][y] == 1) {
                            xMinus = 1;
                            if (!flag){tree.insert(toDec(x, y));}
                            tree.insert(toDec(x-1,y)); // add next child

                        }
                    }
                    if (y + 1 >= massColumn) {
                        if(!flag) {
                            flag = true;
                            tree.insert(toDec(x, y));
                        }
                    } else {
                        if (mass[x][y + 1] == 1) {
                            yPlus = 1;
                            if (!flag){
                                tree.insert(toDec(x, y));
                            }
                            tree.insert(toDec(x,y+1));

                        }
                    }

                    if (x + 1 >= mass.length) {
                        if (!flag) {
                            flag = true;
                            tree.insert(toDec(x, y));
                        }
                    } else {
                        if (mass[x + 1][y] == 1) {
                            xPlus = 1;
                            if (!flag){
                                tree.insert(toDec(x, y));
                            }
                            tree.insert(toDec(x+1,y));

                        }
                    }

                    if (y - 1 < 0) {
                        if (!flag){
                            flag = true;
                            tree.insert(toDec(x, y));
                        }
                    } else {
                        if (mass[x][y - 1] == 1) {
                            yMinus = 1;
                            if (!flag){
                                tree.insert(toDec(x, y));
                            }
                            tree.insert(toDec(x,y-1));

                        }
                    }



                    tree.displayTree();
                    int summ = xPlus + xMinus + yMinus + yPlus;
                    //if (summ > 0 | flag == true) { massChecked[x][y]=false;}


                }
            }
        }


    }

    private static void checkNextNode() {

    }
//TODO check border number
    private static int toDec(int x, int y) {
        // mass[3][6]; x=3; y=6;
        if (x==0){
            return y+1;
        }
        int dec = (x * mass[0].length) + y; // get decimal value of cell [x][y];
        return dec;

    }

    private static void invDec(int decInv) {
        int xInv = decInv / mass[0].length; // get x coordinate
        int yInv = decInv % mass[0].length; // get y coordinate

    }

    private static void checkBorder(int x, int y, boolean flag, int xMinus, int xPlus, int yMinus, int yPlus, int massColumn) {
        if (x - 1 < 0) {
            flag = true;
        } else {
            if (mass[x - 1][y] == 1) {
                xMinus = 1;
                flag = true;
            }
        }
        if (x + 1 >= mass.length) {
            flag = true;
        } else {
            if (mass[x + 1][y] == 1) {
                xPlus = 1;
                flag = true;
            }
        }
        if (y - 1 < 0) {
            flag = true;
        } else {
            if (mass[x][y - 1] == 1) {
                yMinus = 1;
                flag = true;
            }
        }
        if (y + 1 >= massColumn) {
            flag = true;
        } else {
            if (mass[x][y + 1] == 1) {
                yPlus = 1;
                flag = true;
            }
        }
    }

}
