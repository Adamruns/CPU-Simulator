package main.java.view;

import java.util.Map;

public class CPUTextView {
    
    // Method to update the view with CPU state
    public void updateView(int[] registers, int[] memory, Map<String, Integer> statistics) {
        // Print CPU state: registers, memory, statistics
        printRegisters(registers);
        printMemory(memory);
        printStatistics(statistics);
    }

    private void printRegisters(int[] registers) {
        System.out.println("Registers:");
        for (int i = 0; i < registers.length; i++) {
            System.out.println("R" + i + ": " + registers[i]);
        }
        System.out.println();
    }

    private void printMemory(int[] memory) {
        System.out.println("Memory:");
        // Print memory contents (you might adjust this based on your memory layout)
        for (int i = 0; i < memory.length; i++) {
            System.out.println("0x" + Integer.toHexString(i) + ": " + memory[i]);
        }
        System.out.println();
    }

    private void printStatistics(Map<String, Integer> statistics) {
        System.out.println("Statistics:");
        // Print CPU statistics (e.g., cycle count, ALU operations, memory reads/writes)
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }
}
