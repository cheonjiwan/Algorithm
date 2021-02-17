datas=[]
while True:
    strr=input()
    if strr=='.': break
    else: datas.append(strr)

for data in datas:
    cnt=0;flag=True;stack=[]
    for c in data:
        if c=='(' or c=='[':
            stack.append(c)
        elif c==')':
            if len(stack)==0: flag=False;print('no');break
            else: top=stack.pop()
            if top!='(': flag=False;print('no');break
        elif c==']':
            if len(stack)==0: flag=False;print('no');break
            else: top=stack.pop()
            if top!='[': flag=False;print('no');break
    if flag:
        if len(stack)==0 : print('yes')
        else: print('no')
    