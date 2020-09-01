import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
public class tetranacci {
	public static long[] TetraLinear(long n ) 

	{
		
		long[] a= new long[4];
		
		if (n==0|| n==1||n==2) {	
			a[0]=0;
			a[1]=0;
			a[2]=0;
			a[3]=0;
			
			return a;
		}
		else if (n==3) {
			a[0]=1;
			a[1]=0;
			a[2]=0;
			a[3]=0;
			
			
			return a;
		}
		else 
		{	
			a= TetraLinear(n-1);
			
			long sum = a[0] + a[1] + a[2] + a[3];
            a[3] = a[2];
            a[2] = a[1];
            a[1] = a[0];
            a[0] = sum;
			return a;
			
		}	
	}
	public static int TetraMultiple(int n) {

		if (n == 0 || n == 1 || n == 2)
			return 0;
		if (n == 3)
			return 1;

		return TetraMultiple(n - 4) + TetraMultiple(n - 3) + TetraMultiple(n - 2) + TetraMultiple(n - 1);

	}
	public static void main(String[] args) throws FileNotFoundException 
	{
		PrintWriter pw2;
		PrintWriter pw;
		pw2 = new PrintWriter(new FileOutputStream("Comparison.txt"));
		pw = new PrintWriter(new FileOutputStream("TetranacciOutputs.txt"));
		pw.println("Tetranacci Linear outputs Value");
		double startTime =System.nanoTime();
		for (int i=5;i<=100;i=i+5) 
		{
			
			long arr[];
			arr=TetraLinear(i);
			pw.print(arr[0]+" ");
		}
		pw.println();
		pw.println("Tetranacci Linear Time in nano seconds");
		double endTime =System.nanoTime();
		pw.print("\n"+(endTime-startTime));
		pw.println();
		pw.println("Tetranacci Multiple outputs Value");
		double startTime2 =System.nanoTime();
		pw.print(TetraMultiple(36));
		pw.println();
		pw.println("Tetranacci Multiple Time in nano seconds");
		double endTime2 =System.nanoTime();
		pw.print("\n"+(endTime2-startTime2));
		pw.close();
		pw2.println("For the linear part, it took 273200 nano seconds to go from 5 to 100. As for the multiple part, for tetranaci(36), it took 10 seconds. Over 36, the time is too big.");
		pw2.close();
	}

}
