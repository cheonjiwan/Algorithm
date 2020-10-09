import sys
from bisect import bisect_left, bisect_right

input = sys.stdin.readline

n, x = map(int, input().rstrip().split())
data = list(map(int, input().rstrip().split()))


def count_by_range(a, left, right):
    right_index = bisect_right(a, right)
    left_index = bisect_left(a, left)

    return right_index - left_index


result = count_by_range(data, x, x)
print(result if result != 0 else -1)
