from models.cpu import CPU
from models.alu import ALU
from models.instruction import Instruction
from views.cpu_text_view import CpuTextView
from views.cpu_gui_view import CpuGuiView
from utils import some_utility_function  # Example of how you might include utilities

def main():
    # Instantiate the components of the CPU
    cpu = CPU()
    alu = ALU()
    # Set the ALU for the CPU (assuming a composition relationship)
    cpu.set_alu(alu)

    # Choose between GUI or text view based on user input or configuration
    use_gui = input("Do you want to use the GUI view? (yes/no): ").lower() == 'yes'
    view = CpuGuiView() if use_gui else CpuTextView()

    # Attach the view to the CPU model
    cpu.add_observer(view)

    # Load the initial state or program into the CPU memory
    program_path = input("Enter the path to the machine code file: ")
    with open(program_path, 'rb') as program_file:
        program = program_file.read()
    cpu.load_program(program)

    # Example of running the simulation in full, could also implement step-by-step execution
    while not cpu.is_halted():
        cpu.execute_next_instruction()

    # Display final state
    view.display(cpu.get_state())

    # Any post-execution cleanup or reporting can go here
    print("Simulation complete. Total cycles:", cpu.get_cycle_count())

# Utility function could be used here if needed, for example:
# some_utility_function()

if __name__ == '__main__':
    main()
