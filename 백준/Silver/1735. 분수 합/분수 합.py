c, a=map(int,input().split())
d, b =map(int,input().split())

temp_a=a
temp_b=b

#최대공약수 구하기
z = a%b

while z != 0 :
    a=b
    b=z
    z=a%b
gcd =b
lcm = (temp_a*temp_b)//gcd
bottom = lcm
top = (c*(lcm//temp_a)) + (d*(lcm//temp_b))

#기약분수 만들기
temp_top = top
temp_bottom =bottom

x=top%bottom
while x !=0 :
    top=bottom
    bottom=x
    x=top%bottom
gdc1 = bottom

top = temp_top//gdc1
bottom = temp_bottom//gdc1
print(top, bottom)