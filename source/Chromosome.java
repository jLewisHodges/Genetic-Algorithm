import java.util.*;
import java.util.Random;
import java.lang.Math;

/**
 * Author: Jorden Hodges
 */
 public class Chromosome
 {
    public ArrayList<Integer> genes;
    public int fitness;

    public Chromosome()
    {
        genes = new ArrayList<Integer>();
        fitness = 0;
        calcFitness();
    }

    public Chromosome(int sizeOfChromosome)
    {
        genes = new ArrayList<Integer>();
        fitness = 0;

        Random gene = new Random();
        for(int i = 0; i < sizeOfChromosome; i++)
        {
            genes.add(gene.nextInt(2));
        }
        calcFitness();
    }

    /**
     * method addGene - adds a gene to Offspring
     * @param gene that is being added
     * @return none
     */
    public void addGene(int gene)
    {
        genes.add(gene);
        calcFitness();
    }

    /**
     * method calcFitness - calculates fitness with basic fitness function
     */
    public void calcFitness()
    {
        int sum = 0;
        for(int i = 0; i < genes.size(); i++)
        {
            if(genes.get(i) == 1)
            {
                sum = sum + (int)Math.pow(2, genes.size()-i-1); 
            }
        }
        fitness = (int)Math.pow(sum, 2); //fitness function is sum^2
    }

    /**
     * method getsize - getter method for size
     * @return size
     */
    public int getsize()
    {
        return genes.size();
    }

    /**
     * method getGenes - getter method for genes
     * @return genes list
     */
    public ArrayList<Integer> getGenes()
    {
        return genes;
    }

    /**
     * method getGeneSubList - retreives a sublist base on starting index and ending index
     * @param startingIndex
     * @param endingIndex
     * @return sub list of genes
     */
    public ArrayList<Integer> getGeneSubList (int startingIndex, int endingIndex)
    {
        ArrayList<Integer> geneSubList = new ArrayList<Integer>();
        for(int i = startingIndex; i <= endingIndex; i++)
        {
            geneSubList.add(genes.get(i));
        }
        return geneSubList;
    }

    /**
     * method toString
     * @return formatted string
     */
    @Override
    public String toString()
    {
        String s = "";
        for(int i = 0; i < genes.size(); i++)
        {
            s = s + genes.get(i);
        }
        return s;
    }
 }