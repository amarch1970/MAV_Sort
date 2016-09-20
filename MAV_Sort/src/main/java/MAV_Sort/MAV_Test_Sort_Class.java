package MAV_Sort;
import java.util.*;



public class MAV_Test_Sort_Class {
	static final int nMax = 10;
	static Integer [] aSort_Et = new Integer[nMax];
	static Integer [] aSort_B = new Integer[nMax];
	static Integer [] aSort_Q = new Integer[nMax];
	static Integer [] aSort_ST = new Integer[nMax];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MAV_QSort cQSort = new MAV_QSort();
		MAV_BSort cBSort = new MAV_BSort();
		
		// Инициализируем массивы
		initarray();
		// Стандартная сортировка массивов
		Arrays.sort(aSort_ST);
		System.out.print("Пузырек: ");
		for (int i = 0; i< aSort_Et.length; i++) System.out.print(aSort_B[i]+ ", ");
		System.out.println("");
		System.out.print("Quick  : ");
		for (int i = 0; i< aSort_Et.length; i++) System.out.print(aSort_Q[i]+ ", ");
		
		// Сортируем массив по пузырьку
		cBSort.make_BSort(aSort_B);
		
		// Выводим результаты сортировки
		System.out.println("");
		System.out.println("Результаты сортировки");
		System.out.print("Пузырек рез: ");
		for (int i = 0; i< aSort_Et.length; i++) System.out.print(aSort_B[i]+ ", ");
		cQSort.make_QSort(aSort_Q);
		System.out.println("");
		System.out.print("Quick рез  : ");
		for (int i = 0; i< aSort_Et.length; i++) System.out.print(aSort_Q[i]+ ", ");
		System.out.println("");
		System.out.println("Равенство массивов сортировки пузырьком и быстрой сортировки:"+Arrays.equals(aSort_B, aSort_Q));
		System.out.println("Равенство массивов стандарной сортировки и быстрой сортировки:"+Arrays.equals(aSort_ST, aSort_Q));

	}
	static void initarray() {
		// Инициализация датчика случайных чисел для заполнения массива случайными значениями
		Random rand = new Random(48);
		for (int i = 0; i< aSort_Et.length; i++) {
			// заполняем первоначальный массив для сортировки
			aSort_Et[i] = rand.nextInt(10000);
			aSort_Q[i] = aSort_Et[i];
			aSort_B[i] = aSort_Et[i];
			aSort_ST[i] = aSort_Et[i];

		};
	
	}

}
