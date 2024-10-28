// def longest_palindromic_substring(s):
//     if not s:
//         return ""
    
//     start, end = 0, 0
    
//     for i in range(len(s)):
//         len1 = expand_from_center(s, i, i)        # Odd-length palindromes
//         len2 = expand_from_center(s, i, i + 1)    # Even-length palindromes
//         max_len = max(len1, len2)
        
//         if max_len > end - start:
//             start = i - (max_len - 1) // 2
//             end = i + max_len // 2
    
//     return s[start:end + 1]

// def expand_from_center(s, left, right):
//     while left >= 0 and right < len(s) and s[left] == s[right]:
//         left -= 1
//         right += 1
//     return right - left - 1

// # Example Usage
// s = "babad"
// print(longest_palindromic_substring(s))  # Output: "bab" or "aba"
