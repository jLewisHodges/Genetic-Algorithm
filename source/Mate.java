import java.util.ArrayList;
import java.util.Random;

/**
 * @author Jorden Hodges
 */

 public class Mate
 {
     private Chromosome parent1, parent2, child1, child2;
     int crossoverPoint;

     public Mate()
     {
         parent1 = new Chromosome();
         parent2 = new Chromosome();
         child1 = new Chromosome();
         child2 = new Chromosome();
         crossoverPoint = 0;
     }

     public Mate(Chromosome parent1, Chromosome parent2)
     {
         this.parent1 = parent1;
         this.parent2 = parent2;
         child1 = new Chromosome();
         child2 = new Chromosome();
         crossoverPoint = 0;
         mate(); //automatically mates as soon as the parents are chosen
     }

     /**
      * method getChildren
      * @return list of children
      */
     public ArrayList<Chromosome> getChildren()
     {
         ArrayList<Chromosome> children = new ArrayList<Chromosome>();
         children.add(child1);
         children.add(child2);

         return children;
     }

     /**
      * method mate - facilitates mating of the two parents
      */
     private void mate()
     {
        ArrayList<Integer> child1Genes = new ArrayList<Integer>();
        ArrayList<Integer> child2Genes = new ArrayList<Integer>();
        findCrossoverPoint();

        ArrayList<Integer> p1Sub1 = parent1.getGeneSubList(0, crossoverPoint); //gets subarray to be crossed at crossover point
        ArrayList<Integer> p1Sub2 = parent1.getGeneSubList(crossoverPoint + 1, parent1.getsize() - 1);
        ArrayList<Integer> p2Sub1 = parent2.getGeneSubList(0, crossoverPoint);
        ArrayList<Integer> p2Sub2 = parent2.getGeneSubList(crossoverPoint + 1, parent1.getsize() - 1);

        child1Genes.addAll(p1Sub1); //appends subarrays to create new childrens genes
        child1Genes.addAll(p2Sub2);
        child2Genes.addAll(p2Sub1);
        child2Genes.addAll(p1Sub2);

        child1.genes = child1Genes; 
        child1.calcFitness();
        child2.genes = child2Genes;
        child2.calcFitness();
     }

     /**
      * method findCrossoverPoint - finds crossover point based on chromosome size
      */
     private void findCrossoverPoint()
     {
        Random random = new Random();
        crossoverPoint = random.nextInt(parent1.getsize());
     }

     /**
      * method toString -overriden 
      * @return formatted string
      */
     public String toString()
     {
        return String.format("%s mated with %s at crossover point %d\nWhich resulted in %s and %s as children", parent1.toString(), parent2.toString(), crossoverPoint, child1.toString(), child2.toString());
     }
 }