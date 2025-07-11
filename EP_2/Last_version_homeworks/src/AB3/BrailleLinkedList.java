package AB3;

import AB3.Interfaces.List;
import AB3.Provided.ListNode;

/**
 * A custom implementation of a singly linked list for storing {@code ListNode} elements.
 * The {@code BrailleLinkedList} class provides methods for adding, removing, and retrieving
 * elements from both the head and tail of the list, as well as methods for inserting and
 * removing elements at specific indices. It also includes methods for clearing the list.
 *
 * <p>This class is particularly designed to operate with {@code ListNode} objects which represent
 * nodes in a linked list, each containing a bitmap and a reference to the next node.</p>
 */
public class BrailleLinkedList implements List {
    private ListNode head;
    private ListNode tail;

    // TODO: (optional) variable declarations


    /**
     * Constructor initializes an empty BrailleLinkedList.
     */
    public BrailleLinkedList() {

    }

    /**
     * Returns the number of nodes in the BrailleLinkedList.
     *
     * @return the current size of the list.
     */
    @Override
    public int size() {

        boolean end = false;
        int count = 0;
        ListNode currentNode = head;
        while (!end) {

            if (currentNode.getNext() == null) {
                end = true;
            } else {
                currentNode = currentNode.getNext();
            }
            count++;
        }

        return count;
    }

    /**
     * Adds the specified {@code ListNode} at the beginning of the linked list.
     * The new node becomes the head of the list. If the list was empty,
     * the new node is set as both the head and tail of the list.
     *
     * @param newNode the {@code ListNode} to be added at the beginning of the list.
     *                If {@code newNode} is {@code null}, the method does nothing.
     */
    @Override
    public void addFirst(ListNode newNode) {
        if (newNode != null) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                ListNode temp = head;
                head = newNode;
                head.setNext(temp);
            }
        }
    }

    /**
     * Retrieves the first node in the linked list.
     * If the list is empty, returns {@code null}.
     *
     * @return the head of the linked list, or {@code null} if the list is empty.
     */
    @Override
    public ListNode getFirst() {
        if (head != null) return head;
        else return null;
    }

    /**
     * Removes and returns the first node in the linked list.
     * If the list is empty, returns {@code null}.
     * After removing the node, updates the head to the next node in the list.
     * If the list becomes empty after removal, the tail is also set to {@code null}.
     *
     * @return the first {@code ListNode} that was removed from the list,
     * or {@code null} if the list was empty.
     */
    @Override
    public ListNode removeFirst() {
        if (head == null) {
            return null;
        } else {
            ListNode retNode = head;
            head = head.getNext();

            if (head == null) tail = null;

            return retNode;
        }
    }

    /**
     * Adds the specified {@code ListNode} to the end of the linked list.
     * If the list is empty, the new node becomes both the head and the tail
     * of the list. Otherwise, the new node is appended after the current tail.
     *
     * @param newNode the {@code ListNode} to be added at the end of the list.
     *                If {@code newNode} is {@code null}, the method does nothing.
     */
    @Override
    public void addLast(ListNode newNode) {

        if (newNode != null) {

            if (head != null) {
                ListNode temp = tail;
                tail = newNode;
                temp.setNext(tail);
            } else {
                head = newNode;
                tail = newNode;
            }
        }

    }

    /**
     * Retrieves the last node in the linked list.
     * If the list is empty, returns {@code null}.
     *
     * @return the tail of the linked list, or {@code null} if the list is empty.
     */
    @Override
    public ListNode getLast() {
        if (tail != null) return tail;
        else return null;
    }

    /**
     * Removes and returns the last node in the linked list.
     * If the list is empty, returns {@code null}.
     * After removing the node, updates the tail to the previous node in the list.
     * If the list becomes empty after removal, both the head and tail are set to {@code null}.
     *
     * @return the last {@code ListNode} that was removed from the list,
     * or {@code null} if the list was empty.
     */
    @Override
    public ListNode removeLast() {

        if (tail == null) {
            return null;
        } else {

            ListNode curNode;
            ListNode deletedNode = tail;
            if (head == tail) return removeFirst();

            curNode = get(size() - 2);

            tail = curNode;
            tail.setNext(null);

            return deletedNode;
        }
    }

    /**
     * Retrieves the {@code ListNode} at the specified index in the linked list.
     * If the index is out of bounds, returns {@code null}.
     *
     * @param index the zero-based position of the node to retrieve.
     *              Must be greater than or equal to 0 and less than the size of the list.
     * @return the {@code ListNode} at the specified index, or {@code null} if the index is invalid.
     */
    @Override
    public ListNode get(int index) {

        if (index < 0 || index >= size()) return null;

        ListNode curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.getNext();
        }

        return curNode;
    }

    /**
     * Inserts the specified {@code ListNode} at the given index in the linked list.
     * If the index is less than or equal to 0, the new node is added at the beginning of the list.
     * If the index is greater than or equal to the current size of the list, the new node is added at the end.
     * Otherwise, the new node is inserted at the specified position.
     *
     * @param newNode the {@code ListNode} to be inserted into the list.
     * @param index   the position at which the node is to be inserted.
     *                A value less than or equal to 0 results in the node being added at the start.
     *                A value greater than or equal to the current size of the list results in the node being
     *                added at the end.
     */
    @Override
    public void insert(ListNode newNode, int index) {
        if (newNode != null) {
            if (index <= 0) addFirst(newNode);
            else if (index >= size()) addLast(newNode);
            else {
                ListNode bevNode = get(index - 1);
                ListNode aftNode = bevNode.getNext();
                bevNode.setNext(newNode);
                newNode.setNext(aftNode);
            }
        }
    }


    /**
     * Removes and returns the {@code ListNode} at the specified index in the linked list.
     * If the index is less than 0, the first node is removed and returned.
     * If the index is greater than or equal to the size of the list, the last node is removed and returned.
     * Otherwise, the node at the specified index is removed and returned.
     * After removal, updates the linked list, including the head and tail references, if necessary.
     *
     * @param index the zero-based position of the node to remove. A value less than 0 results in the first node being removed;
     *              a value greater than or equal to the size of the list results in the last node being removed.
     * @return the {@code ListNode} that was removed from the list, or {@code null} if the list was empty.
     */
    @Override
    public ListNode remove(int index) {
        if (index <= 0) return removeFirst();
        else if (index >= size()) return removeLast();
        else {
            ListNode bevNode = get(index - 1);
            ListNode deletNode = bevNode.getNext();
            ListNode aftNode = deletNode.getNext();
            bevNode.setNext(aftNode);
            return deletNode;
        }
    }

    /**
     * Clears the BrailleLinkedList by removing all nodes.
     *
     * <p>This method sets the head and tail of the list to null,
     * effectively removing all elements from the list.</p>
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    /**
     * Method is required for submission testing.
     * DO NOT EDIT.
     */
    @Override
    public ListNode debugGetHead() {
        return head;
    }

    /**
     * Method is required for submission testing.
     * DO NOT EDIT.
     */
    @Override
    public ListNode debugGetTail() {
        return tail;
    }

}

