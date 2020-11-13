import heapq
class Node:
    def __init__(self, freq, char=None, left=None, right=None):
        self.freq = freq
        self.char = char
        self.left = left
        self.right = right

    def __lt__(self, other):
        return self.freq < other.freq
    def __repr__(self):
        return str(self.char)
def create_huffman_code_tree(string):
    if not string:
        return None
    freq = {}
    for c in string:
        freq[c] = freq.get(c,0) + 1
    
    q = []
    for c in freq:
        q.append(Node(freq[c], c))

    heapq.heapify(q)
    for _ in range(len(q)-1):
        l = heapq.heappop(q) 
        r = heapq.heappop(q)
        z = Node(l.freq + r.freq, None, l, r)
        heapq.heappush(q,z)
    return heapq.heappop(q)

def traverse_encoding_tree(partial_code, tree:Node, encoding_table):
    if tree.char:
        encoding_table[tree.char] = partial_code
    else:
        traverse_encoding_tree(partial_code + '0', tree.left, encoding_table)
        traverse_encoding_tree(partial_code + '1', tree.right, encoding_table)


def create_encoding_table(string):
    encoding_table = {}
    tree = create_huffman_code_tree(string)
    if tree:
        traverse_encoding_tree("", tree, encoding_table)
    return encoding_table



def huffman_encode(string):
    encoding_table = create_encoding_table(string)
    encoded_str = ""
    for c in string:
        encoded_str += encoding_table.get(c,"*")
    
    return encoded_str

string = "BCCABBDDAECCBBAEDDCC"

e = huffman_encode(string)
print(e)