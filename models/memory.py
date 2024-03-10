class Memory:
    def __init__(self, size):
        self.size = size
        self.storage = [0] * size

    def read(self, address):
        # Add boundary checks to prevent out-of-range access
        if 0 <= address < self.size:
            return self.storage[address]
        else:
            raise ValueError("Memory read error: Address out of range.")

    def write(self, address, value):
        # Add boundary checks and potentially value format checks
        if 0 <= address < self.size:
            self.storage[address] = value
        else:
            raise ValueError("Memory write error: Address out of range.")

    # Add any additional methods needed for memory management
