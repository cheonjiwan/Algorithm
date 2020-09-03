n,k = map(int,input().split())
arr1 = list(map(int,input().split()))
arr2 = list(map(int,input().split()))

arr1 = sorted(arr1)
arr2 = sorted(arr2,reverse= True)

for i in range(k):
    if arr1[i]<arr2[i]:
        arr1[i],arr2[i] = arr2[i],arr1[i]
    else:
        break

print(sum(arr1))

