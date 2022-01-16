b_num =  list(input("input a binary number:")) 
value = 0 
for i in range(len(b_num)) : 
        digit = b_num.pop() 
        if(digit == '1'): 
            value = value + pow(2,i ) 
print("the decimal value is: value", value)