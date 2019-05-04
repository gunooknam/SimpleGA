package GA;

import java.util.Random;

public class Individual {
	int fitness = 0;
	int [] genes =new int[10];
	int geneLength = 10;
	
	public Individual() {
		Random rn = new Random();
		
		//Set genes randomly for each individual 
		for(int i=0; i<genes.length ; i++) {
			genes[i] = Math.abs(rn.nextInt() % 2); //-1, 0, 1 ���� ���� => �׷��� ���밪�� �����ش�. 
		}
		// genes.length �� ����µ� 
		fitness = 0;
	}
	
	public void calcFitness() {
		
		fitness = 0;
		for(int i=0; i<geneLength; i++) {
			if(genes[i] == 1) {
				++fitness;
			}
		} 
		// fitness �� �����ϱ� �����̴�... 
		// �ٵ� ���⼭�� genes[i]���� 1�̸� fitness�� �����Ѵ�.
		
	}
}		
