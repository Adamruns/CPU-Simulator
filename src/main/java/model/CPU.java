package main.java.model;

import java.util.Map;

// need support for lw, sw, addi, add, sub, and, or, slt, beq, j

public class CPU {
    private RegisterFile registerFile;
    private ALU alu;
    private Memory memory;
    private ControlUnit controlUnit;
    private int pc;

    public CPU(int numRegisters, int memorySize) {
        registerFile = new RegisterFile(numRegisters);
        alu = new ALU();
        memory = new Memory(memorySize);
        controlUnit = new ControlUnit();
        pc = 0;
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

    public int fetchInstruction() {
        // Fetch the instruction at the current PC value
        int instruction = memory.readInstruction(pc);
    
        // Return the fetched instruction for decoding and execution
        return instruction;
    }

    public int decodeInstruction() {

        // implement decode logic here, could include updating pc

        return 0;
    }

    // potential helper for decode/execute
    public void updatePCAfterInstruction(int instruction) {
        int opcode = extractOpcode(instruction);
    
        switch (opcode) {
            case 0x04: // BEQ
                pc += 4 + (extractImmediate(instruction) << 2);
                break;
            case 0x02: // J (jump)
                pc = ((pc + 4) & 0xF0000000) | (extractJumpAddress(instruction) << 2);
                break;
            default: // For most instructions
                pc += 4;
                break;
        }
    }

    // Helper methods for extracting fields from instructions
    private int extractOpcode(int instruction) {
        return (instruction >> 26) & 0x3F; 
    }

    private int extractImmediate(int instruction) {
        return (instruction & 0xFFFF); 
    }

    private int extractJumpAddress(int instruction) {
        return (instruction & 0x03FFFFFF); 
    }
}
