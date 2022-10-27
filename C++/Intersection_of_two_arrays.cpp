// https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int m,n,i=0,j=0;
        unordered_map<int,int>mp;
        for(int i=0;i<nums2.size();i++){
            mp[nums2[i]] += 1;
        }
        i=0;
        vector<int>vc;
        while(i < nums1.size()){
            if(mp.count(nums1[i]) && mp[nums1[i]] != 0){
            vc.push_back(nums1[i]);
                mp[nums1[i]] -=1;
        }
            i++;
        }
        
        return vc;
    }
};