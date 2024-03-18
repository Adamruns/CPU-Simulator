package main.java.model;

public class RegisterFile {
    private int[] registers;

    public RegisterFile(int numRegisters) {
        registers = new int[numRegisters];
    }

    public int readRegister(int registerNumber) {
        return registers[registerNumber];
    }

    public void writeRegister(int registerNumber, int value) {
        registers[registerNumber] = value;
    }
}