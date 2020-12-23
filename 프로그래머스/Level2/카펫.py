from math import sqrt
def solution(brown, yellow):
    x=((brown+4)+sqrt((brown+4)**2-16*(brown+yellow)))//4
    y=(brown+yellow)//x    
    return [max(x,y),min(x,y)]
