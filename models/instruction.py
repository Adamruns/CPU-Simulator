class Instruction:
    def __init__(self, instruction_code):
        self.instruction_code = instruction_code
        self.opcode = (instruction_code & 0xFC000000) >> 26
        self.rs = (instruction_code & 0x03E00000) >> 21
        self.rt = (instruction_code & 0x001F0000) >> 16
        self.rd = (instruction_code & 0x0000F800) >> 11
        self.shamt = (instruction_code & 0x000007C0) >> 6
        self.funct = instruction_code & 0x0000003F
        self.immediate = instruction_code & 0x0000FFFF
        self.address = instruction_code & 0x03FFFFFF

    def decode(self):
        # Depending on the opcode, decode the instruction differently
        if self.opcode == 0x00:  # This would be an R-type instruction
            return self._decode_r_type()
        elif self.opcode in [0x02, 0x03]:  # This could be J-type instructions like 'j' and 'jal'
            return self._decode_j_type()
        else:  # Otherwise, it's I-type
            return self._decode_i_type()

    def _decode_r_type(self):
        # Decode R-type instruction specifics
        # Here you would set properties specific to R-type instructions if needed
        pass

    def _decode_i_type(self):
        # Decode I-type instruction specifics
        # Here you would set properties specific to I-type instructions if needed
        pass

    def _decode_j_type(self):
        # Decode J-type instruction specifics
        # Here you would set properties specific to J-type instructions if needed
        pass

    def execute(self, alu, registers, memory):
        # Execute the instruction using the ALU, registers, and memory
        # This might involve calling methods on the ALU, or reading/writing registers or memory
        pass
