class Solution:
    def isPalindrome(self, s: str) -> bool:
        str = s.casefold()
        stck = []
        stck1 = []
        for element in str:
            if  48 <= ord(element) <= 57 or 97 <= ord(element) <= 122:
                stck.append(ord(element)) 
       
        mid = len(stck)
        
        if  mid%2 == 0:
            print("Inside even")
            for element in range(math.floor(mid/2)):
                stck1.append(stck.pop())

            for element in range(len(stck)):
                a = stck.pop()
                b = stck1.pop()
                if stck and a == b:
                    continue
                elif a != b:
                    return False
            
            print("stck", stck)
            print("stck1", stck1)
            while not stck and not stck1:
                return True
            return False
        
        if mid%2 != 0:
            print("Inside odd")
            for element in range(math.floor(mid/2)):
                stck1.append(stck.pop())
            if  len(stck) == 1 and not stck1:
                return True

            if stck:
                stck.pop()
            for element in range(len(stck)):
                while stck and stck.pop() == stck1.pop():
                    continue
            while not stck and not stck1:
                return True
            return False

