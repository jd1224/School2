package homeWork42;
//**************************************************************************************************
// INTERFACE: BinaryTreeVisitor<E>
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
// Web: http://www.devlang.com
//**************************************************************************************************

/**
 * An object that implements this interface implements the visit() method which will be called by
 * the BinaryTree class traversal methods as each node of the BinaryTree is visited during the
 * traversal.
 */
public interface BinaryTreeVisitor<E> {
    void visit(E pData);
}
