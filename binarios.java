//import java.util.Scanner;


public class binarios{//1

	public static String cadbf="";
    public static void main(String[] args) {//2    
		java.util.Scanner in = new java.util.Scanner(System.in);
		String cad="hola y";
		String cadb="";
		 
		char[] arr= cad.toCharArray();
		int [] bin=new int[8];
		int num=0;
		int ind=0,size=0;
		boolean est=false;
		double y=0;
		for(int x=0;x<=arr.length-1;x++){
			num=compbase(arr,num,x);
			//num=Integer.parseInt(in.next(arr[x]).charAt(0));
			ind=0;
			for(int i=0;i<=8-1;i++){
				if(num%2==0){
					bin[i]=0;
					ind++;
					num/=2;
				}else if(num%2==1){
					bin[i]=1;
					ind++;
					num/=2;
				}
			}
			for(int i=bin.length-1;i>=0;i--){
				cadb=cadb.concat(""+bin[i]);
				System.out.print(bin[i]);
			}
			System.out.print(" ");
			/*
			num=237;
			while(num>=y){
				y++;
				size++;
				if(Math.pow(2,y)>=num) break;
				System.out.println(y+"-"+size);
			}
			
			bin=new int[size];
			ind=0;
			for(int i=size-1;i>=0;i--){
			
				if(num>=Math.pow(2,i)){
					bin[ind]=1;
					num-=Math.pow(2,i);
				}else bin[ind]=0;
				ind++;
			}
			for(int i=0;i<=bin.length-1;i++){
				System.out.print("-"+bin[i]+"-");
			
			}
			*/
			/*
			num=237;
			while(num>=y){
				y++;
				
				size++;
				if(Math.pow(2,y)>=num) break;
				
				System.out.println(y+"-"+num);
			}
			
			
			for(int i=size;i>=0;i--){
				if(num>=Math.pow(2,i)){
					num-=Math.pow(2,i);
					cadb=cadb.concat("1");
				
				}else cadb=cadb.concat("0");
				
			}
			
			System.out.print(cadb);
			*/
			
			
		}
		
		
		char[] arrb=cadb.toCharArray();
		int j=0;
		int lim=8;
		int sum=0,cont1=7;
		for(int x=0;x<=(arrb.length-1)/8;x++){
			sum=0;
			cont1=7;
			for(int i=j;i<=lim-1;i++){
				
				if(i==0&&arrb[0]=='1') sum+=1;
				else{
					if(arrb[i]=='1'){
						sum+=Math.pow(2,cont1);
					}
				}
				cont1--;
				
				//System.out.print(arrb[i]);
			
			}
			j+=8;
			lim+=8;
			System.out.print("\n"+sum);
			
			cadbf=compbase1(sum,cadbf);
		}
		System.out.print("\n"+cadbf);
		
    }
    
    public static String compbase1(int sum,String cadbf){
		
			if(sum==32)cadbf=cadbf.concat(" ");
			if(sum==97)cadbf=cadbf.concat("a");
			if(sum==98)cadbf=cadbf.concat("b");
			if(sum==99)cadbf=cadbf.concat("c");
			if(sum==100)cadbf=cadbf.concat("d");
			if(sum==101)cadbf=cadbf.concat("e");
			if(sum==102)cadbf=cadbf.concat("f");
			if(sum==103)cadbf=cadbf.concat("g");
			if(sum==104)cadbf=cadbf.concat("h");
			if(sum==105)cadbf=cadbf.concat("i");
			if(sum==106)cadbf=cadbf.concat("j");
			if(sum==107)cadbf=cadbf.concat("k");
			if(sum==108)cadbf=cadbf.concat("l");
			if(sum==109)cadbf=cadbf.concat("m");
			if(sum==110)cadbf=cadbf.concat("n");
			if(sum==111)cadbf=cadbf.concat("o");
			if(sum==112)cadbf=cadbf.concat("p");
			if(sum==113)cadbf=cadbf.concat("q");
			if(sum==114)cadbf=cadbf.concat("r");
			if(sum==115)cadbf=cadbf.concat("s");
			if(sum==116)cadbf=cadbf.concat("t");
			if(sum==117)cadbf=cadbf.concat("u");
			if(sum==118)cadbf=cadbf.concat("v");
			if(sum==119)cadbf=cadbf.concat("w");
			if(sum==120)cadbf=cadbf.concat("x");
			if(sum==121)cadbf=cadbf.concat("y");
			if(sum==122)cadbf=cadbf.concat("z");
			
			return cadbf;
    
    }
    public static int compbase(char[] arr, int num, int x){
		if(arr[x]==' ')num=32;
			if(arr[x]=='a')num=97;
			if(arr[x]=='b')num=98;
			if(arr[x]=='c')num=99;
			if(arr[x]=='d')num=100;
			if(arr[x]=='e')num=101;
			if(arr[x]=='f')num=102;
			if(arr[x]=='g')num=103;
			if(arr[x]=='h')num=104;
			if(arr[x]=='i')num=105;
			if(arr[x]=='j')num=106;
			if(arr[x]=='k')num=107;
			if(arr[x]=='l')num=108;
			if(arr[x]=='m')num=109;
			if(arr[x]=='n')num=110;
			if(arr[x]=='o')num=111;
			if(arr[x]=='p')num=112;
			if(arr[x]=='q')num=113;
			if(arr[x]=='r')num=114;
			if(arr[x]=='s')num=115;
			if(arr[x]=='t')num=116;
			if(arr[x]=='u')num=117;
			if(arr[x]=='v')num=118;
			if(arr[x]=='w')num=119;
			if(arr[x]=='x')num=120;
			if(arr[x]=='y')num=121;
			if(arr[x]=='z')num=122;
		
		
		return num;
    }
        
}