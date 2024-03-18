package model;

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
}