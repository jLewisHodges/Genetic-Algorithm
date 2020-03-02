/**
 * Author: Jorden Hodges
 * 
 * pseudocode:
 *  
 */
import java.util.*;

 public class GeneticAlgorithm
 {
    public static ArrayList <Generation> generations = new ArrayList<Generation>();
    public static void main(String args[])
    {
        int menu = 0;
        Scanner in = new Scanner(System.in);
        int sizeOfChromosome, sizeOfPopulation;
        Chromosome perfectChromosome = new Chromosome();

        while(menu !=3)
        {
            System.out.println("Menu:\n1: run with random starting Generation\n2: Manual Entry\n3: Exit");
            menu = in.nextInt();

            switch(menu)
            {
                case 1:
                {
                    System.out.println("What are the size of the chromosomes?");
                    sizeOfChromosome = in.nextInt();
                    System.out.println("What is the size of the population?");
                    sizeOfPopulation = in.nextInt();
                    generations.add(new Generation(sizeOfPopulation, sizeOfChromosome)); //creates random new generation
                    System.out.println("What is the value you are searching for?");
                    perfectChromosome = findPerfectSolution(getFitnessSolution(in.next())); //takes desired value from user and begins searching for solution
                    if(perfectChromosome == null)
                        System.out.println("No perfect solution found");
                    break;
                }
                case 2:
                {
                    Generation newGeneration = new Generation();
                    Population newPopulation = new Population();
                    String input = "";
                    
                    while(!input.equals("q"))
                    {
                        System.out.println("enter Chromosomes one at a time seperated by enter Ex. 10100 (q to quit)");
                        input = in.next();
                        if(!input.equals("q"))
                        {
                            newPopulation.addChromosome(input);
                        }
                    }
                    newGeneration.addPopulation(newPopulation);
                    generations.add(newGeneration);
                    System.out.println("What is the value you are searching for?");
                    perfectChromosome = findPerfectSolution(getFitnessSolution(in.next()));
                    if(perfectChromosome == null)
                        System.out.println("No perfect solution found");
                    break;
                }
            }
        }
        in.close();
    }

    /**
     * method keeps mating until the perfect solution is found
     * @param desiredFitness - the resultint Chromosome wanted
     * @return perfect Chromosome
     */
    public static Chromosome findPerfectSolution(int desiredFitness)
    {
        boolean done = false;
        int generationCount = 1; //starts at 1 because there is already an initial generation
        while(!done)
        {
            Generation currentGeneration = generations.get(generations.size()-1); //gets the last added generation which is the current
            currentGeneration.sortPopulation(desiredFitness);
            if(desiredFitness == currentGeneration.getBestChromosome().fitness) //checks for desired chromosome
            {
                return currentGeneration.getBestChromosome();
            }
            else
            {
                generations.add(currentGeneration.mate());
                generationCount++;
                System.out.println(generationCount);
            }
        }
        return null; //Note: should never be executed but if no perfect solution is found then returns null
    }

    /**
     * finds the fitness of the desired Chromosome base on the fitness function 
     * @param desiredResult - string representation of desired result
     * @return numeric fitness
     */
    public static int getFitnessSolution(String desiredResult)
    {
        Population temp = new Population();
        temp.addChromosome(desiredResult);
        return temp.population.get(0).fitness;
    }
 }