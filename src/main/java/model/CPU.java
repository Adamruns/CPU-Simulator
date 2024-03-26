package main.java.model;

import java.util.Map;

// need support for lw, sw, addi, add, sub, and, or, slt, beq, j

public class CPU {
    private RegisterFile registerFile;
    private ALU alu;
    private Memory memory;
    private ControlUnit controlUnit;
    private int pc;

    // opcodes and funct constants
    public static final int OPCODE_R_TYPE = 0x0;
    public static final int OPCODE_ADDI = 0x8;
    public static final int OPCODE_BEQ = 0x4;
    public static final int OPCODE_J = 0x2;
    public static final int OPCODE_LW = 0x23;
    public static final int OPCODE_SW = 0x2B;

    public static final int FUNCT_ADD = 0x20;

    public CPU(int numRegisters, int memorySize) {
        registerFile = new RegisterFile(numRegisters);
        alu = new ALU();
        memory = new Memory(memorySize);
        controlUnit = new ControlUnit();
        pc = 0;
    }

    // methods for display use
    public int[] getRegisters() {
        return registerFile.getRegisters();
    }

    public int[] getMemory() {
        return memory.getMemoryContents();
    }

    public Map<String, Integer> getStatistics() {
        return controlUnit.getStatistics();
    }

    // getter method for a specific register
    public int getRegister(int index) {
        return registerFile.readRegister(index);
    }

    // setter method for a specific register
    public void setRegister(int index, int value) {
        registerFile.writeRegister(index, value);
    }

    // if
    public int fetchInstruction() {
        // Fetch the instruction at the current PC value
        int instruction = memory.readInstruction(pc);
        controlUnit.incrementCycleCount();
    
        // Return the fetched instruction for decoding and execution
        return instruction;
    }

    // id
    public void decodeInstruction(int instruction) {
        int opcode = extractOpcode(instruction);
        controlUnit.trackInstruction("" + opcode);
    
        if (opcode == OPCODE_R_TYPE) {
            int funct = extractFunctField(instruction);
            switch (funct) {
                case FUNCT_ADD:
                    executeAdd(instruction);
                    break;
                // Add cases for other R-type functions
                default:
                    // Handle undefined function code
                    System.err.println("Undefined function code for R-type instruction: " + funct);
                    break;
            }
        } else {
            // Handle non-R-type instructions
            switch (opcode) {
                case OPCODE_BEQ:
                    //executeBEQ(instruction);
                    break;
                // Add cases for other opcodes
                default:
                    // Handle undefined opcode
                    System.err.println("Undefined opcode encountered: " + opcode);
                    break;
            }
        }
    }

    // helpers for id stage, for each operation, NEED TO ADD THE OTHERS
    private void executeAdd(int instruction) {
        int rs = extractSourceRegister(instruction);
        int rt = extractTargetRegister(instruction);
        int rd = extractDestinationRegister(instruction);
        // could replace with a call to an 'add' function in alu?
        int result = getRegister(rs) + getRegister(rt);
        setRegister(rd, result);
        controlUnit.trackALUOperation("ADD");
        pc += 4; 
    }
    
    /*private void executeLw(int instruction) {
        int base = extractSourceRegister(instruction);
        int rt = extractTargetRegister(instruction);
        int offset = extractImmediate(instruction); 
        int address = getRegister(base) + offset;
        int data = memory.readMemory(address);
        setRegister(rt, data);
        controlUnit.trackALUOperation("LW");
        controlUnit.trackMemoryRead();
        pc += 4;
    }
    
    private void executeAddi(int instruction) {
        int rs = extractSourceRegister(instruction);
        int rt = extractTargetRegister(instruction);
        int immediate = extractImmediate(instruction); 
        int result = getRegister(rs) + immediate;
        setRegister(rt, result);
        controlUnit.trackALUOperation("ADDI");
        pc += 4;
    }*/

    // helper methods for extracting fields from instructions
    private int extractOpcode(int instruction) {
        return (instruction >> 26) & 0x3F; 
    }

    private int extractSourceRegister(int instruction) {
        return (instruction >> 21) & 0x1F;
    }
    
    private int extractTargetRegister(int instruction) {
        return (instruction >> 16) & 0x1F;
    }
    
    private int extractDestinationRegister(int instruction) {
        return (instruction >> 11) & 0x1F;
    }

    private int extractImmediate(int instruction) {
        int immediate = instruction & 0xFFFF;

        // if negative
        if ((immediate & 0x8000) > 0) {
            immediate |= 0xFFFF0000;
        }

        return immediate;
    }

    private int extractJumpAddress(int instruction) {
        return (instruction & 0x03FFFFFF); 
    }

    private int extractFunctField(int instruction) {
        return instruction & 0x3F; 
    }
}
