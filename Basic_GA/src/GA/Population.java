package GA;

public class Population {
	int popSize = 10;
	Individual[] individuals = new Individual[10]; 
	//10개의 개체를 잡았다.
	int fittest = 0;
	
	//Initialize population
	public void intializePopulation(int size) {
		for(int i=0 ; i< individuals.length; i++) {
			individuals[i] = new Individual(); // individual을 만듬 이건 genes[5] 씩이다. 
		}
	}
	
	public Individual getFittest() {
		int maxFit = Integer.MIN_VALUE;
		int maxFitIndex = 0;
		
		for (int i=0; i<individuals.length; i++) {
			if(maxFit <= individuals[i].fitness) {
				maxFit = individuals[i].fitness;
				maxFitIndex = i; // 가장 큰 fitness의 인덱스를 뽑는다. 
			}
		}
		
		fittest = individuals[maxFitIndex].fitness; // 그것의 fitness를 리턴 
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
			individuals[i].calcFitness(); // 각각의 individual의 fitness를 계산해서 저장한다. 
		}
		
		getFittest(); // 최적의 fittest를 값 을 저장한다. 
	}
}
