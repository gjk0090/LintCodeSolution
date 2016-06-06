package other;

import java.util.*;

public class AmzNameList {

	public static void main(String[] args) {
		List<String> names = Arrays.asList(new String[]{"aaa","sss","bbb","fff","eee","ddd","aaa","aaa","sss","sss","aaa"});
		System.out.println(romanizeNames(names));

	}
	
	private static List<String> romanizeNames(List<String> namesInOrder){
		
		List<String> result = new ArrayList<String>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		for(int i=0; i<namesInOrder.size(); i++){
			
			if(map.containsKey(namesInOrder.get(i))){
				
				if(map.get(namesInOrder.get(i)) <= 0){
					int pos = -map.get(namesInOrder.get(i));
					map.put(namesInOrder.get(i), 2);
					result.add(namesInOrder.get(i)+"2");
					result.remove(pos);
					result.add(pos, namesInOrder.get(i)+"1");
				}else{
					map.put(namesInOrder.get(i), map.get(namesInOrder.get(i))+1);
					result.add(namesInOrder.get(i)+map.get(namesInOrder.get(i)));
				}
			}else{
				map.put(namesInOrder.get(i), -i);
				result.add(namesInOrder.get(i));
			}
		}
		
		return result;
	}

}
