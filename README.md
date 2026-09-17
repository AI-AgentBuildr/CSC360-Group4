# ASCII Tree Generator (Java)

A Java program that reads parent-child relationships from the user and prints
them as a formatted ASCII tree — similar to the output of the Unix `tree`
command.

---

## How It Works

1. The user enters the number of relationships they want to define.
2. For each relationship, the user types a line in the format `Parent Child`.
3. The program automatically figures out the **root** node (the one name that
   never appears as a child).
4. It then prints the full tree using `├──`, `└──`, and `│` connectors to show
   the hierarchy.

---

## Sample Input

```
Enter number of relationships: 8
Enter relationships as "Parent Child":
CEO VP_Sales
CEO VP_Eng
VP_Sales Manager_1
VP_Sales Manager_2
VP_Eng Dev_1
VP_Eng Dev_2
VP_Eng Dev_3
Manager_1 Sales_Rep
```

## Sample Output

```
ASCII Tree:
CEO
├── VP_Sales
│   ├── Manager_1
│   │   └── Sales_Rep
│   └── Manager_2
└── VP_Eng
    ├── Dev_1
    ├── Dev_2
    └── Dev_3
```

**What this shows:** `CEO` is the root because it's never listed as a child.
It has two children, `VP_Sales` and `VP_Eng`. `VP_Sales` has two children of
its own (`Manager_1`, `Manager_2`), and `Manager_1` has one child
(`Sales_Rep`) — four levels deep. `VP_Eng` has three children (`Dev_1`,
`Dev_2`, `Dev_3`). The `│` character marks a branch that still has more
siblings below it; `└──` marks the last child in a group, after which the
vertical line stops.

---

## Project Structure

| File | Purpose |
|---|---|
| `TreeNode.java` | Represents a single node in the tree (a name + list of children) |
| `TreeBuilder.java` | Builds the tree from the parent-child pairs and detects the root |
| `InputHandler.java` | Reads and validates user input from the console |
| `StackFrame.java` | Wraps a node with printing context (prefix, whether it's the last child) |
| `TreeTraversal.java` | Iterative (stack-based) traversal logic that visits nodes in the right order |
| `TreePrinter.java` | Prints each node with the correct `├──` / `└──` / `│` formatting |
| `AsciiTree.java` | The `main` method — ties all the above pieces together |

---

## How to Run

```bash
javac *.java
java AsciiTree
```

Then follow the prompts: enter the number of relationships, then one
`Parent Child` pair per line.

---

## Team Contributions

| Module | Owner |
|---|---|
| Tree Construction (`TreeNode`, `TreeBuilder`) | Dev |
| Input Handling (`InputHandler`) | Krishna |
| Stack Traversal Logic (`StackFrame`, `TreeTraversal`) | Shashwat |
| Printing & Formatting (`TreePrinter`) | Dhyan |
| Integration (`AsciiTree` main) | Team (final step) |

Each module was developed on its own Git branch and merged into `main` via
pull request, in this order: Tree Construction → Input Handling → Stack
Traversal → Printing (since Printing depends on the Stack Traversal classes).
