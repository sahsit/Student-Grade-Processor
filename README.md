Software Design Document: https://docs.google.com/document/d/1g6sXQ5gXFbVlI8uPxE8KPhsr6J_CoUqi

<h2>1. Introduction</h2> 

<h3>1.1	Purpose</h3>

The purpose of this document is to define the structure and architecture for a grade processing system (GPS). The system goal is defined as the process of combining two input files (one containing student IDs and student names, another containing student ID, course code and grades) into one output file containing students’ final grades sorted by student ID and course code. The project will use object-oriented principles as to follow coding standards of software development. 

<h3>1.2 Scope</h3>

This project’s main goal is to create a Java-based application that performs the following tasks heeding to the requirements stated below: 

- Read and parse two text files containing the student and course information. 

- Calculate by student ID, a student's final grade in each course using weighted components (test 1-3 at 20% each and final exam at 40%) 

- Write the results to an output file sorted by student ID, formatted as specified in Appendix A of the project requirements. 

- Incorporate at least two object-oriented design principles such as inheritance, encapsulation, abstraction, and implement error-handling practices aligned with “offensive programming” techniques. 

Requirements: 

- Two files in; one file out. 

- Must have at least two features of Object-Oriented Programming. 

- For this project; Inheritance and encapsulation. 

- Output file must be sorted using student ID. 

- Must apply “offensive programming”. 

Assumptions and Constraints: 

- Input files are in plain text format with a consistent structure. 

- Student IDs are unique. 

- For a student’s grade n, 0 ≤ n ≤ 100.
 

Definitions, Acronyms, and Abbreviations 

- GPS: Grade Processing System  

- SDD: Software Design Document  

- ID: Unique number assigned to each student

- SRP: Single Responsibility Principle 

- OOP: Object-Oriented Programming


<h2>2. Architecture design/System design </h2>

<h3>2.1 Architecture Design Model</h3>

The architectural design model illustrated by our project is component-based architecture, as it consists of varying functional components that deconstruct the overall objective. i.e. calculating a student’s final grade and formatting the output based on their student identification. 

In our GPS, the component-based model consists of varying functional components each with different functionality, each of these components are listed below: 

- User I/F Component: The main function extracts names of files from the user’s input. 

- Data Models Component: Classes Course.java, Student.java and OutputRow.java store structured data for student info, course details, and final grade outputs. 

- Project Logic Component: Represents the core orchestrator. Coordinates parsing, processing, error handling, and output generation by interacting with all major modules through interface abstractions. It contains no low-level logic. 

- Output Handlers Component: Responsible for generating the final output data and writing it to the specified file. 

- Error Handler Component: Handles all error reporting and termination. 

- Parsers Component: Responsible for reading and validating input data from the student and course files. 

- Grade Logic Component: Computes final grades based on test and exam grades and weights. 

 
<img width="442" height="325" alt="image" src="https://github.com/user-attachments/assets/409e9d7d-27fd-405e-87d8-317d4be45d7f"/>

Figure 1: Component-Based Architecture Visualized 

As seen in figure 1, each module executes a specific role and interacts with other modules through explicit method calls. Component-based architecture was implemented as its fundamental principles are to uphold modularity, clarity, and decomposition. 

<img width="516" height="348" alt="image" src="https://github.com/user-attachments/assets/a753b55f-47e2-434b-9b2f-2727e84b7004" />

Figure 2: UML Behavior Sequence Diagram














