class FileSystem {

    FileNode root;
    
    public FileSystem() {
        root = new FileNode("");
    }
    
    public List<String> ls(String path) {
        List<String> output = new ArrayList<>();
        String[] splits = path.split("/");
        FileNode node = root;
        for (String split: splits) {
            if (split.length() == 0)
                continue;
            node.children.putIfAbsent(split, new FileNode(split));
            node = node.children.get(split);
            if (node.contents.length() > 0) { // if file
                break;
            }
        }
        if (node.contents.length() > 0)
            output.add(node.name);
        else {
            output.addAll(node.children.keySet());
        }
        return output;
    }
    
    public void mkdir(String path) {
        String[] splits = path.split("/");
        FileNode node = root;
        for (String split: splits) {
            if (split.length() == 0)
                continue;
            node.children.putIfAbsent(split, new FileNode(split));
            node = node.children.get(split);
            if (node.contents.length() > 0) { // if file
                break;
            }
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] splits = filePath.split("/");
        FileNode node = root;
        for (String split: splits) {
            if (split.length() == 0)
                continue;
            node.children.putIfAbsent(split, new FileNode(split));
            node = node.children.get(split);
            if (node.contents.length() > 0) { // if file
                break;
            }
        }
        node.contents.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] splits = filePath.split("/");
        FileNode node = root;
        for (String split: splits) {
            if (split.length() == 0)
                continue;
            node.children.putIfAbsent(split, new FileNode(split));
            node = node.children.get(split);
            if (node.contents.length() > 0) { // if file
                break;
            }
        }
        return node.contents.toString();
    }
}

class FileNode {
    String name;
    StringBuilder contents;
    TreeMap<String, FileNode> children;
    
    public FileNode(String name) {
        this.name = name;
        this.contents = new StringBuilder();
        this.children = new TreeMap<>();
    }
    
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */