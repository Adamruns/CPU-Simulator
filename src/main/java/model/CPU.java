package main.java.model;

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
}
