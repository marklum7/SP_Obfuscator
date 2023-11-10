import java.util.Scanner;

public class Main {

 public static void main(String[] args) {
 Scanner in = new Scanner(System.in);

 int N = in.nextInt();
 int[] sortArr = new int[N];

 for (int i = 0; i < sortArr.length; i++) {
 sortArr[i] = in.nextInt();
 }
 comdsort(sortArr);
 for(int i=0;i<sortArr.length;i++){

 System.out.println(sortArr[i]);

 }
 }
 public static void comdsort(int[] values){
 double factor = 1.247;
 int step = values.length-1;
 while (step>=1) {
 for (int i = 0; i + step < values.length; i++) {
 if (values[i]>values[i+step])
 swap(values, i, i + step);
 }
 step /= factor;
 }
 }


 static void swap(int[] sortArr,int i, int j){
 int temp =sortArr[i];

 sortArr[i]=sortArr[j];

 sortArr[j]=temp;
 }
}
