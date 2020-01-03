public class Main {

    public static void main(String[] args) {

        Tree myTree = new Tree();




        myTree.insert(3, "Gleb");
        myTree.insert(1, "Alexey");
        myTree.insert(1, "Lida");
        myTree.insert(9, "Masha");
        myTree.insert(7, "Kolya");
        myTree.insert(10, "Stas");
        myTree.insert(8, "Zhora");
        myTree.insert(6, "Marina");


        System.out.println("Обход в глубину");
        myTree.displayTreeDeeply();
        //Умное удаление
        myTree.deleteSafely(3);
        System.out.println("После удаления:");
        myTree.displayTreeDeeply();
        System.out.println();

        System.out.println("Обход в ширину");
        myTree.displayTreeWidely();

        System.out.println("Поиск(10): " + myTree.find(10).name);


    }
}
