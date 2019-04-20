# A command-line based RPN (reverse polish notation) calculator.

The following operators are supported:
*   '+'   - performs the addition on the top two items from the context
*   '-'   - performs the subtraction on the top two items from the context
*   '*'   - performs the multiplication on the top two items from the context
*   '/'   - performs the division on the top two items from the context
*   sqrt  - performs a square root on the top item from the context
*   undo  - undoes the previous operation, “undo undo” will undo the previous two operations
*   clear - removes all items from the context
*   exit  - exit the calculator

Examples:
<pre>
1 2 +
context: 3
2 -
context: 1
4 *
context: 4
3 /
context: 1.3333333333
sqrt
context: 1.1547005383
undo
context: 1.3333333333
clear
context:
undo
context: 1.3333333333
</pre>
