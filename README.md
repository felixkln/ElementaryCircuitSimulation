# ElementaryCircuitSimulationJava

This repository is the implementation in Java of an elementary circuit simulator.

## Step 1 : build and run ```Main.java'''

Choose the voltage source (rectangular, triangular, sine wave, Heaviside step function) and its characteristics (starting time, frequency, duty cycle, etc.).
Then, choose your ciruit by picking A, B, C or D and pick the values of the circuit's components.
![image](https://user-images.githubusercontent.com/91145041/231163550-13de30e6-f899-48db-bcb5-56c3483dbc84.png)
![image](https://user-images.githubusercontent.com/91145041/231163797-ae1c9479-8543-4661-b14c-9b069e0f0cd1.png)

The program will generate ```output.txt''' containing three columns: time stamps, source voltage, and output voltage.

## Step 2 : run ```traceSignal.m'''

From ```output.txt''', this program will display and save the graphs corresponding to the time stamps in x-axis and the voltage values in y-axis.
