# Java Console Calculator

This console calculator converts the infix math expression (`3 + 5`) to postfix (`3 5 +`), 
Reverse Polish Notation (RPN), and then calculates a result of expression. 
Program checks input expression to present unacceptable symbols: alphabetic letters, 
redundant operators, unavailable functions. If necessary it throws out messages with these symbols. 

For example:
```
> Enter math expression:
> 40 ++ 10
> Incorrect Expression: ++
```

It is allowed not to use spaces between operators and operands. Available operations: `+, -, *, /`.
In this version unavailable round brackets and negative numbers.
```
> Enter math expression:
> 30 * 2.5 - 0.5 + 100
> Result: 174.5
```
