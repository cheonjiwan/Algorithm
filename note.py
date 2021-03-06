# 2차원 배열 시계방향 90도 회전 함수
def rotate(key):
    rotated_key = []
    q = deque()

    idx = 0
    for _ in range(len(key)):
        for i in range(len(key)):
            q.appendleft(key[i][idx])
        rotated_key.append(list(q))
        idx += 1
        q.clear()

    return rotated_key


# 동빈나 90도 회전 함수
def rotate_a_matrix_by_90_degree(a):
    n = len(a)  # 행 길이 계산
    m = len(a[0])  # 열 길이 계산
    result = [[0] * n for _ in range(m)]  # 결과 리스트
    for i in range(n):
        for j in range(m):
            result[j][n - i - 1] = a[i][j]
    return result


# 2차원 배열 선언
arr = eval(("[[0]*5]+" * 10)[:-1])

# 이진탐색, 주어진 숫자 개수 찾기
from bisect import bisect_left, bisect_right


def count_by_range(a, left, right):
    right_index = bisect_right(a, right)
    left_index = bisect_left(a, left)

    return right_index - left_index


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


# 리스트 뒤에 붙이기
M = [0] + list(map(int, input().split()))

# 오름차순 정렬 출력
print(*sorted(arr))

# 파이썬 zip
name = ["a", "b"]
value = [1, 2]
for n, v in zip(name, value):
    print(n, v)

# in-line for문
print(" ".join(str(i) for i in result))

# 람다식 입력
input = __import__('sys').stdin.readline
MIS = lambda: map(int,input().split())

# 원소들의 갯수
import collections
collections.Counter('내가 알고 싶어하는 리스트')