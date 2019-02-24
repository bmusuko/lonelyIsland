def main():
	FOutput = open("input.txt","w")
	x = 1000000
	FOutput.write(str(x)+" "+str(x-1)+" "+"1\n")
	for i in range(x-1):
		FOutput.write(str(i+1)+" "+str(i+2)+"\n")

if __name__ == '__main__':
	main()
