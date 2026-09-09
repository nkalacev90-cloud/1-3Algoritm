package task1Algoritm;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BalancedBSTBuilder {

    public static TreeNode buildBalancedBST(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        java.util.Arrays.sort(arr);
        return buildFromSorted(arr, 0, arr.length - 1);
    }

    private static TreeNode buildFromSorted(int[] arr, int left, int right) {
        // Базовый случай: диапазон пуст
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(arr[mid]);

        node.left = buildFromSorted(arr, left, mid - 1);
        node.right = buildFromSorted(arr, mid + 1, right);

        return node;
    }

    public static void main(String[] args) {
        int[] arr = {17, 6, 5, 20, 19, 18, 11, 14, 12, 13, 2, 4, 10};
        TreeNode root = buildBalancedBST(arr);

        System.out.println("Родитель с дочерними:");
        printParentWithChildren(root);
    }

    public static void printParentWithChildren(TreeNode node) {
        if (node == null) {
            return;
        }

        // Выводим родителя
        System.out.print("Родитель: " + node.val);

        // Выводим левого ребёнка
        if (node.left != null) {
            System.out.print(", Левое: " + node.left.val);
        } else {
            System.out.print(", Левое: null");
        }

        // Выводим правого ребёнка
        if (node.right != null) {
            System.out.print(", Правое: " + node.right.val);
        } else {
            System.out.print(", Правое: null");
        }
        System.out.println();

        // Рекурсивно идём по детям
        printParentWithChildren(node.left);
        printParentWithChildren(node.right);
    }
}
