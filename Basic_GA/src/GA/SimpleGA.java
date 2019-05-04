package GA;

import java.util.Random;

/*
implementation of Basic Genetic Algorithm

ref : https://towardsdatascience.com/introduction-to-genetic-algorithms-including-example-code-e396e98d8bf3

PsuedoCode
START
Generate the initial population
Compute fitness
REPEAT
	Selection
	CrossOver
	Mutatin
	Compute fitness
UNTIL population has converged
STOP

*/


public class SimpleGA {
	Population population = new Population();
	Individual fittest;
	Individual secondFittest;
	int generationCount = 0;
	
	//Selection 
	void selection() {
		
		//Select the most Fitteㄴst individual
		fittest = population.getFittest(); // 가장 fitness 높은 individual 선택
		
		//Select the second most fittest individual
		secondFittest = population.getSecondFittest();
	}
	
	// Crossover
	void crossover() {
		Random rn = new Random();
		
		//Select a random crossover point
		int crossOverPoint = rn.nextInt(population.individuals[0].geneLength);
		
		for(int i=0; i< crossOverPoint; i++) {
			int temp = fittest.genes[i];
			fittest.genes[i] = secondFittest.genes[i];
			secondFittest.genes[i] = temp;
		}
	}
	
	// Mutation 
	void mutation() {
		Random rn = new Random();
		
		int mutationPoint = rn.nextInt(population.individuals[0].geneLength);
		
		if(fittest.genes[mutationPoint] == 0 ) { // 그냥 뒤집는다. >> mutation point
			fittest.genes[mutationPoint] = 1;
		}else {
			fittest.genes[mutationPoint] = 0;
		}
		
		mutationPoint = rn.nextInt(population.individuals[0].geneLength);
		
		if (secondFittest.genes[mutationPoint] == 0) {
            secondFittest.genes[mutationPoint] = 1;
        } else {
            secondFittest.genes[mutationPoint] = 0;
        }
	}
	
	// Get fittest offspring
	Individual getFittestOffspring(){
		if(fittest.fitness > secondFittest.fitness) {
			return fittest;
		}
		return secondFittest;
	}
	
	// Replace least fittest individual from most fittest offspring
	void addFittestOffspring() {
		
		fittest.calcFitness();			// 첫번째와 두번쨰의 fittest 계산ㄷ
		secondFittest.calcFitness();
		
		int leastFittestIndex = population.getLeastFittnessIndex(); // 가장 fittest가 작은 인덱스 뽑는다. 
		
		population.individuals[leastFittestIndex] = getFittestOffspring(); ;// 가장 fittest가 작은 individaul을  fittest와 secondfittest 중 큰 것과 교환한다. 
	}
	
	public static void main(String[] args) {
		Random rn = new Random(); // 랜덤 객체를 만들고 
		
		SimpleGA demo = new SimpleGA(); 
		// Simple GA 객체를 만듬 -> population 객체를 만듬
	
		
		// Initialize population
		demo.population.intializePopulation(10); // individual 10개를 만듬
		
		// Calculate fitness of each individual
		demo.population.calculateFitness();
		
		System.out.println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest);
		
		
		while(demo.population.fittest < 9) {
			++demo.generationCount;
			
			//Do selection
			demo.selection();
			//Do crossover
			demo.crossover();
			// Do mutation under a random probability 
			if(rn.nextInt()%7 < 5) {
				demo.mutation();
			}
			//Add fittest offspring to population
			demo.addFittestOffspring();
			//Calculate new fitness value
			demo.population.calculateFitness();
			System.out.println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest);
		}
		
		System.out.println("\nSolution found in generation " + demo.generationCount);
		System.out.println("Fitness: " + demo.population.getFittest().fitness);
		System.out.println("Genes: ");
		
		for(int i=0; i< 10; i++) {
			System.out.print(demo.population.getFittest().genes[i]);
		}
		
		System.out.println("");
	}
}
