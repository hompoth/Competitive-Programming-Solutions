import java.util.*;
class PotW_3 {
	public static void main(String arg[]){
		Trie t = new Trie();
		int N;
		String str;
		Scanner sc = new Scanner(System.in);
		for(N = sc.nextInt(); N-- != 0;)
			t.add(sc.next());
		t.print();
		for(N = sc.nextInt(); N-- != 0;)
			System.out.println(t.isSentence(sc.next()));
	}
}
class Trie {
	Node root;
	Trie(){ root = new Node(' '); }
	public void add(String str){
		Node current = root, tmp;
		for(int i=0; i<str.length(); ++i){
			if((tmp=current.find(str.charAt(i)))!=null) current=tmp;
			else current=current.add(str.charAt(i)); 
		}
		current.setEnd();
	}
	public int isSentence(final String inStr){ 
		Queue<Pair> q = new LinkedList<Pair>(){{add(new Pair(root, inStr));}};
		Node current;
		String str;
		Pair tmp;
		for(;q.peek()!=null;){
			tmp=q.remove();
 			current=tmp.n;
			str=tmp.s;
			if(str.compareTo("")==0) return 1;
			if((current=current.find(str.charAt(0)))==null) continue;
			str=str.substring(1);
			if(current.getEnd()) q.add(new Pair(root, str));
			q.add(new Pair(current, str));
		}
		return 0; 
	}
        public void print(){
                Queue<Pair> q = new LinkedList<Pair>(){{add(new Pair(root, ""));}};
		Pair tmp;
                while(q.peek()!=null){
			tmp=q.remove();
			for(Node n : tmp.n.getChildren()){
				q.add(new Pair(n, tmp.s+n.getChar()));
			}
			if(tmp.n.getEnd()) System.out.println(tmp.s);
                }
        }
}
class Pair {
	public String s;
	public Node n;
	Pair(Node node, String str){ n = node; s = str; }
}
class Node {
	private boolean end;
	private char c;
	private List<Node> child;
	Node(char c){ this.c = c; child = new LinkedList<Node>(); end = false; }
	public List<Node> getChildren(){ return child; }
	public Node add(char c){
		Node tmp;
		if((tmp=find(c))==null){
			tmp = new Node(c);
			child.add(tmp);
		}
		return tmp;
	}
	public void setEnd(){
		end = true;
	}
	public char getChar(){ return c; }
	public boolean getEnd(){ return end; }
	public Node find(char c){
		for(Node n : child){
			if(n.getChar() == c) return n;
		}
		return null;
	}
}
