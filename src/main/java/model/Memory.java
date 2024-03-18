package main.java.model;

public class Memory {
    private int[] memory;

    public Memory(int size) {
        memory = new int[size];
    }

    public int readMemory(int address) {
        return memory[address];
    }

    public void writeMemory(int address, int value) {
        memory[address] = value;
    }

    // get memory contents
    public int[] getMemoryContents() {
        return memory;
    }

    // read instruction at memory address (current pc)
    public int readInstruction(int address) {
        // Check if the address is within the bounds of the memory array
        if (address >= 0 && address < memory.length) {
            // Return the instruction stored at the specified address
            return memory[address];
        } 
        else {
            // address out of bounds 
            throw new IllegalArgumentException("Invalid memory address: " + address);
        }
    }
}