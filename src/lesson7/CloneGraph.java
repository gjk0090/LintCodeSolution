package lesson7;

import java.util.*;

import util.UndirectedGraphNode;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null){return null;}
    	
    	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    	map.put(node, new UndirectedGraphNode(node.label));
    	
    	Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    	queue.offer(node);
    	
    	while(!queue.isEmpty()){
    		UndirectedGraphNode temp = queue.poll();
    		for(UndirectedGraphNode n : temp.neighbors){
    			if(!map.containsKey(n)){
    				map.put(n, new UndirectedGraphNode(n.label));
    				queue.offer(n);
    			}
    		}
    	}
    	
    	for(UndirectedGraphNode n : map.keySet()){
    		for(UndirectedGraphNode neighbor : n.neighbors){
    			map.get(n).neighbors.add(map.get(neighbor));
    		}
    	}
    	
		return map.get(node);
    }
}
