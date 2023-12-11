This is the *Encryption-Decryption (Java)* project.

Using this application.
1. Ensure you have java downloaded. Run java -version in the cmd/terminal.
2. Navigate to the directory containing the src files.
3. Run javac Main.java to compile.
4. To create an encrypted file provide:
   
       Start command using java Main 
-mode [dec/enc] "this is decrypt or encrypt."
-key [key] "allows if known for decryption, used to encrypt the file."
-in [inputfile.txt] "if decrypting a file."
-out [outputfile.txt] "if encrypting a file."
-alg [shift/unicode] "the algorithm encryption type, also used to decrypt by type previously used to encrypt."

    Example: java Main -mode enc -key 5 -data "Hello World" -out output.txt -alg shift 
    or 
    java Main -mode enc -key 5 -data "Hello World" -out output.txt -alg unicode

    Example Decrypt: java Main -mode dec -key 5 -in encrypted.txt -out decrypted.txt -alg shift


5. The output file will be located in the project directory.
