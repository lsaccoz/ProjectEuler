import time

def isPrime(n):
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    i = 3
    while i*i <= n:
        if n % i == 0:
            return False
        i += 2
    return True

def generatePrimes(low, high):
    primes = set()
    for i in range(low, high):
        if isPrime(i):
            primes.add(i)
    return primes

init_time = time.time()
primes = generatePrimes(2,1000000)
after_prime_time = time.time()

count = 0
for num in range(2,1000000):
    str_num = str(num)
    truth = True
    for i in range(len(str_num)):
        if (int(str_num[i:] + str_num[:i])) in primes:
            continue
        truth = False
        break
    if truth:
        count += 1

after_algorithm_time = time.time()

print("Answer: ", count)

# time it took to complete algorithm
print("Algorithm Time: ", (after_algorithm_time-after_prime_time)) # seconds
# time it took to generate prime numbers plus the algorithm
print("Total Execution Time: ", (after_algorithm_time-init_time)) # seconds