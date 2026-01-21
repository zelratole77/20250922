'''
# 알고리즘 연습 ..
'''
# ex1) 단어 Python의 각 철자를 한 줄에 하나씩 출력하고, // 역순으로 만들어 출력하세요   문자열 index 활용
str = 'python'
for ch in str:
    print(ch)
for idx in range(len(str)-1,-1,-1):
    print(str[idx])    
str2 = ''.join([str[idx] for idx in range(len(str)-1,-1,-1)] )
print(str2)    
# ex2) 리스트 red, green, blue, yellow 의 요소를 나는 @@색을 좋아합니다. 라고 출력하세요.
colors = ['red','green','blue','yellow']
favorMsg = [f'나는 {color}색을 좋아합니다.' for color in colors]
print(favorMsg)
# ex3) 10 55 23 80 47 에서 50보다 큰 숫자만 골라 새 리스트에 담아서 출력.
nums = [10,55,23,80,47]
new_nums = [num for num in nums if num>50]
print(new_nums)
# ex4) 사용자에게 문자을 입력받아 그 문장에 포함되 공백(' ')의 개수를 세어 출력하세요
inText = input("문자열 입력")
print(f"입력한 문자:{inText}, 공백 문자열 갯수:{inText.count(' ')}")
