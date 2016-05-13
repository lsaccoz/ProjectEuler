from itertools import permutations

print("Problem 44 - Project Euler\nAuthor: Luigi Sacco")

def hasProperty(numString):
	for i in range(len(primes)):
		if (int(numString[i+1:i+4]) % primes[i] != 0):
			return False
	return True

primes = (2,3,5,7,11,13,17)
perms = [''.join(p) for p in permutations("0123456789")]
ans = 0

for perm in perms:
	if hasProperty(perm):
		ans += int(perm)

print ("Answer: ",ans)