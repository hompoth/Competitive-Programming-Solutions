import java.util.Scanner;
class grille {
	static char[][] rotate(char[][] arr){
		int n = arr.length;
		char tmp = arr[0][0];
		char[][] new_arr = new char[n][n];
		for(int i = 0; i < n; ++i)
			for(int j = 0; j < n; ++j)
				new_arr[i][j] = arr[n-j-1][i];
		new_arr[0][n-1] = tmp;
		return new_arr;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = -1, invalid = 0;
		char[][] pos_arr = new char[n][n], letter_arr = new char[n][n];
		String str = sc.next();
		for(int i = 0; i < n; ++i, str = sc.next())
			for(int j = 0; j < n; ++j)
				pos_arr[i][j] = str.charAt(j);
		for(int l = 0; l < 4; ++l, pos_arr = rotate(pos_arr))
			for(int i = 0; i < n; ++i)
				for(int j = 0; j < n; ++j)
					if(pos_arr[i][j] == '.' && ++k < n*n) letter_arr[i][j] = str.charAt(k);
		str = "";
		for(int i = 0; i < n; ++i)
			for(int j = 0; j < n; ++j)
				if(letter_arr[i][j] != 0) str+= letter_arr[i][j];
				else invalid = 1;
		if(invalid == 1 || k > n*n) System.out.println("invalid grille");
		else System.out.println(str);
	}

}
