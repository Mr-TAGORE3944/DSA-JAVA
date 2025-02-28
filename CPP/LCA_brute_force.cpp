#include <bits/stdc++.h>
using namespace std;
 
struct Node {
    int key;
    struct Node *left, *right;
};
 
Node* newNode(int k){
    Node* temp = new Node;
    temp->key = k;
    temp->left = temp->right = NULL;
    return temp;
}


bool findPath(Node *root , int n , vector<int> &path){
    if(root == NULL) return false;
    path.push_back(root->key);
    if(root->key == n) return true;
    
    if((root->left and findPath(root->left , n , path)) || (root->right and findPath(root->right , n , path))) return true;
    
    path.pop_back();
    
    return false;
}

int findLCA(Node *root , int n1 , int n2){
    if(root == nullptr) return -1;
    vector<int> path1, path2;
    
    if(!findPath(root, n1 , path1) or !findPath(root, n2 , path2)) return -1;
    
    int i = 0;
    
    for(i = 0 ; i < path1.size() and i < path2.size() ; i++){
        if(path1[i] != path2[i]) break;
    }
    return path1[i-1];
}

 
int main(){
    Node* root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->left->right = newNode(5);
    root->right->left = newNode(6);
    root->right->right = newNode(7);
    cout << "LCA(4, 5) = " << findLCA(root, 4, 5);
    cout << "\nLCA(4, 6) = " << findLCA(root, 4, 6);
    cout << "\nLCA(3, 4) = " << findLCA(root, 3, 4);
    cout << "\nLCA(2, 4) = " << findLCA(root, 2, 4);
    return 0;
}