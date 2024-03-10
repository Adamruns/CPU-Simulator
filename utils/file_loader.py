class FileLoader:
    def __init__(self, filepath):
        self.filepath = filepath

    def load(self):
        instructions = []
        try:
            with open(self.filepath, 'rb') as file:
                byte = file.read(4)  # Assuming each instruction is 4 bytes (32 bits)
                while byte:
                    instruction = int.from_bytes(byte, byteorder='big')  # or 'little' based on your architecture
                    instructions.append(instruction)
                    byte = file.read(4)
        except FileNotFoundError:
            print(f"The file {self.filepath} does not exist.")
        except Exception as e:
            print(f"An error occurred while reading the file: {e}")

        return instructions
