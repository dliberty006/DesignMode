package com.dliberty.demo.iterator;

import java.util.Arrays;

/**
 * iterator遍历，迭代
 * 
 * @author v_guojt
 *
 */
public class Test {

	public static void main(String[] args) {
		List_<Integer> list = new LinkedList_<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
			// System.out.println(list.size());
		}

//		for (int i = 0; i < 10; i++) {
//			Integer item = list.get(i);
//			System.out.println(item);
//		}
		Iterator_<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
}

interface List_<E> {

	int size();

	boolean add(E t);

	E get(int index);
	
	Iterator_<E> iterator();
}

/**
 * 模拟ArrayList
 * 
 * @author v_guojt
 *
 * @param <E>
 */
@SuppressWarnings("unchecked")
class ArrayList_<E> implements List_<E> {

	private Object[] elementData = new Object[10];

	private int size;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(E t) {
		ensureCapacityInternal(size + 1);
		elementData[size++] = t;
		return true;
	}

	private void ensureCapacityInternal(int minCapacity) {
		if (minCapacity == elementData.length) {
			elementData = Arrays.copyOf(elementData, minCapacity * 2);
		}
	}

	@Override
	public E get(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		return (E) elementData[index];
	}

	@Override
	public Iterator_<E> iterator() {
		return new ArrayListIterator<E>();
	}
	
	private class ArrayListIterator<E> implements Iterator_<E> {
		
		int cursor;

		@Override
		public boolean hasNext() {
			return cursor < size;
		}

		@Override
		public E next() {
			E t = (E)elementData[cursor];
			cursor++;
			return t;
		}
		
	}

	

}

class LinkedList_<E> implements List_<E> {

	private int size;

	private Node<E> first;

	private Node<E> last;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(E t) {
		final Node<E> l = last;
		final Node<E> newNode = new Node<>(l, t, null);
		last = newNode;
		if (l == null)
			first = newNode;
		else
			l.next = newNode;
		size++;
		return true;
	}

	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}

	/**
	 * 判断index < (size/2) 正序遍历 反之反序遍历
	 * 
	 * @param index
	 * @return
	 */
	private Node<E> node(int index) {
		if (index < (size >> 1)) {
			Node<E> x = first;
			for (int i = 0; i < index; i++)
				x = x.next;
			return x;
		} else {
			Node<E> x = last;
			for (int i = size - 1; i > index; i--)
				x = x.prev;
			return x;
		}
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		return node(index).item;
	}

	@Override
	public Iterator_<E> iterator() {
		return new LinkedListIterator<E>();
	}
	
	private class LinkedListIterator<E> implements Iterator_<E> {
		
		int cursor;

		@Override
		public boolean hasNext() {
			return cursor < size;
		}

		@Override
		public E next() {
			E e = (E) get(cursor);
			cursor++;
			return e;
		}
		
	}

}

interface Iterator_<E> {
	
	boolean hasNext();
	
	E next();
}
