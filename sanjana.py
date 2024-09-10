import tkinter as tk
from tkinter import messagebox, scrolledtext

# Create the main application window
root = tk.Tk()
root.title("Vaccine Registration")
root.geometry("500x600")
root.configure(bg="#f0f8ff")

# Center the window on the screen
root.update_idletasks()
width = root.winfo_width()
height = root.winfo_height()
x = (root.winfo_screenwidth() // 2) - (width // 2)
y = (root.winfo_screenheight() // 2) - (height // 2)
root.geometry('{}x{}+{}+{}'.format(width, height, x, y))

# List to store the registration data
registrations = []

# Function to handle the registration
def register():
    name = name_entry.get()
    age = age_entry.get()
    gender = gender_var.get()
    phone = phone_entry.get()
    email = email_entry.get()
    address = address_entry.get("1.0", tk.END).strip()
    vaccine_type = vaccine_var.get()

    # Validation checks
    if not name or not age or not gender or not phone or not email or not address or not vaccine_type:
        messagebox.showwarning("Input Error", "All fields are required!")
        return
    if not age.isdigit() or int(age) < 1:
        messagebox.showwarning("Input Error", "Please enter a valid age.")
        return
    if not phone.isdigit() or len(phone) != 10:
        messagebox.showwarning("Input Error", "Please enter a valid 10-digit phone number.")
        return
    if "@" not in email or "." not in email.split("@")[-1]:
        messagebox.showwarning("Input Error", "Please enter a valid email address.")
        return

    # Store the data in a dictionary and add it to the list
    registration_data = {
        'Name': name,
        'Age': int(age),
        'Gender': gender,
        'Phone': phone,
        'Email': email,
        'Address': address,
        'Vaccine Type': vaccine_type
    }
    registrations.append(registration_data)

    # Confirmation message
    messagebox.showinfo("Registration Success", f"Thank you {name}, you have been registered for {vaccine_type}!")

    # Clear the form
    name_entry.delete(0, tk.END)
    age_entry.delete(0, tk.END)
    phone_entry.delete(0, tk.END)
    email_entry.delete(0, tk.END)
    address_entry.delete("1.0", tk.END)
    gender_var.set("Select")
    vaccine_var.set("Select")

# Function to view all registrations in a new window
def view_registrations():
    if not registrations:
        messagebox.showinfo("No Registrations", "No one has registered yet.")
        return

    # Create a new window to display registrations
    view_window = tk.Toplevel(root)
    view_window.title("Registered People")
    view_window.geometry("500x400")
    view_window.configure(bg="#f0f8ff")

    reg_info = ""
    for idx, reg in enumerate(registrations, start=1):
        reg_info += f"{idx}. Name: {reg['Name']}, Age: {reg['Age']}, Gender: {reg['Gender']}\n"
        reg_info += f"   Phone: {reg['Phone']}, Email: {reg['Email']}\n"
        reg_info += f"   Address: {reg['Address']}\n"
        reg_info += f"   Vaccine Type: {reg['Vaccine Type']}\n\n"

    # ScrolledText widget for viewing registrations
    reg_text = scrolledtext.ScrolledText(view_window, wrap=tk.WORD, width=60, height=20)
    reg_text.insert(tk.END, reg_info)
    reg_text.configure(state="disabled")
    reg_text.pack(pady=10)

# Create the title label
title_label = tk.Label(root, text="Vaccine Registration Form", font=("Arial", 20, "bold"), bg="#f0f8ff", fg="#4682b4")
title_label.grid(row=0, column=0, columnspan=2, pady=20)

# Labels and Entry widgets
tk.Label(root, text="Name:", bg="#f0f8ff").grid(row=1, column=0, pady=5, padx=10, sticky="e")
name_entry = tk.Entry(root)
name_entry.grid(row=1, column=1, pady=5, padx=10)

tk.Label(root, text="Age:", bg="#f0f8ff").grid(row=2, column=0, pady=5, padx=10, sticky="e")
age_entry = tk.Entry(root)
age_entry.grid(row=2, column=1, pady=5, padx=10)

tk.Label(root, text="Gender:", bg="#f0f8ff").grid(row=3, column=0, pady=5, padx=10, sticky="e")
gender_var = tk.StringVar(value="Select")
gender_menu = tk.OptionMenu(root, gender_var, "Male", "Female", "Other")
gender_menu.grid(row=3, column=1, pady=5, padx=10)

tk.Label(root, text="Phone:", bg="#f0f8ff").grid(row=4, column=0, pady=5, padx=10, sticky="e")
phone_entry = tk.Entry(root)
phone_entry.grid(row=4, column=1, pady=5, padx=10)

tk.Label(root, text="Email:", bg="#f0f8ff").grid(row=5, column=0, pady=5, padx=10, sticky="e")
email_entry = tk.Entry(root)
email_entry.grid(row=5, column=1, pady=5, padx=10)

tk.Label(root, text="Address:", bg="#f0f8ff").grid(row=6, column=0, pady=5, padx=10, sticky="ne")
address_entry = tk.Text(root, height=4, width=23)
address_entry.grid(row=6, column=1, pady=5, padx=10)

tk.Label(root, text="Vaccine Type:", bg="#f0f8ff").grid(row=7, column=0, pady=5, padx=10, sticky="e")
vaccine_var = tk.StringVar(value="Select")
vaccine_menu = tk.OptionMenu(root, vaccine_var, "Pfizer", "Moderna", "AstraZeneca", "Johnson & Johnson")
vaccine_menu.grid(row=7, column=1, pady=5, padx=10)

# Register and View buttons
register_button = tk.Button(root, text="Register", command=register, bg="#4682b4", fg="white", font=("Arial", 10, "bold"))
register_button.grid(row=8, column=0, pady=10, padx=10)

view_button = tk.Button(root, text="View Registrations", command=view_registrations, bg="#4682b4", fg="white", font=("Arial", 10, "bold"))
view_button.grid(row=8, column=1, pady=10, padx=10)

# Run the application
root.mainloop()
