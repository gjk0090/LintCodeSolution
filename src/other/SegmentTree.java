package other;

import util.SegmentTreeNode;

//http://www.lintcode.com/en/problem/segment-tree-build/

public class SegmentTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public SegmentTreeNode build(int start, int end) {
        if(start>end){return null;}
        if(start==end){return new SegmentTreeNode(start,end);}

        SegmentTreeNode node = new SegmentTreeNode(start,end);
        node.left = build(start,(start+end)/2);
        node.right = build((start+end)/2+1,end);
        
        return node;
    }
}
