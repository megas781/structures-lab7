public class Main {

    public static void main(String[] args) {

        Tree myTree = new Tree();

        myTree.insert(5, "Gleb");
        myTree.insert(7, "Alexey");
        myTree.insert(3, "Katya");
        myTree.insert(4, "Zhenya");
        myTree.insert(5, "Pasha");

//        for (int i = 0; i < 10; i++) {
//            myTree.insert((int) Math.round(Math.random() * 90 + 10), "Zhopa" + (i + 1));
//        }

        myTree.displayTree();
        myTree.delete(5);
        System.out.println("after:");
        myTree.displayTree();

    }
}
