class ALU:
    def __init__(self):
        # Initialize ALU state if needed
        pass

    def add(self, operand1, operand2):
        # Perform addition and return result
        return operand1 + operand2

    def sub(self, operand1, operand2):
        # Perform subtraction and return result
        return operand1 - operand2

    def and_op(self, operand1, operand2):
        # Perform bitwise AND and return result
        return operand1 & operand2

    def or_op(self, operand1, operand2):
        # Perform bitwise OR and return result
        return operand1 | operand2

    def slt(self, operand1, operand2):
        # Set on less than: if operand1 < operand2, set to 1, else 0
        return int(operand1 < operand2)

    # Add more operations as required by your simulator's instruction set
