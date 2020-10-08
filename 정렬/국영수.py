import sys

input = sys.stdin.readline

grade = []
n = int(input().rstrip())
for _ in range(n):
    name, kor, eng, math = map(str, input().rstrip().split())
    kor = int(kor)
    eng = int(eng)
    math = int(math)
    grade.append((name, kor, eng, math))

grade = sorted(grade, key=lambda x: (-x[1], x[2], -x[3], x[0]))

for i in range(n):
    print(grade[i][0])
