### Encryption-Decryption (Java)

## Simple Encryption and Decryption Application

### Description

This Java application provides a simple way to encrypt and decrypt text files using either the "shift" or "unicode" algorithm. It allows users to specify various options for encryption and decryption through command-line arguments.


### Motivation

The motivation behind the Encryption-Decryption project stemmed from a desire to challenge myself and overcome the initial fear of tackling new and complex concepts such as cryptographic algorithms. The idea of implementing encryption techniques like the shift algorithm was daunting at first, but it provided an excellent opportunity to delve into the world of cryptography. By developing this project, I aimed to deepen my understanding of encryption and decryption methods, enhance my Java programming skills, and build a practical tool.

### Features

- **Encrypt and Decrypt Text**: Supports encryption and decryption of text using the shift or unicode algorithm.
- **Command-Line Interface**: Users can specify options such as mode, key, input file, output file, and algorithm through command-line arguments.
- **File I/O**: Reads from an input file and writes the encrypted or decrypted text to an output file.

### How To Run

1. Ensure you have Java installed. Run `java -version` in the terminal to check.
2. Navigate to the directory containing the source files.
3. Compile the program:
   ```bash
   javac Main.java
   ```

### Usage

To create an encrypted or decrypted file, provide the following command-line arguments:

- `-mode [dec/enc]`: Specifies whether to decrypt or encrypt.
- `-key [key]`: The key used for encryption or decryption.
- `-in [inputfile.txt]`: The input file to be decrypted (optional if using `-data`).
- `-out [outputfile.txt]`: The output file to write the encrypted or decrypted text.
- `-alg [shift/unicode]`: The algorithm type for encryption or decryption.

#### Example Commands

- **Encrypting Text**:
  ```bash
  java Main -mode enc -key 5 -data "Hello World" -out output.txt -alg shift
  ```
  or
  ```bash
  java Main -mode enc -key 5 -data "Hello World" -out output.txt -alg unicode
  ```

- **Decrypting Text**:
  ```bash
  java Main -mode dec -key 5 -in encrypted.txt -out decrypted.txt -alg shift
  ```

### Technologies Used

- Java

### Future Improvements

- **Support for More Algorithms**: Add additional encryption and decryption algorithms.
- **Graphical User Interface (GUI)**: Develop a GUI for easier interaction with the application.
- **Error Handling**: Improve error handling for invalid inputs and edge cases.

### Motivation

The motivation behind the Encryption-Decryption project is to gain a deeper understanding of cryptographic algorithms and how they can be implemented in Java. This project serves as an educational tool to explore the principles of encryption and decryption, and to apply these principles in a practical application.

### Example Commands for Running

```bash
java Main -mode enc -key 5 -data "Hello World" -out output.txt -alg shift
```
or
```bash
java Main -mode enc -key 5 -data "Hello World" -out output.txt -alg unicode
```
or
```bash
java Main -mode dec -key 5 -in encrypted.txt -out decrypted.txt -alg shift
```

### Output

The output file will be located in the project directory.

This structured README provides a comprehensive overview of the project, including features, usage instructions, and examples, similar to the format used in the provided example.
