/*
 * Класс пузырьковой сортировки
 * 
 * */
package MAV_Sort;

public class MAV_BSort {
	public void make_BSort(Integer[] SortArr){
		// Сортируем
		int nlen = SortArr.length;
		int nProm;
		for (int i = 0; i < nlen; i++){
			for (int j = 0; j < (nlen - 1 - i); j++){
				if (SortArr[j] > SortArr[j+1]) {
					// Меняем местами
					nProm = SortArr[j];
					SortArr[j] = SortArr[j + 1];
					SortArr[j+1] = nProm;
				}
			}
			
		}
	}
}
