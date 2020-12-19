from math import gcd
def solution(n,m):
    a=gcd(n,m)
    b=(n*m)//a
    return [a,b]

