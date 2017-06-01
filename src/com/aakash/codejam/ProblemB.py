#!/usr/bin/python
#
# __author__: Aakash Nagar (anagar@walmartlabs.com)
# __date__  : 4/8/17

def main():
    t = raw_input()
    for i in range(0, int(t)):
        n = raw_input()
        ans = get_tidy(n)
        print 'Case #%d: %s' % (i + 1, ans)


def get_tidy(n):
    l = [int(d) for d in str(n)]
    l.reverse()
    for x in range(0, len(l) - 1):
        if l[x] < l[x + 1]:
            for t in range(0, x + 1):
                l[t] = 9
            l[x + 1] -= 1
    l.reverse()
    return int(''.join(str(d) for d in l))


if __name__ == '__main__':
    main()
