
public class huangHou {
	public static void main (String[] args){
		int n = 0;
		int m = 0;
		int A[][] = new int [8][8];

			nt(A,1,0);
			int aa = 1;
			aa++;
//		System.out.print(java.util.Arrays.toString(A));
		for (int k =0;k<8;k++){
			for (int j = 0;j<8;j++){
				System.out.print(A[k][j]);
			}
		System.out.println();
		}	

		
			
		
	}
	private static void nt(int[][] B,int a,int b){
		//检测a是否过界
		if (a == 8) nt(B,0,b+1);
		//检查b是否过界
		else if (b == 8) return;
		else{
			if (jianCha(B,a,b)>0){//有冲突
				if (a == 7 && B[0][b] == 0 && B[1][b] == 0 && B[2][b] == 0 && B[3][b] == 0 && B[4][b] == 0 && B[5][b] == 0 && B[6][b] == 0 && B[7][b] == 0){
					int t = -1;
					for (int i = 0;i<8;i++){
						if (B[i][b-1] == 1){
							t = i;
						}
					}//检测出上一列谁等于1
					if (t == 7){
						B[t][b-1] = 0;
						for (int i = 0;i<8;i++){
							if (B[i][b-2] == 1){
								t = i;
							}
						}
						B[t][b-2] = 0;
						nt(B,t+1,b-2);
					}
					else{
						B[t][b-1] = 0;//上一个1改成0
						nt(B,t+1,b-1);//继续下一个
					}
					
				}
				else nt(B,a+1,b);
			}
			else{//没有冲突
				B[a][b] = 1;
				nt(B,a+1,b);
			}//标注并进行下一个
		}
	}
	private static int jianCha(int[][] B,int a,int b){
		int cout = 0;
		for(int i = 0;i<8;i++){
			if (B[i][b] == 1) cout++;
		}//列检查
		for(int i = 0;i<8;i++){
			if (B[a][i] == 1) cout++;
		}//行检查
		for(int i = 0;i+a<8 && i+b<8;i++){
			if (B[i+a][i+b] == 1) cout++;
		}//右下角检查
		for(int i = 0;a-i>=0 && b-i>=0;i++){
			if (B[a-i][b-i] == 1) cout++;
		}//坐上角检查
		for(int i = 0;a-i>=0 && b+i<8;i++){
			if (B[a-i][b+i] == 1) cout++;
		}//右上角角检查
		for(int i = 0;a+i<8 && b-i>=0;i++){
			if (B[a+i][b-i] == 1) cout++;
		}//左下角检查
		return cout;
	}

}
