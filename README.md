# basic_alignment_algorithms

========================
DESCRIPTION
========================

Simple bioinformatics algorithms of local and global alignment for didactic purpose.


========================
PURPOSE OF THIS PROJECT
========================

The objective of this project is to help students to understand how the alignment algorithms work. With this software the student can view the substitution and traceback matrixes, and the final alignment of the sequences.
Also in case of classes where the teacher ask for students to make alignment by hand, to see if the understand the algorithms, the student can use it to compare if they doing it correct, or where they are mistaken.
Last I hope that this software can be used as a example of implementation of the algorithms, for curious students in bioinformatics courses that doesn't ask to the students to implement this algorithms.

If you really want to know why I write this program refer to the "HOW THIS CAME TO BE" section in the end of this file.


========================
BUILD OUTPUT DESCRIPTION
========================

When you build an Java application project that has a main class, the IDE
automatically copies all of the JAR
files on the projects classpath to your projects dist/lib folder. The IDE
also adds each of the JAR files to the Class-Path element in the application
JAR files manifest file (MANIFEST.MF).

To run the project from the command line, go to the dist folder and
type the following:

java -jar "basic_alignment_algorithms.jar" 

or 

java -jar "basic_alignment_algorithms.jar" "ana"

To distribute this project, zip up the dist folder (including the lib folder)
and distribute the ZIP file.

Notes:

* If two JAR files on the project classpath have the same name, only the first
JAR file is copied to the lib folder.
* Only JAR files are copied to the lib folder.
If the classpath contains other types of files or folders, these files (folders)
are not copied.
* If a library on the projects classpath also has a Class-Path element
specified in the manifest,the content of the Class-Path element has to be on
the projects runtime path.
* To set a main class in a standard Java project, right-click the project node
in the Projects window and choose Properties. Then click Run and enter the
class name in the Main Class field. Alternatively, you can manually type the
class name in the manifest Main-Class element.

========================
HOW TO USE
========================

The program is very simple to use:

INPUTS:
*Fill the fields "First Sequence" and "Second Sequence" with the sequences that are desired to compare. They must be letter only. I didn't restrict it to ATCGU sequences of characters.
*Fill the fields "Match", "Mismatch" and "Gap" with the scores for a match, a mismatch and a gap, respectivily. Match must be a positive integer, Mismatch and Gap must be negative integers.
*Choose one of the two alignment options, local or global, local is the default.
*Press the "Calculate" button.

OUTPUTS:
The program will show:
*The "Score Matrix" on the left side.
*The "Traceback Matrix" in the right side.
*The two sequences alignment in the bottom.
*If there is any error it should be displayed in the box over the "Calculate" buttom.

========================
HOW THIS CAME TO BE
========================

This is how this program end up being coded.
I signed for a bioinformatics course, with the expectation that part of the classes would be coding algorithms of bioinformatics, because 25% of the course credits are practical classes. Its end up that the practical classes are to learn to use the softwares commonly used in bioinformatics.
While I was taking the course I decided to implement to myself some of the algorithms explained during the classes, to make things more fun and help me studing. I started with a very simple command line implementation in C, that fulfill my needs. But I ended up thinking that the program could be of use to other students. So I decided to rewrite it Java, because I didn't want to compile the program to every popular OS, and Java should do the trick, right? Anyway, I would also need to do a graphical interface because I imagine that many students taking classes in bioinformatics are not necessary from the computer science field, or even if they are, this doesn't mean they like the command line.
Well, this is how this program came to be. I hope in the future put also the C version, but I need to take some time to clean the code and organize it before share.
