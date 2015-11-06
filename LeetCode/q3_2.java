// 128 ms solution
public class Solution {
        String insertC(String s, char c){
                int min = 0, max = s.length()-1, mid=0;
                if(s.length() < 1) return s+c;
                if(s.charAt(0) > c) return c+s;
                while(min<=max){
                        mid = min+(max-min)/2;
                        if(s.charAt(mid)<c) min = mid+1;
                        else if(s.charAt(mid)>c) max = mid-1;
                        else return "bbb";
                }
                if(s.charAt(max)<c) ++max;
                //return s.substring(0,max)+c+s.substring(max);
                return new StringBuilder(s).insert(max, c).toString();//faster
        }
        public int lengthOfLongestSubstring(String s) {
                String tmp="";
                int start = 0, cursize = 0, max = 0;
                for(int i = 0; i < s.length(); ++i){
                        tmp=insertC(tmp, s.charAt(i));
                        if(tmp.compareTo("bbb")==0){
                                for(int j = start; j < i; ++j){
                                        if(s.charAt(j)==s.charAt(i)){
                                                start=j+1;
                                                char[] chars = s.substring(j,i).toCharArray();
                                                Arrays.sort(chars);
                                                tmp = new String(chars);
                                                max=Math.max(max, cursize);
                                                cursize=i-j;
						break;
                                        }
                                }
                        }
                        else ++cursize;
                }
                max=Math.max(max, cursize);
                return max;
        }
}
