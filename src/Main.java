public class Main {

    public static void main(String[] args) {

        Tree myTree = new Tree();

//        myTree.insert(5, "Gleb");
//        myTree.insert(7, "Pasha");
//        myTree.insert(3, "Katya");
//        myTree.insert(4, "Zhenya");
//        myTree.insert(6, "Alexey");
//        myTree.insert(45, "Masha");
//        myTree.insert(41, "Dasha");
//        myTree.insert(40, "Dasha");
//        myTree.insert(48, "Dasha");


//        myTree.insert(-2, "");
//        myTree.insert(3, "");
//        myTree.insert(2, "");
//        myTree.insert(-5, "");
//        myTree.insert(9, "");
//        myTree.insert(7, "");
//        myTree.insert(10, "");
//        myTree.insert(8, "");
//        myTree.insert(6, "");



        myTree.insert(3, "");
        myTree.insert(1, "");
        myTree.insert(1, "");
        myTree.insert(9, "");
        myTree.insert(7, "");
        myTree.insert(10, "");
        myTree.insert(8, "");
        myTree.insert(6, "");

        myTree.displayTreeDeeply();

        myTree.deleteSafely(3);

        System.out.println("after:");

        myTree.displayTreeDeeply();

    }
}
