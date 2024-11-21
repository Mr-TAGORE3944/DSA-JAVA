import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                // Skip empty and current directory components
                continue;
            } else if (component.equals("..")) {
                // Go to the parent directory if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Otherwise, it's a valid directory name, so push it onto the stack
                stack.push(component);
            }
        }

        // Construct the simplified path
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        // Return the root path if the stack is empty, otherwise return the simplified path
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }

    public static void main(String[] args) {
        String path = "/home//foo/../bar/";
        String result = simplifyPath(path);
        System.out.println("Simplified Path: " + result);
    }
}
