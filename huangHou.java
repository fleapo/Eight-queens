
public class huangHou {
	public static void main (String[] args){
		int n = 0;
		int m = 0;
		int A[][] = new int [8][8];

			nt(A,1,0);
//		}
			int aa = 1;
			aa++;
		System.out.print(java.util.Arrays.toString(A));

		
			
		
	}
	private static void nt(int[][] B,int a,int b){
		//���a�Ƿ����
		if (a == 8) nt(B,0,b+1);
		//���b�Ƿ����
		else if (b == 8) return;
		else{
			if (jianCha(B,a,b)>0){//�г�ͻ
				if (a == 7 && B[0][b] == 0 && B[1][b] == 0 && B[2][b] == 0 && B[3][b] == 0 && B[4][b] == 0 && B[5][b] == 0 && B[6][b] == 0 && B[7][b] == 0){
					int t = -1;
					for (int i = 0;i<8;i++){
						if (B[i][b-1] == 1){
							t = i;
						}
					}//������һ��˭����1
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
						B[t][b-1] = 0;//��һ��1�ĳ�0
						nt(B,t+1,b-1);//������һ��
					}
					
				}
				else nt(B,a+1,b);
			}
			else{//û�г�ͻ
				B[a][b] = 1;
				nt(B,a+1,b);
			}//��ע��������һ��
		}
	}
	private static int jianCha(int[][] B,int a,int b){
		int cout = 0;
		for(int i = 0;i<8;i++){
			if (B[i][b] == 1) cout++;
		}//�м��
		for(int i = 0;i<8;i++){
			if (B[a][i] == 1) cout++;
		}//�м��
		for(int i = 0;i+a<8 && i+b<8;i++){
			if (B[i+a][i+b] == 1) cout++;
		}//���½Ǽ��
		for(int i = 0;a-i>=0 && b-i>=0;i++){
			if (B[a-i][b-i] == 1) cout++;
		}//���ϽǼ��
		for(int i = 0;a-i>=0 && b+i<8;i++){
			if (B[a-i][b+i] == 1) cout++;
		}//���ϽǽǼ��
		for(int i = 0;a+i<8 && b-i>=0;i++){
			if (B[a+i][b-i] == 1) cout++;
		}//���½Ǽ��
		return cout;
	}

}
