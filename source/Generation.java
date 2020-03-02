/**
 * Author: Jorden Hodges
 */

 import java.util.*;

 public class Generation
 {
     public Population generation;
     private ArrayList<Mate> matingPairs;

     /**
      * default constructor
      */
     public Generation()
     {
        generation = new Population();
        matingPairs = new ArrayList<Mate>();
     }

     /**
      * constructor for creating a starting generation of random values
      * @param size
      */
     public Generation(int sizeOfPop, int sizeOfChromosome)
     {
        generation = new Population(sizeOfPop, sizeOfChromosome);
        matingPairs = new ArrayList<Mate>();
     }

     /**
      * method mate picks random parents to start the mating process 
      * with helper class Mate and adds resulting children to new generation.
      * @return new Generation as a result of mating
      */
     public Generation mate()
     {
         Generation n = new Generation();
         n.addPopulation(new Population());
         Population copyGen = generation;
         Random random = new Random();
         while(copyGen.population.size() != 0)
         {
            ArrayList<Chromosome> children = new ArrayList<Chromosome>();
         
            Chromosome parent1 = copyGen.population.get(random.nextInt(copyGen.population.size())); //gets random parent
            copyGen.population.remove(parent1); //deletes parent from copy of generation because it has already been picked
            Chromosome parent2 = copyGen.population.get(random.nextInt(copyGen.population.size()));
            copyGen.population.remove(parent2);
            Mate newMate = new Mate(parent1, parent2);
            children = newMate.getChildren();
            matingPairs.add(newMate); //adds parents to list keeping track of mating pairs
            n.generation.population.add(children.get(0));
            n.generation.population.add(children.get(1));
            System.out.println(newMate.toString());
         }
         return n;
     }

     /**
      * method mutate creates a random number that picks the chromosome to mutate
      */
     public void mutate()
     {

     }

     /**
      * method addPopulation manually enters population
      * @param pop
      */
     public void addPopulation(Population pop)
     {
         generation = pop;
     }

     /**
      * method sortPopulation sorts the population in 
      * decending order of their fitnes. (puts the best Chromosome in index 0 for easy access) 
      */
     public void sortPopulation(int desiredValue)
     {
        generation.sort(desiredValue);
     }

     /**
      * method getBestChromosome gets the chromosome in index 0 after being sorted.
      * @return Chromosome in index 1;
      */
     public Chromosome getBestChromosome()
     {
         return generation.population.get(0);
     }

     /**
      * method toString overrd
      * @return formatted String
      */
 }