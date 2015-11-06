import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
class Colour {
	int v;
	Colour(int r, int g, int b){this.v = (r<<16)|(g<<8)|b;}
	@Override
	public int hashCode(){return this.v;}
	@Override
	public boolean equals(Object o){return this.v == ((Colour) o).v;}
	public String toString(){return	((this.v>>16)&0xFF)+" "+((this.v>>8)&0xFF)+" "+(this.v&0xFF);}
}
public class PotW_8 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Colour c, max_key = new Colour(0,0,0);
		int n = sc.nextInt(), t = sc.nextInt(), val, max_value = 0;
		Map<Colour, Integer> rgb_map = new HashMap<Colour, Integer>();
		for(int i = 0; i < n; ++i){
			c = new Colour(sc.nextInt()/t, sc.nextInt()/t, sc.nextInt()/t);
			if(rgb_map.get(c)!=null) rgb_map.put(c, rgb_map.get(c)+1);
			else rgb_map.put(c, 1);
		}
		for(Entry<Colour, Integer> e : rgb_map.entrySet())
			if(e.getValue() > max_value){
				max_key = e.getKey(); 
				max_value = e.getValue();
			}
		System.out.println(max_key);
	}
}
