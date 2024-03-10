from models.cpu import CPU
from models.memory import Memory
from utils.file_loader import FileLoader
from views.cpu_text_view import CPUTextView
# from views.cpu_gui_view import CPUGUIView  # Uncomment if GUI view is implemented

class CPUController:
    def __init__(self, filepath):
        self.cpu = CPU()
        self.memory = Memory()
        self.view = CPUTextView()  # or CPUGUIView() for the GUI
        self.filepath = filepath
        self.instruction_set = self._load_instructions()

    def _load_instructions(self):
        loader = FileLoader(self.filepath)
        return loader.load()

    def run(self):
        # Load instructions into CPU memory
        for address, instruction in enumerate(self.instruction_set):
            self.memory.write(address, instruction)

        # Main execution loop
        while not self.cpu.halted:
            instruction = self.memory.read(self.cpu.pc)
            self.cpu.execute(instruction)
            self.cpu.pc += 1  # Move to the next instruction

            # Update the view with the new CPU state
            self.view.update(self.cpu)

    def step(self):
        # Execute a single instruction
        instruction = self.memory.read(self.cpu.pc)
        self.cpu.execute(instruction)
        self.cpu.pc += 1  # Move to the next instruction

        # Update the view with the new CPU state
        self.view.update(self.cpu)

    # You can add more methods to handle user input for stepping or running
    # the program, and for other control-related tasks

# This part could be in your main.py file
if __name__ == '__main__':
    filepath = 'path_to_instruction_file.bin'
    controller = CPUController(filepath)
    controller.run()
    # or, to step through each instruction:
    # while not controller.cpu.halted:
    #     controller.step()
    #     input("Press Enter to execute the next instruction...")
