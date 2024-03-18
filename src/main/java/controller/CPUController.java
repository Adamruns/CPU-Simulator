package main.java.controller;

import main.java.model.CPU;
import main.java.view.CPUTextView;


public class CPUController {
    private CPU cpu;
    private CPUTextView view;

    public CPUController(CPU cpu, CPUTextView view) {
        this.cpu = cpu;
        this.view = view;
    }

    // Method to start the CPU simulation
    public void startSimulation() {
        // Perform initialization if necessary

        // Run the entire program
        runProgram();

        // Alternatively, you can implement logic for step-by-step execution here
        // based on user input or other conditions
    }

    // Method to run the entire program
    private void runProgram() {
        // Logic to execute the entire program
        // This could involve fetching instructions from memory, executing them,
        // updating CPU state, and updating the view
        // You would typically use a loop to iterate over instructions until the program terminates
    }

    // Method to handle step-by-step execution
    private void stepExecution() {
        // Logic for executing one instruction at a time
        // This could involve fetching the next instruction from memory,
        // executing it, updating CPU state, and updating the view
        // You would typically prompt the user for input to proceed to the next step
    }

    // Method to update the view with CPU state
    private void updateView() {
        // Get CPU state (e.g., register values, memory contents) from the model
        // Update the view with the current CPU state
        view.updateView(cpu.getRegisters(), cpu.getMemory(), cpu.getStatistics());
    }
}
