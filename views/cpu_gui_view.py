import tkinter as tk

class CPUGUIView(tk.Frame):
    def __init__(self, master=None, cpu=None):
        super().__init__(master)
        self.master = master
        self.cpu = cpu
        self.pack()
        self.create_widgets()

    def create_widgets(self):
        # Display the CPU registers
        self.registers_label = tk.Label(self, text="Registers")
        self.registers_label.pack()
        
        self.registers_text = tk.Text(self, height=10, width=50)
        self.registers_text.pack()

        # Display the CPU memory
        self.memory_label = tk.Label(self, text="Memory")
        self.memory_label.pack()
        
        self.memory_text = tk.Text(self, height=10, width=50)
        self.memory_text.pack()

        # Control buttons
        self.step_button = tk.Button(self)
        self.step_button["text"] = "Step"
        self.step_button["command"] = self.step_simulation
        self.step_button.pack(side="left")

        self.run_button = tk.Button(self)
        self.run_button["text"] = "Run"
        self.run_button["command"] = self.run_simulation
        self.run_button.pack(side="left")

    def update_cpu_state(self):
        # Update the text areas with the current state of the CPU registers and memory
        self.registers_text.delete(1.0, tk.END)
        self.registers_text.insert(tk.END, str(self.cpu.registers)) # Assuming cpu.registers is a list or similar
        
        self.memory_text.delete(1.0, tk.END)
        self.memory_text.insert(tk.END, str(self.cpu.memory)) # Assuming cpu.memory is a list or similar

    def step_simulation(self):
        # Step through the simulation
        if self.cpu:
            self.cpu.step()  # Assuming CPU class has a method to step through the instruction
            self.update_cpu_state()

    def run_simulation(self):
        # Run the simulation continuously
        if self.cpu:
            self.cpu.run()  # Assuming CPU class has a method to run the simulation
            self.update_cpu_state()

# Example usage:
if __name__ == "__main__":
    root = tk.Tk()
    root.title("CPU Simulator")
    cpu = None  # You would instantiate your CPU model here
    app = CPUGUIView(master=root, cpu=cpu)
    app.mainloop()
