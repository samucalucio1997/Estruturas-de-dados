package utils;

import RubroNegra.NoRN;

public class ValidatorsUtil {

    public static boolean isEmpty(Object node) {
        try {
            return node == null;
        } catch (Exception e) {
            throw new RuntimeException("T");
        }
    }

    public static boolean isNotEmpty(Object node) {
        try {
            return !(node == null);
        } catch (Exception e) {
            throw new RuntimeException("T");
        }
    }

    public static <T> NoRN<T> filhoNaoNulo(NoRN<T> node) {
        try {
            return node.getLeftChild() == null ? node.getRightChild() : node.getLeftChild();
        } catch (Exception e) {
            throw new RuntimeException("T");
        }
    }

    public static <T> boolean isLeftChild(NoRN<T> pai, NoRN<T> child) {
        return pai.getLeftChild() == child;
    }
}
