

package MAV_Sort;

public class MAV_QSort {
	int nlen;
	Integer[] qSortArr;
	static int nCount = 0;
	

	public void make_QSort(Integer[] SortArr){
		nlen = SortArr.length;
		if (SortArr.length >= 1) {			
			qSortArr = SortArr;
			QSort(0, nlen-1);
		}
	}
	
	private void QSort(int x1, int x2){
		//  определяем рекурсивную процедуру для сортировки. Входные параметры - нижний и верхние индексф для массива
		int nPos = (x1+x2)/2;
		int nProm;
		/* Алгоритм. 
		 * Идем сдева направо и справа надева до тех пор, пока счетчики не встретяться
		 * Идем слева, как только находим элемент больший заданного - останавливаемся
		 * Идем справа, как только находиим элемент меньше заданного - останавливаемся
		 * Меняем элементы местами
		 * 
		 * Как только счетчики встретились отправляем  то что слева на рекрсию и то что справа - на рекурсию
		 * 
		 * */		
		int i = x1;
		int j = x2;
		if (x1 >=x2) return;
		nCount++;
//		System.out.println(" x1="+x1+ " x2="+x2+" nPos="+nPos+"; nPosZn="+qSortArr[nPos]+ " nCount="+nCount);
		while (j > i) {
			while ((i < nPos) && (qSortArr[i] <= qSortArr[nPos])) i++;
			while ((j > nPos) && (qSortArr[j] >= qSortArr[nPos])) j--;
			if ((j > i) && (qSortArr[i] >= qSortArr[j])) {
				// Меняем местами
				nProm = qSortArr[i];
				qSortArr[i] = qSortArr[j];
				qSortArr[j] = nProm; 
				//Если один из индексов дошел до опорного элемента, то индекс опорного элемента меняем на другой инекс (который не дошел)
				if (i == nPos) nPos = j; else if (j == nPos) nPos = i;
			}
		}
		if ((nPos-1) > x1)
			QSort(x1, nPos-1);
		if (x2 > nPos+1)
			QSort(nPos+1, x2);
	}
}
