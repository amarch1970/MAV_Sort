package MAV_Sort;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import ru.yandex.qatools.allure.annotations.*;
import java.util.*;


@Title("Тестирование пузырьковой и быстрой сортировки")
@Description("Это общий класс")
@RunWith(Parameterized.class)
public class SortJUnitTest { 
	static final int nMax_f = 100000; // макимальное количество элементов в массиве
	static int [] aSort_Et = new int[nMax_f];
	MAV_QSort cQSort = new MAV_QSort();
	MAV_BSort cBSort = new MAV_BSort();
	public Integer[] aSort_ST;
	public Integer[] aSort_B;
	public Integer[] aSort_Q;
	public int nArrLen;
	


	public SortJUnitTest(ArrayList<Integer[]> arr_s){
		aSort_ST = arr_s.get(0);
		aSort_B = arr_s.get(1);
		aSort_Q = arr_s.get(2);
		nArrLen = aSort_Q.length; 
				
	
}
	
	@BeforeClass
	public static void initarray() {
	}


// параметры для запуска тестов - формируем массивы для сортировки 10, 100, 1000 и т.д элементов. максимальное количество задано в nMax_f 
	
	@Parameterized.Parameters
	public static List<List<Integer[]>> testArray(){
		// Структура входных параметров. Каждый тест имеет три массива на входе по определенной длине 1 - стандартная сортировка, 2- Пузырьковая 3 - быстрая
		List<List<Integer[]>> aCount = new ArrayList<List<Integer[]>>();
		Integer[] aProm_st;
		Integer[] aProm_qt;
		Integer[] aProm_bt;
		List<Integer[]> aProm_lt;

		// Инициализация датчика случайных чисел для заполнения массива случайными значениями
		Random rand = new Random(48);
		for (int i = 0; i< aSort_Et.length; i++) {
			// заполняем первоначальный массив для сортировки
			aSort_Et[i] = rand.nextInt(nMax_f);
		};
		
		//System.out.println("aSort_Et[1]="+ aSort_Et[1]);
		
		for ( int nMax= 10; nMax <= nMax_f; nMax *= 10){
			aProm_st=new Integer[nMax];
			aProm_qt=new Integer[nMax];
			aProm_bt=new Integer[nMax];
			// Заполняем массивы
			for(int i = 0; i < nMax; i++){
				aProm_st[i] = aSort_Et[i];
				aProm_bt[i] = aSort_Et[i];
				aProm_qt[i] = aSort_Et[i];
			}
			aProm_lt = new ArrayList<Integer[]>();
			aProm_lt.add(aProm_st);
			aProm_lt.add(aProm_bt);
			aProm_lt.add(aProm_qt);
			aCount.add(aProm_lt);
//			System.out.println("aProm_lt.length="+ aProm_lt.size());
		}

//		System.out.println("aCount[0]="+ aCount.get(0).get(0)[1]);
		return aCount;
	}
	

	@Title("Общий тест по сортировкам")
	@Description("Общий тест по сортировкам")
	@Test
	public void test() {
	
//		System.out.println("Начало теста  : ");
		// Инициализируем массивы
		initarray();
		// Стандартная сортировка массивов
		// Сортируем массив по Стандартной сортировке
	
		test_ST(nArrLen);
		// Сортируем массив по пузырьку
		test_B(nArrLen);
	
		// Сортируем массив по Быстрой сортировке
		test_Q(nArrLen);
	

		// Тестируем отсортированные массивы на совпадение
		test_good_B(aSort_B, aSort_ST);
		test_good_Q(aSort_Q, aSort_ST);

	}

	@Step ("Пузырьковая сортировка на {0} элементах массива")
	public void test_B(int nL){
		// Сортируем массив по пузырьку
		cBSort.make_BSort(aSort_B);
	}
	
	@Step ("Быстрая сортировка на {0} элементах массива")
	public void test_Q(int nL){
		// Сортируем массив по Быстрой сортировке
		cQSort.make_QSort(aSort_Q);
	}

	@Step ("Стандартная сортировка на {0} элементах массива")
	public void test_ST(int nL){
		// Сортируем массив по Стандартной сортировке
		Arrays.sort(aSort_ST);
	}
	@Step ("Проверка правильности пузырьковой сортировки")
	public void test_good_B(Integer[] a_B, Integer[] a_ST){
		// Сравниваем массивы
		assertTrue(Arrays.equals(a_ST, a_B));
	}
	@Step ("Проверка правильности быстрой сортировки")
	public void test_good_Q(Integer[] a_Q, Integer[] a_ST){
		// Сравниваем массивы
		assertTrue(Arrays.equals(a_ST, a_Q));
	}


}
