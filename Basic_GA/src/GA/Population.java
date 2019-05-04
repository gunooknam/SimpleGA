package GA;

public class Population {
	int popSize = 10;
	Individual[] individuals = new Individual[10]; 
	//10���� ��ü�� ��Ҵ�.
	int fittest = 0;
	
	//Initialize population
	public void intializePopulation(int size) {
		for(int i=0 ; i< individuals.length; i++) {
			individuals[i] = new Individual(); // individual�� ���� �̰� genes[5] ���̴�. 
		}
	}
	
	public Individual getFittest() {
		int maxFit = Integer.MIN_VALUE;
		int maxFitIndex = 0;
		
		for (int i=0; i<individuals.length; i++) {
			if(maxFit <= individuals[i].fitness) {
				maxFit = individuals[i].fitness;
				maxFitIndex = i; // ���� ū fitness�� �ε����� �̴´�. 
			}
		}
		
		fittest = individuals[maxFitIndex].fitness; // �װ��� fitness�� ���� 
		return individuals[maxFitIndex];
	}
	
	public Individual getSecondFittest() {
		int maxFit1 =0;
		int maxFit2 =0;
		
		for(int i=0; i< individuals.length; i++) {
			if(individuals[i].fitness > individuals[maxFit1].fitness) {
				maxFit2= maxFit1;
				maxFit1 = i;
				
			}else if (individuals[i].fitness > individuals[maxFit2].fitness) {
				maxFit2 = i;
			}
			
		}
		
		return individuals[maxFit2];
	}
	
	public int getLeastFittnessIndex() {
		int minFitVal = Integer.MAX_VALUE;
		int minFitIndex = 0;
		for (int i =0; i<individuals.length ; i++) {
			if(minFitVal >= individuals[i].fitness) {
				minFitVal = individuals[i].fitness;
				minFitIndex = i;
			}
			
		}
		return minFitIndex;
	}
	
	public void calculateFitness() {
		for(int i=0 ; i< individuals.length; i++) {
			individuals[i].calcFitness(); // ������ individual�� fitness�� ����ؼ� �����Ѵ�. 
		}
		
		getFittest(); // ������ fittest�� �� �� �����Ѵ�. 
	}
}
