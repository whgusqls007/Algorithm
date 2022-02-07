import sys


arr = [0 for _ in range(16)]
arr[0], Y = map(int, sys.stdin.readline().strip().split())

for i in range(1, Y + 1):
    arr[i] = int(arr[i - 1] * 1.05)
    if i > 2:
        arr[i] = max(arr[i], int(arr[i - 3] * 1.2))
    if i > 4:
        arr[i] = max(arr[i], int(arr[i - 5] * 1.35))

sys.stdout.write("%d" % arr[Y])
