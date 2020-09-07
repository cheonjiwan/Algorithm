from collections import deque

moveMap = []
row = deque([1, 2, 3])
moveMap.append(list(row))
row = deque([1, 2, 3])
moveMap.append(list(row))

row = deque([0 for _ range(5)])