// Calculates a postfix equation with recursion and a perfect hash function
import java.util.Scanner;

abstract class Func {abstract int call(int a, int b);}
class A extends Func {int call(int a, int b){return a*b;}}
class B extends Func {int call(int a, int b){return a+b;}}
class C extends Func {int call(int a, int b){return a-b;}}
class D extends Func {int call(int a, int b){return a/b;}}

class PotW_11 {
	public static Func[] f= {new A(), new B(), new C(), new D()};
	public static int X(int x){
		return (x-42)-(x-42)/2;
	}
        public static int equatePostfix(String s){
                String[] ele = s.split(" ");
                return postToInfix(ele, ele.length-1).val;
        }
        public static Pair postToInfix(String[] ele, int i){
                if(ele[i].charAt(0) > 58 || ele[i].charAt(0) < 48){
                        Pair p = postToInfix(ele, i-1), p2 = postToInfix(ele,p.i-1);
                        return new Pair(f[X(ele[i].charAt(0))].call(p2.val,p.val),p2.i);
                }
                return new Pair(new Integer(ele[i]), i);
        }
        public static void main(String[] args)throws Exception{
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                sc.nextLine(); // to clear the new line character
                for(int i = 0; i < N; ++i)
                        System.out.println(equatePostfix(sc.nextLine()));
        }
}
class Pair{
        int i, val;
        Pair(int val, int i){this.val = val; this.i = i;}
}
