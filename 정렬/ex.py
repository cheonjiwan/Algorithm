array = [7,5,9,0,3,1,6,2,4,8]

# sorted
result = sorted(array)

# 내장 함수 sort
array.sort()

array2 = [('바나나',2),('사과',5),('당근',3)]

def setting(data):
    return data[1]

result = sorted(array2, key = setting)
print(result)
