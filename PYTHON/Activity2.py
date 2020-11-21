number = int(input("Please Enter number:"))
mod = number % 2
if mod==0:
    print("number is even")
elif mod>0:
    print("number is odd")
else:
    print("number is neither even nor odd")