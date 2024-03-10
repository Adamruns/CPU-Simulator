# Import necessary modules
from .alu import ALU
from .instruction import Instruction

class CPU:
    def __init__(self):
        # Initialize your CPU state here
        self.PC = 0  # Program Counter
        self.registers = [0] * 32  # A list of 32 registers
        self.memory = []  # This will be your simulated memory
        self.alu = ALU()  # The ALU object

    def load_program(self, program):
        # Load the program into the CPU's memory
        # The program is a list of binary instructions.
        self.memory = program
        self.PC = 0  # Start execution at the beginning

    def fetch(self):
        # Fetch the instruction from memory at the current PC
        # and then increment the PC
        instruction = self.memory[self.PC]
        self.PC += 1
        return instruction

    def decode(self, instruction):
        # Decode the binary instruction into its parts
        # For simplicity, let's assume an R-type instruction format
        opcode = (instruction >> 26) & 0x3F
        rs = (instruction >> 21) & 0x1F
        rt = (instruction >> 16) & 0x1F
        rd = (instruction >> 11) & 0x1F
        shamt = (instruction >> 6) & 0x1F
        funct = instruction & 0x3F
        return opcode, rs, rt, rd, shamt, funct

    def execute(self, opcode, rs, rt, rd, shamt, funct):
        # Execute the instruction
        if opcode == 0:  # This is an R-type instruction
            if funct == 0x20:  # 'add' function code
                self.alu.add(rs, rt, rd)
            # Add more function codes as necessary
            # elif funct == ...:
            #     ...

    def run(self):
        # Run the entire program in memory
        while self.PC < len(self.memory):
            raw_instruction = self.fetch()
            opcode, rs, rt, rd, shamt, funct = self.decode(raw_instruction)
            self.execute(opcode, rs, rt, rd, shamt, funct)

    def step(self):
        # Execute a single instruction for single-stepping
        if self.PC < len(self.memory):
            raw_instruction = self.fetch()
            opcode, rs, rt, rd, shamt, funct = self.decode(raw_instruction)
            self.execute(opcode, rs, rt, rd, shamt, funct)
            return True  # Return True to indicate an instruction was executed
        return False  # Return False to indicate the end of the program
