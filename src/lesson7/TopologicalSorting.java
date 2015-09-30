package lesson7;

import java.util.*;

import util.DirectedGraphNode;

public class TopologicalSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {

		Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();

		for (DirectedGraphNode n : graph) {
			if (!map.containsKey(n)) {
				map.put(n, 0);
			}
			for (DirectedGraphNode neighbor : n.neighbors) {
				if (!map.containsKey(neighbor)) {
					map.put(neighbor, 1);
				} else {
					map.put(neighbor, map.get(neighbor) + 1);
				}
			}
		}

		// if(!map.containsValue(0)){return null;}

		ArrayList<DirectedGraphNode> list = new ArrayList<DirectedGraphNode>();

		while (map.containsValue(0)) {

			for (DirectedGraphNode n : map.keySet()) {
				if (map.get(n) == 0) {
					map.put(n, Integer.MAX_VALUE);
					list.add(n);
					for (DirectedGraphNode neighbor : n.neighbors) {
						map.put(neighbor, map.get(neighbor) - 1);
					}

					// System.out.println(n.label);
					// for(DirectedGraphNode temp : map.keySet()){
					// System.out.println(temp.label + " " + map.get(temp));
					// }

				}
			}
		}

		return list;
	}

	public ArrayList<DirectedGraphNode> topSort2(ArrayList<DirectedGraphNode> graph) {

		Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();

		for (DirectedGraphNode n : graph) {
			if (!map.containsKey(n)) {
				map.put(n, 0);
			}
			for (DirectedGraphNode neighbor : n.neighbors) {
				if (!map.containsKey(neighbor)) {
					map.put(neighbor, 1);
				} else {
					map.put(neighbor, map.get(neighbor) + 1);
				}
			}
		}

		ArrayList<DirectedGraphNode> list = new ArrayList<DirectedGraphNode>();
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

		for (DirectedGraphNode n : map.keySet()) {
			if (map.get(n) == 0) {
				queue.offer(n);
			}
		}
		
		while(!queue.isEmpty()){
			DirectedGraphNode node = queue.poll();
			list.add(node);
			for (DirectedGraphNode neighbor : node.neighbors) {
				map.put(neighbor, map.get(neighbor) - 1);
				if(map.get(neighbor) == 0){
					queue.offer(neighbor);
				}
				
			}

		}

		return list;
	}

}
