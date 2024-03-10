class CpuTextView:
    def __init__(self, cpu):
        self.cpu = cpu

    def update(self):
        # Clear the screen
        print("\033[H\033[J", end="")

        print("CPU State:")
        print("==========")
        print(f"PC: {self.cpu.PC}")

        print("\nRegisters:")
        for idx, value in enumerate(self.cpu.registers):
            print(f"R{idx:02}: {value:08x}", end="\t")
            if (idx + 1) % 4 == 0:
                print()  # Newline every 4 registers for readability

        print("\nMemory:")
        for addr, value in enumerate(self.cpu.memory):
            if value != 0:  # Only display non-zero memory values
                print(f"MEM[{addr:03}]: {value:08x}")

        print("\nStatistics:")
        print(f"Total Cycles: {self.cpu.cycles}")
        print(f"ALU Operations: {self.cpu.alu_operations}")
        # Add more statistics as needed

        print("\n")  # Add extra newline for spacing
