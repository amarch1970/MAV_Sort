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
		
		// �������������� �������
		initarray();
		// ����������� ���������� ��������
		Arrays.sort(aSort_ST);
		System.out.print("�������: ");
		for (int i = 0; i< aSort_Et.length; i++) System.out.print(aSort_B[i]+ ", ");
		System.out.println("");
		System.out.print("Quick  : ");
		for (int i = 0; i< aSort_Et.length; i++) System.out.print(aSort_Q[i]+ ", ");
		
		// ��������� ������ �� ��������
		cBSort.make_BSort(aSort_B);
		
		// ������� ���������� ����������
		System.out.println("");
		System.out.println("���������� ����������");
		System.out.print("������� ���: ");
		for (int i = 0; i< aSort_Et.length; i++) System.out.print(aSort_B[i]+ ", ");
		cQSort.make_QSort(aSort_Q);
		System.out.println("");
		System.out.print("Quick ���  : ");
		for (int i = 0; i< aSort_Et.length; i++) System.out.print(aSort_Q[i]+ ", ");
		System.out.println("");
		System.out.println("��������� �������� ���������� ��������� � ������� ����������:"+Arrays.equals(aSort_B, aSort_Q));
		System.out.println("��������� �������� ���������� ���������� � ������� ����������:"+Arrays.equals(aSort_ST, aSort_Q));

	}
	static void initarray() {
		// ������������� ������� ��������� ����� ��� ���������� ������� ���������� ����������
		Random rand = new Random(48);
		for (int i = 0; i< aSort_Et.length; i++) {
			// ��������� �������������� ������ ��� ����������
			aSort_Et[i] = rand.nextInt(10000);
			aSort_Q[i] = aSort_Et[i];
			aSort_B[i] = aSort_Et[i];
			aSort_ST[i] = aSort_Et[i];

		};
	
	}

}
