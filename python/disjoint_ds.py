class SetHeader:
    def __init__(self, rep, tail):
        self.rep = rep
        self.tail = tail
        self.len = 0

    def increase_len(self):
        self.len += 1
    
    def decrease_len(self):
        self.len -= 1
    def print(self):
        csr = self.rep
        while csr:
            print(csr)
            csr = csr.next

class Element:
    def __init__(self, val, set_header:SetHeader=None, next=None):
        self.val = val
        self.set_header = set_header
        self.next = next

    def __repr__(self):
        return str(self.val)

def make_set(val):
    first_ele = Element(val, None, None)
    set_header = SetHeader(first_ele, first_ele)
    set_header.increase_len()
    first_ele.set_header = set_header
    return set_header

def find_set(element:Element):
    return element.set_header.rep

def add_element_to_set(ele:Element, set_header:SetHeader):
    ele.set_header = set_header
    tail_ele = set_header.tail
    tail_ele.next = ele
    set_header.tail = ele
    set_header.increase_len()



def union(e1:Element, e2:Element)->SetHeader:

    s1 = e1.set_header
    s2 = e2.set_header
    if s1.len < s2.len:
        return union(e2, e1)
    
    # make s1 tail ele point to first ele (s2.rep) of s2
    s2_csr = s2.rep
    s1_tail = s1.tail
    s1_tail.next = s2_csr

    # change header for all eles in s2 to s1
    while s2_csr:
        s2_csr.set_header = s1
        s1.increase_len()
        s2_csr = s2_csr.next

    #  make s1 tail point to s2.tail
    s1.tail = s2.tail
    
    return s1


if __name__ == "__main__":
    s = make_set(5)
    e = Element(2,None)
    add_element_to_set(e, s)
    s.print()


    s2 = make_set(3)
    e2 = Element(4,None)
    add_element_to_set(e2, s2)
    s2.print()

    new_s = union(e,e2)
    new_s.print()