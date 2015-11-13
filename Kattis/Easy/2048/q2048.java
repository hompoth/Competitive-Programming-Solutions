// Took me way too long to code (remove bugs) for something I labeled Easy.
//
// Starts from the side it wants to move towards.
// 1. If current cell is 0, shift. 
// 	1.1 Afterwards, if current cell and next are the same, --j to repeat
// 2. If current cell isn't 0, check if the next one is and shift.
//	2.1 If current cell and next are the same, push together (one is 2x, other is 0)
//	Zeroes shifted away in next cell during 1.
// Loop adds ++j; start over on next row/col
import java.util.*;
class q2048 {
	public static void main(String args[]){
		int[][] arr = new int[4][4];
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 4; ++i)
			for(int j = 0; j < 4; ++j)
				arr[i][j] = sc.nextInt();
		int dir = sc.nextInt();
		for(int i = 0; i < 4; ++i){
			for(int j = 0; j < 3; ++j){
				if(dir==0&&arr[i][j]==0||dir==2&&arr[i][3-j]==0|| 
						dir==1&&arr[j][i]==0||dir==3&&arr[3-j][i]==0){
					// 1.
					for(int c=0;c<3;++c){
						if(dir==0&&arr[i][j]!=0||dir==2&&arr[i][3-j]!=0||
								dir==1&&arr[j][i]!=0||dir==3&&arr[3-j][i]!=0) break;
						for(int l = j; l < 3; ++l){
							if(dir==0){arr[i][l]=arr[i][l+1];arr[i][l+1]=0;}
							if(dir==2){arr[i][3-l]=arr[i][3-l-1];arr[i][3-l-1]=0;}
							if(dir==1){arr[l][i]=arr[l+1][i];arr[l+1][i]=0;}
							if(dir==3){arr[3-l][i]=arr[3-l-1][i];arr[3-l-1][i]=0;}
						}
					}
					// 1.1
					if(dir==0&&arr[i][j]==arr[i][j+1]&&arr[i][j]!=0||
							dir==1&&arr[j][i]==arr[j+1][i]&&arr[j][i]!=0||
							dir==2&&arr[i][3-j]==arr[i][3-j-1]&&arr[i][3-j]!=0||
							dir==3&&arr[3-j][i]==arr[3-j-1][i]&&arr[3-j][i]!=0) --j;
				}
				else {
					// 2.
					for(int c=0;c<3;++c){
						if(dir==0&&arr[i][j+1]!=0||dir==2&&arr[i][3-j-1]!=0||
								dir==1&&arr[j+1][i]!=0||dir==3&&arr[3-j-1][i]!=0) break;
						for(int l = j+1; l < 3; ++l){
							if(dir==0){arr[i][l]=arr[i][l+1];arr[i][l+1]=0;}
							if(dir==2){arr[i][3-l]=arr[i][3-l-1];arr[i][3-l-1]=0;}
							if(dir==1){arr[l][i]=arr[l+1][i];arr[l+1][i]=0;}
							if(dir==3){arr[3-l][i]=arr[3-l-1][i];arr[3-l-1][i]=0;}
						}
					}
					// 2.1
					if(dir==0&&arr[i][j]==arr[i][j+1]){arr[i][j]+=arr[i][j+1];arr[i][j+1]=0;}
					if(dir==1&&arr[j][i]==arr[j+1][i]){arr[j][i]+=arr[j+1][i];arr[j+1][i]=0;}
					if(dir==2&&arr[i][3-j]==arr[i][3-j-1]){arr[i][3-j]+=arr[i][3-j-1];arr[i][3-j-1]=0;}
					if(dir==3&&arr[3-j][i]==arr[3-j-1][i]){arr[3-j][i]+=arr[3-j-1][i];arr[3-j-1][i]=0;}
				}
			}
		}
		for(int i = 0; i < 4; ++i){
			System.out.println(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]+" "+arr[i][3]);
		}
	}
}
