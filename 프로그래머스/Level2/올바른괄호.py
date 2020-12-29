def solution(s):
    stack=[]
    for c in s:
        if c=='(': stack.append(c)
        else:
            try: stack.pop()
            except: return False
    if len(stack)==0: return True
    else: return False