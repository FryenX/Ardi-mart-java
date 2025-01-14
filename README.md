# Ardi-Mart Point of Sale (POS) Application

## Overview
Ardi-Mart is a Point of Sale (POS) application designed to manage transactions, inventory, purchases, and sales efficiently. The application is built as a standalone executable (EXE) with an installer, making it easy to distribute and use. SQLite is used as the database backend, ensuring a lightweight and portable solution.

## Features
- Transaction management
- Inventory tracking
- Purchase and sales management
- User-friendly interface
- Lightweight SQLite database
- Packaged as an executable (EXE) with an installer for ease of use

## Requirements
- **Operating System**: Windows 7 or higher
- **Disk Space**: At least 100 MB of free space

## Installation
1. Download the installer file (`Ardi-Mart-Setup.exe`).
2. Double-click the installer to start the installation process.
3. Follow the on-screen instructions to complete the installation.
4. Once installed, you can launch the application from the Start Menu or desktop shortcut.

## Usage
1. Open the application.
2. Use the intuitive menu to navigate through features like transactions, inventory, purchases, and sales.
3. Data is automatically saved to the embedded SQLite database.

## Development Notes
### Creating the Executable (EXE)
- The application has been packaged into an EXE using tools like **Launch4j**.
- The EXE is further packaged into an installer using tools like **Inno Setup** for distribution.

### Database
The application uses SQLite as its database. The database file is included within the application directory and requires no additional configuration.

## Distribution
To distribute this project:
1. Provide the installer (`Ardi-Mart-Setup.exe`) to end users.
2. The installer ensures all necessary files are correctly set up on the target machine.

## Notes
- The EXE version includes all required runtime dependencies, so no additional installation of Java or other tools is required.

## Troubleshooting
### Common Issues
- **Application Fails to Launch**
  - Ensure that the installation process completed successfully and all files are present.
- **Database Connection Issues**
  - Verify that the SQLite database file exists in the application directory.

## License
This project is licensed under Fryenx.

---

For further assistance, please contact ardiwidana.gg@gmail.com.

