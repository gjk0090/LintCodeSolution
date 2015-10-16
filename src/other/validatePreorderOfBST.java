package other;

public class validatePreorderOfBST {

	public static void main(String[] args) {
		System.out.println(check(new int[]{1,2,3}));
		System.out.println(check(new int[]{2,1,3}));
		System.out.println(check(new int[]{3,2,1,5,4,6}));
		System.out.println(check(new int[]{1,3,4,2}));
		System.out.println(check(new int[]{3,4,5,1,2}));
	}
	public static boolean check(int[] nodes) {
	    return check(nodes, 0, nodes.length, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean check(int[] nodes, int start, int end, int min, int 
	max) {
	    if (start >= end) return true;
	    int root = nodes[start];
	    if (root <= min || max <= root)
	        return false;
	    int i = start + 1;
	    while (i < end && nodes[i] < root)
	        i++;
	    return check(nodes, start+1, i, min, root) &&
	           check(nodes, i, end, root, max);
	}
}
