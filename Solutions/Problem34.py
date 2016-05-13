#       0! 1! 2! 3! 4!  5!   6!   7!    8!     9! 
fact = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880]

def match(n):
	s = str(n); sum = 0;
	for i in range(len(s)):
		sum += fact[int(s[i])]
	if sum == n:
		return True
	else:
		return False

sum = 0
for n in range(10,362880):
	if match(n):
		sum += n
print(sum)