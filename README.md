# Java Console Calculator

This console calculator uses Reverse Polish Notation (RPN) for convert infix math expression (`3 + 5`) to postfix (`3 5 +`)
and then calculate a result of expression. Programm checks input expression to presence unacceptable symbols: 
alphabetics letters, redundant operators, unavailable functions. If necessary it throws out message with this symbols.
For example:
```
> 40 ++ 10
> Incorrect Expression: ++
```

It is allowed not to use spaces between operators and operands. Available operations: +, -, *, /.
In this version unavailable round brackets and negative numbers.
```
> 30 * 2.5 - 0.5 + 100
> Result: 174.5
```
