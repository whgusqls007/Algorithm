import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()+1;
		int[] sw = new int[n];
		
		for (int i = 1; i < n; i++) {
			sw[i] = sc.nextInt();
		}
		int student = sc.nextInt();
		
		for(int j = 1; j<= student; j++) {
			int gender = sc.nextInt();
			int key = sc.nextInt();
			
			//남자라면
			if(gender == 1) {
				//key의 배수로
				for(int i = key; i<n; i+=key) sw[i]^=1;//xor(다르면 1)
			}
			//여자라면
			else if(gender == 2){
				int l = key-1;
				int r = key+1;
				
				while(true) {//대칭 찾아서
					if(l<1 || r>= n) break;
					if(sw[l] != sw[r]) break;
					l--; r++;
				}
				l++; r--;
				
				while(l<=r) {
					sw[l] ^=1;//xor
					l++;
				}
			}
		}
		//asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        //asdddddddddddddddddddd
        
		for (int i = 1; i < n; i++) {
			System.out.print(sw[i]+" ");
			if(i%20==0) System.out.println();
		}
	
	}
}