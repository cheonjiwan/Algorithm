from math import sqrt,ceil

def isPalindrom(num):
    num=str(num)
    if num==num[::-1]: return True
    return False

def isPrime(num):
    prime=[True]*(1003002)
    prime[0],prime[1]=False,False
    for i in range(2,1003002):
        if prime[i]:
            for j in range(i+i,1003002,i):
                prime[j]=False
    return prime

n=int(input())
prime=isPrime(n);flag=True
for num in range(n,1003002):
    if prime[num] and isPalindrom(num):
        print(num);flag=False;break
if flag: print(1003001)
