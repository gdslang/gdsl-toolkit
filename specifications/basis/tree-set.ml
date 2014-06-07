#type treeset [c, b] = Fop of {cmp: c, tree: bbtree}
#
#val sm a b = a < b
#
#val treeset-empty-int = Fop {cmp=sm}
