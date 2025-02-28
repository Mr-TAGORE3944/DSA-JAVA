import pandas as pd

# Define the updated data structure with separate columns for each option
data = {
    "Question": [
        "What is the correct way to output 'Hello, World!' in Python?",
        "How do you assign a value to a variable in Python?",
        "What is the output of print(2 + 3 * 4)?",
        "Which of the following is used to take user input in Python?",
        "What is the correct way to create a comment in Python?",
        "Which data type is used to store a sequence of characters in Python?",
        "How do you create a list in Python?",
        "How do you access the first element of a list numbers = [10, 20, 30]?",
        "What will print(len('Python')) output?",
        "How do you create a function in Python?",
        "What keyword is used to exit a loop early in Python?",
        "What will print(5 // 2) output?",
        "Which keyword is used to handle exceptions in Python?",
        "What will print(type(42)) output?",
        "What is the result of bool([]) in Python?"
    ],
    "Question Type": ["MCQ"] * 15,
    "Option A": [
        "echo 'Hello, World!'", "x := 10", "20", "scanf()", "// This is a comment", "int",
        "list = {1, 2, 3}", "numbers(0)", "5", "def my_function():", "exit", "2.5", "catch", "<class 'int'>", "True"
    ],
    "Option B": [
        "print('Hello, World!')", "int x = 10;", "14", "input()", "# This is a comment", "float",
        "list = [1, 2, 3]", "numbers[1]", "6", "function my_function():", "stop", "2", "handle", "Integer", "False"
    ],
    "Option C": [
        "Console.WriteLine('Hello, World!')", "x = 10", "24", "cin >>", "/* This is a comment */", "string",
        "list = (1, 2, 3)", "numbers[0]", "7", "create my_function():", "break", "3", "try", "int", "None"
    ],
    "Option D": [
        "printf('Hello, World!')", "declare x = 10", "11", "read()", "-- This is a comment", "char",
        "list = <1, 2, 3>", "numbers.first()", "8", "define my_function():", "return", "2.0", "except", "<int>", "Error"
    ],
    "Correct Option": ["B", "C", "B", "B", "B", "C", "B", "C", "B", "A", "C", "B", "D", "A", "B"],
    "Points": [1] * 15,
    "Category": [
        "Python Basics", "Python Variables", "Python Operators", "Python Input", "Python Comments",
        "Python Data Types", "Python Lists", "Python Lists", "Python Strings", "Python Functions",
        "Python Loops", "Python Operators", "Python Exceptions", "Python Data Types", "Python Booleans"
    ],
    "Tags": ["Beginner"] * 15  # Adding a generic tag for all questions
}

# Create DataFrame
df = pd.DataFrame(data)

# Save to Excel file with correct headers
excel_path = "python_questions_final.xlsx"
df.to_excel(excel_path, index=False)

# Print the file path
print(f"Excel file saved as: {excel_path}")
