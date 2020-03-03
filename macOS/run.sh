#!/usr/bin/env bash
SCRIPTPATH=$(dirname "$0")
cd "$SCRIPTPATH"
cd ..
ls
java -jar GeneticAlgorithm.jar
