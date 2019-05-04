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
			genes[i] = Math.abs(rn.nextInt() % 2); //-1, 0, 1 까지 생성 => 그래서 절대값을 씌워준다. 
		}
		// genes.length 를 만드는데 
		fitness = 0;
	}
	
	public void calcFitness() {
		
		fitness = 0;
		for(int i=0; i<geneLength; i++) {
			if(genes[i] == 1) {
				++fitness;
			}
		} 
		// fitness 는 정의하기 나름이다... 
		// 근데 여기서는 genes[i]에서 1이면 fitness가 증가한다.
		
	}
}		
