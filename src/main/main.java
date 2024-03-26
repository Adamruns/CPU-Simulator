package main;

import main.java.model.CPU;
import main.java.view.CPUTextView;
import main.java.controller.CPUController;

public class main {
    public static void main(String[] args) {
        // Initialize components
        int numRegisters = 16;
        int memorySize = 1024; // Example size, adjust as needed
        CPU cpu = new CPU(numRegisters, memorySize);
        CPUTextView view = new CPUTextView();
        CPUController controller = new CPUController(cpu, view);

        // Start the simulation
        controller.startSimulation();

        // Optionally, after the simulation has run, display final statistics or state
        System.out.println("Simulation complete.");
        // You can call methods here to print out the state of the CPU, memory, or any statistics gathered
    }
}
