// O(NlogN) solution. O(N) on sorted list
class Solution {
	public:
		vector<int> twoSum(vector<int>& nums, int target) {
			vector<int> v;
			vector<pair<int, int>> index_nums;
			for(int i = 0; i < nums.size(); ++i)
				index_nums.push_back({nums[i], i});
			sort (index_nums.begin(), index_nums.end());
			for(int i = 0, j = nums.size()-1; i <= j;){
				if(index_nums[j].first + index_nums[i].first > target) --j;
				else if(index_nums[j].first + index_nums[i].first == target){
					v.push_back(index_nums[i].second + 1);  
					v.push_back(index_nums[j].second + 1);
					if(v[0] > v[1]){
						v[0]^=v[1];
						v[1]^=v[0];
						v[0]^=v[1];
					}
					break;
				} 
				else ++i;
			}
			return v;
		}
};
