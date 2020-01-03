public class Tree {
    private TreeNode root;

    public TreeNode find(int searchedID) {
        TreeNode current = root;
        while (current.id != searchedID) {
            if (current.id < searchedID) {
                //Нужно двигаться вправо
                current = current.rightChild;
            } else {
                //Нужно двигаться влево
                current = current.leftChild;
            }
            if (current == null) {
                return null; //Поиск завершился неудачей :(
            }
        }
        //Найдено совпадение curent.id == searchedID. Возвращаем значение!
        return current;
    }

    public void insert(int id, String data) {
        TreeNode newNode = new TreeNode();
        newNode.id = id;
        newNode.data = data;

        //Если корневого узла не существует
        if (root == null) {
            root = newNode;
        } else {
            TreeNode current = root;
            TreeNode parent;

            //Не беспокоиться! Тут внутренний выход из цикла
            while (true) {

                //Сохраняем ссылку на вероятно родительский узел, потому что у дочерних узлов нет ссылки на родителя
                parent = current;

                if (current.id < newNode.id) {
                    //Двигаться направо
                    if (current.rightChild == null) {
                        parent.rightChild = newNode;
                        return;
                    } else {
                        current = current.rightChild;
                    }
                } else {
                    //Двигаться налево
                    if (current.leftChild == null) {
                        parent.leftChild = newNode;
                        return;
                    } else {
                        current = current.leftChild;
                    }
                }
            }
        }
    }

    public void delete(int deleteId) {
        TreeNode parent = root;
        TreeNode current = root;

        int k = 0;

        while (current.id != deleteId) {

            System.out.println(++k);
//            if (!current.hasChildren()) {
//                return; // не нашли, что удалить((
//            }

            if (current.id < deleteId) {
                //Нужно двигаться вправо

                if (current.hasRightChild()) {
                    parent = current;
                    current = current.rightChild;
                } else {
                    return; //не нашли
                }

            } else {
                if (current.hasLeftChild()) {
                    //Нужно двигаться влево
                    parent = current;
                    current = current.leftChild;
                } else {
                    return; //не нашли
                }

            }
        }

        if (deleteId == this.root.id) {
            this.root = null;
        } else {
            if (parent.leftChild == current) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
    }


    public void displayTree() {
        if (root == null) {
            System.out.println();
            System.out.println("[Empty Tree]");
            System.out.println();
            return;
        }
        displayTree(root, 0);
    }

    private void displayTree(TreeNode rootNode, int level) {
        System.out.println("  " + rootNode.id);

        if (rootNode.hasLeftChild()) {
            System.out.print("/");
        }
        if (rootNode.hasRightChild()) {
            System.out.print("   \\");
        }
        if (rootNode.hasChildren()) {
            System.out.println();
        }

        if (rootNode.hasLeftChild()) {
            System.out.print(rootNode.leftChild.id);
        }
        if (rootNode.hasRightChild()) {
            System.out.print("   " + rootNode.rightChild.id);
        }
        if (rootNode.hasChildren()) {
            System.out.println();
            System.out.println();
        }

        if (rootNode.hasLeftChild() && rootNode.leftChild.hasChildren()) {
            displayTree(rootNode.leftChild, level + 1);
        }
        if (rootNode.hasRightChild() && rootNode.rightChild.hasChildren()) {
            displayTree(rootNode.rightChild, level + 1);
        }
    }

}
