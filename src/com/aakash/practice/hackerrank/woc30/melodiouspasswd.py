#!/usr/bin/python
#
# __author__: Aakash Nagar (anagar@walmartlabs.com)
# __date__  : 16/03/17
#!/bin/python

import sys

varr=  ["a","e","i","o","u"]
carr= ["b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w", "x","z"]

def printpasswd(n, s, vowel):
    if n == 0:
        print s
    else :
        if vowel:
            for c in varr:
                printpasswd(n-1, s + c, False)
        else:
            for c in carr:
                printpasswd(n-1, s + c, True)


if __name__ == '__main__':
    n = int(raw_input().strip())
    printpasswd(n, '', True)
    printpasswd(n, '', False)
