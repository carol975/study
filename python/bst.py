class TreeNode:
    def __init__(self, val, left=None, right=None, parent=None):
        self.val = val
        self.left = left
        self.right = right
        self.parent = parent
    def __repr__(self):
        return str(self.val)
def print_inorder(root):
    if root:
        print_inorder(root.left)
        print(root)
        print_inorder(root.right)


class Tree:
    def __init__(self, root:TreeNode=None):
        self.root = root


def replace_node(tree, old, new):
    if old.parent is None:
        tree.root = new
    elif old == old.parent.left:
        old.parent.left = new
    else:
        old.parent.right = new
    if new is not None:
        new.parent = old.parent




# find min node
def tree_minimum(node):
    while node and node.left:
        node = node.left
    return node
    
def tree_maximum(node):
    while node and node.right:
        node = node.right
    return node

# find the node that is just a little bigger
def treenode_successor(node):
    if node.right:
        return tree_minimum(node.right)
    y = node.parent

    while y and node == y.right:
        node = y
        y = node.parent
    return y

# find the node that is just a little smaller 
def treenode_predecessor(node):
    if node.left:
        return tree_maximum(node.left)
    
    y = node.parent
    while y and node == y.left:
        node = y
        y = node.parent
    return y

def tree_insert(tree, node):
    
    parent = None
    cursor = tree.root

    while cursor:
        parent = cursor     
        if node.val > cursor.val:
            cursor = cursor.right
        else:
            cursor = cursor.left
    node.parent = parent
    if not parent:
        tree.root = node
    elif node.val > parent.val:
        parent.right = node
    else:
        parent.left = node             

def tree_delete(tree, node):
    if node.left is None:
        replace_node(tree, node, node.right)
    
    elif node.right is None:
        replace_node(tree, node, node.left)
    
    else:
        successor = treenode_successor(node)
        if node.right != successor:
            # remove successor first
            replace_node(tree, successor, successor.right)
            # successor inherits node' right children
            successor.right = node.right
            node.right.parent = successor
        
        # node's parent becomes successor's parent        
        replace_node(tree, node, successor)
        # successor inherits node' left children
        successor.left = node.left
        node.left.parent = successor
        

root = TreeNode(12)
tree = Tree(root)
n = TreeNode(5)
tree_insert(tree,n)
n = TreeNode(2)
tree_insert(tree,n)
n = TreeNode(9)
tree_insert(tree,n)
n = TreeNode(18)
tree_insert(tree,n)
n = TreeNode(15)
tree_insert(tree,n)
n = TreeNode(19)
tree_insert(tree,n)
n = TreeNode(13)
tree_insert(tree,n)
n = TreeNode(17)
tree_insert(tree,n)
# root.left = TreeNode(5,None, None,root)
# root.left.left = TreeNode(2,None, None,root.left)
# root.left.right = TreeNode(9,None, None,root.left)
# root.right = TreeNode(18,None, None,root)
# root.right.left = TreeNode(15,None, None,root.right)
# root.right.right = TreeNode(19,None, None,root.right)
# root.right.left.left = TreeNode(13,None, None,root.right.left)
# root.right.left.right = TreeNode(17, None, None, root.right.left)

print_inorder(tree.root)
tree_delete(tree, tree.root.left)
print_inorder(tree.root)