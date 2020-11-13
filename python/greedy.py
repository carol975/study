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

def create_decoding_table(encoding_table):
    decoding_table = {}
    for k in encoding_table:
        v = encoding_table[k]
        decoding_table[v] = k
    return decoding_table

def huffman_encode(string, encoding_table):
    encoded_str = ""
    for c in string:
        encoded_str += encoding_table.get(c,"*")
    
    return encoded_str

def huffman_decode(string, decoding_table):
    i = 0
    j = 0
    decoded_str = ""
    while j < len(string):
        if string[i:j+1] in decoding_table:
            decoded_str += decoding_table[string[i:j+1]]
            i = j+1
        j+=1
    return decoded_str

if __name__ == "__main__":
    # huffman encode test
    string = "BCCABBDDAECCBBAEDDCC"
    hfm_encoding_table = create_encoding_table(string)
    e = huffman_encode(string, hfm_encoding_table)
    print(e)
    hfm_decoding_table = create_decoding_table(hfm_encoding_table)
    d = huffman_decode(e, hfm_decoding_table)
    print(d)

    assert(string == d)