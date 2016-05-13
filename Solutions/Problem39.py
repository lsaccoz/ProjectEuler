import time

TIME = time.time()
p = 2
max_p = 0
max_count = 0
while p <= 1000:
	count = 0
	for a in range(1, int(p/3)):
		num = p*p/2-p*a
		den = p-a
		if num % den == 0:
			count += 1
	if count > max_count:
		max_count = count
		max_p = p
	p += 2

TIME = time.time() - TIME  # seconds
print("Answer: max p =", max_p)
print("Execution time:",str(TIME)[:6],"sec")