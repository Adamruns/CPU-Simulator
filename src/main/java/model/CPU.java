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

    public int fetchNextInstruction() {
        // NEED TO IMPLEMENT readInstruction within memory class
        int instruction = memory.readInstruction(pc);

        // Determine the type of instruction and calculate the size 
        switch (extractOpcode(instruction)) {
            case 0x04:
                // BEQ instruction: PC += 4 + SignExt18b({imm, 00})
                pc += 4 + (extractImmediate(instruction) << 2); 
                break;

            case 0x02:
                // J (jump) instruction: PC ← {(PC + 4)[31:28], address, 00}
                pc = ((pc + 4) & 0xF0000000) | (extractJumpAddress(instruction) << 2);
                break;
            
            default:
                // Default: PC += 4 
                pc += 4;
                break;
        }

        return instruction;
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
