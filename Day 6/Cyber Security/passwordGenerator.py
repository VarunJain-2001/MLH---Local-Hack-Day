import random, string

size = int(input('Digite o tamanho de senha que você deseja gerar: '))

chars = string.ascii_letters + string.digits + '!@#%&*><.,;?'

rnd = random.SystemRandom() #os.urandom

print(''.join(rnd.choice(chars) for i in range(size)))
