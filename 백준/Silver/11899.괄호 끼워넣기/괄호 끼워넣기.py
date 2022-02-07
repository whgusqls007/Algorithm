import sys

lst1 = list(sys.stdin.readline().strip())
lst2 = []
while True:
    if len(lst1) == 0:
        break
    lst2.append(lst1.pop())
    while True:
        if len(lst2) == 0 or len(lst1) == 0:
            break
        if lst2[-1] == ")" and lst1[-1] == "(":
            lst1.pop()
            lst2.pop()
        else:
            break

sys.stdout.write("%d" % (len(lst2) + len(lst1)))
