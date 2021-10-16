import bitcoin
#Using Vitalik Buterin's pybitcointools library to make a valid bitcoin keypair

while True:
	#Generate Random Private Key
	#The private key is simply a randomly generated number between 1 and 2^256
	valid_private_key = False
	while not valid_private_key:
		private_key = bitcoin.random_key()
		decoded_private_key = bitcoin.decode_privkey(private_key, 'hex')
		valid_private_key = 0 < decoded_private_key < bitcoin.N
	
	print"Private Key (hex) is: ", private_key
	print("\n")
	print"Private Key (decimal) is: ", decoded_private_key
	
	
	#Multiply the Elliptical Curve generator point G with the private key to get a public key point.
	#Bitcoin uses Elliptical curve multiplication algorith to go from the private key to a public key.
	#EC algorithm is used because it is fast, secure, and one way
	
	
	public_key = bitcoin.fast_multiply(bitcoin.G, decoded_private_key)
	print("\n")
	print "Public key (x,y) coordinates is:", public_key
	
	#Compress public key to proper format
	#Adjust prefix depending on wheteher y is even or odd
	
	(public_key_x, public_key_y) = public_key
	if (public_key_y % 2) == 0:
		compressed_prefix = '02'
	else:
		compressed_prefix = '03'
	hex_compressed_public_key = compressed_prefix + bitcoin.encode(public_key_x, 16)
	print("\n")
	print "Compressed Public Key (hex) is:", hex_compressed_public_key
	
	#Generate bitcoin address from public key
	print("\n")
	print "Bitcoin Address is:", bitcoin.pubkey_to_address(public_key)
	
	#Generate compressed bitcoin address from compressed public key
	#Compressed addresses have been added to reduce transaction size
	#Both compressed and uncompressed addresses can be generated from the same private key
	print("\n")
	print "Compressed Bitcoin Address is:", \
		bitcoin.pubkey_to_address(hex_compressed_public_key)
	
	print("\n\n")	
	user_input = raw_input("Would you like to generate another bitcoin key pair? y/n")
	if user_input == 'n':
		break

	
