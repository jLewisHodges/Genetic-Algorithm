# Genetic-Algorithm
A simple genetic algorithm that can either randomly generate a starting population or take manual input. The algorithm then searches for desired solution. (Binary values only at the momment)

Background:
Genetic Algorithms are powerful algorithms that have the ability to solve complex programs in a relatively simple manner. A genetic Algorithm works similarly to how human genetics work where you have a population that holds many people or in a genetic algorithms case chromosomes. Chromosomes are then made up of genes which are either on or off(1 or 0) in this programs case. Above populations you have generations which hold one and only one population per generation. See the UML Diagram for a visual representation of this concept. In each generation random mating pairs will be chosen to mate to create new children. In this example program each parent is chosen to be mated with another random parent and is then removed from consideration. Thus the population per generation will be the same throughout execution. Each individual mating pair will be mated at a certaint crossover point at which two "halves" of each parent chromosome is made in accordance with the crossover point. Then the first sub chromosme of one parent is combined with the second sub chromosome of the other parent and vise versa which is called a crossover or recombination.

# How to Run

# Windows
For running the file on windows, you should be able to just click the run.bat file in the Windows folder. If this does not work for some reason, open command prompt. Copy the path to the root Genetic Algorithm Directory and type cd filepath. If done correctly you should be inside the root folder. Then type java -jar GeneticAlgorithm.jar (this command can be found in the run.bat file).

# Mac OS
1. Due to Mac OS' many security features and to avoid having to make a dmg file, the shell script for mac will not work natively. To get it working you need to right click on it and hover over open with and click more options. In the finder window that opens search Terminal, then in the drop down menu with the option Recommended Option select All Aplications. Check the Always Open With Box.
2. If 1 does not work, open terminal navigate in finder to the root folder. Type cd and copy the macOS folder over and then press return. This will make your working directory the macOS folder. Then type chmod +x run.sh and hit return. Then type ./run.sh.
