

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
		//  ���������� ����������� ��������� ��� ����������. ������� ��������� - ������ � ������� ������� ��� �������
		int nPos = (x1+x2)/2;
		int nProm;
		/* ��������. 
		 * ���� ����� ������� � ������ ������ �� ��� ���, ���� �������� �� �����������
		 * ���� �����, ��� ������ ������� ������� ������� ��������� - ���������������
		 * ���� ������, ��� ������ �������� ������� ������ ��������� - ���������������
		 * ������ �������� �������
		 * 
		 * ��� ������ �������� ����������� ����������  �� ��� ����� �� ������� � �� ��� ������ - �� ��������
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
				// ������ �������
				nProm = qSortArr[i];
				qSortArr[i] = qSortArr[j];
				qSortArr[j] = nProm; 
				//���� ���� �� �������� ����� �� �������� ��������, �� ������ �������� �������� ������ �� ������ ����� (������� �� �����)
				if (i == nPos) nPos = j; else if (j == nPos) nPos = i;
			}
		}
		if ((nPos-1) > x1)
			QSort(x1, nPos-1);
		if (x2 > nPos+1)
			QSort(nPos+1, x2);
	}
}
