def calculateSum(num):
  if num:
    
    return num + calculateSum(num-1)
  else:
    return 0

result = calculateSum(10)
print(result)