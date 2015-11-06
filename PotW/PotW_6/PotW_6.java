import java.util.*;
import java.util.Map.Entry;;
class Pair {
	HashSet<String> set;
	boolean checked;
	String event;
	Pair(String e) {event = e; set = new HashSet<String>(); checked = false;}
	void add(String s) {set.add(s);}
}
class PotW_6 {
	public static String order (HashMap<String, Pair> map, HashSet<String> roots){
		Queue<Pair> q = new LinkedList<Pair>();
		List<String> list = new LinkedList<String>();
		String str = "";
		while(!roots.isEmpty()){
			String s1 = roots.iterator().next();
			Pair p = map.get(s1);
			roots.remove(s1);
			q.add(p);
			while(q.peek()!=null){
				p = q.remove();
				if(p.checked == true){
					//if(!list.remove(p.event)) System.out.println("Wat");
					list.add(p.event);
				}
				else {
					list.add(p.event);
					p.checked = true;
					for(String s : p.set){
						p = map.get(s);
						q.add(p);
					}
				}
			}
		}
		for(String s : list){
			str+=s+" ";
		}
		return str;
	}
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String s1, s2;
		HashMap<String, Pair> g = new HashMap<String, Pair>();
		HashSet<String> roots = new HashSet<String>();
		Pair p;
		for(int i = 0; i < N; ++i){
			s1 = sc.next();
			s2 = sc.next();
			if(g.containsKey(s1)) g.get(s1).add(s2);
			else {
				roots.add(s1);
				p = new Pair(s1);
				p.add(s2);
				g.put(s1, p);
			}
			if(!g.containsKey(s2)) {
				p = new Pair(s2);
				g.put(s2, p);
			}
			roots.remove(s2);
		}
		System.out.println(order(g, roots));
	}
}
