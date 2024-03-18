package main.java.model;

import java.util.Map;

public class CPU {
    private RegisterFile registerFile;
    private ALU alu;
    private Memory memory;
    private ControlUnit controlUnit;

    public CPU(int numRegisters, int memorySize) {
        registerFile = new RegisterFile(numRegisters);
        alu = new ALU();
        memory = new Memory(memorySize);
        controlUnit = new ControlUnit();
    }

    // Methods for CPU operations...
    public int[] getRegisters() {
        return registerFile.getRegisters();
    }

    public int[] getMemory() {
        return memory.getMemoryContents();
    }

    public Map<String, Integer> getStatistics() {
        return controlUnit.getStatistics();
    }
}
