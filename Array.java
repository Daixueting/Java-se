import java.util.Arrays;
//用Array.sort(函数名);----是对数组升序的排序
//用System.arraycopy(源，开始位置，目的数组，开始位置，复制个数)
//Aarry.copyOf(源数组名称，copy个数【只能从头0开始】)；
//【对数组的使用，一定要注意，不要下标越界！！！！！！！！！！！！】
public class Array {
	public static void main(String[] args){
		int[] arr=new int[]{1,3,5,7};
		int[] arr1=new int[]{8,6,4,2};
		Arrays.sort(arr1);
		for(int temp:arr1){
			System.out.print(temp+"\t");
		}
		System.out.println();
		System.arraycopy(arr,1,arr1,1,3);
		for(int temp:arr1){
			System.out.print(temp+"\t");
		}
		System.out.println();
		int[] arr2=Arrays.copyOf(arr,3);
		for(int temp:arr2){
			System.out.print(temp+"\t");
		}
		
}
}