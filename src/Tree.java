import java.util.LinkedList;

public class Tree {
    private TreeNode root;

    //Поиск элемента
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

    //Добавление
    public void insert(int id, String data) {
        TreeNode newNode = new TreeNode();
        newNode.id = id;
        newNode.name = data;

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

    //Умное удаление
    public void deleteSafely(int deleteId) {
        //Parent нужен, потому что только родитель может удалить потомка
        TreeNode parent = root;
        TreeNode current = root;
        Boolean isLeft = false;
//        Счетчик, определяющий root
        int k = 0;

        //Алгоритм похож на поиск
        while (current.id != deleteId) {

            k++;

            if (current.id < deleteId) {
                //Нужно двигаться вправо

                if (current.hasRightChild()) {
                    parent = current;
                    current = current.rightChild;
                    isLeft = false;
                } else {
                    System.out.println("[Не нашёл, что удалять]");
                    return; //не нашли
                }

            } else {
                if (current.hasLeftChild()) {
                    //Нужно двигаться влево
                    parent = current;
                    current = current.leftChild;
                    isLeft = true;
                } else {
                    System.out.println("[Не нашёл, что удалять]");
                    return; //не нашли
                }

            }
        }

        //Если удалось выйти из цикла, то узел найден. Удаляем!

        //сохраняем тот узел, который собираемся удалять
        TreeNode delNode = current;

        if (!delNode.hasChildren()) {//Если нет потомков
            if (k == 0) {
                //Типа удаление
                this.root = null;
            } else {
                if (isLeft) {
                    //Типа удаление
                    parent.leftChild = null;
                } else {
                    //Типа удаление
                    parent.rightChild = null;
                }
            }
        } else if (delNode.hasLeftChild() && !delNode.hasRightChild()) {

            if (isLeft) {
                //Типа удаление
                parent.leftChild = delNode.leftChild;
            } else {
                //Типа удаление
                parent.rightChild = delNode.leftChild;
            }

        } else if (!delNode.hasLeftChild() && delNode.hasRightChild()) {
            if (isLeft) {
                //Типа удаление
                parent.leftChild = delNode.rightChild;
            } else {
                //Типа удаление
                parent.rightChild = delNode.rightChild;
            }
        } else {
            //Здесь нужно выбирать

            //Шагаем один раз вправо (Теперь current используется для поиска приемника)
            current = current.rightChild;

            /* на этом месте если у очередного current нет левого потомка,
                то parent.rightChild = current и всё */
            if (!current.hasLeftChild()) {
                current.leftChild = delNode.leftChild; //наличие гарантировано
                current.rightChild = delNode.rightChild; //наличие гарантировано

                if (k == 0) {
                    this.root = current;
                } else {
                    //Типа удаление
                    if (isLeft) {
                        parent.leftChild = current;
                    } else {
                        parent.rightChild = current;
                    }
                }
                return;
            }


            TreeNode previous = null; //previous это типа родитель, но у которого скоро заберут ребёнка

            //Далее налево, пока не упрёмся
            while (current.hasLeftChild()) {
                previous = current;
                current = current.leftChild;
            }


            current.leftChild = delNode.leftChild; //наличие гарантировано
            current.rightChild = delNode.rightChild; //наличие гарантировано
            previous.leftChild = null;

            if (k == 0) {
                this.root = current;
            } else {
                //Типа удаление
                if (isLeft) {
                    parent.leftChild = current;
                } else {
                    parent.rightChild = current;
                }
            }

        }


    }

    //Удаление c потомками
    public void deleteWithChildren(int deleteId) {
        //Parent нужен, потому что только родитель может удалить потомка
        TreeNode parent = root;
        TreeNode current = root;

//        Счетчик, определяющий root
        int k = 0;

        //Алгоритм похож на поиск
        while (current.id != deleteId) {

            k++;

            if (current.id < deleteId) {
                //Нужно двигаться вправо

                if (current.hasRightChild()) {
                    parent = current;
                    current = current.rightChild;
                } else {
                    System.out.println("[Не нашёл, что удалять]");
                    return; //не нашли
                }

            } else {
                if (current.hasLeftChild()) {
                    //Нужно двигаться влево
                    parent = current;
                    current = current.leftChild;
                } else {
                    System.out.println("[Не нашёл, что удалять]");
                    return; //не нашли
                }

            }
        }

        //Если удалось выйти из цикла, то узел найден. Удаляем!

        //Проверка, не является ли узел корневым
        if (k == 0) {
            this.root = null;
        } else {

            if (parent.leftChild == current) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
    }


    //Обход дерева в глубину
    public void displayTreeDeeply() {
        if (root == null) {
            System.out.println();
            System.out.println("[Empty Tree]");
            System.out.println();
            return;
        }
        _displayTree(root, 0);
    }

    private void _displayTree(TreeNode rootNode, int level) {
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
            _displayTree(rootNode.leftChild, level + 1);
        }
        if (rootNode.hasRightChild() && rootNode.rightChild.hasChildren()) {
            _displayTree(rootNode.rightChild, level + 1);
        }
    }

    //Обход дерева в ширину
    public void displayTreeWidely() {

        int k = 0;

        LinkedList<TreeNode> currentQueue = new LinkedList<>();
        LinkedList<TreeNode> tempQueue = new LinkedList<>();

        currentQueue.addLast(root);

        while (!currentQueue.isEmpty()) {

//            System.out.println("length: " + currentQueue.size());
            //Принтим currentQueue, параллельно заполняя tempQueue
            System.out.print((++k) + ")");
            while (!currentQueue.isEmpty()) {
                TreeNode node = currentQueue.pollFirst();
                System.out.print(" " + node.id);

                if (node.hasLeftChild()) {
                    tempQueue.addLast(node.leftChild);
                }
                if (node.hasRightChild()) {
                    tempQueue.addLast(node.rightChild);
                }
            }
            while (!tempQueue.isEmpty()) {
                currentQueue.addLast(tempQueue.pollFirst());
            }
            System.out.println();
        }
        ;

    }
}
