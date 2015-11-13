// O(N) on sorted list -- gets hung up on test case for idk
using map_t = std::unordered_map<int, int>;
int checkValid(map_t index_map, int val, int target){
    auto p = index_map.find(target-val);
    if(p != index_map.end() && val + p->first == target) return p->second;
    p = index_map.find(target+val);
    if(p != index_map.end() && val + p->first == target) return p->second;
    return -1; // invalid
}
class Solution {
    public:
            vector<int> twoSum(vector<int>& nums, int target) {
                    vector<int> v(2);
                    int tmp;
                    map_t index_map;
                    for(int i = 0; i < nums.size(); ++i){
                            if((tmp=checkValid(index_map, nums[i], target)) != -1){
                                    v[0] = tmp+1;
                                    v[1] = i+1;
                                    break;
                            }
                            index_map[nums[i]] = i;
                    }
                    return v;
            }
};
