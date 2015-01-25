package edu.usc.preparation;

import java.util.Stack;

public class InfixPostfixEvaluator {
	
	private static final String operators = "-+/*";
	private static final String operands = "0123456789";
	
	private int getPrecedence(char operator)
	{
		int ret = 0;
		
		if(operator == '-' || operator == '+')
			ret = 1;
		if(operator == '*' || operator == '/')
			ret = 2;
		
		return ret;
		
	}
	
	private boolean operatorPrecedence(char op1, char op2)
	{
		return getPrecedence(op1) >= getPrecedence(op2);
	}
	
	private boolean isOperator(char op)
	{
		return operators.indexOf(op) >= 0;
	}
	
	private boolean isOperand(char val)
	{
		return operands.indexOf(val) >= 0;
	}
	
	public String convert2Postfix(String infixExpression)
	{
		char[] chars = infixExpression.toCharArray();
		
		Stack<Character> stack = new Stack<Character>();
		
		StringBuilder result = new StringBuilder(infixExpression.length());
		
		for (char c : chars)
		{
			if(isOperator(c))
			{
				while(!stack.isEmpty() && stack.peek() != '(')
				{
					if(operatorPrecedence(stack.peek(), c))
					{
						result.append(stack.pop());
					}
					else
					{
						break;
					}
				}
				stack.push(c);
			}
			else if(c == '(')
			{
				stack.push(c);
			}
			else if(c == ')')
			{
				while(!stack.isEmpty() && stack.peek() != '(')
				{
					result.append(stack.pop());
				}
				if(!stack.isEmpty())
				{
					stack.pop();
				}
			}
			else if(isOperand(c))
			{
				result.append(c);
			}
		}
		
		while(!stack.isEmpty())
		{
			result.append(stack.pop());
		}
		System.out.println(result.toString());
		return result.toString();
	}
	
	public int evaluatePostfix(String postfixExpression)
	{
		char[] chars = postfixExpression.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(char c : chars)
		{
			if(isOperand(c))
				stack.push(c - '0');
			else if(isOperator(c))
			{
				int op1 = stack.pop();
				int op2 = stack.pop();
				int result;
				switch(c)
				{
					case '*':
						result = op1*op2;
						stack.push(result);
						break;
					case '/':
						result = op1/op2;
						stack.push(result);
						break;
					case '+':
						result = op1+op2;
						stack.push(result);
						break;
					case '-':
						result = op2-op1;
						stack.push(result);
						break;
				}
			}
		}
		return stack.pop();
	}
	
	public int evaluateInfixExpression(String infixExpression)
	{
		return evaluatePostfix(convert2Postfix(infixExpression));
	}
	

}
