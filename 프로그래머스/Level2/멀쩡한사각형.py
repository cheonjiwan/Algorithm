from math import gcd
def solution(w,h):
    if w>h: w,h=h,w
    return w*h-(h+w-gcd(w,h))

w,h=8,12
solution(w,h)