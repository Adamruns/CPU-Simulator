.PHONY: run test clean

# Command to run the program with the default input file.
run:
	python3 main.py input_file.bin

# Command to run the unit tests.
test:
	python3 -m unittest discover -s tests

# Command to clean up Python cache files.
clean:
	find . -type f -name '*.pyc' -delete
	find . -type d -name '__pycache__' -exec rm -rf {} +

# You can add more tasks as needed for your project.
