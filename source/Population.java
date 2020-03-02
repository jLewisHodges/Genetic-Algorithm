import java.util.*;

/**
 * Author: Jorden Hodges
 */

 public class Population
 {
    public ArrayList<Chromosome>population;

    /**
     * if the population starts empty
     */
    public Population()
    {
        population =new ArrayList<Chromosome>();
    }

    /**
     * initializes random population based on parameters
     * @param sizeOfPop - desired size of the population
     * @param sizeOfChromosome - desired size of chromosomes
     */
    public Population(int sizeOfPop, int sizeOfChromosome)
    {
        population =new ArrayList<Chromosome>();
        for(int i = 0; i < sizeOfPop; i++)
        {
            population.add(new Chromosome(sizeOfChromosome));
        }
    }

    /**
     * method mutate
     * @param none
     * @return none
     */
    public void mutate()
    {

    }

    /**
     * method addChromosome manually adds chromosome
     * @param offspring
     * @return none
     */
    public void addChromosome(String chromosome)
    {
        String gene = "";
        Chromosome newChromosome = new Chromosome();
        int size = chromosome.length();
        for(int i = 0; i < size; i++)
        {
            gene = chromosome.substring(0, 1);
            chromosome = chromosome.substring(1);
            int geneNum = Integer.parseInt(gene);
            newChromosome.addGene(geneNum);
        }
        population.add(newChromosome);
    }

    /**
     * method addChromosome -overloaded adds an already made Chromosome
     * @param newChromosome
     */
    public void addChromosome(Chromosome newChromosome)
    {
        population.add(newChromosome);
    }

    /**
     * method sort - sorts the population based on fitness distance from desired solution
     * @param desiredValue - fitness of desired solution
     */
    public void sort(int desiredValue)
    {
        
        Collections.sort(population, new Comparator<Chromosome>() {
            @Override public int compare(Chromosome c1, Chromosome c2)
            {
                int difference1 = 0, difference2 = 0;
                difference1 = Math.abs(desiredValue - c1.fitness); //finds difference between desired value and fitness
                difference2 = Math.abs(desiredValue - c2.fitness);

                return difference1 - difference2; //decending ordering
            }
        });
    }
 }