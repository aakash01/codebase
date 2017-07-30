#!/usr/bin/python
#
# __author__: Aakash Nagar (anagar@walmartlabs.com)
# __date__  : 4/8/17

def main():

    t = raw_input()
    for i in range(0, int(t)):
        line = raw_input()
        s,k = line.split(' ')
        k = int(k)
        l = len(s)
        count = 0
        s = list(s)
        for x in range(0, l):
            if s[x] == '-':
                if l-x < k:
                    count = -1
                    break
                flip(s, x, x + k)
                count += 1
        ans = count
        if count == -1:
            ans = 'IMPOSSIBLE'

        print 'Case #%d: %s' % (i+1, ans)

def flip(s, st, en):
    for x in range(st, en):
        s[x] = '+' if s[x] == '-' else '-'
    return ''.join(s)

if __name__ == '__main__':
    main()