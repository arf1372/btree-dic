/** In The Name of Allah
 * 
 */
package ds;

import java.io.Serializable;

import ds.BTreeNode;

/**
 * @author arf1372
 * 
 */
public class BTree<T extends Comparable<? super T>> implements Serializable {
	private BTreeNode<T> root = null;
	private int degree;

	public BTree() {
		this(12);
	}

	public BTree(int n) {
		this.degree = n;
		this.root = new BTreeNode<T>(n);
	}

	public BTreeNode<T> getRoot() {
		return this.root;
	}

	public void add(T data) {
		BTreeNode<T> curr = findNode(data);
		curr.add(data);
		restructure(curr);
	}

	private BTreeNode<T> findNode(T data) {
		BTreeNode<T> curr = this.root;
		while (!curr.isLeaf())
			curr = curr.childs.get(curr.findPos(data));
		return curr;
	}

	public T find(T data) {
		BTreeNode<T> now = findHelper(data);
		return ((now == null) ? (null) : (now.data.get(now.findPos(data))));
	}

	// FIXME buggy findhelper func
	private BTreeNode<T> findHelper(T data) {
		System.err.println("IN FIND HELPER:");
		BTreeNode<T> curr = this.root;
		System.err.println("CURR:" + curr.data.size());
		for (int idx = curr.findPos(data)/* indexOf(data) */; (idx == curr.data
				.size() || curr.data.get(idx).compareTo(data) != 0)
				&& curr != null; curr = curr.childs.get(curr.findPos(data))) {
			System.err.println("IDX IS: " + idx);
		}
		return curr;
	}

	private void restructure(BTreeNode<T> node) {
		// System.err.println("RESTRUCTURE:");
		// System.err.println("SIZE IS:" + node.data.size());
		// System.err.println("DEGREE IS: " + degree);
		// System.err.println();
		if (!(node.data.size() < this.degree)) {
			reStructure(node);
			restructure(node.parent);
		}
	}

	private void reStructure(BTreeNode<T> node) {
		// System.err.println("RESTRUCTUREHELPER:");
		// System.err.println("SIZE IS:" + node.data.size());
		// System.err.println("DEGREE IS: " + degree);
		// System.err.println();
		T midean = node.getMidean();
		BTreeNode<T> newNode = node.split();
		if (node == root) {
			BTreeNode<T> newRoot = new BTreeNode<T>(degree);
			newRoot.add(midean);
			newRoot.childs.add(node);
			newRoot.childs.get(0).parent = newRoot;
			newRoot.childs.add(newNode);
			newRoot.childs.get(1).parent = newRoot;
			this.root = newRoot;
		} else {
			int i = node.parent.add(midean);
			node.parent.childs.add(i + 1, newNode);
			newNode.parent = node.parent;
		}
	}

}
