package main.java.model;

import java.util.HashMap;
import java.util.Map;

public class ControlUnit {
    private int cycleCount;
    private Map<String, Integer> aluOperations;
    private int memoryReads;
    private int memoryWrites;
    private Map<String, Integer> instructionCounts;

    public ControlUnit() {
        cycleCount = 0;
        aluOperations = new HashMap<>();
        memoryReads = 0;
        memoryWrites = 0;
        instructionCounts = new HashMap<>();
    }

    // Method to increment cycle count
    public void incrementCycleCount() {
        cycleCount++;
    }

    // Method to track ALU arithmetic operations
    public void trackALUOperation(String operation) {
        aluOperations.put(operation, aluOperations.getOrDefault(operation, 0) + 1);
    }

    // Method to track memory reads
    public void trackMemoryRead() {
        memoryReads++;
    }

    // Method to track memory writes
    public void trackMemoryWrite() {
        memoryWrites++;
    }

    // Method to track individual instructions
    public void trackInstruction(String instruction) {
        instructionCounts.put(instruction, instructionCounts.getOrDefault(instruction, 0) + 1);
    }

    // Method to get statistics
    public Map<String, Integer> getStatistics() {
        Map<String, Integer> statistics = new HashMap<>();
        statistics.put("CycleCount", cycleCount);
        statistics.putAll(aluOperations);
        statistics.put("MemoryReads", memoryReads);
        statistics.put("MemoryWrites", memoryWrites);
        statistics.putAll(instructionCounts);
        return statistics;
    }
}