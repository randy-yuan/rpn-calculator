# A command-line based RPN (reverse polish notation) calculator.

The following operators are supported:
*   '+'   - performs the addition on the top two items from the stack
*   '-'   - performs the subtraction on the top two items from the stack
*   '*'   - performs the multiplication on the top two items from the stack
*   '/'   - performs the division on the top two items from the stack
*   pow   - performs the pow on the top two items from the stack
*   sqrt  - performs a square root on the top item from the stack
*   '**'  - performs a square on the top item from the stack
*   exp   - E raised to the power of the top item from the stack
*   ten   - 10 raised to the power of the top item from the stack
*   pow2  - 2 raised to the power of the top item from the stack
*   ln    - performs the natural logarithm (base E) on the top item from the stack
*   log   - performs the base 10 logarithm on the top item from the stack
*   log2  - performs the base 2 logarithm on the top item from the stack
*   e     - push the E value to the stack
*   pi    - push the PI value to the stack
*   rand  - push a random number between 0 and 1.0 to the stack
*   undo  - undoes the previous operation, “undo undo” will undo the previous two operations
*   clear - removes all items from the stack
*   exit  - exit the calculator

Examples:
<pre>
1 2 +
stack: 3
2 -
stack: 1
4 *
stack: 4
3 /
stack: 1.3333333333
sqrt
stack: 1.1547005383
undo
stack: 1.3333333333
clear
stack:
undo
stack: 1.3333333333
</pre>
