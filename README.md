# Compilers-Final-Project

### Contributors
- Matthew Witvoet
- Levi Willms
- Russell Ngo

### Submission Instructions
- **Submission Deadline:** April 14, 2024
- **Submission Method:** Submit the link to the github repository of the project and link of a video demo. Include names and emails of members when submitting.
- **Google Form** Links to all material are to be submitted via: (https://forms.gle/JZpnLgfghEeXSP2j8)


# Project Setup Guide

This README provides a comprehensive guide on setting up a Jupyter Notebook environment for Kotlin with ANTLR integration. It covers everything from installing Jupyter, configuring the Kotlin kernel, adjusting the Python version, and setting up ANTLR.

## 1. Setting Up Jupyter Notebook

### Prerequisites
- Ensure Python (Python 3 is recommended) is installed on your system.
- Jupyter Notebook or JupyterLab is needed.

### Installation
If Jupyter is not already installed, it can be installed via pip:

    pip install notebook  # For Jupyter Notebook
    # or
    pip install jupyterlab  # For JupyterLab

## 2. Configuring Kotlin Kernel

### Install Kotlin Kernel
To add Kotlin as a kernel to your Jupyter setup:

    pip install kotlin-jupyter-kernel

### Verify Kernel Installation
To confirm the installation, list the installed Jupyter kernels:

    jupyter kernelspec list

### Start Jupyter
Launch Jupyter Notebook or JupyterLab using:

    jupyter notebook
    # or
    jupyter lab

## 3. Adjusting Python Version in Kernel JSON

If the default Python version needs adjustment (e.g., changing "python" to "python3"), modify the `kernel.json` file:

    {
      "argv": ["python3", "-m", "ipykernel_launcher", "-f", "{connection_file}"],
      "display_name": "Python 3",
      "language": "python"
    }

## 4. Setting Up ANTLR

### Install ANTLR
Install ANTLR using the following command, which also sets it up within the Jupyter environment:

    conda install -c conda-forge antlr-python-runtime
    # Or using pip
    pip install antlr4-python3-runtime

### Configuring ANTLR in Kotlin Notebook
Declare the ANTLR dependency in your Kotlin notebook using:

    @file:DependsOn("/usr/local/lib/antlr-4.11.1-complete.jar")

### Using ANTLR
Import ANTLR and use your generated lexer and parser:

    import org.antlr.v4.runtime.*
    import org.antlr.v4.runtime.tree.*
    // Reference your generated lexer and parser

## 5. Compile and Run ANTLR Grammar

To generate your lexer and parser from your ANTLR grammar file (e.g., `PL.g4`):

    antlr4 PL.g4 -o output_dir
    javac output_dir/*.java

Ensure the output directory containing `.class` files is in your classpath.

## Conclusion

This guide should help you configure a robust development environment in Jupyter Notebook for working with Kotlin and ANTLR. Adjust the paths and commands according to your setup and operating system specifics. If you encounter any issues, verify each step, and make sure all paths are correct and accessible.
