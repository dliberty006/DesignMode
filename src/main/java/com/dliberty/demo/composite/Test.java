package com.dliberty.demo.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * 树状结构 （目录和文件组成）
 * @author v_guojt
 *
 */
public class Test {

	public static void main(String[] args) {
		BranchNode b1 = new BranchNode("学科");
		BranchNode b2 = new BranchNode("数学");
		BranchNode b3 = new BranchNode("语文");
		Node l1 = new LeafNode("微积分");
		BranchNode b4 = new BranchNode("文言文");
		Node l2 = new LeafNode("兰亭集序");
		
		b1.addNode(b2);
		b1.addNode(b3);
		b2.addNode(l1);
		b3.addNode(b4);
		b4.addNode(l2);
		
		print(b1,0);
	}
	
	public static void print(Node node,int depth) {
		for (int i = 0;i < depth; i++) {
			System.out.print("--");
		}
		node.p();
		if (node instanceof BranchNode) {
			BranchNode bn = (BranchNode)node;
			for (Node n : bn.getNodes()) {
				print(n, depth + 1);
			}
		}
	}
}


abstract class Node{
	abstract void p();
}
class BranchNode extends Node {
	
	private List<Node> nodes = new ArrayList<>();
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public List<Node> getNodes() {
		return nodes;
	}
	
	private String content;

	public BranchNode(String content) {
		super();
		this.content = content;
	}

	@Override
	void p() {
		System.out.println(content);
	}
	
}

class LeafNode extends Node {
	
	private String content;

	public LeafNode(String content) {
		super();
		this.content = content;
	}

	@Override
	void p() {
		System.out.println(content);
	}
	
}